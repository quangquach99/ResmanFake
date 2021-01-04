<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="${pageContext.request.contextPath}/admin/fontawesome/css/all.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet'>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/shared.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/adminTable2.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="admin/header.jsp" />
	<!-- Left Navigation Bar -->
	<jsp:include page="admin/navigationBar.jsp" />
	<!-- Content -->
	<div id="content">
	
		<form method="post"
			action="insert">
					<h1>Add New Table</h1> 
					<div class="wrap_form">						          
					<span>People:</span>
					<select name="maximumOfPeople" id="maximumOfPeople">							
							<option 
								value="1">1</option>
							<option 
								value="2">2</option>
							<option 
								value="3">3</option>
							<option 
								value="4">4</option>
							<option 
								value="5">5</option>
							<option 
								value="6">6</option>
							<option 
								value="7">7</option>
							<option 
								value="8">8</option>
							<option 
								value="9">9</option>
							<option 
								value="10">10</option>
							<option 
								value="11">11</option>
							<option 
								value="12">12</option>
							<option 
								value="13">13</option>
							<option 
								value="14">14</option>
							<option 
								value="15">15</option>
							<option 
								value="16">16</option>
							<option 
								value="17">17</option>
							<option 
								value="18">18</option>
							<option 
								value="19">19</option>
							<option 
								value="20">20</option>
					</select>
					<span>Image:</span>
					<select name="tableImage" id="tableImage">
						<option 
								value="table.jpg">Image</option>
						<option 
								value="table1.jpg">Image1</option>
						<option 
								value="table2.jpg">Image2</option>
						<option 
								value="table3.jpg">Image3</option>
						<option 
								value="table4.jpg">Image4</option>
					</select>
					<span>Near window:</span>
					<select name="nearWindow" id="nearWindow">
						<option 
								value="1">1</option>
					<option 
								value="0">0</option>
					</select>				
                	<span>Price:</span>
					<input type="text"  class="" required name="tablePrice">
					<button type="submit" >Add</button>
					</div>
		</form>
			
			
		
	</div>
	<!-- Overlay The Whole Body And DatePicker-->
	<jsp:include page="admin/datePicker.jsp" />
	<!-- Javascript -->
	<script type="text/javascript">
		// DatePicker Function Toggle
		document.getElementById("Table").onclick = function(e) {
			e.preventDefault();
			document.getElementById("datePicker").style.display = "block";
			document.getElementById("overlay").style.display = "block";
		}
		document.getElementById("closeDatePickerBtn").onclick = function() {
			document.getElementById("datePicker").style.display = "none";
			document.getElementById("overlay").style.display = "none";
		}
	</script>
</body>
</html>