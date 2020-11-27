<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Detail - Revenue</title>
	<link href="${pageContext.request.contextPath}/admin/fontawesome/css/all.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/shared.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/detailDishRevenue.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="admin/header.jsp" />
	<!-- Left Navigation Bar -->
	<jsp:include page="admin/navigationBar.jsp" />
	<!-- Content -->
	<div id="content">
		<h3><span>${dish.dishName}</span> From <span>${startDate}</span> To <span>${endDate}</span></h3>
		<div id="dish-info">
			<div id="dishImg">
				<img src="${pageContext.request.contextPath}/images/dishes/${dish.dishImage}" alt="Dish">
			</div>
			<div id="dish-description">
				<p>Id: <span>${dish.dishId}</span></p>
				<p>Name: <span>${dish.dishName}</span></p>
				<c:if test="${dish.dishType == 1}">
				<p>Type: <span>Appetizer</span></p>
				</c:if>
				<c:if test="${dish.dishType == 2}">
				<p>Type: <span>Main Course</span></p>
				</c:if>
				<c:if test="${dish.dishType == 3}">
				<p>Type: <span>Dessert</span></p>
				</c:if>
				<c:if test="${dish.dishType == 4}">
				<p>Type: <span>Beverage</span></p>
				</c:if>
				<p>Price: <span>4.00$</span></p>
			</div>
		</div>
		<div id="orderedTimes">
		<c:forEach var="order" items="${orders}">
			<div class="row">
				<a href="${pageContext.request.contextPath}/Admin/DetailInvoice?reservationId=${order.reservationId}" class="bill-detail">On ${order.orderedOn} At ${order.orderedAt}</a>
			</div>
		</c:forEach>
		</div>
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