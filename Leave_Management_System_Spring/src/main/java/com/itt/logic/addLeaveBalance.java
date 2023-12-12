package com.itt.logic;

import com.itt.constants.LeaveTypes;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

public class addLeaveBalance {
	
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
