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


</body>
</html>