<%-- 
    Document   : reservation-summary-page
    Created on : 28-12-2015, 20:23:32
    Author     : Thomas
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
        <h1>Reservations summary page</h1>
        <c:forEach var="reservations" items="${requestScope.reservations}">
        <li>
            <form action="FrontController" method="POST">
                <input name="id" value="${reservations.id}"><br>
                ${reservations.firstName} ${reservations.lastName} ${reservations.email} ${reservations.ticketType} ${reservations.route}
                <button type="submit" name="command" value="view-reservation" >Get reservations</button>
                <br>
            </form>
        </li>
        </c:forEach>
    </body>
</html>
