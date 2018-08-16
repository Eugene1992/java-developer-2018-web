<%@ page import="java.util.List" %>
<%@ page import="com.cbs.edu.servlets_crud.model.Employee" %>
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
            <h2>Employees</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var = "employee" items="${employees}">
                    <tr>
                        <td><c:out value = "${employee.id}"/></td>
                        <td><c:out value = "${employee.name}"/></td>
                        <td><c:out value = "${employee.age}"/></td>
                        <td>${employee.salary}</td>
                        <%--<td style="width: 20px"><a data-toggle="modal" data-dismiss="modal" class="btn btn-info" role="button"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a></td>--%>
                        <td style="width: 20px"><button type="button" class="btn btn-info btn-sm right-button" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></button></td>
                        <td style="width: 20px"><a href="/employees?action=delete&id=${employee.id}" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn btn-info btn-sm right-button" data-toggle="modal" data-target="#myModal">Add new</button>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Add new employee</h4>
                        </div>
                        <div class="modal-body">
                            <form action="/employees" method="post">
                                <div class="form-group">
                                    <label for="name">Name:</label>
                                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name"
                                           value="<%=((List<Employee>)request.getAttribute("employees")).get((Integer)request.getAttribute("id")).getName()%>">
                                </div>
                                <div class="form-group">
                                    <label for="age">Age:</label>
                                    <input type="number" class="form-control" id="age" placeholder="Enter age" name="age">
                                </div>
                                <div class="form-group">
                                    <label for="salary">Salary:</label>
                                    <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary">
                                </div>
                                <button type="submit" class="btn btn-success">Submit</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        </div>
    </body>
</html>