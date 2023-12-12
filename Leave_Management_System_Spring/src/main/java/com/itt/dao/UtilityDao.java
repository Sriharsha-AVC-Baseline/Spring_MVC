package com.itt.dao;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.constants.LeaveStatus;
import com.itt.database.HqlQueries;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;

@Repository("utilityDao")
@Transactional
public class UtilityDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;

	public long getUserCount()
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String queryStatement = "SELECT COUNT(*) FROM com.itt.modal.EmployeeEntity";
		Query<Long> query = session.createQuery(queryStatement);
		Long count = query.uniqueResult();
		return count.longValue();
	}
	
	public int getDateDiffernce(java.sql.Date fromDate, java.sql.Date toDate)
	{
	/*	String dateDiffQuery = "SELECT datediff(:toDate,:fromDate)";
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createNativeQuery(dateDiffQuery);
		q.setParameter("fromDate", fromDate);
		q.setParameter("toDate", toDate);
		java.math.BigInteger getResult = (BigInteger) q.uniqueResult();
		int result = getResult.intValue();
		
		*/
		
		int result=0;
		
		java.util.Date from = new java.util.Date(fromDate.getTime());
		java.util.Date to = new java.util.Date(toDate.getTime());

		System.out.println(from);
		System.out.println(to);
		
		Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		
		fromCalendar.setTime(fromDate);
		toCalendar.setTime(toDate);
		
		while(fromCalendar.before(toCalendar))
		{
			if(Calendar.SATURDAY!=fromCalendar.get(Calendar.DAY_OF_WEEK) && Calendar.SUNDAY!=fromCalendar.get(Calendar.DAY_OF_WEEK))
			{
				result++;
			}
			fromCalendar.add(Calendar.DATE, 1);
		}
		System.out.println(result);
		return result;
		
	}
	
	public EmployeeEntity reloadEmployeeDetails(String employeeId)
	{
		String queryStatement = HqlQueries.RELOAD_EMPLOYEE;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeId);
		EmployeeEntity reloaded = query.uniqueResult();
		return reloaded;
	}
	
	public List<LeaveRecordsEntity> fetchPendingRecords(EmployeeEntity employee)
	{
		String queryStatement = HqlQueries.FETCH_PENDING_RECORDS;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employee);
		query.setParameter("type", LeaveStatus.PENDING.toString());
		List<LeaveRecordsEntity> pendingRecords = query.getResultList();
		return pendingRecords;
	}
	
	public List<LeaveRecordsEntity> fetchApprovedRecords(EmployeeEntity employee, String status)
	{
		String queryStatement = HqlQueries.FETCH_APPROVRED_RECORDS;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employee);
		query.setParameter("type", status);
		List<LeaveRecordsEntity> pendingRecords = query.getResultList();
		return pendingRecords;
	}
	
	public List<LeaveRecordsEntity> fetchRevokedRecords(EmployeeEntity employee)
	{
		String queryStatement = HqlQueries.FETCH_REVOKED_RECORDS;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employee);
		query.setParameter("type", LeaveStatus.REVOKED.toString());
		List<LeaveRecordsEntity> pendingRecords = query.getResultList();
		return pendingRecords;
	}
	
	public List<LeaveRecordsEntity> fetchRejectedRecords(EmployeeEntity employee)
	{
		String queryStatement = HqlQueries.FETCH_REVOKED_RECORDS;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employee);
		query.setParameter("type", LeaveStatus.REJECTED.toString());
		List<LeaveRecordsEntity> pendingRecords = query.getResultList();
		return pendingRecords;
	}
	
}
