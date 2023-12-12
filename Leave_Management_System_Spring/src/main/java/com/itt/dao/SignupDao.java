package com.itt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.ManagerEntity;

@Repository
@Transactional
public class SignupDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	public<T> void insert(T entity)
	{
		this.hibernateTemplate.save(entity);
	}
	
	public<T> T update(T entity)
	{
		this.hibernateTemplate.update(entity);
		return entity;
	}
	
	public List<String> getEmailList()
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<String> query = session.createQuery("select e.employeeMail FROM Employee e");
		List<String> list = query.list();
		return list;
	}
	
	public List<String> getPhoneList()
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<String> query = session.createQuery("select e.employeePhone FROM Employee e");
		List<String> list = query.list();
		return list;
	}

	
	public LeadsEntity getSuitableLead() 
	{
		String queryStatement = "select(l) from Leads l where executivesUnderMe = (select min(l.executivesUnderMe) from Leads l)";
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<LeadsEntity> query = session.createQuery(queryStatement);
		List<LeadsEntity> minimumCount = query.getResultList();
		if(minimumCount.isEmpty())
		{
			//throw new Exception("There are no leads in this organization!!!");
		}
		return minimumCount.get(0);
	}
	
	public void insertExecutive(ExecutiveEntity newExecutive)
	{
		this.hibernateTemplate.save(newExecutive);
		updateLead(newExecutive.getMyLead());
	}
	

	public void updateLead(LeadsEntity lead)
	{
		lead.setExecutivesUnderMe(lead.getExecutivesUnderMe()+1);
		this.hibernateTemplate.update(lead);
	}
	
	
	public ManagerEntity getSuitableManager() 
	{
		String queryStatement = "select(m) from Manager m where leadsUnderMe=(select min(m.leadsUnderMe) from Manager m)";
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<ManagerEntity> query = session.createQuery(queryStatement);
		List<ManagerEntity> minimumCount = query.getResultList();
		if(minimumCount.isEmpty())
		{
		//	throw new Exception("There are no Managers in this organization!!!");
		}
		return minimumCount.get(0);
	}
	
	public void insertLead(LeadsEntity leadsEntity)
	{
		this.hibernateTemplate.save(leadsEntity);
		updateManager(leadsEntity.getMyManager());	
	}
	
	

	public void updateManager(ManagerEntity manager)
	{
		manager.setLeadsUnderMe(manager.getLeadsUnderMe()+1);
		this.hibernateTemplate.update(manager);
	}

	

}
