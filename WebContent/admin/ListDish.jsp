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

	<!-- Content -->
	<div id="content">
			<div class="wrap_dish">
				<c:if test="${!empty listDish}">	
				<h3>List Of Dish</h3>
				
				<div class="btn_new"><a href="${pageContext.request.contextPath}/Admin/new">Add new dish</a></div>
				<table>
					<tr>
						<th>NO.</th>
						<th>Name</th>
						<th>Image</th>
						<th>Type</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<c:set var="no" value="${1}" />
					<c:forEach var="Dish" items="${listDish}">
						<tr>
							<!-- no -->
							<td class="in-no"><c:out value="${no}" /></td>
							<c:set var="no" value="${no+1}" />
	
							<!-- number -->
							<td class="dish-col"><c:out value="${Dish.dishName}" /></td>
	
	
							<!-- image -->
							<td id="dishImg"><img
								src="${pageContext.request.contextPath}/images/dishes/<c:out value="${Dish.dishImage}" />"
								alt="dish"></td>
	
	
							<!-- near window -->
	
							
	
							<!-- price -->
							<td class="dish-col">$<c:out value="${Dish.dishPrice}" /></td>
							
							<!-- action -->
							<td class="action">
								<a
								href="/Resman/admin/UpdateDish.jsp?dishId=${Dish.dishId}">Edit</a>
								
								&nbsp;&nbsp;&nbsp;&nbsp; 
								
								<a
								href="deletemonan?dishId=${Dish.dishId}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			</div>
			
		<c:if test="${empty listDish}">
			<p style="text-align: center;">No Records!!!</p>
		</c:if>
	</div>


	
	<script type="text/javascript">
		// DatePicker Function Toggle
		document.getElementById("Dish").onclick = function(e) {
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