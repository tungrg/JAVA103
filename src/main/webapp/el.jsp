<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Epression language</title>
    </head>
    <body>
        <h1>Expression language</h1>
        <ul>
            <li>requestScope.x: ${requestScope.x}</li>
            <li>sessionScope.y: ${sessionScope.y}</li>
            <li>applicationScope.z: ${applicationScope.z}</li>
            <li>Bean.month: ${now123.month} </li>
            <li>Bean.year: ${now123.year}</li>
            <li>MSSV cua toi: ${MSSV}</li>
            <li>map.a: ${map['a']}</li>
            <li>map.b: ${map['b']}</li>
            <!-- <li>Danh sach ten[0]: ${listTen[0]}</li>
            <li>Danh sach ten[1]: ${listTen[1]}</li>
            <li>Danh sach ten[2]: ${listTen[2]}</li> -->
            <c:forEach var="item" items="${listTen123}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </body>
</html>