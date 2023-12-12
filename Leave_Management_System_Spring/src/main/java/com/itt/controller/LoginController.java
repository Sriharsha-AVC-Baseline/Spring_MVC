package com.itt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.constants.EmployeeTypes;
import com.itt.dao.LoginDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(path="/login",method = RequestMethod.POST)
	public ModelAndView login(ModelAndView modelView,@RequestParam(name = "employeeMail") String employeeMail,
			@RequestParam(name = "password") String employeePassword,HttpServletRequest request)
	{
		String result;
		EmployeeEntity loggedUser = loginService.designationPage(employeeMail, employeePassword);
		
		if(loggedUser == null)
		{
			modelView.setViewName("redirect:/");
			request.setAttribute("message", "Swal.fire('Invalid username or password...');");
			return modelView;
		}
		
		String designation = loggedUser.getEmployeeDesignation();
		HttpSession session = request.getSession();
		session.setAttribute("employeeDetails",loggedUser);
		modelView.addObject("designation", designation);
		request.setAttribute("message", "Swal.fire('Welcome "+loggedUser.getEmployeeName()+"!');");
		modelView.setViewName(designation.toLowerCase());
		System.out.println(loggedUser.getLeaveBalanceEntity().getCasualLeave());
		loggedUser.getLeaveRecordsEntity();
		return modelView;
	}
	

	
}
