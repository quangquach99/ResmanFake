<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<link href="${pageContext.request.contextPath}/admin/fontawesome/css/all.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/shared.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="admin/header.jsp" />
	<!-- Left Navigation Bar -->
	<jsp:include page="admin/navigationBar.jsp" />
	<!-- Content -->
	<div id="content"></div>
	<!-- Overlay The Whole Body And DatePicker-->
	<jsp:include page="admin/datePicker.jsp" />
	<c:if test="${param.success == '0003'}">
	<div id="welcome">
		<p>Welcome Back <span><c:out value="${sessionScope.managerFullname}"/></span></p>
	</div>
	</c:if>
	
	<!-- Javascript -->
	<script type="text/javascript">
		// DatePicker Function Toggle
		document.getElementById("revenueByDish").onclick = function(e) {
			e.preventDefault();
			document.getElementById("datePicker").style.display = "block";
			document.getElementById("overlay").style.display = "block";
		}
		document.getElementById("closeDatePickerBtn").onclick = function() {
			document.getElementById("datePicker").style.display = "none";
			document.getElementById("overlay").style.display = "none";
		}
		window.onload = function(){
	  		var divToHide = document.getElementById('welcome');
	  		document.onclick = function(e){
	    	if(e.target.id !== 'divToHide'){
	      		//element clicked wasn't the div; hide the div
	     		divToHide.style.display = 'none';
		    }
		  };
		};
	</script>
</body>
</html>