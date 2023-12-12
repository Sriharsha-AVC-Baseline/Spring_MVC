package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.LeaveStatus;
import com.itt.constants.LeaveTypes;
import com.itt.dao.ApplyLeaveDao;
import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.oracle.wls.shaded.org.apache.regexp.recompile;

@Service
public class ApplyLeaveService {

	@Autowired
	ApplyLeaveDao applyLeaveDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	
	
	public void applyLeaveData(LeaveRecordsEntity leaveRecordsEntity,EmployeeEntity employeeEntity)
	{
		java.sql.Date fromDate = leaveRecordsEntity.getFromDate();
		
		leaveRecordsEntity.setEmployeeId(employeeEntity);
		int dateDifference = utilityDao.getDateDiffernce(leaveRecordsEntity.getFromDate(), leaveRecordsEntity.getToDate());
		leaveRecordsEntity.setNumberOfDays(dateDifference);
		leaveRecordsEntity.setLeaveStatus(LeaveStatus.PENDING.toString());
		
		applyLeaveDao.insertLeaveRecord(leaveRecordsEntity);
		
		LeaveBalanceEntity employeeLeaveBalanceEntity = applyLeaveDao.fetchLeaveBalance(employeeEntity);
		
		employeeLeaveBalanceEntity = deductLeave(employeeLeaveBalanceEntity, leaveRecordsEntity);
		
		applyLeaveDao.updateLeaveBalance(employeeLeaveBalanceEntity);
		
	}
	
	public LeaveBalanceEntity deductLeave(LeaveBalanceEntity leaveBalanceEntity,LeaveRecordsEntity leaveRecordsEntity)
	{
		int leaveBalance = 0;
		if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.CASUAL_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getCasualLeave() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setCasualLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.EARNED_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getEarnedLeave() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setEarnedLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.SICK_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getSickLeave() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setSickLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.MATERNITY_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getMaternityLeave() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setMaternityLeave(leaveBalance);
		}	
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.PARENTAL_LEAVE.toString()))
		{
			leaveBalance = leaveBalanceEntity.getParentalLeave() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setParentalLeave(leaveBalance);
		}
		else if(leaveRecordsEntity.getLeaveType().equalsIgnoreCase(LeaveTypes.LEAVE_WITHOUT_PAY.toString()))
		{
			leaveBalance = leaveBalanceEntity.getLeaveWithoutPay() - leaveRecordsEntity.getNumberOfDays();
			leaveBalanceEntity.setLeaveWithoutPay(leaveBalance);
		}
		System.out.println(leaveBalance);
		return leaveBalanceEntity;
	}
	
	public EmployeeEntity reloadEmployeeDetails(EmployeeEntity employeeEntity)
	{
		return applyLeaveDao.reloadEmployeeDetails(employeeEntity);
	}
}
