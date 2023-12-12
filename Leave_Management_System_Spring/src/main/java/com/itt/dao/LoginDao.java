package com.itt.dao;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itt.modal.EmployeeEntity;

@Repository
@Transactional
public class LoginDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public EmployeeEntity getDesignation (String email,String password)
	{
		String queryStatement = "select e from Employee e where e.employeeMail= :id";
		Query<EmployeeEntity> query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryStatement);
		query.setParameter("id", email);
		EmployeeEntity employeeEntity = query.uniqueResult();
		
		return employeeEntity;	
	}

	
	
}
