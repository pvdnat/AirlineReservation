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
<title>Passenger Form</title>
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
		<h1>Passenger Form</h1>
		
		<f:form action="savePassenger" method="POST" modelAttribute="passenger">
			<table>
				<tr>
					<td colspan="3"><f:errors  path="*" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Passenger Id:</td>
					<td><f:input path="passengerId" value="${passenger.getPassengerId() }"/></td>
				</tr>

				<tr>
					<td>First Name:</td>
					<td><f:input path="passengerFirstName" value="${passenger.getPassengerFirstName() }"/></td>
				</tr>
				
				<tr>
					<td>Last Name:</td>
					<td><f:input path="passengerLastName" value="${passenger.getPassengerLastName() }"/></td>
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><f:input path="passengerEmail" value="${passenger.getPassengerEmail() }"/></td>
				</tr>
				
				<tr>
					<td>Phone:</td>
					<td><f:input path="passengerPhoneNo" value="${passenger.getPassengerPhoneNo() }"/></td>
				</tr>
				
				<tr>
					<td>Gender:</td>
					<td>	
						<c:forEach items="${genders}" var="gender">
							<c:choose>
								<c:when test="${selectedGender==gender }">
									<f:radiobutton path="passengerGender" name="gender" value="${gender }" label="${gender }" checked="true"/>
								</c:when>
								<c:otherwise>
									<f:radiobutton path="passengerGender" name="gender" value="${gender }" label="${gender }"/>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
				</tr>
				
				<tr>
					<td>DOB:</td>
					<td><f:input type="date" path="passengerDOB" value="${passenger.getPassengerDOB() }"/></td>
				</tr>
				
				<tr>
					<td align="center">Address</td>
				</tr>
				
				<tr>
					<td>Address 1:</td>
					<td><f:input path="passengerAddress.addressLine1" value="${passenger.getPassengerAddress().getAddressLine1() }"/></td>
				</tr>
				
				<tr>
					<td>Address 2:</td>
					<td><f:input path="passengerAddress.addressLine2" value="${passenger.getPassengerAddress().getAddressLine2() }"/></td>
				</tr>
				
				<tr>
					<td>City:</td>
					<td><f:input path="passengerAddress.city" value="${passenger.getPassengerAddress().getCity() }"/></td>
				</tr>
				
				<tr>
					<td>State:</td>
					<td><f:input path="passengerAddress.state" value="${passenger.getPassengerAddress().getState() }"/></td>
				</tr>
				
				<tr>
					<td>Country:</td>
					<td><f:input path="passengerAddress.country" value="${passenger.getPassengerAddress().getCountry() }"/></td>
				</tr>
				
				<tr>
					<td>Zip Code:</td>
					<td><f:input path="passengerAddress.zipCode" value="${passenger.getPassengerAddress().getZipCode() }"/></td>
				</tr>
				
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="submit"  class="btn btn-primary"/></td>
				</tr>

			</table>
		</f:form>
		
	</div>

	<div class="container">
		<table class="table table-bordered border-primary">
			<thead class="thead-dark">
				<tr>
					<td>Id</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Phone No</td>
					<td>Gender</td>
					<td>DOB</td>
					<td>Address</td>
					
					<td>Action</td>
					
				</tr>
			</thead>
			
				<c:forEach items="${allPassenger}" var="passenger">
	
					<tr>
						<td>${passenger.getPassengerId() }</td>
						<td>${passenger.getPassengerFirstName() }</td>
						<td>${passenger.getPassengerLastName() }</td>
						<td>${passenger.getPassengerEmail() }</td>
						<td>${passenger.getPassengerPhoneNo() }</td>
						<td>${passenger.getPassengerGender() }</td>
						<td>${passenger.getPassengerDOB() }</td>
						<td>
						Address Line 1: ${passenger.getPassengerAddress().getAddressLine1() }<br>
						Address Line 2: ${passenger.getPassengerAddress().getAddressLine2() }<br>
						City: ${passenger.getPassengerAddress().getCity() }<br>
						State: ${passenger.getPassengerAddress().getState() }<br>
						Country: ${passenger.getPassengerAddress().getCountry() }<br>
						Zip Code: ${passenger.getPassengerAddress().getZipCode() }
						</td>
						<td>
						<a href="updatePassenger?passengerId=${passenger.getPassengerId()}">Update</a>
						<a href="">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			
			
			
		</table>
	</div>
</body>
</html>