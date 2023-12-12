package com.itt.dao;

import java.util.List;

import com.itt.modal.LeaveRecordsEntity;

public interface ManagerialDao {
	
	public void approveLeaves(int leaveId);
	
	public void rejectLeaves(int leaveId);
	
	public void revokeLeaves(int leaveId);
	

}
