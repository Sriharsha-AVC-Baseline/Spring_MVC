package com.itt.dao;

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

//@Repository("executiveDao")
@Repository("executiveDao")
@Transactional
public class ExecutiveDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	

}
