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
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/book.js"></script>
<meta charset="ISO-8859-1">
<title>Flight Form</title>
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
	<div align="center">
		<%@include file="navBar.jsp"%>
		<sec:authorize access="hasAuthority('Admin')">
		<h1>Flight Form</h1>
			<f:form action="saveFlight" method="POST" modelAttribute="flight">
				<table>
					<tr>
						<td colspan="3"><f:errors  path="*" cssStyle="color:red;"/></td>
					</tr>
					<tr>
						<td>Flight Id:</td>
						<td><f:input path="flightId" value="${flight.getFlightId() }"/></td>
					</tr>
	
					<tr>
						<td>Flight Number:</td>
						<td><f:input path="flightNumber" value="${flight.getFlightNumber() }"/></td>
					</tr>
					
					<tr>
						<td>Airlines:</td>
						<td>
							<f:select path="flightAirlines">
								<c:forEach items="${airlines}" var="al">
									<c:if test="${selectedAirlines==al}">
										<f:option value="${al.airlinesId }" selected="true">${al.airlinesName }</f:option>
									</c:if>
									<c:if test="${selectedAirlines!=al}">
										<f:option value="${al.airlinesId }">${al.airlinesName }</f:option>
									</c:if>
								</c:forEach>
							</f:select>
						</td>
					</tr>
					
					<tr>
						<td>Departure City:</td>
						<td>
						<f:select path="departureCity">
							<c:forEach items="${airport}" var="ap">
								<c:if test="${selectAirportDepartureCity==ap}">
									<f:option value="${ap.airportCity }" selected="true">${ap.airportCity }</f:option>
								</c:if>
								<c:if test="${selectedAirport!=ap}">
									<f:option value="${ap.airportCity }">${ap.airportCity }</f:option>
								</c:if>
							</c:forEach>
						</f:select>
						</td>
					</tr>
					
					<tr>
						<td>Arrival City:</td>
						<td>
						<f:select path="arrivalCity">
							<c:forEach items="${airport}" var="ap">
								<c:if test="${selectAirportArrivalCity==ap}">
									<f:option value="${ap.airportCity }" selected="true">${ap.airportCity }</f:option>
								</c:if>
								<c:if test="${selectedAirport!=ap}">
									<f:option value="${ap.airportCity }">${ap.airportCity }</f:option>
								</c:if>
							</c:forEach>
						</f:select>
						</td>
					</tr>
					
					<tr>
						<td>Departure Date:</td>
						<td><f:input type="date" path="flightDepartureDate" value="${flight.getFlightDepartureDate() }"/></td>
					</tr>
					 
					<tr>
						<td>Departure Time:</td>
						<td><f:input type="time" path="flightDepartureTime" value="${flight.getFlightDepartureTime() }"/></td>
					</tr>
					
					<tr>
						<td>Arrival Date:</td>
						<td><f:input type="date" path="flightArrivalDate" value="${flight.getFlightArrivalDate() }"/></td>
					</tr>
					 
					<tr>
						<td>Arrival Time:</td>
						<td><f:input type="time" path="flightArrivalTime" value="${flight.getFlightArrivalTime() }"/></td>
					</tr>
					
					<tr>
						<td>Capacity:</td>
						<td><f:input path="flightCapacity" value="${flight.getFlightCapacity() }"/></td>
					</tr>
					
					<tr>
						<td>Price:</td>
						<td><f:input path="flightPrice" value="${flight.getFlightPrice() }"/></td>
					</tr>
					
					<tr>
						<td>Seats Booked:</td>
						<td><f:input path="flightSeatsBooked" value="${flight.getFlightSeatsBooked() }"/></td>
					</tr>
					
					<tr>
						<td colspan="3" align="center"><input type="submit"
							value="submit"  class="btn btn-primary"/></td>
					</tr>
	
				</table>
			</f:form>
		</sec:authorize>
	</div>

	<div class="container">
	
		<h1 align="center">Current Active Flight</h1>
		<table class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td>Id</td>
					<td>Number</td>
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
			<c:forEach items="${allActiveFlight}" var="flight">

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
					<sec:authorize access="hasAuthority('Admin')">
						<a href="updateFlight?flightId=${flight.getFlightId()}">Update</a>
						<a href="deleteFlight?flightId=${flight.getFlightId()}">Delete</a>
					</sec:authorize>
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
		
		<sec:authorize access="hasAuthority('Admin')">
			<h1 align="center">Completed Flight</h1>
			<table class="table table-bordered border-primary">
				<thead class="thead-dark">
					<tr>
						<td>Id</td>
						<td>Number</td>
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
					</tr>
				</thead>
				<c:forEach items="${allCompletedFlight}" var="flight">
	
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
						
					</tr>
				</c:forEach>
			</table>
		</sec:authorize>
		
		
	</div>
</body>
</html>