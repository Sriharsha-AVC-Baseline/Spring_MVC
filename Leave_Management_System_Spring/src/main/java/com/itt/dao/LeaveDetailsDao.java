package com.itt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itt.constants.EmployeeTypes;
import com.itt.database.HqlQueries;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;

@Repository
public class LeaveDetailsDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	
	
	
	

}
