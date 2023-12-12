package com.itt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.database.HqlQueries;
import com.itt.modal.LeaveRecordsEntity;

@Transactional
@Repository
public class AvailLeaveDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public LeaveRecordsEntity getLeaveRecordsEntity(int leaveId)
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		String queryStatement = HqlQueries.FETCH_LEAVE_RECORDS;
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", leaveId);
		LeaveRecordsEntity leaveRecordsEntity = query.uniqueResult();
		return leaveRecordsEntity;
	}
	
	public void updateLeaveRecord(LeaveRecordsEntity leaveRecordsEntity)
	{
		this.hibernateTemplate.update(leaveRecordsEntity);
	}

}
