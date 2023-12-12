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
	<link rel="stylesheet" href="css_scripts//forgot.css"> 
	
	 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 
    <title>Hello, world!</title>
    
    
    
    <style>
    h2{
	text-align: center;
	
		
}



#InputID{
	width: 86%;
    margin-left: 30px;
}

#DOB
{
	width: 86%;
    margin-left: 30px;
}

#InputEmail
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
	
	width: 500px;
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
 




    </style>
    
    
    
  </head>


<body style="background-color:rgb(199, 180, 255);">





<div class='center' style="background-color: white;">
<br>
<h2>Leave Management system</h2>
<br>

<br>
<form method="post" action="Verify">
  <div class="form-group">
    <label for="exampleInputEmail1">Email Employee ID</label>
    <input type="text" class="form-control" name="employeeID" id="InputID" placeholder="Enter Employee ID">

  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Date Of Birth</label>
    <input type="date" class="form-control" name="dob" id="DOB" placeholder="Date Of birth">
  </div>
  
   <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" class="form-control" name="email" id="InputEmail" placeholder="Enter your email">
  </div>
  
  <button type="submit" id="submit" class="btn btn-primary" style="border-radius:30px;font-size: large;" onmouseover="check()"><a href="https://www.flaticon.com/free-icons/login" title="login icons"></a>Reset</button>
  <br><br>
  <br>
</form>

</div>
<br>


<!-- https://img.freepik.com/free-vector/abstract-blur-background-sunset_1048-2746.jpg -->

<script>

function check()
{
var empID = document.getElementById('InputID').value;
var DateOfBirth = document.getElementById('DOB').value;
var email = document.getElementById('InputEmail').value;

if(empID==''||DateOfBirth==''||email=='')
	{
	
	document.getElementById('submit').disabled = true;
	}
else
	{
	
	document.getElementById('submit').disabled = false;
	}
}

</script>


</body>
</html>