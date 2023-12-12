package com.itt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.logic.LeaveDistributor;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;

@Repository("leaveBalanceDao")
@Transactional
public class LeaveBalanceDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	public void insertLeaveBalance(LeaveBalanceEntity leBalanceEntity)
	{
		 this.hibernateTemplate.save(leBalanceEntity);
	}
}
