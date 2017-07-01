<%--
  Created by IntelliJ IDEA.
  User: lav
  Date: 24.08.2016
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" href="../styles/styles.css">
    <meta charset="utf-8"/>
</head>
<body>

    <center>
        <h1 id="header">Hello, Spring!</h1>
        <form:form action="newSpitter" method="get">
        <table id = "spittersTable">
            <th>№</th>
            <th>Username</th>
            <th>Fullname</th>
            <th>Address</th>
            <th>Email</th>
            <th>Action</th>
            <c:forEach var="spitter" items="${spittles}"
            varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${spitter.userName}</td>
                    <td>${spitter.fullName}</td>
                    <td>${spitter.password}</td>
                    <td>${spitter.email}</td>
                    <td>
                        <a href="deleteSpitter?id=${spitter.id}" id="deleteSpitter">Delete</a>
                        <a href="editSpitter?id=${spitter.id}" id = editSpitter>Edit</a>
                    </td>
                </tr>

            </c:forEach>
            <tr>

                <td colspan="2"><input type="submit" id="addUser" value="Add User"/></td>
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
