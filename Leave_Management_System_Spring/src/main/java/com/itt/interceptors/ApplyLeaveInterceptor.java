package com.itt.interceptors;

import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import com.itt.constants.LeaveStatus;
import com.itt.modal.EmployeeEntity;
import com.itt.modal.LeaveRecordsEntity;
import com.itt.util.DateHelper;

import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApplyLeaveInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		EmployeeEntity currentEmployee = (EmployeeEntity)request.getSession().getAttribute("employeeDetails");
		
		List<LeaveRecordsEntity> hisLeaves = currentEmployee.getLeaveRecordsEntity();
		
		java.util.Date secondStart = DateHelper.readDate(request.getParameter("fromDate"));
		java.util.Date secondEnd = DateHelper.readDate(request.getParameter("toDate"));
		
		for(LeaveRecordsEntity leaveRecord:hisLeaves)
		{
			java.util.Date firstStart = new Date(leaveRecord.getFromDate().getTime());
			java.util.Date firstEnd = new Date(leaveRecord.getToDate().getTime());
			String leaveStatus = leaveRecord.getLeaveStatus();

			if((DateHelper.checkOverlapConditions(firstStart, firstEnd, secondStart, secondEnd) == false))
			{
				if(leaveStatus.equalsIgnoreCase(LeaveStatus.CANCELLED.toString()) || leaveStatus.equalsIgnoreCase(LeaveStatus.REJECTED.toString()) || leaveStatus.equalsIgnoreCase(LeaveStatus.REVOKED.toString()))
				{
					continue;
				}
				response.getWriter().println("<script>alert('Another leave was applied before');</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/back");
				dispatcher.include(request, response);
				return false;
			}
		}
		
		return true;
	}

	

	

}
