package com.itt.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.modal.EmployeeEntity;

@Transactional
@Repository
public class FetchEmployeeListDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public List<EmployeeEntity> fetchExecutiveEntities()
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery("select ex.myEmployeeId from Executive ex");
		List<EmployeeEntity> executives = query.list();
		return executives;
	}
	
	public List<EmployeeEntity> fetchLeadsEntities()
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery("select ld.myEmployeeId from Leads ld");
		List<EmployeeEntity> leads = query.list();
		return leads;
	}
	
	public List<EmployeeEntity> fetchManagerEntities()
	{
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery("select mg.myEmployeeId from Manager mg");
		List<EmployeeEntity> managers = query.list();
		return managers;
	}
	
	

}
