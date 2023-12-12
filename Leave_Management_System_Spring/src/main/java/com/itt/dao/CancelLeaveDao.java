package com.itt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.database.HqlQueries;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Repository
@Transactional
public class CancelLeaveDao {

	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public LeaveRecordsEntity fetchLeaveRecords(int leaveId)
	{
		String queryStatement = HqlQueries.FETCH_LEAVE_RECORDS;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", leaveId);
		LeaveRecordsEntity leaveRecordsEntity = query.uniqueResult();
		return leaveRecordsEntity;
	}
	
	
	public LeaveBalanceEntity getLeaveBalance(EmployeeEntity employeeId)
	{
		String queryStatement = HqlQueries.FETCH_LEAVE_BALANCE;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveBalanceEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeId);
		LeaveBalanceEntity leaveBalanceEntity = query.uniqueResult();
		return leaveBalanceEntity;
	}
	
	
	public void updateLeaveDetails(LeaveBalanceEntity leaveBalanceEntity,LeaveRecordsEntity leaveRecordsEntity)
	{
		this.hibernateTemplate.update(leaveRecordsEntity);
		this.hibernateTemplate.update(leaveBalanceEntity);
	}
}
