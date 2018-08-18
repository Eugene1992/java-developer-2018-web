<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 18.08.2018
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">

    <label for="login"><b>Login</b></label>
    <input type="text" placeholder="Enter Login" id="login" name="login" required>
    <br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" id="password" name="password" required>
    <br>
    <c:choose>
        <c:when test="${errMsg != null}">
            <p style="color: red">${errMsg}</p>
        </c:when>
    </c:choose>
    <button type="submit">Login</button>
</form>
</body>
</html>
