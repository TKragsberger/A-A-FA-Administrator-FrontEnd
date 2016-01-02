<%-- 
    Document   : reservation-page
    Created on : 02-01-2016, 13:39:49
    Author     : Thomas Kragsberger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        console.log("hello this is a test");
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reservation page</h1>
        <form action="FrontController" method="POST">
            <div>Get reservations for specifik date</div>
            <input name="date" placeholder="Date">
            <button type="submit" name="command" value="view-reservations">Get reservations</button>
        </form>
    </body>
</html>
