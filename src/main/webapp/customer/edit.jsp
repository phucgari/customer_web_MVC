<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/3/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit customer ${requestScope["customer"].getId()}</title>
</head>
<body>
<form method="post">
  <table>
    <tr>
      <th>name</th>
      <td><input type="text" name="name"placeholder= "name" value="${requestScope["customer"].getName()}"></td>
    </tr>
    <tr>
      <th>email</th>
      <td><input type="text" name="email"placeholder= "email" value="${requestScope["customer"].getEmail()}"></td>
    </tr>
    <tr>
      <th>address</th>
      <td><input type="text" name="address"placeholder= "address" value="${requestScope["customer"].getAddress()}"></td>
    </tr>
  </table>
  <button type="submit">edit</button>
</form>

</body>
</html>
