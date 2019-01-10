<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <br>
    This is list of expositions!
    <br>
    <p><a href="index?command=index">Index page</a></p>
</h2>

<form action="/buyTicket?command=buyTicket" method="Post">
    <table border="1">
        <tr>
            <td>Check</td>
            <td>Title</td>
            <td>Theme of exibitoin</td>
            <td>Descroption</td>
            <td>Start data</td>
            <td>End data</td>
            <td>Price</td>
            <td>Picture</td>
        </tr>
        <c:forEach items="${events}" var="event">
            <tr>
                <td><input type="checkbox" id="${event.getEventId()}" name="id" value="${event.getEventId()}"  class="c"></td>
                <td><c:out value="${event.getTitle()}"/></td>
                <td><c:out value="${event.getTheme()}"/></td>
                <td><c:out value="${event.getDescription()}"/></td>
                <td><c:out value="${event.getStartDate().getTime()}"/></td>
                <td><c:out value="${event.getEndDate().getTime()}"/></td>
                <td><c:out value="${event.getPrice()}"/></td>
                <%--<td> <img src= <c:out value="${event.getPicture()}"/>></td>--%>
            </tr>
        </c:forEach>
    </table>
    <div>
        <button class="new" type="submit" name="delete" value="buyTicket">Buy ticket</button>
    </div>
</form>
</body>
</html>