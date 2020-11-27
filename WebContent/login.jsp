<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Log In</title>
	<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="container"></div>
	<div class="overlay"></div>
	<div class="login">
		<form id="loginController" action="${pageContext.request.contextPath}/Admin/LoginController" method="post" onsubmit="event.preventDefault(); validateMyLogin();">
			<h3>Log In</h3>
			<p class="error">Error!</p>
			<input type="email" required id="email" value="<c:out value="${param.userEmail}" />" name="email" placeholder="Email">
			<input type="password" required id="password" name="password" placeholder="Password">
			<label for="level">Sign In As: </label>
			<select name="level" id="level">
				<option value="0">Customer</option>
				<option value="1">Restaurant Assistant</option>
				<option value="2">Warehouse Staff</option>
				<option value="3">Administrator</option>
			</select>
			<button type="submit" name="login">Log In</button>
		</form>
	</div>
	<div id="errorAlert">
		<img src="${pageContext.request.contextPath}/images/error.png" id="errorImg" alt="error">
		<span id="errorMessage"></span>
		<img src="${pageContext.request.contextPath}/images/close.png" id="closeErrorAlert" alt="">
	</div>
	<c:if test="${param.error == '0006'}">
      	<div id="anotherErrorAlert">
			<img src="${pageContext.request.contextPath}/images/error.png" id="anotherErrorImg" alt="error">
			<span id="errorMessage">Password Is Incorrect! Please Try Again!</span>
			<img src="${pageContext.request.contextPath}/images/close.png" id="closeAnotherErrorAlert" alt="">
		</div>
	</c:if>
	<c:if test="${param.error == '0007'}">
      	<div id="anotherErrorAlert">
			<img src="${pageContext.request.contextPath}/images/error.png" id="anotherErrorImg" alt="error">
			<span id="errorMessage">Email Is Incorrect! Please Try Again!</span>
			<img src="${pageContext.request.contextPath}/images/close.png" id="closeAnotherErrorAlert" alt="">
		</div>
	</c:if>
	<script src="${pageContext.request.contextPath}/javascript/loginValidate.js"></script>
</body>
</html>