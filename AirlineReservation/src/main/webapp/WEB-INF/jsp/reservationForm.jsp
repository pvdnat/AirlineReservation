<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Reservation Form</title>
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
		
		
		<h1>Flight Information</h1>
		
		<f:form modelAttribute="flightInfo">
			
			 <div class="form-group">
				<label for="airline">Airline</label>
				<f:input id="airline" class="form-control" path="flightAirlines" value="${flightInfo.getFlightAirlines().getAirlinesName() }"/>
		    </div>
					    
				
			
			<div class="form-row">
				<div class="form-group col-md-6">
				  <label for="dCity">Departure City</label>
				  <f:input id="dCity" class="form-control" path="departureCity" value="${flightInfo.getDepartureCity() }"/>
				</div>
				<div class="form-group col-md-4">
				  <label for="dDate">Departure Date</label>
				  <f:input id="dDate" class="form-control" path="flightDepartureDate" value="${flightInfo.getFlightDepartureDate() }"/>
				</div>
				<div class="form-group col-md-2">
				   <label for="dTime">Departure Time</label>
				  <f:input id="dTime" class="form-control" path="flightDepartureTime" value="${flightInfo.getFlightDepartureTime() }"/>
				</div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
				  <label for="aCity">Arrival City</label>
				  <f:input id="aCity" class="form-control" path="arrivalCity" value="${flightInfo.getArrivalCity() }"/>
				</div>
				<div class="form-group col-md-4">
				  <label for="aDate">Arrival Date</label>
				  <f:input id="aDate" class="form-control" path="flightArrivalDate" value="${flightInfo.getFlightArrivalDate() }"/>
				</div>
				<div class="form-group col-md-2">
				   <label for="aTime">Arrival Time</label>
				  <f:input id="aTime" class="form-control" path="flightArrivalTime" value="${flightInfo.getFlightArrivalTime() }"/>
				</div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-4">
				  <label for="capacity">Capacity</label>
				  <f:input id="capacity" class="form-control" path="flightCapacity" value="${flightInfo.getFlightCapacity() }"/>
				</div>
				<div class="form-group col-md-4">
				  <label for="price">Price</label>
				  <f:input id="price" class="form-control" path="flightPrice" value="${flightInfo.getFlightPrice() }"/>
				</div>
				<div class="form-group col-md-4">
				   <label for="seatBooked">Seats Booked</label>
				  <f:input id="seatBooked" class="form-control" path="flightSeatsBooked" value="${flightInfo.getFlightSeatsBooked() }"/>
				</div>
			</div>
			
		</f:form>	
	</div>

	<div class="container">
		<h1>Reservation Form</h1>
		<f:form action="saveReservation?flightId=${flightInfo.getFlightId() }" method="POST" modelAttribute="reservation">
			<table>
				<tr>
					<td colspan="3"><f:errors  path="*" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Passenger:</td>
					<td>
					<f:select path="passenger">
						<c:forEach items="${passengers}" var="pa">
							<f:option value="${pa.passengerId }">${pa.passengerLastName } ${pa.passengerFirstName }</f:option>
						</c:forEach>
					</f:select>
					</td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Book Now"  class="btn btn-primary"/></td>
				</tr>

			</table>
		</f:form>
	</div>
	
	
</body>
</html>