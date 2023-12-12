package com.itt.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.ApproveRejectLeaveService;
import com.itt.service.CommonServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApproveRejectController  {


	@Autowired
	ApproveRejectLeaveService approveRejectLeaveService;
	
	@Autowired
	CommonServices commonServices;
	
	@RequestMapping("/approveLeave")
	public String goToApprovalPage(HttpServletRequest request)
	{
		EmployeeEntity currentEmployee = (EmployeeEntity)request.getSession().getAttribute("employeeDetails");
		List<LeaveRecordsEntity> records = approveRejectLeaveService.getLeaveRecordsOfEmployeesUnderMe(currentEmployee);
		HttpSession session = request.getSession();
		session.setAttribute("records", records);
		return "approve_reject";
	}
	

	@RequestMapping(value = "/SubmitVerdict",method = RequestMethod.POST)
	public ModelAndView apprroveRejectLeave(HttpServletRequest request,@RequestParam(name = "leaveId") String[] leaveIds, @RequestParam(name = "result") String verdict,ModelAndView mv )
	{
		HttpSession session = request.getSession();
		EmployeeEntity employeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		for(String id:leaveIds)
		{
			approveRejectLeaveService.approveRejectLeave(employeeEntity, id, verdict);
		}
		session.setAttribute("employeeDetails", commonServices.reloadEmployee(employeeEntity.getEmployeeId()));
		 mv.setViewName(employeeEntity.getEmployeeDesignation().toLowerCase());
		 request.setAttribute("message", "Swal.fire('Applications processed');");
		 return mv;
	}



}
