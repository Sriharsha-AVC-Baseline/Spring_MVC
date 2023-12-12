package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.dao.CommonDao;
import com.itt.dao.ExecutiveDao;
import com.itt.dao.SignupDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.ExecutiveEntity;
import com.itt.modal.LeadsEntity;

@Service("executiveService")
public class ExecutiveService {
	
	@Autowired 
	ExecutiveDao dao;
	
	public void addExecutive(EmployeeEntity employeeEntity,SignupDao signupDao)
	{
		this.dao = new ExecutiveDao();
		LeadsEntity myLead = signupDao.getSuitableLead();
		//dao.hibernateTemplate = commonDao.getSession();
		if(myLead==null)
		{
			return;
		}
		ExecutiveEntity newExecutive = new ExecutiveEntity();
		newExecutive.setMyEmployeeId(employeeEntity);
		newExecutive.setMyLead(myLead);
		newExecutive.setMyManager(myLead.getMyManager());
		signupDao.insert(newExecutive);
		System.out.println(newExecutive.getMyLead().getMyEmployeeId().getEmployeeId()+" "+newExecutive.getMyLead().getExecutivesUnderMe());
		signupDao.updateLead(newExecutive.getMyLead());
	}

}
