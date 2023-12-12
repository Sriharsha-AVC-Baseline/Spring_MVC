package com.itt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itt.modal.EmployeeEntity;

@Repository
public class FetchDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	


}
