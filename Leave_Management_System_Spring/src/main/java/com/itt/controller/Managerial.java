package com.itt.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itt.modal.EmployeeEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface Managerial {
	
	public ModelAndView apprroveRejectLeave(HttpServletRequest request,@RequestParam(name = "leaveID") String[] leaveIds, @RequestParam(name = "result") String verdict,ModelAndView mv);
	
	public ModelAndView revokeLeave();

}
