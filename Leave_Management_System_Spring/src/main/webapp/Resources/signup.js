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
	 let result = name.match(/\d/g);
	 alert("active");
	 if(name.length > 20 || name.length < 1 || result.length != 0)
	 {	 
		 alert('invalid name');
		 document.getElementById('InputName').value = '';
		 
	 }

	 
	 if(surName.length > 20)
		 {
		 alert('invalid Surname');
		 document.getElementById('InputSecondName').value = '';
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
		  document.getElementById('InputPhone').value=''
	  }
 
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
	   if(cnfpass == pass)
	   {
		   document.getElementById('InputPassword1').value='';
		  Toastify({text: "Too long Password",duration: 3000,}).showToast();
	 		var cnfpass = document.getElementById('ConfirmPassword1').value;
	   }
 }
 
 
 
 function checkSamePerson()
 {
	 var phone = document.getElementById('InputPhone').value;
	 var email = document.getElementById('InputEmail1').value;
	 
	 
	 var url = "./CheckSamePerson.jsp.jsp?phone="+phone+"&email="+email;
	// alert(url);
	 var xmlHttpRequestObj = new XMLHttpRequest();
	 
	 xmlHttpRequestObj.onreadystatechange = function() {
		 
		 if(this.readyState==4 && this.status==200)
		 {
			 document.getElementById("temporary").innerHTML = this.responseText;
			 numberOfPeople = (document.getElementById("temporary").innerHTML).trim();
		//	 alert(numberOfLeaves);
		if(numberOfPeople > 1)
		{
			alert("Same Person!!!")
			return true;
		}
		return false;
		 }
		 
	 };
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
 
 
 