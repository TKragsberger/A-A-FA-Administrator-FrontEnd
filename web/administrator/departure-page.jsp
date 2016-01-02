<%-- 
    Document   : departure-page
    Created on : 02-01-2016, 13:39:17
    Author     : Thomas Kragsberger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departure page</h1>
        <c:forEach var="departures" items="${requestScope.departures}">
        <li>
            <form action="FrontController" method="POST">
                <input name="id" value="${departures.id}"><br>
                ${departures.date} ${departures.routeId}
                <button type="submit" name="command" value="view-departure" >Get Departure</button>
                <br>
            </form>
        </li>
        </c:forEach>
        <div>Create Departure</div>
        <form action="FrontController" method="POST">
            <input name="id" placeholder="Id">
            <input name="date" placeholder="Date">
            <input name="routeId" placeholder="Route ID">
            <button type="submit" name="command" value="create-departure">Create Departure</button>
        </form>
    </body>
</html>
