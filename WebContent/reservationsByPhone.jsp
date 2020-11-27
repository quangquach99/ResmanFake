<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/searchReservationByPhone.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared.css">
</head>
<body>
	<div id="navBar">
		<a href="${pageContext.request.contextPath}/Home" id="home">
			Home
		</a>
		<a id="reservation">
			Reservation
		</a>
		<a id="order">
			Order
		</a>
		<a href="#" id="login">
			Login
		</a>
		<a href="#" id="sign-up">
			Sign Up
		</a>
		<a href="#" id="logout">
			Logout
		</a>
	</div>
	<div id="results">
		<h2>Reservations For - <span id="phone"><c:out value="${customerPhone}" /></span></h2>
		<c:forEach var="reservation" items="${reservations}">
		<div class="row">
			<div class="table">
				<img src="${pageContext.request.contextPath}/images/tables/<c:out value="${reservation.tableImage}" />" alt="table">
				<div class="description">
					<p>Customer Full Name: <span><c:out value="${reservation.customerFullname}" /></span></p>
					<p>Customer Email: <span><c:out value="${reservation.customerEmail}" /></span></p>
					<p>Customer Phone: <span><b><c:out value="${reservation.customerPhone}" /></b></span></p>
					<p>Number Of People: <span><c:out value="${reservation.numberOfPeople}" /></span></p>
					<p>Date: <span><fmt:formatDate value="${reservation.reservationDate}" pattern="yyyy-MM-dd" /></span></p>
					<p>Time: <span><c:out value="${reservation.reservationTime}" /></span></p>
					<a class="book" href="${pageContext.request.contextPath}/SetSessionReservation?reservationId=<c:out value="${reservation.reservationId}" />">
						Confirm
					</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<div id="footer">
		<div class="open-time">
			<div id="monday-friday">
				<span class="days">monday-friday</span>
				<br>
				<span class="time">5am-10pm</span>
			</div>
			<div id="saturday">
				<span class="days">saturday</span>
				<br>
				<span class="time">11am–4pm / 5pm–10pm</span>
			</div>
			<div id="sunday">
				<span class="days">sunday</span>
				<br>
				<span class="time">11am–4pm / 5–9pm</span>
			</div>
		</div>
		<div class="contact">
			<span id="phone">0355764662</span>
			<br>
			<span id="address">Hoang Mai, Ha Noi</span>
			<br>
			<span id="email">caothubongro5899@gmail.com</span>
		</div>
	</div>
	<div id="overlay"></div>
	<div id="reservationBox">
		<h2>Options</h2>
		<img src="${pageContext.request.contextPath}/images/close.png" id="closeBtn" alt="">
		<form method="get" action="${pageContext.request.contextPath}/ReservationSearch">
		 	<select name="bookingDate" id="bookingDate">
		 		<option selected value="">Date</option>
		 		<c:forEach var="date" items="${dates}">
			 		<option value="<c:out value="${date}" />"><c:out value="${date}" /></option>
			 	</c:forEach>
		 	</select>
		 	<select name="bookingTime" id="bookingTime">
		 		<option value="" selected>Time</option>
		 		<option value="06:00">6AM</option>
		 		<option value="07:00">7AM</option>
		 		<option value="08:00">8AM</option>
		 		<option value="09:00">9AM</option>
		 		<option value="10:00">10AM</option>
		 		<option value="11:00">11AM</option>
		 		<option value="12:00">12PM</option>
		 		<option value="13:00">1PM</option>
		 		<option value="14:00">2PM</option>
		 		<option value="15:00">3PM</option>
		 		<option value="16:00">4PM</option>
		 		<option value="17:00">5PM</option>
		 		<option value="18:00">6PM</option>
		 		<option value="19:00">7PM</option>
		 		<option value="20:00">8PM</option>
		 		<option value="21:00">9PM</option>
		 	</select>
		 	<select name="numberOfPeople" id="numberOfPeople">
		 		<option value="" selected>Number Of People</option>
		 		<option value="1">1</option>
		 		<option value="2">2</option>
		 		<option value="3">3</option>
		 		<option value="4">4</option>
		 		<option value="5">5</option>
		 		<option value="6">6</option>
		 		<option value="7">7</option>
		 		<option value="8">8</option>
		 		<option value="9">9</option>
		 		<option value="10">10</option>
		 		<option value="11">11</option>
		 		<option value="12">12</option>
		 		<option value="13">13</option>
		 		<option value="14">14</option>
		 		<option value="15">15</option>
		 		<option value="16">16</option>
		 		<option value="17">17</option>
		 		<option value="18">18</option>
		 		<option value="19">19</option>
		 		<option value="20">20</option>
		 	</select>
		 	<button type="submit" id="submit">Find Available Tables</button>
		</form>
	</div>
	<div id="orderBox">
		<h2>Search Reservation</h2>
		<img src="${pageContext.request.contextPath}/images/close.png" id="closeOrderBoxBtn" alt="">
		<form method="get" action="${pageContext.request.contextPath}/GetReservations">
		 	<input type="text" name="customerPhone" placeholder="Enter Your Phone To Find Your Reservation" id="searchReservation">
		 	<button type="submit">Search</button>
		</form>
	</div>
	<script type="text/javascript">
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
	</script>
</body>
</html>