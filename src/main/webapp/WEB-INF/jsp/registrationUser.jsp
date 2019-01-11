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
<h1>
    Registration consumer page
</h1>
    <br>
<h2><%= request.getAttribute("message")%></h2>

<form action="/reg?command=reg" method="post" name="loginForm">
    <label for="name">Name:</label>
    <input id="name" type="text" name="name" size="20">
    <br>
    <label for="surname">Surname:</label>
    <input id="surname" type="text" name="surname" size="20">
    <br>
    <label for="login">Login:</label>
    <input id="login" type="text" name="login" size="20">
    <br>
    <label for="password">Password </label>
    <input id="password" type="password" name="password" size="20">
    <br>
    <label for="email">Email </label>
    <input id="email" type="text" name="email" size="20">
    <br>
    <label for="phoneNumber">Phone number </label>
    <input id="phoneNumber" type="text" name="phoneNumber" size="20">
    <br>
    <input type="submit" value="Registration">
</form>
</body>
</html>