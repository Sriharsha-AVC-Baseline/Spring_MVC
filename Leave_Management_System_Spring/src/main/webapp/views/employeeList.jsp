<%@page import="com.itt.modal.EmployeeEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false" %>
<%@ page import="com.itt.constants.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  	<link href="Resources/dashboardPage.css" rel="stylesheet">
  	<script src="Resources/dashboard.js"></script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
      <style>
      .table th{
      		text-align: center;
      }
      .table td{
      		text-align: center;
      }
      
      .table{
      	margin-left: 40px;
      	width:90%;
      }
      
      </style>
      
      <%
      	
      EmployeeEntity employee = (EmployeeEntity) session.getAttribute("employeeDetails");
      String employeeInitial = String.valueOf(employee.getEmployeeName().charAt(0)).toUpperCase();
      request.setAttribute("employeeInitial", employeeInitial);
      %>
      
</head>
<body>
		<div id="header" >
         <h1 style="text-align: center;color: blueviolet;margin-left: auto;">Java On Time</h1>
        <div class="drop">
            <button class="drop_button" onclick="disable('Content')" id="drop_button">${employeeInitial}</button>
            </div>
        	</div>
            <div id="Content" class="contents" >
                <ul style="list-style: none;" >
                <li>${sessionScope.employeeDetails.getEmployeeName()}</li>
                <li>${sessionScope.employeeDetails.getEmployeeDesignation()}</li>
               
                <li><a href="logout" style="color: red;"><i class="fa fa-close"></i> Logout</a></li>
                </ul>
                
            </div>
      <br><br>      
	
<div id="Managers">
<h2 style="text-align: center">Managers</h2>
	<table class="table table-bordered">
	<tr>
	<th>Name</th>
	<th>Mail</th>
	<th>Phone number</th>

	</tr>
<c:forEach items="${sessionScope.managers}" var="element"> 
  <tr>
    <td>${element.getEmployeeName()}</td>
    <td>${element.getEmployeeMail()}</td>
    <td>${element.getEmployeePhone()}</td>
  </tr>
</c:forEach>
</table>

</div>

<br><br>

<div id="Leads">
	<h2 style="text-align: center">Leads</h2>
	<table class="table table-bordered">
	<tr>
	<th>Name</th>
	<th>Mail</th>
	<th>Phone number</th>


	</tr>
<c:forEach items="${sessionScope.leads}" var="element"> 
  <tr>
    <td>${element.getEmployeeName()}</td>
    <td>${element.getEmployeeMail()}</td>
    <td>${element.getEmployeePhone()}</td>

  </tr>
</c:forEach>
</table>

</div>

<br><br>
<div id="Executives">
	<h2 style="text-align: center">Executives</h2>
	<table class="table table-bordered">
	<tr>
	<th>Name</th>
	<th>Mail</th>
	<th>Phone number</th>

	</tr>
<c:forEach items="${sessionScope.executives}" var="element"> 
  <tr>
    <td>${element.getEmployeeName()}</td>
    <td>${element.getEmployeeMail()}</td>
    <td>${element.getEmployeePhone()}</td>

  </tr>
</c:forEach>
</table>
<br><br>
<a style="text-decoration: none;text-align: center;padding: 10px;color:white;margin-left:46%;background-color: red;" href="back">Back</a>

</div>
<br>

<br>
<br>
<h1></h1>
</body>
</html>