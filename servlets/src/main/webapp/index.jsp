<%@ page import="com.cbs.edu.servlets.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>Welcome, <%=((User)request.getSession().getAttribute("user")).getUsername()%></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <br>
        <div class="panel panel-primary">
            <div class="panel-heading">Employees CRUD v1.0</div>
            <div class="panel-body">
                <div class="col-lg-8 col-md-8">
                    <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th style="text-align: center"><span class="glyphicon glyphicon-refresh"
                                                             aria-hidden="true"></span></th>
                        <th style="text-align: center"><span class="glyphicon glyphicon-trash"
                                                             aria-hidden="true"></span></th>
                    </tr>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.age}</td>
                            <td>${employee.salary}</td>
                            <td style="width: 20px">
                                <a href="/employees?action=update&id=${employee.id}">
                                    <button class="btn btn-info"><span class="glyphicon glyphicon-refresh"
                                                                       aria-hidden="true"></span></button>
                                </a>
                            </td>
                            <td style="width: 20px">
                                <a href="/employees?action=delete&id=${employee.id}">
                                    <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"
                                                                         aria-hidden="true"></span></button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
                <div class="col-lg-4 col-md-4">
                    <form action="/employees" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="id" name="id" value="${updatedEmployee.id}">
                        </div>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" value="${updatedEmployee.name}">
                        </div>
                        <div class="form-group">
                            <label for="age">Age:</label>
                            <input type="number" class="form-control" id="age" name="age" value="${updatedEmployee.age}">
                        </div>
                        <div class="form-group">
                            <label for="salary">Salary:</label>
                            <input type="number" class="form-control" id="salary" name="salary"
                                   value="${updatedEmployee.salary}">
                        </div>
                        <c:choose>
                            <c:when test="${updatedEmployee.id == null}">
                                <button type="submit" class="btn btn-success center-block">Create</button>
                            </c:when>
                            <c:when test="${updatedEmployee.id != null}">
                                <button type="submit" class="btn btn-warning center-block">Update</button>
                            </c:when>
                        </c:choose>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</body>
</html>