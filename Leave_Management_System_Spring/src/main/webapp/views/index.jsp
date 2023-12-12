<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css_scripts//home1.css"> 
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
	  		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
	 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 
    <title>Hello, world!</title>
    
    
    
    <style>
    h2{
	text-align: center;
	
		
}



#exampleInputID{
	width: 86%;
    margin-left: 30px;
}

#exampleInputPassword1
{
	width: 86%;
    margin-left: 30px;
}
 button{
	 margin-left: 40%;
	 margin-top: 4%;
	 margin-bottom: 4%;
	 width: 20%;
    height: 50px
 }

label{
	margin-left: 5%;
	font-weight: bold;
}


.center{
	
	width: 40%;
	margin: auto;
	margin-top: 5%;
}

.form-group input{
	  border:0;
  border-bottom:1px solid #555;  
  width:100%;
  padding:8px 0 5px 0;
  font-size:16px;
}

.form-group input:focus{
 
  background:transparent;
  color:black;

}
 
}

.form-group label{
	color: white;
}


    </style>
    
    
    
  </head>


<body style="background-color:rgb(199, 180, 255);">

<%

/* 	String name = (String)request.getAttribute("name");
	String id = (String)request.getAttribute("employeeID");
	String message = null;
	if(name!=null && id!=null)
	{
		PrintWriter pw = response.getWriter();
		 message = "Swal.fire('Welcome "+name+" Your Id will be "+id+"');";
	}
	String errorMessage = (String)request.getAttribute("message"); */
	
%>



<div class='center' style="background-color: white;">
<br>
<h2>Leave Management system</h2>
<br>

<br>
<form method="post" action="login">
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Email</label>
    <input type="text" class="form-control" name="employeeMail" id="exampleInputID" placeholder="Email">

  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-primary" style="font-size: larger;border-radius: 30px;"><a href="https://www.flaticon.com/free-icons/login" title="login icons" ></a>Login</button>
  <br><br>
  <a href="signup" style="text-align: center;text-decoration: none;"><h5>New Employee? Signup here</h5></a>
  <br>
  
   <a href="forgotPassword" style="text-align: center;text-decoration: none;"><h5>Forgot Password?</h5></a>
  <br>
</form>

</div>

<!-- https://img.freepik.com/free-vector/abstract-blur-background-sunset_1048-2746.jpg -->


<script type="text/javascript">
 <%= request.getAttribute("message") %>

</script>

</body>


</html>