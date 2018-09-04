<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee CRUD</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee CRUD</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAuthenticated()">
            <li>
                <a href="">
                    <span class="glyphicon glyphicon-user"></span> Welcome, <sec:authentication property="principal.username" />!
                </a>
            </li>
            </sec:authorize>
            <li>
                <a href="/logout">
                    <span class="glyphicon glyphicon-log-in"></span> Logout
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">

    <div class="row col-lg-8 col-lg-offset-2">
        <br>
        <div class="panel panel-primary">
            <div class="panel-heading">Employees CRUD</div>
            <div class="panel-body">
                <form class="form-horizontal" action="/main" method="post">
                    <input type="hidden" class="form-control" id="id" name="id" value="${updEmployee.id}">
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-offset-2" for="first_name">First name:</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" id="first_name" placeholder="Enter first name" name="firstName" value="${updEmployee.firstName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-offset-2" for="last_name">Last name:</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" id="last_name" placeholder="Enter last name" name="lastName" value="${updEmployee.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-offset-2" for="age">Age:</label>
                        <div class="col-lg-5">
                            <input type="number" class="form-control" id="age" placeholder="Enter age" name="age" value="${updEmployee.age}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-offset-2" for="salary">Salary:</label>
                        <div class="col-lg-5">
                            <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary" value="${updEmployee.salary}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="submit" class="btn btn-success center-block">Submit</button>
                        </div>
                    </div>
                </form>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th style="width: 5%"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></th>
                        <th style="width: 5%"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.age}</td>
                            <td>${employee.salary}</td>
                            <td>
                                <a href="/main?action=update&id=${employee.id}">
                                    <button type="button" class="btn btn-info">
                                        <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                                    </button>
                                </a>
                            </td>
                            <td>
                                <a href="/main?action=delete&id=${employee.id}">
                                    <button type="button" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>