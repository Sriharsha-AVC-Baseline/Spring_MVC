<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

	<link href="Resources/dashboardPage.css" rel="stylesheet">


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<title>Hello, world!</title>

<style type="text/css">
.center{
	
	width: 60%;
	margin: auto;
	margin-top: 1%;
	margin-bottom: 1%;
	background-color: rgb(255, 255, 255);
}

label{
	font-weight: bold;
	margin-left: 10px;
}

input{
	margin-left: 10px;
	max-width: 96%;
}

</style>

  </head>
<body style="background-color: #c8a9ff;">

<h6 id="temporary" style="visibility: hidden;"></h6>
<div class="center" style="padding: 10px">
<br>
<form method="post" action="Signup">
<div class="form-group" >
<label for="exampleInputEmail1"> Name</label>
	<div class="form-group" style="display: flex;">
		
    	<input type="text" class="form-control" name="employeeName" id="InputName" placeholder="Name" onchange="checkUserName()">

    	<input style="margin-right: 20px;" type="text" class="form-control" name="employeeSurName" id="InputSecondName" placeholder="Surname" onchange="checkname()">
	</div>
	</div>
	
	<div class="form-group">
	 <label for="exampleInputPassword1">Phone number</label>
	<div class="form-group" style="display: flex;">
   <input type="text" class="form-control" name="countryCode" id="InputPhoneCountry" placeholder="Phone number" maxlength="3" onchange="checkCountryCode()" value="+91" style="width:60px;">
 
    <input style="width:87%;" type="number" class="form-control" name="employeePhone" id="InputPhone" placeholder="Phone number"  onchange="checkPhone()">
  </div>
  </div>

  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="InputEmail1" name="employeeMail" aria-describedby="emailHelp" placeholder="Enter email" onchange="checkSamePerson()">
    <small id="emailHelp" class="form-text text-muted" style="margin-left: 10px;">We'll never share your email with anyone else.</small>
  </div>
  
    <div class="form-group">
    <label for="exampleInputEmail1">Date Of birth (MM / dd / yyyy)</label>
    <input type="date" class="form-control" id="InputDOB" name="employeeDOB" aria-describedby="emailHelp" onchange="checkDob()">
    </div>
  
  <div class="form-group">
		<label for="exampleInputEmail1"> Permanent Address </label>
		<div class="address-form-group" style="display: flex; margin-right: 4%;">
    	<input type="text" class="form-control" id="InputHno" name="houseNumber" aria-describedby="emailHelp" placeholder="House no">
    	<input type="text" class="form-control" id="InputStreet" name="streetName" aria-describedby="emailHelp" placeholder="Street or Area">
    	
    	</div>
    	<br>
    	<div class="address-form-group" style="display: flex;margin-right: 4%;">
    	<input type="text" class="form-control" id="InputDistrict" name="district"  placeholder="District">
		<input type="text" class="form-control" id="InputCountry" name="state"  placeholder="state">
		<input type="number" class="form-control" id="InputPinCode" name="pinCode"  placeholder="PIN Code">
    	</div>
    	</div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <div style="display: flex;">
    <input type="password" class="form-control" id="InputPassword1" name="employeePass" placeholder="Password" style="margin-left: 10px;max-width: 80%;" onchange="checkPass()">
  	 <input type="text" class="form-control" id="ConfirmPassword1"  placeholder=" Confirm Password" style="margin-left: 10px;max-width: 80%;" onchange="verifyPass()">
  	</div>
  	<small id="emailHelp" class="form-text text-muted" style="margin-left: 10px;">Password length should be in between 6 to 10 characters.</small>
  	
  </div>

  <br>
   <div class="form-group">
    <label for="exampleFormControlSelect1">Gender</label>
    <select class="form-control" id="genderSelect" name="employeeGender" style="margin-left: 10px;max-width: 96%;">
      <option value=''>select</option>
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      <option value="Others">Others</option>
    </select>
    <br>
     <div class="form-group">
    <label for="exampleFormControlSelect1">Designation</label>
    <select class="form-control" id="designationSelect" name="employeeDesignation" style="margin-left: 10px;max-width: 96%;">
      <option value=''>select</option>
      <option value="Manager">MANAGER</option>
      <option value="Lead">LEAD</option>
      <option value="Executive">EXECUTIVE</option>
    </select>
    <br>
  <button type="submit" class="btn btn-primary" id="submitButton" style="margin-left: 45%" onmouseover="checkEmpty()">Submit</button>
</form>
<br><br>
</div>

<script> 

function checkUserName() {
	 var name = document.getElementById('InputName').value;
	 var surName = document.getElementById('InputSecondName').value;
	 
	 var regex = /^[a-zA-Z ]{1,20}$/;
	    let nameResult = regex.test(name);
	    let surNameResult = regex.test(surName);
	    
	    if(nameResult == false)
		 {	 
			 alert('invalid name');
			 document.getElementById('InputName').value = '';
			 document.getElementById('InputSecondName').value = '';
		 }
	
}




function checkPhone()
{
	 var phone = document.getElementById('InputPhone').value.toString();
	 
	 if(phone.length!=10)
	 {
		 alert("invalid phone number");
		  document.getElementById('InputPhone').value=''
		  
	  }

}

