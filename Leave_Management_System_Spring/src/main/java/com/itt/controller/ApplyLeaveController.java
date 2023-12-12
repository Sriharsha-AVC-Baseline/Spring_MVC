package com.itt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itt.dao.UtilityDao;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.ApplyLeaveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApplyLeaveController {
	
	@Autowired
	ApplyLeaveService applyLeaveService;
	
	
	@RequestMapping(value = "/applyLeave",method = RequestMethod.POST)
	public ModelAndView applyLeave(ModelAndView mv,HttpServletRequest request,@ModelAttribute LeaveRecordsEntity leaveRecordsEntity)
	{
		HttpSession session = request.getSession();
		EmployeeEntity thisEmployee = (EmployeeEntity)session.getAttribute("employeeDetails");
		applyLeaveService.applyLeaveData(leaveRecordsEntity, thisEmployee);
		mv.setViewName(thisEmployee.getEmployeeDesignation().toLowerCase());
		thisEmployee = applyLeaveService.reloadEmployeeDetails(thisEmployee);
		session.setAttribute("employeeDetails", thisEmployee);
		request.setAttribute("message", "Swal.fire('Leave Applied');");
		return mv;
	}
	
}
