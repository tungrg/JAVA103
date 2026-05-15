<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hello</title>
    </head>
    <body>
        <h1>Hello, World!</h1>
        <p>Welcome to the Spring Boot application.</p>
        <!-- <%@ include file="sub.jsp" %> -->
         <jsp:include page="sub.jsp">
            <jsp:param value="Hello sub page" name="param1" />
         </jsp:include>
    </body>
</html>