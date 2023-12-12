package com.itt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.dao.ForgetPasswordDao;
import com.itt.modal.EmployeeEntity;
import com.itt.util.DateHelper;

import java.sql.*;
import java.text.ParseException;

@Service
public class ForgetPasswordService {
	
	@Autowired
	ForgetPasswordDao forgetPasswordDao;

	public EmployeeEntity verifyUser(String employeeID,String dob,String email) throws ParseException
	{
		java.sql.Date dateOfBirth = new java.sql.Date(DateHelper.readDate(dob).getTime());
		EmployeeEntity isValidEmployee = forgetPasswordDao.verifyUserInDao(employeeID, email, dateOfBirth);
		return isValidEmployee;
	}
	
	public void resetUser(String password,EmployeeEntity validEmployee) throws ParseException
	{
		validEmployee.setEmployeePass(password);
		forgetPasswordDao.resetPasswordDao(validEmployee);
	}
	
}
