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
			<div class="wrap_table">
				<c:if test="${!empty listTable}">	
				<h3>List Of Tables</h3>			
				<div class="btn_new"><a href="${pageContext.request.contextPath}/Admin/new">Add new table</a></div>
				<table>
					<tr>
						<th>NO.</th>
						<th>Maximum Of People</th>
						<th>Image</th>
						<th>Near Window</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<c:set var="no" value="${1}" />
					<c:forEach var="Table" items="${listTable}">
						<tr>
							<!-- no -->
							<td class="in-no"><c:out value="${no}" /></td>
							<c:set var="no" value="${no+1}" />
	
							<!-- number -->
							<td class="table-col"><c:out value="${Table.maximumOfPeople}" /></td>
	
	
							<!-- image -->
							<td id="tableImg"><img
								src="${pageContext.request.contextPath}/images/tables/<c:out value="${Table.tableImage}" />"
								alt="table"></td>
	
	
							<!-- near window -->
	
							<td class="table-col">
								<c:if test="${Table.nearWindow == 1}">
									<span>Yes</span>
								</c:if>
								<c:if test="${Table.nearWindow == 0}">
									<span>No</span>
								</c:if>
							</td>
	
							<!-- price -->
							<td class="table-col">$<c:out value="${Table.tablePrice}" /></td>
							
							<!-- action -->
							<td class="action">
								<a
								href="${pageContext.request.contextPath}/Admin/edit?tableId=${Table.tableId}">Edit</a>
								
								&nbsp;&nbsp;&nbsp;&nbsp; 
								
								<a
								href="${pageContext.request.contextPath}/Admin/delete?tableId=${Table.tableId}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			</div>
			
		<c:if test="${empty listTable}">
			<p style="text-align: center;">No Records!!!</p>
		</c:if>
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