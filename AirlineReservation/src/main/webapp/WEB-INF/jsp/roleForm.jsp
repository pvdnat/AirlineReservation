<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Role Form</title>
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
		<h1>Role Form</h1>
		<f:form action="saveRole" method="POST" modelAttribute="role">
			<table>
				<tr>
					<td>Role Id:</td>
					<td><f:input path="roleId" /></td>
					<td><f:errors path="roleId" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Name:</td>
					<td><f:input path="roleName" /></td>
					<td><f:errors path="roleName" cssClass="error" /></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="submit"  class="btn btn-primary"/></td>
				</tr>

			</table>
		</f:form>
	

		<div class="container-sm">
			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<td>Role Id</td>
						<td>Role Name</td>
					</tr>
				</thead>
				<c:forEach items="${roles}" var="role">
	
					<tr>
						<td>${role.getRoleId() }</td>
						<td>${role.getRoleName() }</td>
					</tr>
				</c:forEach>
	
			</table>
		</div>
	</div>
</body>
</html>