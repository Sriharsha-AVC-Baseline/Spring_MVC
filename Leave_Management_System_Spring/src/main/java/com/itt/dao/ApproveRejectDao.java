package com.itt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ApproveRejectDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	
}
