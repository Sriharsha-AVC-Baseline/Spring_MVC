package com.itt.logic;

import com.itt.constant_values.Leaves;
import com.itt.constants.Gender;
import com.itt.modal.EmployeeEntity;

public class LeaveDistributor {
	
	public static int assignMaternintyLeave(String employeeGender)
	{
		if(employeeGender.equalsIgnoreCase(Gender.MALE.toString()))
		{
			return 0;
		}
		return Leaves.MATERNITY_LEAVE;
	}
	
	public static int assignParentalLeave(String employeeGender)
	{
		if(employeeGender.equalsIgnoreCase(Gender.MALE.toString()))
		{
			return Leaves.PARENTAL_LEAVE;
		}
		return 0;
	}
	

}
