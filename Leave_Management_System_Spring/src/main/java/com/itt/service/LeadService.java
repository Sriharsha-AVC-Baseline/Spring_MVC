package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.dao.CommonDao;
import com.itt.dao.LeadDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.SignupDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeadsEntity;
import com.itt.modal.ManagerEntity;

@Service("leadService")
public class LeadService {
	
	@Autowired
	LeadDao leadDao;

	public void addLead(EmployeeEntity employeeEntity,SignupDao signupDao)
	{
		this.leadDao = new LeadDao();
		ManagerEntity myManager = signupDao.getSuitableManager();
		//leadDao.hibernateTemplate = commonDao.getSession();
		if(myManager==null)
		{
			return;
		}
		LeadsEntity leadsEntity = new LeadsEntity();
		leadsEntity.setMyEmployeeId(employeeEntity);
		leadsEntity.setExecutivesUnderMe(0);
		leadsEntity.setMyManager(myManager);
		System.out.println(leadsEntity.getMyManager().toString()+" "+leadsEntity.getMyEmployeeId().getEmployeeId()+" "+leadsEntity.getExecutivesUnderMe());
		signupDao.insert(leadsEntity);
		signupDao.updateManager(leadsEntity.getMyManager());
	}
	
}
