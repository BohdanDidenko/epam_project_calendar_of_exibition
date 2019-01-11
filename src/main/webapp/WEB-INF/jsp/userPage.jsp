<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>
    This is private consumer page!
    <br>
     <%= request.getAttribute("message")%>
    <br>
    <p><a href="/index?command=index">Index page</a></p>
    <p><a href="/events?command=events">list of expositions</a></p>
</h2>
<h3>
    <c:choose>
        <c:when test="${(!tickets.isEmpty()) && tickets != null}">
    <table border="1">
        <tr>
            <td>Title</td>
            <td>Descroption</td>
            <td>Start data</td>
            <td>End data</td>
            <td>Price</td>
        </tr>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td><c:out value="${ticket.getEvent().getTitle()}"/></td>
                <td><c:out value="${ticket.getEvent().getDescription()}"/></td>
                <td><c:out value="${ticket.getEvent().getStartDate().getTime()}"/></td>
                <td><c:out value="${ticket.getEvent().getEndDate().getTime()}"/></td>
                <td><c:out value="${ticket.getEvent().getPrice()}"/></td>
            </tr>
        </c:forEach>
        </c:when>
        </c:choose>
    </table>
</h3>
</body>
</html>