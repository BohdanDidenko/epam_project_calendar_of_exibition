<html>
<body>
<h2>
    This is private consumer page!
    <br>
    Massage: <%= request.getAttribute("message")%>
    <br>
    <p><a href="/index?command=index">Index page</a></p>
    <p><a href="/events?command=events">list of expositions</a></p>
</h2>
<h2></h2>
</body>
</html>