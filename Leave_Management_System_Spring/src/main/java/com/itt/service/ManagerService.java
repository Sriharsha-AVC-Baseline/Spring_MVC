package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.itt.dao.CommonDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.SignupDao;
import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ManagerEntity;

@Service("managerService")
public class ManagerService {

	@Autowired
	ManagerDao dao;
	
	public void addManager(EmployeeEntity employeeEntity,SignupDao signupDao)
	{
		ManagerEntity newManager = new ManagerEntity();
		newManager.setMyEmployeeId(employeeEntity);
		newManager.setLeadsUnderMe(0);
		/* ManagerDao managerDao = new ManagerDao(); */
		signupDao.insert(newManager);
	}
	
	
	
}
