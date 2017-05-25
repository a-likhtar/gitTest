<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Edit User Details</title>
</head>
<body>
	<center>

		<div><h1 id="editSpitterHeader">Edit Spitter</h1></div>



	<%--	<c:url var="userRegistration" value="saveUser.html" />--%>
		<form:form id="registerForm" modelAttribute="spitter" method="post"
			action="updateSpitter">
			<table id="editSpittersTable">
				<tr>
					<td><form:input path="id" value="${spitterObject.id}" type="hidden"/></td>
				</tr>
				<tr>
					<td><form:label path="userName">First Name:</form:label></td>
					<td><form:input path="userName" value="${spitterObject.userName}" /></td>
				</tr>
				<tr>
					<td><form:label path="fullName">Last Name:</form:label></td>
					<td><form:input path="fullName" value="${spitterObject.fullName}"/></td>
				</tr>
				<tr>
					<td><form:label path="password">Email:</form:label></td>
					<td><form:input path="password" value="${spitterObject.password}"/></td>
				</tr>
				<tr>
					<td><form:label path="email">Phone:</form:label></td>
					<td><form:input path="email" value="${spitterObject.email}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" />
					</td>
				</tr>
			</table>
		</form:form>


		
	</center>
	<style>
		<%@ include file="../styles/styles.css"%>
		<%@ include file="../styles/clear.css"%>
	</style>
</body>
</html>
