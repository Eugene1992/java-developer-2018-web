<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yede0517
  Date: 8/21/2018
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>First request config param: ${firstInitParameter}</h3>
    <h3>Second request config param: ${secondInitParameter}</h3>
    <hr>
    <h3>Request context param: ${servletContextParam}</h3>

    <form action="/coockies" method="post">
        <input type="text" name="coockie_name">
        <br>
        <input type="text" name="coockie_value">
        <br>
        <input type="number" name="coockie_age">
        <br>
        <input type="submit">
    </form>

    <c:forEach var="cookieVal" items="${requestScope.cookies}" >
        <p>${cookieVal.name} = ${cookieVal.value}</p>
    </c:forEach>

    <% Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];%>

        <p><%=cookie.getName()%> = <%=cookie.getValue()%></p>

    <%}%>
</body>
</html>
