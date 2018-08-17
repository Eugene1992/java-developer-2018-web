<html>
<head>
    <title>Auth app</title>
</head>
<body>
<form action="/login" method="post">
    <label for="login">
        Login:
        <input id="login" type="text" name="login">
    </label>
    <br>
    <label for="password">
        Password:
        <input id="password" type="text" name="password">
    </label>
    <br>
    <input type="submit" value="login">
</form>
<p style="color: red;">${errMsg}</p>
<p style="color: red;"><% request.getAttribute("errMsg"); %></p>
</body>
</html>