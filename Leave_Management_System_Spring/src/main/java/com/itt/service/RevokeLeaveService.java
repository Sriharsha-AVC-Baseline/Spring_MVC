package com.itt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.EmployeeTypes;
import com.itt.constants.LeaveStatus;
import com.itt.constants.LeaveTypes;
import com.itt.dao.ApproveRejectDao;
import com.itt.dao.LeadDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.RevokeLeaveDao;
import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Service
public class RevokeLeaveService {
	
	@Autowired
	RevokeLeaveDao revokeLeaveDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	LeadDao leadDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	public List<LeaveRecordsEntity> getLeaveRecordsOfEmployeesUnderMe(EmployeeEntity employeeEntity)
	{
		
		System.out.println(employeeEntity.getEmployeeName());
		
		List<LeaveRecordsEntity> leaveRecords = new ArrayList<LeaveRecordsEntity>();
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		 {
			List<LeaveRecordsEntity> executiveLeaveRecords = null;
			List<LeaveRecordsEntity> leadsLeaveRecords = null;
			executiveLeaveRecords = getExecutiveLeaveRecords(employeeEntity,LeaveStatus.APPROVED_BY_LEAD.toString());
			executiveLeaveRecords.addAll(getExecutiveLeaveRecords(employeeEntity, LeaveStatus.APPROVED.toString()));
			leadsLeaveRecords = getLeadsLeaveRecords(employeeEntity);
			leaveRecords.addAll(executiveLeaveRecords);
			leaveRecords.addAll(leadsLeaveRecords);
		 }
		else if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.LEAD.toString()))
		{
			List<LeaveRecordsEntity> executiveLeaveRecords = null;
			executiveLeaveRecords = getExecutiveLeaveRecords(employeeEntity,LeaveStatus.APPROVED_BY_LEAD.toString());
			leaveRecords.addAll(executiveLeaveRecords);
		}
		return leaveRecords;
	}
	
	public List<LeaveRecordsEntity> getExecutiveLeaveRecords(EmployeeEntity employeeEntity,String status)
	{
		List<LeaveRecordsEntity> executiveLeaveRecords = new ArrayList<LeaveRecordsEntity>();
		List<ExecutiveEntity> executives =  leadDao.getExecutivesUnderMe(employeeEntity);
		for(ExecutiveEntity ex:executives)
		{
			executiveLeaveRecords.addAll(utilityDao.fetchApprovedRecords(ex.getMyEmployeeId(),status));
		}
		return executiveLeaveRecords;
	}
	
	public List<LeaveRecordsEntity> getLeadsLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> leadsLeaveRecords = new ArrayList<LeaveRecordsEntity>();
		List<LeadsEntity> leads =  leadDao.getLeadsUnderMe(employeeEntity);
		for(LeadsEntity lds:leads)
		{
			leadsLeaveRecords.addAll(utilityDao.fetchApprovedRecords(lds.getMyEmployeeId(),LeaveStatus.APPROVED.toString()));
		}
		
		return leadsLeaveRecords;
	}
	
	
	public void revokeLeave(String leaveId)
	{
		managerDao.revokeLeaves(Integer.parseInt(leaveId));
		updateLeaveBalance(Integer.parseInt(leaveId));
	}
	
	public void updateLeaveBalance(int leaveId)
	{
		EmployeeEntity employeeEntity = revokeLeaveDao.getEmployeeEntity(leaveId);
		
		LeaveBalanceEntity leaveBalanceEntity = revokeLeaveDao.getLeaveBalance(employeeEntity);
		
		LeaveRecordsEntity leaveRecordsEntity = revokeLeaveDao.getLeaveRecordsEntity(leaveId);
		
		LeaveBalanceEntity updatedLeaveBalance = addLeave(leaveBalanceEntity, leaveRecordsEntity);
		
		revokeLeaveDao.updateLeaveBalance(leaveBalanceEntity);
	}
	
	public LeaveBalanceEntity addLeave(LeaveBalanceEntity leaveBalanceEntity,LeaveRecordsEntity leaveRecordsEntity)
	{
		int leaveBalance = 0;
		if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.CASUAL_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getCasualLeave() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setCasualLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.EARNED_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getEarnedLeave() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setEarnedLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.SICK_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getSickLeave() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setSickLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.MATERNITY_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getMaternityLeave() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setMaternityLeave(leaveBalance);
		}	
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.PARENTAL_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getParentalLeave() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setParentalLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.LEAVE_WITHOUT_PAY.toString()))
		{
			leaveBalance = leaveBalanceEntity.getLeaveWithoutPay() + leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setLeaveWithoutPay(leaveBalance);
		}
		System.out.println(leaveBalance);
		return leaveBalanceEntity;
	}

}
