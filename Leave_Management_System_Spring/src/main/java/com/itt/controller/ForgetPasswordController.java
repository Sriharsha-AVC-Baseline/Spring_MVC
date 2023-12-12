package com.itt.controller;

import java.net.http.HttpRequest;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;
import com.itt.service.ForgetPasswordService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class ForgetPasswordController {
	
	@Autowired
	ForgetPasswordService forgetPasswordService;
	
	EmployeeEntity validEmployee;
	
	@RequestMapping("/forgotPassword")
	public String getForgotPasswordForm()
	{
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/Verify",method = RequestMethod.POST)
	public ModelAndView verifyUser(ModelAndView mv,@RequestParam(name = "employeeID") String employeeID
			,@RequestParam(name="dob") String dob,@RequestParam(name="email") String email,HttpServletRequest httpRequest) throws ParseException
	{
		this.validEmployee = forgetPasswordService.verifyUser(employeeID, dob, email);
		if(this.validEmployee == null)
		{
			mv.setViewName("redirect:forgotPassword");
		}
		else
		{
			mv.setViewName("resetPassword");
		}
		HttpSession session = httpRequest.getSession();
		session.setAttribute("employee", this.validEmployee);
		return mv;
	}
	
	@RequestMapping(value = "/reset",method = RequestMethod.POST)
	public ModelAndView resetPassword(ModelAndView mv,@RequestParam(name="employeePassword") String employeePassword,HttpServletRequest request) throws ParseException
	{
		HttpSession session = request.getSession();
		EmployeeEntity validEmployee = (EmployeeEntity) session.getAttribute("employee");
		
		forgetPasswordService.resetUser(employeePassword, validEmployee);
		mv.setViewName("index");
		return mv;
	}

	
	
	
}
