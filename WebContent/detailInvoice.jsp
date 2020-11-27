<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Invoice</title>
	<link href="${pageContext.request.contextPath}/admin/fontawesome/css/all.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/shared.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/detailInvoice.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="admin/header.jsp" />
	<!-- Left Navigation Bar -->
	<jsp:include page="admin/navigationBar.jsp" />
	<!-- Content -->
	<div id="content">
		<h2 id="invoice-id">INVOICE ID: <span>0012</span></h2>
		<div id="invoice">
			<div id="invoice-info">
				<h2>INVOICE</h2>
				<p>No. <span>00012</span> // <span>20:20:20 04/01/2020</span></p>
			</div>
			<div id="logo">
				<a href="${pageContext.request.contextPath}/Admin">
					<h1>Res<span>man</span></h1>
				</a>
			</div>
			<div id="customer-info">
				<span id="billing-to">Billing To:</span>
				<br>
				<p>Mr./Mrs. ${reservation.customerFullname} | ${reservation.customerPhone}</p>
				<p>NUMBER OF PEOPLE: ${reservation.numberOfPeople}</p>
				<p>${reservation.customerEmail}</p>
				<p>Table Id: <b>${reservation.tableId}</b></p>
			</div>
			<div id="bill-detail">
				<table>
					<tr>
						<th>NO.</th>
						<th>ITEM DESCRIPTION</th>
						<th>AT</th>
						<th>QUANTITY</th>
						<th>TOTAL</th>
					</tr>
					<c:if test="${!empty orders}">
					<c:set var="no" value="${1}" />
					<c:forEach var="order" items="${orders}">
					<tr>
						<td class="in-order">0<c:out value="${no}" />.</td>
						<c:set var="no" value="${no+1}" />
						<td class="dish-info">
							<div id="dishImg">
								<img src="${pageContext.request.contextPath}/images/dishes/<c:out value="${order.particularDish.getDishImage()}" />" alt="Dish">
							</div>
							<div id="description">
								<p>Id: <span><c:out value="${order.particularDish.getDishId()}" /></span></p>
								<p>Name: <span><c:out value="${order.particularDish.getDishName()}" /></span></p>
								<c:if test="${order.particularDish.getDishType() == 1}">
								<p>Type: <span>Appetizer</span></p>
								</c:if>
								<c:if test="${order.particularDish.getDishType() == 2}">
								<p>Type: <span>Main Course</span></p>
								</c:if>
								<c:if test="${order.particularDish.getDishType() == 3}">
								<p>Type: <span>Dessert</span></p>
								</c:if>
								<c:if test="${order.particularDish.getDishType() == 4}">
								<p>Type: <span>Beverage</span></p>
								</c:if>
								<p>Price: <span>$<c:out value="${order.particularDish.getDishPrice()}" /></span></p>
							</div>
						</td>
						<td class="time-format">${order.orderedAt}</td>
						<td class="quantity">${order.dishQuantity}</td>
						<td class="total">$${order.orderPrice}</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${empty orders}">
					<tr>NO RECORDS!!!</tr>
					</c:if>
				</table>
			</div>
			<div id="payment-method">
				<span id="method">Payment Method : </span>
				<i class="fab fa-cc-visa"></i>
			</div>
			<div id="grand-total">
				<div id="sub-total">
					<p>Sub-total</p>
					<span>$${reservationBill}</span>
				</div>
				<div id="discount">
					<p>Discount (0%)</p>
					<span>$0.00</span>
				</div>
				<div id="grand">
					<p>GRAND TOTAL</p>
					<span>$${reservationBill}</span>
				</div>
			</div>
			<div id="thanks">Thank You For Being With Us!</div>
			<hr>
			<div id="contacts">
				<p><i class="fas fa-phone-alt"></i>: 0355764662</p>
				<p><i class="fas fa-envelope"></i>: dinhquang149999@gmail.com</p>
				<p><i class="fas fa-map-marker-alt"></i>: Vinh Hung, Hoang Mai, Ha Noi</p>
				<p>www.resman.com</p>
			</div>
		</div>
		<button id="print">Print</button>
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