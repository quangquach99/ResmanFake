document.getElementById("reservation").onclick = function(e) {
	e.preventDefault();
	document.getElementById("overlay").style.display = "block";
	document.getElementById("reservationBox").style.display = "block";
}
document.getElementById("closeBtn").onclick = function() {
	document.getElementById("overlay").style.display = "none";
	document.getElementById("reservationBox").style.display = "none";
}
document.getElementById("order").onclick = function(e) {
	e.preventDefault();
	document.getElementById("overlay").style.display = "block";
	document.getElementById("orderBox").style.display = "block";
}
document.getElementById("closeOrderBoxBtn").onclick = function() {
	document.getElementById("overlay").style.display = "none";
	document.getElementById("orderBox").style.display = "none";
}

// Form Submit And Validate
var errorAlert = document.getElementById("errorAlert");
function validateMyForm() {
	var customerFullname = document.getElementById("customerFullname").value;
	var customerEmail = document.getElementById("customerEmail").value;
	var customerAddress = document.getElementById("customerAddress").value;
	var customerPhone = document.getElementById("customerPhone").value;
	var customerFullnameRex = /^[a-zA-Z ]+$/;
	var customerEmailRex = /^[a-zA-Z][a-zA-Z0-9_\.]{5,32}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var customerPhoneRex = /^0\d{9}$/;
	var customerAddressRex = /^[a-zA-Z0-9-_,&+ ]+$/;
	if(!customerFullname.match(customerFullnameRex)) {
		document.getElementById("errorMessage").innerHTML = "Your Full Name Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else if(!customerEmail.match(customerEmailRex)) {
		document.getElementById("errorMessage").innerHTML = "Your Email Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else if(customerAddress != "" && !customerAddress.match(customerAddressRex)) {
		document.getElementById("errorMessage").innerHTML = "Your Address Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else if(!customerPhone.match(customerPhoneRex)) {
		document.getElementById("errorMessage").innerHTML = "Your Phone Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else {
		document.getElementById("reservationConfirm").submit();
	}
}

if(document.getElementById("errorAlert")) {
	document.getElementById("closeErrorAlert").onclick = function() {
		document.getElementById("errorAlert").style.display = "none";
	}
}