document.getElementById("reservation").onclick = function(e) {
	e.preventDefault();
	document.getElementById("overlay").style.zIndex = "12";
	document.getElementById("overlay").style.opacity = ".7";
	document.getElementById("reservationBox").style.display = "block";
}
document.getElementById("closeBtn").onclick = function() {
	document.getElementById("overlay").style.zIndex = "10";
	document.getElementById("overlay").style.opacity = ".5";
	document.getElementById("reservationBox").style.display = "none";
}
document.getElementById("order").onclick = function(e) {
	e.preventDefault();
	document.getElementById("overlay").style.zIndex = "12";
	document.getElementById("overlay").style.opacity = ".7";
	document.getElementById("orderBox").style.display = "block";
}
document.getElementById("closeOrderBoxBtn").onclick = function() {
	document.getElementById("overlay").style.zIndex = "10";
	document.getElementById("overlay").style.opacity = ".5";
	document.getElementById("orderBox").style.display = "none";
}
if(document.getElementById("closeSuccessAlert")) {
	document.getElementById("closeSuccessAlert").onclick = function() {
		document.getElementById("successAlert").style.display = "none";
	}
}
if(document.getElementById("closeErrorAlert")) {
	document.getElementById("closeErrorAlert").onclick = function() {
		document.getElementById("errorAlert").style.display = "none";
	}
}