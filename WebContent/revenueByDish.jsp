<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link href="${pageContext.request.contextPath}/admin/fontawesome/css/all.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/shared.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/revenueByDish.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="admin/header.jsp" />
	<!-- Left Navigation Bar -->
	<jsp:include page="admin/navigationBar.jsp" />
	<!-- Content -->
	<div id="content">
		<h3>Revenue From <span>${startDate}</span> To <span>${endDate}</span></h3>
		<c:if test="${!empty revenueByDishList}">
		<table>
			<tr>
				<th>NO.</th>
				<th>Dish Information</th>
				<th>Revenue</th>
				<th>Action</th>
			</tr>
			<c:set var="no" value="${1}" />
			<c:forEach var="revenueByDish" items="${revenueByDishList}">
			<tr>
				<td class="in-order"><c:out value="${no}" /></td>
				<c:set var="no" value="${no+1}" />
				<td class="dish-info">
					<div id="dishImg">
						<img src="${pageContext.request.contextPath}/images/dishes/<c:out value="${revenueByDish.particularDish.getDishImage()}" />" alt="Dish">
					</div>
					<div id="description">
						<p>Id: <span><c:out value="${revenueByDish.particularDish.getDishId()}" /></span></p>
						<p>Name: <span><c:out value="${revenueByDish.particularDish.getDishName()}" /></span></p>
						<c:if test="${revenueByDish.particularDish.getDishType() == 1}">
						<p>Type: <span>Appetizer</span></p>
						</c:if>
						<c:if test="${revenueByDish.particularDish.getDishType() == 2}">
						<p>Type: <span>Main Course</span></p>
						</c:if>
						<c:if test="${revenueByDish.particularDish.getDishType() == 3}">
						<p>Type: <span>Dessert</span></p>
						</c:if>
						<c:if test="${revenueByDish.particularDish.getDishType() == 4}">
						<p>Type: <span>Beverage</span></p>
						</c:if>
						<p>Price: <span>$<c:out value="${revenueByDish.particularDish.getDishPrice()}" /></span></p>
					</div>
				</td>
				<td class="dish-revenue">$<c:out value="${revenueByDish.revenueTotal}" /></td>
				<td class="action">
					<a href="${pageContext.request.contextPath}/Admin/DetailRevenueByDish?dishId=${revenueByDish.particularDish.getDishId()}&startDate=${startDate}&endDate=${endDate}">More Detail</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${empty revenueByDishList}">
		<p style="text-align:center;">No Records!!!</p>
		</c:if>
	</div>
	<!-- Overlay The Whole Body And DatePicker-->
	<jsp:include page="admin/datePicker.jsp" />
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
	</script>
</body>
</html>