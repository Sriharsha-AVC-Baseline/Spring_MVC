package com.itt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.service.ApproveRejectLeaveService;
import com.itt.service.CommonServices;
import com.itt.service.RevokeLeaveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RevokeLeaveController {
	
	@Autowired
	RevokeLeaveService revokeLeaveService;
	
	@Autowired
	CommonServices commonServices;
	
	@RequestMapping("/revoke")
	public String goToApprovalPage(HttpServletRequest request)
	{
		EmployeeEntity currentEmployee = (EmployeeEntity)request.getSession().getAttribute("employeeDetails");
		List<LeaveRecordsEntity> records = revokeLeaveService.getLeaveRecordsOfEmployeesUnderMe(currentEmployee);
		HttpSession session = request.getSession();
		session.setAttribute("records", records);
		return "revoke";
	}
	

	@RequestMapping(value = "/SubmitRevoke",method = RequestMethod.POST)
	public ModelAndView apprroveRejectLeave(HttpServletRequest request,@RequestParam(name = "leaveId") String[] leaveIds,ModelAndView mv )
	{
		HttpSession session = request.getSession();
		EmployeeEntity employeeEntity = (EmployeeEntity)session.getAttribute("employeeDetails");
		for(String id:leaveIds)
		{
			revokeLeaveService.revokeLeave(id);
		}
		session.setAttribute("employeeDetails", commonServices.reloadEmployee(employeeEntity.getEmployeeId()));
		 mv.setViewName("redirect:revoke");
		 request.setAttribute("message", "Swal.fire('Applications processed');");
		 return mv;
	}

	
	

}
