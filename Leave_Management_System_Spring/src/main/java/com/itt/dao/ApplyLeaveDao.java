package com.itt.dao;

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
public class ApplyLeaveDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public void insertLeaveRecord(LeaveRecordsEntity leaveRecordsEntity)
	{
		this.hibernateTemplate.save(leaveRecordsEntity);
	}
	
	public LeaveBalanceEntity fetchLeaveBalance(EmployeeEntity employeeEntity)
	{
		String queryStatement = HqlQueries.FETCH_LEAVE_BALANCE;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveBalanceEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeEntity);
		LeaveBalanceEntity leaveBalanceEntity = query.uniqueResult();
		return leaveBalanceEntity;
	}
	
	public void updateLeaveBalance(LeaveBalanceEntity leaveBalanceEntity)
	{
		this.hibernateTemplate.update(leaveBalanceEntity);
	}
	
	public EmployeeEntity reloadEmployeeDetails(EmployeeEntity employeeEntity)
	{
		String queryStatement = HqlQueries.RELOAD_EMPLOYEE;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeEntity.getEmployeeId());
		EmployeeEntity reloaded = query.uniqueResult();
		return reloaded;
	}
	
}
