package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.itt.constants.EmployeeTypes;
import com.itt.dao.CommonDao;
import com.itt.dao.ExecutiveDao;
import com.itt.dao.LeadDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.SignupDao;
import com.itt.modal.EmployeeEntity;

import net.bytebuddy.asm.Advice.This;

@Service("registerDesignation")
public class RegisterDesignation {
	
	@Autowired
	CommonDao commonDao2;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	LeadService leadService;
	
	@Autowired
	ExecutiveService executiveService;
	
	public void filterDesignation(EmployeeEntity employeeEntity,SignupDao signupDao)
	{
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.MANAGER.toString()))
		{
			//ManagerService managerService = new ManagerService();
			managerService.addManager(employeeEntity,signupDao);
		}
		else if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.LEAD.toString()))
		{
			// LeadService leadService = new LeadService();
			 leadService.addLead(employeeEntity,signupDao);
		}
		if(employeeEntity.getEmployeeDesignation().equalsIgnoreCase(EmployeeTypes.EXECUTIVE.toString()))
		{
			//ExecutiveService executiveService = new ExecutiveService();
			executiveService.addExecutive(employeeEntity,signupDao);
		}
		
	}

}
