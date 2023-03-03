<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/3/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CustomerList</title>
</head>
<body>
<form method="get">
    <a href="/customer?action=create">Create</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>
    <c:forEach var="c" items="${list}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td><a href="/customer?action=edit&id=${c.getId()}">edit</a></td>
            <td><a href="/customer?action=delete&id=${c.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
