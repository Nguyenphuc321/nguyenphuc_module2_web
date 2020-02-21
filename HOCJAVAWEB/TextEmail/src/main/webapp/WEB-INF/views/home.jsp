<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/17/2019
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email validate</title>
    <h3 style="color:red">${message}</h3>
</head>
<body>
<form action="validate" method="get">

    <input type="text" name="email"><br>

    <input type="submit" value="Validate">
</form>
</body>
</html>
