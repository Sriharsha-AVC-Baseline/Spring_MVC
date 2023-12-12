<%@page import="com.itt.modal.EmployeeEntity"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored = "false" %>
<%@ page import="java.util.*" %>
<%@ page import="com.itt.*" %>
<%@ page import="com.itt.modal.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	  		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	  		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link href="Resources/dashboardPage.css" rel="stylesheet">
  	<script src="Resources/dashboard.js"></script>
  		<script
    src="https://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous">
		</script>
  	


<style type="text/css">

#sidemenu{

	background-color: rgb(240,240,240);
	width:20%;
	
}

#sideContents button{
	padding-bottom:10px;
	padding-top:10px;
	border:none;
	color: black;
	font-family:cursive;
	font-size: larger;
}

#sideContents button:hover{
	background-color: rgb(220,220,220);
}

#sideContents
{
	padding-left: 10px;	
	align-items: center;
}

#body
{

	display: flex;
}





</style>
  <%
  
  EmployeeEntity employee = (EmployeeEntity)session.getAttribute("employeeDetails");
  String name = employee.getEmployeeName();
  request.setAttribute("NameInitial", String.valueOf(name.charAt(0)).toUpperCase());
  %>
  
</head>
<body>
	
	<div id="header" >
		<button style="border: none;" onclick="disable('sidemenu')"><img id="buttonImage" alt="" onclick="disableImage('buttonImage')" src="https://w7.pngwing.com/pngs/639/1013/png-transparent-hamburger-button-computer-icons-drop-down-list-fast-food-menu-rectangle-share-icon-pancake.png" width="50" height="40"></button>
         <h1 style="text-align: center;color: blueviolet;margin-left: auto;">Java On Time</h1>
        <div class="drop">
            <button class="drop_button" onclick="disable('Content')" id="drop_button">${NameInitial}</button>
           </div>
        	</div>
            <div id="Content" class="contents" >
                <ul style="list-style: none;" >
                <li>${sessionScope.employeeDetails.getEmployeeName()}</li>
                <li>${sessionScope.employeeDetails.getEmployeeDesignation()}</li>
                 <li><a href="#" data-toggle="modal" data-target="#exampleModal">My Leave Records</a></li>
                <li><a href="logout" style="color: red;"><i class="fa fa-close"></i> Logout</a></li>
                </ul>
                
            </div>
            
            
            
            <div id="body">
            
      <div id="sidemenu">
            
            <div id="sideContents">
            <a href="#"  onclick="showModal('applyLeave')"><button>Apply for leave</button></a> <br>
           <a href="CancelLeave"><button>Cancel leave</button></a> <br>
           <a href="availLeave"><button>Avail leave</button></a> <br>
           <a href="approveLeave"><button>Approve/Reject leave</button></a> <br>
           <a href="revoke"><button>Revoke leave</button></a> <br>
           <a onclick="hideShow('subLeaves')"><button>Leave Verdict History</button></a>
           <ul id="subLeaves" style="visibility: hidden;">
           	<a href="approvedLeaves"><button>Approved Leaves</button></a>
           	<a href="rejectedLeaves"><button>Rejected Leaves</button></a>
           	<a href="revokedLeaves"><button>Revoked Leaves</button></a>
           </ul>
         </div>
            </div>
            
            <div style="font-style: italic;text-align: center;width: 80%;">
     <h1>Welcome ${sessionScope.employeeDetails.getEmployeeName()}, you are logged as ${sessionScope.employeeDetails.getEmployeeDesignation()}  </h1>
	
   
   <!--  Leave Balance -->
   
   
   <div id="leaveBalance" style="visibility: visible;">
   
   <h2 style="text-align: center;">Leave Balance</h2>
 <table class="table">
  <thead>
    <tr>
      <th scope="col">Sl no</th>
      <th scope="col">Leave Type</th>
      <th scope="col">Balance (in days)</th>
    </tr>
  </thead>
  <tbody>
   <tr>
      <th scope="row">1</th>
      <td>CASUAL_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getCasualLeave()}</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>EARNED_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getEarnedLeave()}</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>DUTY_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getDutyLeave()}</td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>SICK_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getSickLeave()}</td>
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>MATERNITY_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getMaternityLeave()}</td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>PARENTAL_LEAVE</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getParentalLeave()}</td>
    </tr>
    <tr>
      <th scope="row">1</th>
      <td>LEAVE_WITHOUT_PAY</td>
      <td>${sessionScope.employeeDetails.getLeaveBalanceEntity().getLeaveWithoutPay()}</td>
    </tr>
  </tbody>
</table>
 </div>
</div>
</div>

<div id="applyLeave"  style="visibility: hidden;"> </div>

<div id="cancelLeave" style="visibility: hidden;"> </div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="right: 50%;width: 200%;">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
	<h2 style="text-align: center">Leave Records</h2>
	<table class="table">
	<tr>

	<th>Leave Type</th>
	<th>From date</th>
	<th>To date</th>
	<th>Status</th>
	<th>Number of days</th>
	</tr>
<c:forEach items="${sessionScope.employeeDetails.getLeaveRecordsEntity()}" var="element"> 
  <tr>

    <td>${element.getLeaveType()}</td>
    <td>${element.getFromDate()}</td>
    <td>${element.getToDate()}</td>
    <td>${element.getLeaveStatus()}</td>
    <td>${element.getNumberOfDays()}</td>
  </tr>
</c:forEach>
</table>
<br><br>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

        
        
        <script>
       
         <%= request.getAttribute("message") %>
        
        $(function(){
      	  $("#applyLeave").load("views/apply_leave.jsp");
      	  $("#cancelLeave").load("views/cancel_leave.jsp");
      	});
        

        
        function hideShow(parameter)
        {
        	var id = ('#'+parameter);
        	var status =  document.querySelector(id).style.visibility;
        	if(status=='hidden')
        		{
        	 	document.querySelector(id).style.visibility='visible';
        		}
        	else 
        		{
        		document.querySelector(id).style.visibility='hidden';
        		}
        }
        
        function disable(id)
        {
            var status =  document.getElementById(id).style.visibility;
            if(status=='hidden')
                {
                    document.getElementById(id).style.visibility='visible';
                }
            else
                {
                    document.getElementById(id).style.visibility='hidden';
                }
        }
        
        
        function disableImage(id)
        {
            var status =  document.getElementById(id).src;
            var hideIcon = 'https://cdn.iconscout.com/icon/premium/png-256-thumb/dropdown-menu-1823407-1545777.png?f=webp';
            var showIcon = 'https://w7.pngwing.com/pngs/639/1013/png-transparent-hamburger-button-computer-icons-drop-down-list-fast-food-menu-rectangle-share-icon-pancake.png';
            
            if(status==showIcon)
                {
                    document.getElementById(id).src=hideIcon;
                }
            else
                {
            	document.getElementById(id).src=showIcon;
                }
        }
        
        </script>
        
        <footer style="background-color: black; position:fixed;bottom: 0;text-align: center;width: 100%;">
        <h1 style="color: White">InTimeTec</h1>
        </footer>
</body>
</html>