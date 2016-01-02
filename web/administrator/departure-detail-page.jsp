<%-- 
    Document   : departure-detail-page
    Created on : 28-12-2015, 20:22:52
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="reservations" value="${departure.reservations}"/>
        <h1>Depareture Detail page</h1>
        <div>Date: ${departure.date}</div>
        <div>RouteId: ${departure.routeId}</div>
        <div>Reservation count: ${fn:length(reservations)}</div>
        <div>Current Passenger count: ${departure.currentPassengers}</div>
        <div>Current Vehicle count: ${departure.currentVehicles}</div>
        <div>Current Large Vehicle count: ${departure.currentLargeVehicles}</div>
        
        <form action="FrontController" method="POST">
            <button type="submit" name="command" value="start-up">Back to frontpage</button>
        </form>
    </body>
</html>
