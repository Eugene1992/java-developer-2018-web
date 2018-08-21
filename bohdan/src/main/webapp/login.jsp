<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/20/2018
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to ECA</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<br><br><br><br>
<div class="container">
    <div class="row">
        <div class="panel panel-primary col-lg-4 col-md-4 col-lg-offset-4 col-md-offset-4">
            <div class="panel-heading">Employee CRUD App v2.0</div>
            <div class="panel-body">
                <form action="/login" method="post">
                    <label for="login"><b>Login</b></label>
                    <input type="text" class="form-control" placeholder="Enter Login" id="login" name="login" required>
                    <br>
                    <label for="password"><b>Password</b></label>
                    <input type="password" class="form-control" placeholder="Enter Password" id="password" name="password" required>
                    <br>
                    <c:choose>
                        <c:when test="${errMsg != null}">
                            <div class="panel panel-danger">
                                <div class="panel-heading">ERROR</div>
                                <div class="panel-body">
                                    <p style="color: red">${errMsg}</p>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>
                    <button type="submit" class="btn btn-block">Log in</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
