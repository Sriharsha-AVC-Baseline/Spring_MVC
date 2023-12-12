package com.itt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.constants.EmployeeTypes;
import com.itt.constants.LeaveStatus;
import com.itt.database.HqlQueries;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.modal.ManagerEntity;

@Repository("leadDao")
@Transactional
public class LeadDao  {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	public List<ExecutiveEntity> getExecutivesUnderMe(EmployeeEntity higherManagerDetails)
	{
		String queryStatement = null;
		if(higherManagerDetails.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		{
			 queryStatement = HqlQueries.FETCH_EXECUTIVES_FROM_MANAGER;
		}
		if(higherManagerDetails.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.LEAD.toString()))
		{
			 queryStatement = HqlQueries.FETCH_EXECUTIVES_FROM_LEADS;
		}
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<ExecutiveEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", higherManagerDetails);
		List<ExecutiveEntity> executivesUnderManager = query.getResultList();
		for(ExecutiveEntity ex:executivesUnderManager)
		{
			System.out.println(ex.getMyEmployeeId().getEmployeeName() + " "+ex.getMyManager().getMyEmployeeId().getEmployeeId());
		}
		return executivesUnderManager;
	}
	
	public List<LeadsEntity> getLeadsUnderMe(EmployeeEntity managerDetails)
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		String queryStatement = HqlQueries.FETCH_LEADS_FROM_MANAGER;
		Query<LeadsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", managerDetails);
		List<LeadsEntity> leadsUnderManager = query.getResultList();
		
		for(LeadsEntity lds:leadsUnderManager)
		{
			System.out.println(lds.getMyEmployeeId().getEmployeeName()+" "+lds.getMyManager().getMyEmployeeId().getEmployeeName());
		}
		return leadsUnderManager;
	}


	public void approveLeaves(int leaveId) {
		
		giveVerdict(leaveId, LeaveStatus.APPROVED_BY_LEAD.toString());
	}


	public void rejectLeaves(int leaveId) {
		
		giveVerdict(leaveId, LeaveStatus.REJECTED.toString());
	}
	
	public void giveVerdict(int leaveId,String verdict)
	{
		Session session =  this.hibernateTemplate.getSessionFactory().getCurrentSession(); 
		String queryStatement = HqlQueries.FETCH_LEAVE_RECORDS;
		Query<LeaveRecordsEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", leaveId);
		LeaveRecordsEntity leaveRecordsEntity = query.uniqueResult();
		leaveRecordsEntity.setLeaveStatus(verdict);
		this.hibernateTemplate.update(leaveRecordsEntity);
	}


	public void revokeLeaves(int leaveId) {
		// TODO Auto-generated method stub
		
	}

	



}
