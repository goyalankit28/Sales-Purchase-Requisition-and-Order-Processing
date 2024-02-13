<%-- 
    Document   : supplier-success
    Created on : Apr 5, 2023, 6:01:32 PM
    Author     : ankitgoyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.userSession.getFirstName()}!</h1>
        <br><h2>Your Role: ${sessionScope.userSession.getUserRole().getRole()}</h2>
    </body>
</html>
