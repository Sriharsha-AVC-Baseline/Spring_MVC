package com.itt.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;

public class IdGenerator {
	
	public static String generateEmployeeID(EmployeeEntity e,UtilityDao utilityDao)
	{
		String initialName = String.valueOf(e.getEmployeeName().charAt(0)).toUpperCase();
		String initialSurName = String.valueOf(e.getEmployeeSurName().charAt(0)).toUpperCase();
		String initialDesignation = String.valueOf(e.getEmployeeDesignation().charAt(0)).toUpperCase();
		
		long uniqueID = utilityDao.getUserCount();
		
		String employeeID = "EMP" + initialName + initialSurName + initialDesignation +String.valueOf(uniqueID);
		
		return employeeID;
	}

}
