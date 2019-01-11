<html>
<head>
    <title>Please login to YourSiteName</title>
    <style type="text/css">
        input[type=text], input[type=password] {
            display: block;
        }
    </style>
</head>
<body>
<h1>Login page</h1>
<h2><%= request.getAttribute("message")%></h2>

<form action="/login?command=login" method="post" name="loginForm">
    <label for="login">User name:</label>
    <input id="login" type="text" name="login" size="20">
    <br>
    <label for="password">Password </label>
    <input id="password" type="password" name="password" size="20">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>