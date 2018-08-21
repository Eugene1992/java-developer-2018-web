<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jdbc.Employee" %>
<%@ page import="jdbc.dao.User" %>
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
    <title>Employee CRUD app</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Deleting</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h4>Do you want to delete selected employee?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Decline</button>
                <button type="submit" class="btn btn-success">Accept</button>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">EmpDBApp</a>
        </div>
        <%--<ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>--%>
        <ul class="nav navbar-nav navbar-right" style="font-size: large">
            <li>Welcome, <%=((User) request.getSession().getAttribute("user")).getUsername()%>
            </li>
            <li><a href="/employees?action=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <br>
        <div class="panel panel-primary">
            <div class="panel-heading">Employee CRUD App v2.0</div>
            <div class="panel-body">
                <div class="col-lg-4 col-md-4">
                    <br><br>
                    <form action="/employees" method="get">
                        <label for="search">Search:</label><br>
                        <input class="form-control" type="text" placeholder="Enter name..." id="search" name="search">
                        <button type="submit" class="btn btn-info btn-block"><span class="glyphicon glyphicon-search"
                                                                                   aria-hidden="true"></span></button>
                    </form>
                    <br><br>
                    <c:if test="${user.role ne 'user'}">
                        <a href="/employees?action=create">
                            <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                                    data-target="#upsertModal">
                                Create new employee
                            </button>
                        </a>
                    </c:if>
                    <%--<br>
                    <c:if test="${user.role eq 'admin'}">
                        <a href="/employees?action=update">
                            <button type="submit" class="btn btn-warning btn-block" data-toggle="modal"
                                    data-target="#upsert">
                                Update
                            </button>
                        </a>
                    </c:if>
                    <br>
                    <c:if test="${user.role eq 'admin'}">
                        <div class="form-group">
                            <a href="/employees?action=delete">
                                <button type="submit" class="btn btn btn-danger btn-block">Delete
                                </button>
                            </a>
                        </div>
                    </c:if>--%>
                </div>

                <!-- Modal -->
                <div id="upsertModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="upsertModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Employee:</h3>
                            </div>
                            <div class="modal-body">
                                <form action="/employees" method="post">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="id" name="id"
                                               value="${updatedEmployee.id}">
                                    </div>
                                    <div class="form-group">
                                        <label for="firstName">First name:</label>
                                        <input type="text" class="form-control" id="firstName" name="firstName"
                                               value="${updatedEmployee.firstName}">
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last name:</label>
                                        <input type="text" class="form-control" id="lastName" name="lastName"
                                               value="${updatedEmployee.lastName}">
                                    </div>
                                    <div class="form-group">
                                        <label for="age">Age:</label>
                                        <input type="number" class="form-control" id="age" name="age"
                                               value="${updatedEmployee.age}">
                                    </div>
                                    <div class="form-group">
                                        <label for="salary">Salary:</label>
                                        <input type="number" class="form-control" id="salary" name="salary"
                                               value="${updatedEmployee.salary}">
                                    </div>
                                    <div class="form-group">
                                        <label for="isMarried">Is married:</label>
                                        <input type="checkbox" class="form-control" id="isMarried" name="isMarried"
                                               value="${updatedEmployee.is_married() ? "checked" : "unchecked"}">
                                    </div>
                                    <div class="form-group">
                                        <label for="position">Position:</label>
                                        <input type="text" class="form-control" id="position" name="position"
                                               value="${updatedEmployee.position}">
                                    </div>
                                    <div class="form-group">
                                        <button type="button" class="btn btn-danger form-control" data-dismiss="modal">
                                            Cancel
                                        </button>
                                        <button type="submit" class="btn btn-success form-control">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-8 col-md-8">
                    <table class="table table-bordered">
                        <caption>Employees:</caption>
                        <tr class="table-info">
                            <th width="90">
                                <a href="/employees?sort=asc">
                                    <button class="btn btn-info btn-xs"><span class="glyphicon glyphicon-chevron-up"
                                                                              aria-hidden="true"></span></button>
                                </a>
                                ID
                                <a href="/employees?sort=desc">
                                    <button class="btn btn-info btn-xs"><span
                                            class="glyphicon glyphicon-chevron-down"
                                            aria-hidden="true"></span></button>
                                </a>
                            </th>
                            <th>First name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Is married</th>
                            <th>Position</th>
                            <th style="text-align: center"><span class="glyphicon glyphicon-refresh"
                                                                 aria-hidden="true"></span></th>
                            <th style="text-align: center"><span class="glyphicon glyphicon-trash"
                                                                 aria-hidden="true"></span></th>
                        </tr>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td style="text-align: right">${employee.id}</td>
                                <td>${employee.firstName}</td>
                                <td>${employee.lastName}</td>
                                <td>${employee.age}</td>
                                <td>${employee.salary}</td>
                                <td style="text-align: center">
                                    <c:choose>
                                        <c:when test="${employee.is_married() == true}">
                                            <span class="glyphicon glyphicon-ok"
                                                  aria-hidden="true"></span>
                                        </c:when>
                                        <c:when test="${employee.is_married() == false}">
                                            <span class="glyphicon glyphicon-remove"
                                                  aria-hidden="true"></span>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>${employee.position}</td>
                                <td style="text-align: right">
                                    <c:if test="${user.role eq 'admin'}">
                                        <a href="/employees?action=update&id=${employee.id}">
                                            <button type="button" class="btn info" data-toggle="modal"
                                                    data-target="#upsertModal">
                                                    <span class="glyphicon glyphicon-refresh"
                                                          aria-hidden="true"></span>
                                            </button>
                                        </a>
                                    </c:if>
                                    <c:if test="${user.role ne 'admin'}">
                                        <button class="btn btn-info disabled"><span
                                                class="glyphicon glyphicon-refresh"
                                                aria-hidden="true"></span></button>
                                    </c:if>
                                </td>
                                <td style="text-align: right">
                                    <c:if test="${user.role eq 'admin'}">
                                        <a href="/employees?action=delete&id=${employee.id}">
                                            <button type="button" class="btn btn-danger" data-toggle="modal"
                                                    data-target="#deleteModal">
                                                    <span class="glyphicon glyphicon-trash"
                                                          aria-hidden="true"></span>
                                            </button>
                                        </a>
                                    </c:if>
                                    <c:if test="${user.role ne 'admin'}">
                                        <button class="btn btn-danger disabled"><span
                                                class="glyphicon glyphicon-trash"
                                                aria-hidden="true"></span></button>
                                    </c:if>
                                        <%--<div class="form-group">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="delete"
                                                       id="delete${i}" value="${employee.id}">
                                            </div>
                                        </div>--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <ul class="pagination justify-content-center">
                        <c:forEach var="i" begin="1" end="${pageAmount}">
                            <li class="page-item"><a class="page-link" href="/employees?page=${i}">${i}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
