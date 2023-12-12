<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
  	
  		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
  
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<style type="text/css">

#applyLeave{
	width:400px;
	background-color: rgb(200,200,200);
	position:fixed;
	top: 30%;
	left: 35%; 
	z-index: 1;
}

#applyLeave label{
padding-bottom: 10px;
padding-right: 10px;
padding-left: 10px;
}
#applyLeave form{
	padding:20px;
}

</style>

<%
	
%>

</head>
<body>



<div id="applyLeave">


<!-- Button trigger modal -->

<!-- Modal -->



		<span class="close" style="float: right;font-size: medium;cursor: pointer;padding: 10px;"onclick="hideModal('applyLeave')">&times;</span>
            <form method="post" action="applyLeave">
            	<label>Leave Type</label>
            <select class="form-select" aria-label="Default select example" id="select" name="leaveType" onchange="getLeaves()">
  				<option selected>Open this select menu</option>
 				<option value="<%= LeaveTypes.CASUAL_LEAVE.toString() %>">CASUAL_LEAVE</option>
  				<option value="<%= LeaveTypes.EARNED_LEAVE.toString() %>">EARNED_LEAVE</option>
  				<option value="<%= LeaveTypes.DUTY_LEAVE.toString() %>">DUTY_LEAVE</option>
  				<option value="<%= LeaveTypes.SICK_LEAVE.toString() %>">SICK_LEAVE</option>
  				<option value="<%= LeaveTypes.MATERNITY_LEAVE.toString() %>">MATERNITY_LEAVE</option>
  				<option value="<%= LeaveTypes.PARENTAL_LEAVE.toString() %>">PARENTAL_LEAVE</option>
  				<option value="<%= LeaveTypes.LEAVE_WITHOUT_PAY.toString() %>">LEAVE_WITHOUT_PAY</option>
			</select>
			<br>
			<h4 id="showRemainingLeaves" style="text-align: center;"></h4>
			<div style="display: flex;width: 100%;text-align: center;">
			<label>From</label><br>
			<input type="date" name="fromDate" id="start"><br>
			<label>To</label><br>
			<input type="date" name="toDate" id="end"><br>
			</div>
			<br>
			<label for="exampleFormControlTextarea1">Comment</label><br>
   			<textarea class="form-control" id="exampleFormControlTextarea1" name="leaveComment" rows="3"></textarea>
   			<br>
			<button type="submit" class="btn btn-primary" style="margin-right: auto;width:40%;">Submit</button>
            </form>
            </div>


</body>

<script>
function getLeaves()
{
	var leaveType = document.getElementById('select').value;
	
	var numberOfLeaves;
	
	//alert(pass);
	

	 
	 var url = "views/AjaxDisplayLeaves.jsp?leave="+leaveType;
	// alert(url);
	 var xmlHttpRequestObj = new XMLHttpRequest();
	 
	 xmlHttpRequestObj.onreadystatechange = function() {
		 
		 if(this.readyState==4 && this.status==200)
		 {
			 document.getElementById("showRemainingLeaves").innerHTML = "Leaves_Left "+this.responseText;
			 numberOfLeaves = (document.getElementById("showRemainingLeaves").innerHTML).trim();
		//	 alert(numberOfLeaves);
		 }
		 
	 };
	 
	 xmlHttpRequestObj.open("POST", url, true);
  	 xmlHttpRequestObj.send();
  	 
  	 
  	 return numberOfLeaves;
}

document.getElementById("start").addEventListener("change",function()
		{
	var date1 = document.getElementById("start").value;
	document.getElementById("end").setAttribute("min", date1);
		});

document.getElementById("end").addEventListener("change",function()
		{
	var selectedLeave = document.getElementById("select").value;
	const array = selectedLeave.split("_");
	var str = document.getElementById("showRemainingLeaves").innerHTML;
	var matches = str.match(/(\d+)/);
	var numberOfLeavesLeft = parseInt(matches[0]);
	var date1 = document.getElementById("start").value;
	console.log(date1);
	var date2 = document.getElementById("end").value;
	var initialDate = new Date(date1);
	var endDate = new Date(date2);
	document.getElementById("end").setAttribute("min", date1);
	var dateDiff = Math.abs(endDate - initialDate);
	var numberOfDays = Math.ceil(dateDiff / (1000 * 60 * 60 * 24));
	if(array[0]==="CASUAL" && numberOfDays > 2)
	{
		Swal.fire("Warning : Casual leaves cannot be applied for more than 2 days");
	document.getElementById("end").value=Date.parse(0);
	}
	if(numberOfDays > numberOfLeavesLeft && array[0]!="DUTY")
		{
		Swal.fire("You Don't have "+numberOfDays+" leaves, "+numberOfLeavesLeft+"days left");
	//	alert();
		document.getElementById("start").value=Date.parse(0);
		document.getElementById("end").value=Date.parse(0);
		}
	
	if(date1 >= date2)
		{
		Swal.fire("Invalid date");
		document.getElementById("end").value=Date.parse(0);
		document.getElementById("start").value=Date.parse(0);
		}
		});

</script>
</html>