function checkCountryCode()
{

	 var countryCode = document.getElementById('InputPhoneCountry').value.toString();
	 var result = countryCode.match(/[+][0-9]/g);
	 if(result.length==0||countryCode.length!=3)
	 {
		 alert("invalid Country code");
		 document.getElementById('InputPhoneCountry').value=''
	 }
}
/**
 * 
 */


 function disableButton()
 {
	 document.getElementById("submitButton").disabled = true;
 }
 function checkname()
 {
	 var name = document.getElementById('InputName').value;
	 var surName = document.getElementById('InputSecondName').value;
	 
	 if(name.length > 20 || name.length < 1 || surName.length > 10)
	 {
		  document.getElementById('InputSecondName').value = '';
		 document.getElementById('InputName').value = '';
		 alert('invalid name');
	 }
 }
 
 function checkPhone()
 {
	 var phone = document.getElementById('InputPhone').value.toString();
	 var countryCode = document.getElementById('InputPhoneCountry').value.toString();
	 var re = new RegExp( "[+/d/d]", "g" );
	 var result = countryCode.match(/[+]\d\d/g);
 	 if(phone.length!=10 || countryCode.length!=3 ||result.length==0)
 	 {
		  alert("invalid phone");
		  document.getElementById('InputPhone').value=''
		  document.getElementById('InputPhoneCountry').value=''
	  }
 
 }
 
 function checkCountryCode()
 {
	 
 }
 
 function checkDob()
 {
	 var dob = document.getElementById('InputDOB').value;
	 var today = new Date();
	 var dateOfBirth = new Date(dob);
	 if(dateOfBirth >= today)
	 {
		 alert('invalid Date Of Birth');
		 document.getElementById('InputDOB').value = '';
	 }
	 
	 var thisYear = today.getFullYear();
	 var yearOfBirth = dateOfBirth.getFullYear();
	 var difference = thisYear - yearOfBirth;
	 
	 if(difference < 18)
		 {
		 alert('You should be above 18');
		 document.getElementById('InputDOB').value = '';
		 }
	 
 }
 

 
 
 function checkPass()
 {
	 var pass = document.getElementById('InputPassword1').value;
	 if(pass.length<6)
	 {
		  document.getElementById('InputPassword1').value='';
		  Toastify({text: "Too short Password",duration: 3000,}).showToast();
	}
	 if(pass.length > 10)
	 {
		document.getElementById('InputPassword1').value='';
		  Toastify({text: "Too long Password",duration: 3000,}).showToast();
	 }
 }
 
 function verifyPass()
 {
	  var pass = document.getElementById('InputPassword1').value;
	   var cnfpass = document.getElementById('ConfirmPassword1').value;
	   if(cnfpass != pass)
	   {
		   document.getElementById('InputPassword1').value='';
		  Toastify({text: "Invalid Password",duration: 3000,}).showToast();
	 		var cnfpass = document.getElementById('ConfirmPassword1').value;
	   }
 }
 
 
 
 function checkSamePerson()
 {
	 var phone = document.getElementById('InputPhoneCountry').value + document.getElementById('InputPhone').value;
	 var email = document.getElementById('InputEmail1').value;
	 
	 
	 var url = "views/CheckSamePerson.jsp?phone="+phone+"&email="+email;
	 
	 var xmlHttpRequestObj = new XMLHttpRequest();
	 
	  
	 
	 xmlHttpRequestObj.onreadystatechange = function() {
		 
		 if(this.readyState==4 && this.status==200)
		 {
			 document.getElementById("temporary").innerHTML = this.responseText;
			 isSamePerson = (document.getElementById("temporary").innerHTML).trim();
			
		if(isSamePerson=='true')
		{
			alert("You have already registered!!!");
			document.getElementById('InputEmail1').value="";
			document.getElementById('InputPhone').value="";
			document.getElementById('InputPhoneCountry').value="";
			return true;
		}
		return false;
		 }
		 
	 };
	 
	 xmlHttpRequestObj.open("POST", url, true);
  	 xmlHttpRequestObj.send();
 }
 
 function checkEmpty()
 {
	 var name = document.getElementById('InputName').value;
	 var phone = document.getElementById('InputPhone').value;
	 var email = document.getElementById('InputEmail1').value;
	 var dob = document.getElementById('InputDOB').value; 
	 var hno = document.getElementById('InputHno').value;
	 var street = document.getElementById('InputStreet').value;
	 var district = document.getElementById('InputDistrict').value;
	 var country = document.getElementById('InputCountry').value;
	 var password = document.getElementById('InputPassword1').value;
	 var cnfPassword = document.getElementById('ConfirmPassword1').value;
	 var gender = document.getElementById('genderSelect').value;
	 var designation = document.getElementById('designationSelect').value;
 
 
 	var somethingIsWrong = false;
 	const values = [name,phone,email,hno,street,district,country,password,cnfPassword,gender,designation]
 
 	console.log(values);
 	if(name == '') 
 	{
	
		somethingIsWrong = true;
	 }
	  	if(phone == '') 
 	{
		 Toastify({text: "Phone number is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(email == '') 
 	{
		 Toastify({text: "Email is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(hno == '') 
 	{
		 Toastify({text: "House number is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(street == '') 
 	{
		 Toastify({text: "Street field is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(district == '') 
 	{
		 Toastify({text: "District Field is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(country == '') 
 	{
		 Toastify({text: "Country field is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(password == '') 
 	{
		 Toastify({text: "Password field is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(cnfPassword == '') 
 	{
		 Toastify({text: "Confirm password field is empty",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	  	if(gender == '') 
 	{
		 Toastify({text: "Select gender",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
	   	if(designation == '') 
 	{
		 Toastify({text: "Select designation",duration: 3000,}).showToast();
		 somethingIsWrong = true;
	 }
 	
 	if(checkSamePerson()==true)
 	{
		 somethingIsWrong = true;
	 }
 	
 	document.getElementById("submitButton").disabled = somethingIsWrong;
 	
}
 
 
 

</script>
</body>
</html>