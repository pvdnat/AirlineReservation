<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>User Form</title>
</head>

<style>
.error{
   color:red;
   font-style:italic;
   font-weight:bold;
}

</style>
<body class="container">
	<div align="center">
		<%@include file="navBar.jsp"%>
<h1>User Form</h1>




<f:form action="saveUser" modelAttribute="user">
<table>
<c:if test="${hasErrors}">
<tr>
<td>Errors:</td>
<td><f:errors path="*" cssClass="error"/></td>
</tr>
</c:if>

<tr>
<td>User Id:</td>
<td><f:input path="userId" value="${user.userId}"/></td>

</tr>

<tr>
<td>User Name</td>
<td><f:input  path="username" value="${user.username}"/></td>
</tr>

<tr>
<td>Password</td>
<td><f:password   path="password" value="${user.password}"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><f:input   path="mobileNo" value="${user.mobileNo}"/></td>
</tr>

<tr>
<td>Email</td>
<td><f:input   path="email" value="${user.email}"/></td>
</tr>

<tr>
<td>Roles</td>
<td>
<c:forEach items="${roles}" var="role">
	<c:if test="${retrievedRole.contains(role) }" >
		<f:checkbox path="roles" label="${role.roleName}" value="${role.roleId}" checked="true"/>
	</c:if>
	
	<c:if test="${!retrievedRole.contains(role) }" >
		<f:checkbox path="roles" label="${role.roleName}" value="${role.roleId}" />
	</c:if>
</c:forEach>
</td>
</tr>

<tr>
<td colspan="2" align="center"><input  type="submit" value="submit" class="btn btn-primary"/></td>
</tr>
</table>
</f:form>

</div>

<div align="center">

<table border="1">
<thead>
<tr><td>User Id</td><td>Name</td><td>Password</td><td>Phone Number</td><td>Email</td>
<td>Roles</td>
<td>Action</td>
</tr>
</thead>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.getUserId() }</td>
<td>${user.getUsername() }</td>
<td>${user.getPassword() }</td>
<td>${user.getMobileNo() }</td>
<td>${user.getEmail() }</td>

<td>
<c:forEach items="${user.getRoles()}" var="role">
${role.getRoleName()}

</c:forEach>
</td>

<td>
<a href="${pageContext.request.contextPath}/update?userId=${user.getUserId() }">Update</a>
<a href="${pageContext.request.contextPath}/delete?userId=${user.getUserId() }">Delete</a>
</td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>