package com.itt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.EmployeeTypes;
import com.itt.constants.LeaveStatus;
import com.itt.dao.ApproveRejectDao;
import com.itt.dao.LeadDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.RevokeLeaveDao;
import com.itt.dao.UtilityDao;
import com.itt.logic.addLeaveBalance;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Service
public class ApproveRejectLeaveService {

	@Autowired
	ApproveRejectDao approveRejectDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	LeadDao leadDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	@Autowired
	RevokeLeaveDao revokeLeaveDao;
	
	public List<LeaveRecordsEntity> getLeaveRecordsOfEmployeesUnderMe(EmployeeEntity employeeEntity)
	{
		
		System.out.println(employeeEntity.getEmployeeName());
		
		List<LeaveRecordsEntity> leaveRecords = new ArrayList<LeaveRecordsEntity>();
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		 {
			List<LeaveRecordsEntity> executiveLeaveRecords = null;
			List<LeaveRecordsEntity> leadsLeaveRecords = null;
			executiveLeaveRecords = getExecutiveLeaveRecords(employeeEntity);
			leadsLeaveRecords = getLeadsLeaveRecords(employeeEntity);
			leaveRecords.addAll(executiveLeaveRecords);
			leaveRecords.addAll(leadsLeaveRecords);
		 }
		else if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.LEAD.toString()))
		{
			List<LeaveRecordsEntity> executiveLeaveRecords = null;
			executiveLeaveRecords = getExecutiveLeaveRecords(employeeEntity);
			leaveRecords.addAll(executiveLeaveRecords);
			
		}
		return leaveRecords;
	}
	
	public List<LeaveRecordsEntity> getExecutiveLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> executiveLeaveRecords = new ArrayList<LeaveRecordsEntity>();
		List<ExecutiveEntity> executives =  leadDao.getExecutivesUnderMe(employeeEntity);
		for(ExecutiveEntity ex:executives)
		{
			executiveLeaveRecords.addAll(utilityDao.fetchPendingRecords(ex.getMyEmployeeId()));
		}
		
		return executiveLeaveRecords;
	}
	
	public List<LeaveRecordsEntity> getLeadsLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> leadsLeaveRecords = new ArrayList<LeaveRecordsEntity>();
		List<LeadsEntity> leads =  leadDao.getLeadsUnderMe(employeeEntity);
		for(LeadsEntity lds:leads)
		{
			leadsLeaveRecords.addAll(utilityDao.fetchPendingRecords(lds.getMyEmployeeId()));
		}
		
		return leadsLeaveRecords;
	}
	
	
	public void approveRejectLeave(EmployeeEntity employeeEntity,String leaveId,String verdict)
	{
		if(verdict.equalsIgnoreCase(LeaveStatus.APPROVED.toString()))
		{
			if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.LEAD.toString()))
				{
					leadDao.approveLeaves(Integer.parseInt(leaveId));
				}
			else if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
			{
				managerDao.approveLeaves(Integer.parseInt(leaveId));
			}
		}
		else if (verdict.equalsIgnoreCase(LeaveStatus.REJECTED.toString()))
			{
				managerDao.rejectLeaves(Integer.parseInt(leaveId));
				
				EmployeeEntity idOfTheEmployee = revokeLeaveDao.getEmployeeEntity(Integer.parseInt(leaveId));
				
				LeaveRecordsEntity leaveRecordsEntity = revokeLeaveDao.getLeaveRecordsEntity(Integer.valueOf(leaveId));
				
				LeaveBalanceEntity leaveBalanceEntity = revokeLeaveDao.getLeaveBalance(idOfTheEmployee);
				
				LeaveBalanceEntity updatedleaveBalanceEntity = new addLeaveBalance().addLeave(leaveBalanceEntity, leaveRecordsEntity);
				
				revokeLeaveDao.updateLeaveBalance(updatedleaveBalanceEntity);
				
			}
	}
	

}
