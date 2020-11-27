<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reservationSearch.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared.css">
</head>
<body>
	<div id="navBar">
		<a href="${pageContext.request.contextPath}/Home" id="home">
			Home
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
	<div id="options">
		<!-- <h2>Options</h2> -->
		<form method="get">
		 	<select name="bookingDate" id="bookingDate">
		 		<option value="">Date</option>
		 		<c:forEach var="date" items="${dates}">
			 		<option <c:if test="${bookingDate == date}">selected</c:if> value="<c:out value="${date}" />"><c:out value="${date}" /></option>
			 	</c:forEach>
		 	</select>
		 	<select name="bookingTime" id="bookingTime">
		 		<option value="">Time</option>
		 		<option <c:if test="${bookingTime == '06:00'}">selected</c:if> value="06:00">6AM</option>
		 		<option <c:if test="${bookingTime == '07:00'}">selected</c:if> value="07:00">7AM</option>
		 		<option <c:if test="${bookingTime == '08:00'}">selected</c:if> value="08:00">8AM</option>
		 		<option <c:if test="${bookingTime == '09:00'}">selected</c:if> value="09:00">9AM</option>
		 		<option <c:if test="${bookingTime == '10:00'}">selected</c:if> value="10:00">10AM</option>
		 		<option <c:if test="${bookingTime == '11:00'}">selected</c:if> value="11:00">11AM</option>
		 		<option <c:if test="${bookingTime == '12:00'}">selected</c:if> value="12:00">12PM</option>
		 		<option <c:if test="${bookingTime == '13:00'}">selected</c:if> value="13:00">1PM</option>
		 		<option <c:if test="${bookingTime == '14:00'}">selected</c:if> value="14:00">2PM</option>
		 		<option <c:if test="${bookingTime == '15:00'}">selected</c:if> value="15:00">3PM</option>
		 		<option <c:if test="${bookingTime == '16:00'}">selected</c:if> value="16:00">4PM</option>
		 		<option <c:if test="${bookingTime == '17:00'}">selected</c:if> value="17:00">5PM</option>
		 		<option <c:if test="${bookingTime == '18:00'}">selected</c:if> value="18:00">6PM</option>
		 		<option <c:if test="${bookingTime == '19:00'}">selected</c:if> value="19:00">7PM</option>
		 		<option <c:if test="${bookingTime == '20:00'}">selected</c:if> value="20:00">8PM</option>
		 		<option <c:if test="${bookingTime == '21:00'}">selected</c:if> value="21:00">9PM</option>
		 	</select>
		 	<select name="numberOfPeople" id="numberOfPeople">
		 		<option value="">Number Of People</option>
		 		<option <c:if test="${numberOfPeople == '1'}">selected</c:if> value="1">1</option>
		 		<option <c:if test="${numberOfPeople == '2'}">selected</c:if> value="2">2</option>
		 		<option <c:if test="${numberOfPeople == '3'}">selected</c:if> value="3">3</option>
		 		<option <c:if test="${numberOfPeople == '4'}">selected</c:if> value="4">4</option>
		 		<option <c:if test="${numberOfPeople == '5'}">selected</c:if> value="5">5</option>
		 		<option <c:if test="${numberOfPeople == '6'}">selected</c:if> value="6">6</option>
		 		<option <c:if test="${numberOfPeople == '7'}">selected</c:if> value="7">7</option>
		 		<option <c:if test="${numberOfPeople == '8'}">selected</c:if> value="8">8</option>
		 		<option <c:if test="${numberOfPeople == '9'}">selected</c:if> value="9">9</option>
		 		<option <c:if test="${numberOfPeople == '10'}">selected</c:if> value="10">10</option>
		 		<option <c:if test="${numberOfPeople == '11'}">selected</c:if> value="11">11</option>
		 		<option <c:if test="${numberOfPeople == '12'}">selected</c:if> value="12">12</option>
		 		<option <c:if test="${numberOfPeople == '13'}">selected</c:if> value="13">13</option>
		 		<option <c:if test="${numberOfPeople == '14'}">selected</c:if> value="14">14</option>
		 		<option <c:if test="${numberOfPeople == '15'}">selected</c:if> value="15">15</option>
		 		<option <c:if test="${numberOfPeople == '16'}">selected</c:if> value="16">16</option>
		 		<option <c:if test="${numberOfPeople == '17'}">selected</c:if> value="17">17</option>
		 		<option <c:if test="${numberOfPeople == '18'}">selected</c:if> value="18">18</option>
		 		<option <c:if test="${numberOfPeople == '19'}">selected</c:if> value="19">19</option>
		 		<option <c:if test="${numberOfPeople == '20'}">selected</c:if> value="20">20</option>
		 	</select>
		 	<button type="submit" id="submit">Find Available Tables</button>
		</form>
	</div>
	<div id="results">
		<h2>Available Tables <span class="title">At ${bookingTime} On ${bookingDate} For ${numberOfPeople} People</span></h2>
		<c:if test="${!empty tables}">
		<c:forEach var="table" items="${tables}">
		<div class="row">
			<div class="table">
				<img src="${pageContext.request.contextPath}/images/tables/<c:out value="${table.tableImage}" />" alt="table">
				<div class="description">
					<p>Number Of People: <span><c:out value="${numberOfPeople}" /> people</span></p>
					<c:if test="${table.nearWindow == 1}">
						<p>Near Window: <span class="text-green" style="background-color: green;">Yes</span></p>
					</c:if>
					<c:if test="${table.nearWindow == 0}">
						<p>Near Window: <span class="text-tomato">No</span></p>
					</c:if>
					<p>Price: <span>$<c:out value="${table.tablePrice}" /></span></p>
					<form class="book" method="post" action="${pageContext.request.contextPath}/ReservationConfirm">
						<input type="hidden" name="tableId" value="${table.tableId}">
						<input type="hidden" name="numberOfPeople" value="${numberOfPeople}">
						<input type="hidden" name="bookingDate" value="${bookingDate}">
						<input type="hidden" name="bookingTime" value="${bookingTime}">
						<button type="submit" class="confirm-btn">Book</button>
					</form>
				</div>
			</div>
		</div>
		</c:forEach>
		</c:if>
		<c:if test="${empty tables }">
			<div class="row">
				<div class="table" style="text-align:center;">
					Sorry!!! We Do Not Have This Kind Of Tables Right Now!!!
				</div>
			</div>
		</c:if>
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
	<div id="orderBox">
		<h2>Search Reservation</h2>
		<img src="${pageContext.request.contextPath}/images/close.png" id="closeOrderBoxBtn" alt="">
		<form method="get" action="${pageContext.request.contextPath}/GetReservations">
		 	<input type="text" name="customerPhone" placeholder="Enter Your Phone To Find Your Reservation" id="searchReservation">
		 	<button type="submit">Search</button>
		</form>
	</div>
	<script type="text/javascript">
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