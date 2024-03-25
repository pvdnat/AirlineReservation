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
<title>Airport Form</title>
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
		<h1>Airport</h1>
			<f:form action="saveAirport" method="POST" modelAttribute="airport">
				<table>
					<tr>
						<td colspan="3"><f:errors  path="*" cssStyle="color:red;"/></td>
					</tr>
					<tr>
						<td>Airport Id:</td>
						<td><f:input path="airportId" value="${airport.getAirportId() }"/></td>
					</tr>
	
					<tr>
						<td>Airport Name:</td>
						<td><f:input path="airportName" value="${airport.getAirportName() }"/></td>
					</tr>
					
					<tr>
						<td>Airport Code:</td>
						<td><f:input path="airportCode" value="${airport.getAirportCode() }"/></td>
					</tr>
					
					<tr>
						<td>Airport City:</td>
						<td><f:input path="airportCity" value="${airport.getAirportCity() }"/></td>
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
		<h1 align="center">Active Airport</h1>
		<table class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td><a href="airportSort?field=airportId">Id</a></td>
					<td><a href="airportSort?field=airportName">Name</a></td>
					<td><a href="airportSort?field=airportCode">Code</a></td>
					<td><a href="airportSort?field=airportCity">City</a></td>
					<sec:authorize access="hasAuthority('Admin')">
						<td>Action</td>
					</sec:authorize>
				</tr>
			</thead>
			<c:forEach items="${allAirport}" var="airport">
				<tr>
					<td>${airport.getAirportId() }</td>
					<td>${airport.getAirportName() }</td>
					<td>${airport.getAirportCode() }</td>
					<td>${airport.getAirportCity() }</td>
					<sec:authorize access="hasAuthority('Admin')">
						<td>
							<a href="updateAirport?airportId=${airport.getAirportId()}">Update</a>
							<a href="deleteAirport?airportId=${airport.getAirportId()}">Delete</a>
						</td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>