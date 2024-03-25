<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Home</title>
</head>
<body class="container">
<div align="center">
	<%@include file="navBar.jsp"%>
	
</div>
	<h3 align="center">
		<sec:authorize access="isAuthenticated()">
	   		Welcome <span id="username" ><sec:authentication property="principal.username"/> </span> 
	   		<sec:authorize access="hasAuthority('Admin')">
	   			<h3 align="center">ADMIN</h3>
	   		</sec:authorize>
		</sec:authorize>
	</h3>
	

	<h1 align="center">Search For Flight</h1>
	<f:form action="searchFight">
		<table  align="center">
			<tr>
				<td>Leaving From:</td>	
				<td><input name="departureCity" /></td>			
			</tr>

			<tr>
				<td>Go To:</td>
				<td><input name="arrivalCity"/></td>
			</tr>
			
			<tr>
				<td>Departure Date:</td>
				<td><input type="Date" name="departureDate"/></td>
			</tr>
			
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="submit"  class="btn btn-primary"/></td>
			</tr>

		</table>
	</f:form>
	
	<div class="container">
		<h1 align="center">Current Active Flight</h1>
		<table class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td>Id</td>
					<td><a>Number</a></td>
					<td>Airlines</td>
					<td>Departure City</td>
					<td>Arrival City</td>
					<td>Departure Date</td>
					<td>Departure Time</td>
					<td>Arrival Date</td>
					<td>Arrival Time</td>
					<td>Capacity</td>
					<td>Price</td>
					<td>Seats Booked</td>
					<td>Action</td>
				</tr>
			</thead>
			
			<c:forEach items="${flights}" var="flight">
				<tr>
					<td>${flight.getFlightId() }</td>
					<td>${flight.getFlightNumber() }</td>
					<td>${flight.getFlightAirlines().getAirlinesName() }</td>
					<td>${flight.getDepartureCity() }</td>
					<td>${flight.getArrivalCity() }</td>
					<td>${flight.getFlightDepartureDate() }</td>
					<td>${flight.getFlightDepartureTime() }</td>
					<td>${flight.getFlightArrivalDate() }</td>
					<td>${flight.getFlightArrivalTime() }</td>
					<td>${flight.getFlightCapacity() }</td>
					<td>${flight.getFlightPrice() }</td>
					<td>${flight.getFlightSeatsBooked() }</td>
					<td>
					<sec:authorize access="isAuthenticated()">
						<a class="btn btn-primary" href="${pageContext.request.contextPath}/reservationForm?flightId=${flight.getFlightId()}">Book</a>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<a class="btn btn-primary" href="login">Book</a>
					</sec:authorize>
					</td>
					
				</tr>
			</c:forEach>
			

		</table>
	</div>
	
</body>
</html>