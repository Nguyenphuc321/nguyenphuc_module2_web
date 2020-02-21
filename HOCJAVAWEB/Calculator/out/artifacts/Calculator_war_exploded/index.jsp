<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/1/2019
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/caculator">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First number:</td>
                <td><input name="firtnumber" type="text"/></td>
            </tr>
            <tr>
                <td>Opert:</td>
                <td>
                    <select name="opert">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second number:</td>
                <td><input name="secondnumber" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
