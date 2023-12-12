package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itt.dao.LoginDao;
import com.itt.modal.EmployeeEntity;

@Service
public class LoginService {
	
	@Autowired
	public LoginDao loginDao;
	
	public EmployeeEntity designationPage(String employeeMail,String password)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		EmployeeEntity employeeEntity = loginDao.getDesignation(employeeMail,password);
		
		if(employeeEntity==null)
		{
			return employeeEntity;
		}
		
		if(encoder.matches(password, employeeEntity.getEmployeePass()))
		{
			return employeeEntity;
		}
		
		employeeEntity = null;
		
		return employeeEntity;
		
	
	}

}
