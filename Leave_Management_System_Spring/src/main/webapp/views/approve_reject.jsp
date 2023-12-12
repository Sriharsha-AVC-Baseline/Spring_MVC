<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="com.itt.constants.*" %>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  	<link href="css_scripts/dashboardPage.css" rel="stylesheet">
  	<script src="javascript/dashboard.js"></script>
	
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

  		<script
    src="https://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous">
		</script>
  	
<%

%>

<style type="text/css">
	#cancelLeave{
	width:80%;
	margin: auto;

	position:fixed;
	top: 10%;
	left: 10%; 
	z-index: 1;
	}
	


</style>

<body>
<div id="approveLeave">
<span class="close" style="float: right;font-size: medium;cursor: pointer;padding: 10px;"onclick="hideModal('cancelLeave')">&times;</span>
<h2 style="text-align: center;">Approve Or Reject leave</h2>

<form action="SubmitVerdict" method="post">
<div>
	<h2 style="text-align: center">Leave Records</h2>
	
	 <select style="width: 60%;margin-left: auto;margin-right: auto;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="result" id="verdict" onchange="getVerdict('verdict')">
  	<option value="<%= LeaveStatus.APPROVED.toString()%>" style="color: green">Approve</option>
  	<option value="<%= LeaveStatus.REJECTED.toString() %>" style="color: red;">Reject</option>
  	</select>
	<h4 id="message" style="text-align: center;">Selected for Approval</h4>
	<table class="table">
	<tr>
	<th>Leave ID</th>
	<th>Employee Name</th>
	<th>Leave Type</th>
	<th>From date</th>
	<th>To date</th>
	<th>Status</th>
	<th>Comment</th>
	<th>Number of days</th>
	</tr>
<c:forEach items="${sessionScope.records}" var="element"> 
  <tr>
  	<td><input type="checkbox" id="leaveID" name="leaveId" value="${element.getLeaveID()}"> ${element.getLeaveID()} </td>
    <td>${element.getEmployeeId().getEmployeeName()}</td>
    <td>${element.getLeaveType()}</td>
    <td>${element.getFromDate()}</td>
    <td>${element.getToDate()}</td>
    <td>${element.getLeaveStatus()}</td>
    <td>${element.getLeaveComment()}</td>
    <td>${element.getNumberOfDays()}</td>
  </tr>
</c:forEach>
</table>
<br>

<button type="submit" class="btn btn-success" style="margin-left: 44%;">Submit</button>

<button type="button" class="btn btn-danger"><a style="text-decoration: none;color: white;" href="back">Back</a></button>
</div>
</div>

<script type="text/javascript">
	function getVerdict(parameter)
	{
		var verdict = document.getElementById(parameter).value;
		if(verdict==1)
			{
			 document.getElementById("message").innerHTML = "Select to Approve";
			 document.getElementById("message").style.color="green";
			}
		else
			{
			document.getElementById("message").innerHTML = "Select to Reject";
			document.getElementById("message").style.color="red";
			}
	}

</script>
</body>
</html>