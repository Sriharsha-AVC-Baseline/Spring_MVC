package com.itt.controller;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itt.service.EmployeeListService;
import com.itt.service.GenerateEmployeeList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeListController {
	
	@Autowired
	GenerateEmployeeList employeeListService;
	
	@RequestMapping(value = "/GetList")
	public String getList(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.setAttribute("executives", employeeListService.getExecEmployeeEntities());
		session.setAttribute("leads", employeeListService.getLeadsEmployeeEntities());
		session.setAttribute("managers", employeeListService.getManagerEmployeeEntities());
		return "employeeList";
	}

}
