<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h3>Employee name: ${employee.name}</h3>
        <h3>Employee age: ${employee.age}</h3>
        <form action="/hello" method="post">
            Employee name:<br>
            <input type="text" name="name" placeholder="Enter name"><br>
            Employee age:<br>
            <input type="number" name="age" placeholder="Enter age"><br>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>