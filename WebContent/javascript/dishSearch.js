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
function validateInputs() {
	var dishName = document.getElementById("dishName").value;
	var dishNameRex = /^[a-zA-Z- ]+$/;
	if(dishName != "" && !dishName.match(dishNameRex)) {
		document.getElementById("errorMessage").innerHTML = "Dish Name Is Invalid! Please Try Again!";
		errorAlert.style.display = "block";
	} else {
		document.getElementById("searchForDish").submit();
	}
}

if(document.getElementById("errorAlert")) {
	document.getElementById("closeErrorAlert").onclick = function() {
		document.getElementById("errorAlert").style.display = "none";
	}
}