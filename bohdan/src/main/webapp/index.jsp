<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/14/2018
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee search</title>
</head>
<body>
<h1 align="center">Employee search WebApp:</h1>
<form align="center" action="/hello" method="post">
    Employee ID:<br>
    <input type="number" name="id" placeholder="Enter id"><br>
    <br>
    <input type="submit" value="Search">
    <br>
</form>
<table align="center" border="1">
    <caption>Employee:</caption>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th>Position</th>
    </tr>
    <tr><td>${employee.id}</td><td>${employee.firstName}</td><td>${employee.lastName}</td><td>${employee.age}</td><td>${employee.salary}</td><td>${employee.position}</td></tr>
</table>
<%--<h3>ID: ${employee.id}</h3>
<h3>First name: ${employee.firstName}</h3>
<h3>Last name: ${employee.lastName}</h3>
<h3>Age: ${employee.age}</h3>
<h3>Salary: ${employee.salary}</h3>
&lt;%&ndash;<h3>Is married: ${employee.isMarried}</h3>&ndash;%&gt;
<h3>Position: ${employee.position}</h3>--%>
</body>
</html>
