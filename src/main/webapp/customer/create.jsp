<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/3/2023
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<%!
%>
<form method="post">
<table>
    <tr>
        <th>name</th>
        <td><input type="text" name="name" placeholder= "name"></td>
    </tr>
    <tr>
        <th>email</th>
        <td><input type="text" name="email" placeholder= "email"></td>
    </tr>
    <tr>
        <th>address</th>
        <td><input type="text" name="address" placeholder= "address"></td>
    </tr>
</table>
    <button type="submit">add</button>
</form>
</body>
</html>
