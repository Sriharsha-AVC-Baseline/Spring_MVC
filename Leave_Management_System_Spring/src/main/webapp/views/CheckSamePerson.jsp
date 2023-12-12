
<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.tomcat.websocket.ClientEndpointHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="java.util.*"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>

<%

	List<String> phoneNumbers = (List<String>)session.getAttribute("phoneNumbers");
	List<String> emails = (List<String>)session.getAttribute("emails");

	String enteredPhoneNumber = "+" + request.getParameter("phone").trim();
	String enteredEmail = request.getParameter("email");
	boolean isEmployeePresent = false;
	System.out.println(enteredPhoneNumber+" "+phoneNumbers.contains(enteredPhoneNumber));
	if(phoneNumbers.contains(enteredPhoneNumber) || emails.contains(enteredEmail))
	{
		isEmployeePresent = true;
		
	}

%>


</head>
<body>
<%= isEmployeePresent %>
</body>
</html>