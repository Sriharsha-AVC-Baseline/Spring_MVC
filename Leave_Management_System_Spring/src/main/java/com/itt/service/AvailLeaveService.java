package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.constants.LeaveStatus;
import com.itt.dao.AvailLeaveDao;
import com.itt.modal.LeaveRecordsEntity;

@Service
public class AvailLeaveService {
	
	@Autowired
	AvailLeaveDao availLeaveDao;
	
	public void updateLeaveRecord(String leaveId)
	{
		LeaveRecordsEntity leaveRecordsEntity = availLeaveDao.getLeaveRecordsEntity(Integer.parseInt(leaveId));
		
		 leaveRecordsEntity.setLeaveStatus(LeaveStatus.AVAILED.toString());
		
		 updateLeaveRecordEntity(leaveRecordsEntity);
		
	}
	
	public void updateLeaveRecordEntity(LeaveRecordsEntity leaveRecordsEntity)
	{
		this.availLeaveDao.updateLeaveRecord(leaveRecordsEntity);
	}

}
