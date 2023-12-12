package com.itt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveBalanceEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.LeaveHistoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LeaveHistoryController {
	
	@Autowired
	LeaveHistoryService leaveHistoryService;

	@RequestMapping("/approvedLeaves")
	public ModelAndView getApprovedHistory(HttpServletRequest request,ModelAndView mv)
	{
		HttpSession session = request.getSession();
		EmployeeEntity employeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		List<LeaveRecordsEntity> leaveHistory =  leaveHistoryService.getApprovedLeaveRecords(employeeEntity);
		session.setAttribute("employeeLeaveHistory", leaveHistory);
		mv.setViewName("history");
		return mv;
		
	}
	@RequestMapping("/rejectedLeaves")
	public ModelAndView getRejectedHistory(HttpServletRequest request,ModelAndView mv)
	{
		HttpSession session = request.getSession();
		EmployeeEntity employeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		List<LeaveRecordsEntity> leaveHistory =  leaveHistoryService.getRejectedLeaveRecords(employeeEntity);
		session.setAttribute("employeeLeaveHistory", leaveHistory);
		mv.setViewName("history");
		return mv;
		
	}
	@RequestMapping("/revokedLeaves")
	public ModelAndView getRevokedHistory(HttpServletRequest request,ModelAndView mv)
	{
		HttpSession session = request.getSession();
		EmployeeEntity employeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		List<LeaveRecordsEntity> leaveHistory =  leaveHistoryService.getRevokedLeaveRecords(employeeEntity);
		session.setAttribute("employeeLeaveHistory", leaveHistory);
		mv.setViewName("history");
		return mv;
		
	}
	
	
}
