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
public class RevokeLeaveDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	public EmployeeEntity getEmployeeEntity(int leaveId)
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		String queryStatement = HqlQueries.FETCH_EMPLOYEE_DETAILS;
		Query<EmployeeEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", leaveId);
		EmployeeEntity employee = query.uniqueResult();
		return employee;
	}
	
	public LeaveBalanceEntity getLeaveBalance(EmployeeEntity employeeEntity)
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		String queryStatement = HqlQueries.FETCH_LEAVE_BALANCE;
		Query<LeaveBalanceEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeEntity);
		LeaveBalanceEntity leaveBalance = query.uniqueResult();
		return leaveBalance;
	}
	
	public LeaveRecordsEntity getLeaveRecordsEntity(int leaveID)
	{
		return this.hibernateTemplate.get(LeaveRecordsEntity.class, leaveID);
	}
	
	public void updateLeaveBalance(LeaveBalanceEntity leaveBalanceEntity)
	{
		this.hibernateTemplate.update(leaveBalanceEntity);
	}
	
	

}
