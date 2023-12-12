package com.itt.service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.EmployeeTypes;
import com.itt.constants.LeaveStatus;
import com.itt.dao.LeadDao;
import com.itt.dao.LeaveHistoryDao;
import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Service
public class LeaveHistoryService {
	
	
	@Autowired
	LeaveHistoryDao leaveHistoryDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	@Autowired
	LeadDao leadDao;

	public List<LeaveRecordsEntity> getLeaveRecordsOfEmployeesUnderMe(EmployeeEntity employeeEntity)
	{
		
		System.out.println(employeeEntity.getEmployeeName());
		
		List<LeaveRecordsEntity> leaveRecords = new ArrayList<LeaveRecordsEntity>();
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		 {
			List<LeaveRecordsEntity> executiveLeaveRecords = null;
			List<LeaveRecordsEntity> leadsLeaveRecords = null;
			executiveLeaveRecords = getExecutiveLeaveRecords(employeeEntity,LeaveStatus.APPROVED.toString());
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
	
	public List<LeaveRecordsEntity> getExecutiveLeaveRecords(EmployeeEntity employeeEntity,String leaveStatus)
	{
		List<LeaveRecordsEntity> executiveLeaveRecords = new ArrayList<LeaveRecordsEntity>();
		List<ExecutiveEntity> executives =  leadDao.getExecutivesUnderMe(employeeEntity);
		for(ExecutiveEntity ex:executives)
		{
			executiveLeaveRecords.addAll(utilityDao.fetchApprovedRecords(ex.getMyEmployeeId(),leaveStatus));
			executiveLeaveRecords.addAll(utilityDao.fetchRejectedRecords(ex.getMyEmployeeId()));
			executiveLeaveRecords.addAll(utilityDao.fetchRevokedRecords(ex.getMyEmployeeId()));	
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
			leadsLeaveRecords.addAll(utilityDao.fetchRejectedRecords(lds.getMyEmployeeId()));
			leadsLeaveRecords.addAll(utilityDao.fetchRevokedRecords(lds.getMyEmployeeId()));
		}
		
		return leadsLeaveRecords;
	}
	
	
	public List<LeaveRecordsEntity> getApprovedLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> leaveRecords = getLeaveRecordsOfEmployeesUnderMe(employeeEntity);
		List<LeaveRecordsEntity> approvedLeaves =null;
		
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		{
			 approvedLeaves = leaveRecords.stream().filter(e->e.getLeaveStatus().equalsIgnoreCase(LeaveStatus.APPROVED.toString())).collect(Collectors.toList());
		}
		else
		{
			 approvedLeaves = leaveRecords.stream().filter(e->e.getLeaveStatus().equalsIgnoreCase(LeaveStatus.APPROVED_BY_LEAD.toString())).collect(Collectors.toList());
			
		}
		
		return approvedLeaves;
		
	}
	
	public List<LeaveRecordsEntity> getRejectedLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> leaveRecords = getLeaveRecordsOfEmployeesUnderMe(employeeEntity);
		List<LeaveRecordsEntity> approvedLeaves = leaveRecords.stream().filter(e->e.getLeaveStatus().equalsIgnoreCase(LeaveStatus.REJECTED.toString())).collect(Collectors.toList());
		return approvedLeaves;
	}
	
	public List<LeaveRecordsEntity> getRevokedLeaveRecords(EmployeeEntity employeeEntity)
	{
		List<LeaveRecordsEntity> leaveRecords = getLeaveRecordsOfEmployeesUnderMe(employeeEntity);
		List<LeaveRecordsEntity> approvedLeaves = leaveRecords.stream().filter(e->e.getLeaveStatus().equalsIgnoreCase(LeaveStatus.REVOKED.toString())).collect(Collectors.toList());
		return approvedLeaves;
	}
	
}
