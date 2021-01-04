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
			action="update">
					<h1>Edit table</h1> 
					<div class="wrap_form">	
					<c:if test="${Table != null}">
                            <input type="hidden" name="tableId" value="<c:out value='${Table.tableId}' />" />
                    </c:if>              
					<span>People:</span>
					<select name="maximumOfPeople" id="maximumOfPeople">
							
							<option <c:if test="${Table.maximumOfPeople == '1'}">selected</c:if>
								value="1">1</option>
							<option <c:if test="${Table.maximumOfPeople == '2'}">selected</c:if>
								value="2">2</option>
							<option <c:if test="${Table.maximumOfPeople == '3'}">selected</c:if>
								value="3">3</option>
							<option <c:if test="${Table.maximumOfPeople == '4'}">selected</c:if>
								value="4">4</option>
							<option <c:if test="${Table.maximumOfPeople == '5'}">selected</c:if>
								value="5">5</option>
							<option <c:if test="${Table.maximumOfPeople == '6'}">selected</c:if>
								value="6">6</option>
							<option <c:if test="${Table.maximumOfPeople == '7'}">selected</c:if>
								value="7">7</option>
							<option <c:if test="${Table.maximumOfPeople == '8'}">selected</c:if>
								value="8">8</option>
							<option <c:if test="${Table.maximumOfPeople == '9'}">selected</c:if>
								value="9">9</option>
							<option <c:if test="${Table.maximumOfPeople == '10'}">selected</c:if>
								value="10">10</option>
							<option <c:if test="${Table.maximumOfPeople == '11'}">selected</c:if>
								value="11">11</option>
							<option <c:if test="${Table.maximumOfPeople == '12'}">selected</c:if>
								value="12">12</option>
							<option <c:if test="${Table.maximumOfPeople == '13'}">selected</c:if>
								value="13">13</option>
							<option <c:if test="${Table.maximumOfPeople == '14'}">selected</c:if>
								value="14">14</option>
							<option <c:if test="${Table.maximumOfPeople == '15'}">selected</c:if>
								value="15">15</option>
							<option <c:if test="${Table.maximumOfPeople == '16'}">selected</c:if>
								value="16">16</option>
							<option <c:if test="${Table.maximumOfPeople == '17'}">selected</c:if>
								value="17">17</option>
							<option <c:if test="${Table.maximumOfPeople == '18'}">selected</c:if>
								value="18">18</option>
							<option <c:if test="${Table.maximumOfPeople == '19'}">selected</c:if>
								value="19">19</option>
							<option <c:if test="${Table.maximumOfPeople == '20'}">selected</c:if>
								value="20">20</option>
					</select>
					<span>Image:</span>
					<select name="tableImage" id="tableImage">
						<option <c:if test="${Table.tableImage == 'table1.jpg'}">selected</c:if>
								value="table.jpg">Image</option>
						<option <c:if test="${Table.tableImage == 'table1.jpg'}">selected</c:if>
								value="table1.jpg">Image1</option>
						<option <c:if test="${Table.tableImage == 'table2.jpg'}">selected</c:if>
								value="table2.jpg">Image2</option>
						<option <c:if test="${Table.tableImage == 'table3.jpg'}">selected</c:if>
								value="table3.jpg">Image3</option>
						<option <c:if test="${Table.tableImage == 'table4.jpg'}">selected</c:if>
								value="table4.jpg">Image4</option>
					</select>
					<span>Near window:</span>
					<select name="nearWindow" id="nearWindow">
						<option <c:if test="${Table.nearWindow == '1'}">selected</c:if>
								value="1">1</option>
					<option <c:if test="${Table.nearWindow == '0'}">selected</c:if>
								value="0">0</option>
					</select>				
                	<span>Price:</span>
					<input type="text" required value="<c:out value='${Table.tablePrice}' />" class="" name="tablePrice">
					<button type="submit" >Save</button>
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