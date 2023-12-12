package com.itt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itt.constants.EmployeeTypes;
import com.itt.dao.CommonDao;
import com.itt.dao.ExecutiveDao;
import com.itt.dao.LeadDao;
import com.itt.dao.LeaveBalanceDao;
import com.itt.dao.LeaveRecordsDao;
import com.itt.dao.ManagerDao;
import com.itt.dao.SignupDao;
import com.itt.dao.UtilityDao;
import com.itt.logic.IdGenerator;
import com.itt.logic.LeaveDistributor;
import com.itt.modal.AddressEntity;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;

@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	CommonDao commonDao;
	
	@Autowired 
	LeaveBalanceDao leaveBalanceDao;
	
	@Autowired 
	UtilityDao utilityDao;
	
	@Autowired
	SignupDao signupDao;
	
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * 
	 * 
	 * @Autowired ManagerDao managerDao;
	 * 
	 * @Autowired LeadDao leadDao;
	 * 
	 * @Autowired ExecutiveDao executiveDao;
	 * 
	 * 
	 */
	
	@Autowired
	RegisterDesignation registerDesignation;

	
	public String saveEmployee(EmployeeEntity employeeEntity,AddressEntity employeeAddress)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		employeeEntity.setEmployeeId(IdGenerator.generateEmployeeID(employeeEntity,utilityDao));
		String password = encoder.encode(employeeEntity.getEmployeePass());
		employeeEntity.setEmployeePass(password);
		
		boolean isEmployeeAlreadyExisting;
		
		
		signupDao.insert(employeeEntity);
		
		employeeAddress.setEmployeeId(employeeEntity);
		
		signupDao.insert(employeeAddress);
		
		LeaveBalanceEntity leaveBalanceEntity = new LeaveBalanceEntity();
		leaveBalanceEntity.setEmployeeId(employeeEntity);
		leaveBalanceEntity.setMaternityLeave(LeaveDistributor.assignMaternintyLeave(employeeEntity.getEmployeeGender()));
		leaveBalanceEntity.setParentalLeave(LeaveDistributor.assignParentalLeave(employeeEntity.getEmployeeGender()));
		
		
		leaveBalanceDao.insertLeaveBalance(leaveBalanceEntity);
		//RegisterDesignation registerDesignation = new RegisterDesignation();
		registerDesignation.filterDesignation(employeeEntity,signupDao);
		
		
		
		return employeeEntity.getEmployeeId();
		
	}
	
	public List<String> getEmployeeEmailList()
	{
		return signupDao.getEmailList();
	}
	
	public List<String> getEmployeePhoneNumber()
	{
		return signupDao.getPhoneList();
	}

}
