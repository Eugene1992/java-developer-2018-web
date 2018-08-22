<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Servlet name: </h1>${servletName}
    <h3>Servlet config param: </h3>${initParameterOne}
    <h3>Servlet config param: </h3>${initParameterTwo}
    <h3>Servlet context param: </h3>${contextParam}
    <hr>

    <form action="/coockie" method="post">
        <input type="text" name="coockie_name">
        <br>
        <input type="text" name="coockie_value">
        <br>
        <input type="number" name="coockie_age">
        <br>
        <input type="submit">
    </form>
</body>
</html>