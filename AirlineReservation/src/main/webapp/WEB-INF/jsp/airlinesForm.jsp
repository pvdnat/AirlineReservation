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
<title>Airlines Form</title>
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
		
		<h1>Airlines</h1>
		<sec:authorize access="hasAuthority('Admin')">
		<f:form action="saveAirlines" method="POST" modelAttribute="airlines">
			<table>
				<tr>
					<td colspan="3"><f:errors  path="*" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Airlines Id:</td>
					<td><f:input path="airlinesId" value="${airlines.getAirlinesId() }"/></td>
				</tr>

				<tr>
					<td>Airlines Name:</td>
					<td><f:input path="airlinesName" value="${airlines.getAirlinesName() }"/></td>
				</tr>
				
				<tr>
					<td>Airlines Code:</td>
					<td><f:input path="airlinesCode" value="${airlines.getAirlinesCode() }"/></td>
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
		<table class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td><a href="airlinesSort?field=airlinesId">Id</a></td>
					<td><a href="airlinesSort?field=airlinesName">Name</a></td>
					<td><a href="airlinesSort?field=airlinesCode">Code</a></td>
					<sec:authorize access="hasAuthority('Admin')">
						<td>Action</td>
					</sec:authorize>
					
				</tr>
			</thead>
			<c:forEach items="${allAirlines}" var="airline">

				<tr>
					<td>${airline.getAirlinesId() }</td>
					<td>${airline.getAirlinesName() }</td>
					
					
					<td>${airline.getAirlinesCode() }</td>
					<sec:authorize access="hasAuthority('Admin')">
						<td>
							<a href="updateAirlines?airlinesId=${airline.getAirlinesId()}">Update</a>
							<a href="deleteAirlines?airlinesId=${airline.getAirlinesId()}">Delete</a>
						</td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>