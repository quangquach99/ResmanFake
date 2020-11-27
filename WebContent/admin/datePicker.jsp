<!-- Overlay The Whole Body -->
<div id="overlay"></div>
<!-- Datepicker For Revenue -->
<div id="datePicker">
	<h2>Pick Date</h2>
	<i id="closeDatePickerBtn" class="fas fa-times"></i>
	<form method="get" action="${pageContext.request.contextPath}/Admin/RevenueByDish">
		<label for="startDate">From : </label>
		<input type="date" id="startDate" name="startDate">
		<label for="endDate">To : </label>
		<input type="date" id="endDate" name="endDate">
		<button type="submit">Confirm</button>
	</form>
</div>