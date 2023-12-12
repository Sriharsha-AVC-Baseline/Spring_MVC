
<%@page import="org.apache.tomcat.websocket.ClientEndpointHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.itt.constants.*" %>
<%@ page import="com.itt.modal.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>

<%
	Map<String,Integer> leaveMap = new LinkedHashMap<>();
	EmployeeEntity entity = (EmployeeEntity)session.getAttribute("employeeDetails");
	leaveMap.put(LeaveTypes.CASUAL_LEAVE.toString(), entity.getLeaveBalanceEntity().getCasualLeave());
	leaveMap.put(LeaveTypes.EARNED_LEAVE.toString(),entity.getLeaveBalanceEntity().getEarnedLeave());
	leaveMap.put(LeaveTypes.DUTY_LEAVE.toString(),entity.getLeaveBalanceEntity().getDutyLeave());
	leaveMap.put(LeaveTypes.SICK_LEAVE.toString(),entity.getLeaveBalanceEntity().getSickLeave());
	leaveMap.put(LeaveTypes.MATERNITY_LEAVE.toString(),entity.getLeaveBalanceEntity().getMaternityLeave());
	leaveMap.put(LeaveTypes.PARENTAL_LEAVE.toString(),entity.getLeaveBalanceEntity().getParentalLeave());
	leaveMap.put(LeaveTypes.LEAVE_WITHOUT_PAY.toString(),entity.getLeaveBalanceEntity().getLeaveWithoutPay());

	String leaveType= request.getParameter("leave");
	
	request.setAttribute("records", leaveMap);
%>
</head>
<body>
<%= leaveMap.get(leaveType) %>
</body>
</html>