<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lav
  Date: 25.08.2016
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Spitter</title>
</head>
<body>
<div align="center">
    <h1 id="addSpitterHeader">Add new spitter</h1>
    <form:form action = "saveSpitter" method = "post" modelAttribute="spitter">
        <table id="newSpitterTable">
            <form:hidden path="id"/>
            <tr>
                <td>Username:</td>
                <td><form:input path="userName"/></td>
            </tr>
            <tr>
                <td>Fullname:</td>
                <td><form:input path="fullName"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="password"/> </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>
</div>
<style>
    <%@ include file="../styles/styles.css"%>
    <%@ include file="../styles/clear.css"%>
</style>
</body>
</html>
