<%-- 
    Document   : reservation-detail-page
    Created on : 02-01-2016, 15:41:12
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reservation detail page</h1>
        <div>Date: ${reservation.date}</div>
        <div>First Name: ${reservation.firstName}</div>
        <div>Last Name: ${reservation.lastName}</div>
        <div>Email: ${reservation.email}</div>
        <div>Price: ${reservation.price}</div>
        <div>TicketType: ${reservation.ticketType}</div>
        <div>routeId: ${reservation.routeId}</div>
    </body>
</html>
