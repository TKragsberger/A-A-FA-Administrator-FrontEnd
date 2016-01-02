<%-- 
    Document   : welcome-page
    Created on : 24-12-2015, 18:15:56
    Author     : Thomas Kragsberger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! this is the welcome page</h1>
        <ul>
            <li><a href="FrontController?command=go-to-departure">Departure</a></li>
            <li><a href="FrontController?command=go-to-reservations">Reservation</a></li>

        </ul>
    </body>
</html>
