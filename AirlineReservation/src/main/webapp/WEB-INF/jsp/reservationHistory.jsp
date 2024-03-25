<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Reservation History</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/checkin.js"></script>
<style type="text/css">
.error
(
color
:red
;
)
</style>
</head>
<body class="container">
<%@include file="navBar.jsp"%>
	<div class="container">
		<h1>Reservation History</h1>
		<table id="checkInTable" class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td>Reservation Number</td>
					<td>Passenger</td>
					<td>Flight</td>
					<td>Bags</td>
					<td>Check in</td>	
					<sec:authorize access="hasAuthority('Admin')">
						<td>Action</td>	
					</sec:authorize>
				</tr>
			</thead>
			<c:forEach items="${allReservation}" var="reservation">

				<tr>
					<td>${reservation.getReservationNumber() }</td>
					<td>${reservation.getPassenger().getPassengerLastName() }</td>
					<td>
					${reservation.getFlight().getFlightAirlines().getAirlinesName() }<br>
					${reservation.getFlight().getDepartureCity() } -> ${reservation.getFlight().getArrivalCity() } <br>
					Departure: ${reservation.getFlight().getFlightDepartureDate()}	${reservation.getFlight().getFlightDepartureTime() }<br>
					Arrival: ${reservation.getFlight().getFlightArrivalDate()}	${reservation.getFlight().getFlightArrivalTime()}
					</td>
					<td>${reservation.getCheckedBags() }</td>
					<td>${reservation.checkedIn }</td>
					<sec:authorize access="hasAuthority('Admin')">
						<td>
							<a class="checkInButton" href="#">Check In</a>
						</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="checkInModal" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Check In</h5>
					<button id="closeX" type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				  	<h4>Reservation Number <span id="resNum"></span></h4>
				  	<label>Check In Status</label>
				  	<input class="form-control" id="checkInStatus"/>
				  	
				  	<label>Checked Bag</label>
				  	<input class="form-control" id="checkedBag"/>
				</div>
				<div class="modal-footer">
					<button id="checkInSubmit" type="button" class="btn btn-primary">Save changes</button>
					<button id="closeButton" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
		  </div>
		</div>
	</div>
	
	
	
</body>
</html>