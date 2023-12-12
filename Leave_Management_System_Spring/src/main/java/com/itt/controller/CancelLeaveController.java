package com.itt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.CancelLeaveService;
import com.itt.service.CommonServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CancelLeaveController {

	
	@Autowired
	CancelLeaveService cancelLeaveService;
	
	@Autowired
    CommonServices commonServices;	
	
	@RequestMapping(value = "/CancelLeave")
	public String goToPage(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		EmployeeEntity currentEmployee = (EmployeeEntity)session.getAttribute("employeeDetails");
		session.setAttribute("pendingRecords", commonServices.fetchPendingLeaves(currentEmployee));
		return "cancel_leave";
	}
	
	@RequestMapping(value = "/SubmitCancelLeave",method =RequestMethod.POST )
	public ModelAndView getCancelRequest(ModelAndView mv,@RequestParam(name = "leaveId") 
	String[] leaveId,HttpServletRequest request)
	{
		for(String ids:leaveId)
		{
			cancelLeaveService.cancelLeave(ids);
		}
		
		HttpSession session = request.getSession();
		
		EmployeeEntity thisEmployeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		thisEmployeeEntity = commonServices.reloadEmployee(thisEmployeeEntity.getEmployeeId());
		
		session.setAttribute("employeeDetails", thisEmployeeEntity);
		
		request.setAttribute("message", "Swal.fire('Leave Cancelled');");
		
		mv.setViewName("redirect:CancelLeave");
		return mv;
	}
}
