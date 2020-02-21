<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/12/2019
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><a href="list">List All Customers </a></h1>
<div align="center">
    <form action="update" method="post">
        <table border="l" cellpadding="5">
            <caption>
                Add New Customer
            </caption>
            <tr>
                <td>
                    <input type="hidden" name="id" size="45" value="${customer.getId()}"/>
                </td>
            </tr>

            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="${customer.getName()}"/>
                </td>
            </tr>

            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="45" value="${customer.getPhone()}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45" value="${customer.getEmail()}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>

        </table>

    </form>
</div>
</body>
</html>

