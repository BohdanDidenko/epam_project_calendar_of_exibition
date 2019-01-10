<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <br>
    Delete event page!
    <br>
    <p><a href="https://localhost:9000/protected/adminPage">Admin page</a></p>
</h2>
<form action="protected/delEvent" method="GET">
    <table border="1">
                <tr>
                    <td>Check</td>
                    <td>Name</td>
                    <td>Short description</td>
                    <td>Cost</td>
                    <td>Hall</td>
                    <td>Start data</td>
                    <td>End data</td>
                    <td>Picture</td>
                </tr>
        <c:forEach items="${events}" var="event">
            <tr>
                <td><input type="checkbox"  transform: scale(1.5); id="${event.getId()}" name="id" value="${event.getId()}"  class="c"></td>
                <td><c:out value="${event.getNameExposition()}"/></td>
                <td><c:out value="${event.getShortDescription()}"/></td>
                <td><c:out value="${event.getCost()}"/></td>
                <td><c:out value="${event.getNameHall()}"/></td>
                <td><c:out value="${event.getStartDate()}"/></td>
                <td><c:out value="${event.getEndDate()}"/></td>
                <td> <img src= <c:out value="${event.getPicture()}"/>></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <button class="new" type="submit" name="delete" value="delEvent">Delete event</button>
    </div>
</form>
</body>
</html>