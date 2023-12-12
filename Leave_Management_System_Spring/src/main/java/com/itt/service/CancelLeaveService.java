package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.LeaveStatus;
import com.itt.constants.LeaveTypes;
import com.itt.dao.CancelLeaveDao;
import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Service
public class CancelLeaveService {

	@Autowired
	CancelLeaveDao cancelLeaveDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	public void cancelLeave(String leaveId)
	{
		Integer leaveIdInInteger = Integer.valueOf(leaveId);
		LeaveRecordsEntity leaveRecordsEntity = cancelLeaveDao.fetchLeaveRecords(leaveIdInInteger.intValue());
		
		
		LeaveBalanceEntity LeaveBalanceEntity = getBalanceEntity(leaveRecordsEntity.getEmployeeId().getEmployeeId());
		
		leaveRecordsEntity.setLeaveStatus(LeaveStatus.CANCELLED.toString());
		
		LeaveBalanceEntity = new com.itt.logic.addLeaveBalance().addLeave(LeaveBalanceEntity, leaveRecordsEntity);
		
		cancelLeaveDao.updateLeaveDetails(LeaveBalanceEntity, leaveRecordsEntity);
		
		
	}
	
	
	
	
	public LeaveBalanceEntity getBalanceEntity(String employeeId)
	{
		return cancelLeaveDao.getLeaveBalance(utilityDao.reloadEmployeeDetails(employeeId));
	}
	
	
	
	
	
	
}
