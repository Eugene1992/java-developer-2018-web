<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Hello employees!</h1>
<h1>Action: ${action}</h1>
<div class="container">
    <div class="row">
        <table class="table table-bordered">
            <tr>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.age}</td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <form action="/employees" method="post">
            <input type="text" name="name"/></br>
            <input type="number" name="age"/></br>
            <input type="submit">
        </form>
    </div>
</div>
</body>
</html>