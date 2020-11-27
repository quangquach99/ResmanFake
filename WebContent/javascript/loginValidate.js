// Form Submit And Validate
var errorAlert = document.getElementById("errorAlert");
function validateMyLogin() {
	// Get Inputs
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	// ReGex
	var emailRex = /^[a-zA-Z][a-zA-Z0-9_\.]{5,32}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var passwordRex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

	// Validate
	if(!email.match(emailRex)) {
		document.getElementById("errorMessage").innerHTML = "Email Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else if(!password.match(passwordRex)) {
		document.getElementById("errorMessage").innerHTML = "Password Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else {
		document.getElementById("loginController").submit();
	}
}

if(document.getElementById("errorAlert")) {
	document.getElementById("closeErrorAlert").onclick = function() {
		document.getElementById("errorAlert").style.display = "none";
	}
}

if(document.getElementById("anotherErrorAlert")) {
	document.getElementById("closeAnotherErrorAlert").onclick = function() {
		document.getElementById("anotherErrorAlert").style.display = "none";
	}
}