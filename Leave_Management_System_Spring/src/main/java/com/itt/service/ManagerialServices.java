package com.itt.service;

import java.util.List;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;

public interface ManagerialServices {

	public List<LeaveRecordsEntity> fetchLeaveRecordsofEmployees();
	
	public void approveRejectLeaves(List<LeaveRecordsEntity> employeeLeaveRecords);
	
	public void revokeLeaves(List<LeaveRecordsEntity> employeeLeaveRecords);
	
	
}
