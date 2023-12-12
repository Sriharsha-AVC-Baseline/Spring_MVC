package com.itt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.AddressEntity;
import com.itt.modal.EmployeeEntity;
import com.itt.service.EmployeeService;
import com.itt.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class HomeController {
	
	@Autowired
	public EmployeeService service;
	
	@Autowired
	public LoginService loginService;
	
	
	@RequestMapping("/")
	public String homePage()
	{
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
	
	
	@RequestMapping("/signup")
	public String setForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		List<String> emails = service.getEmployeeEmailList();
		List<String> phone = service.getEmployeePhoneNumber();

		session.setAttribute("phoneNumbers", phone);
		session.setAttribute("emails",emails);
		return "signup";
	}
	
	@RequestMapping(path = "/Signup",method = RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute EmployeeEntity employeeEntity,@ModelAttribute AddressEntity addressEntity, ModelAndView mv,HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		String employeeID = service.saveEmployee(employeeEntity,addressEntity);
		PrintWriter pw = response.getWriter();
		request.setAttribute("employeeID", employeeID);
		request.setAttribute("name", employeeEntity.getEmployeeName());
		mv.setViewName("index");
		int a=0;
		return mv;
	}

	
	@RequestMapping("/back")
	public String goBack(HttpServletRequest request)
	{
		EmployeeEntity employeeEntity = (EmployeeEntity)request.getSession().getAttribute("employeeDetails");
		return employeeEntity.getEmployeeDesignation().toLowerCase();
	}
	
}
