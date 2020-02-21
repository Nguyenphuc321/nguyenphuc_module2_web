<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/3/2019
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
<table border="1px">
    <caption><h1>List Customer</h1></caption>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>birthday</th>
        <th>image</th>
        <th></th>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getBirthday()}</td>
            <td><img src="${customer.getImage()}" width="60px" height="40px" alt="Image"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

