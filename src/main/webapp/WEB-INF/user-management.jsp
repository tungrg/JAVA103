<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>
    <form action="/user-management" method="post">
        <input type="hidden" id="id" name="id" value="">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="${param.value}">
        <span style = "color:red">${error.email}</span>
        <br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required value="${param.username}">
        <span style = "color:red">${error.username}</span>
        <br>
        <label for = "age">Age:</label>
        <input type="number" id="age" name="age" required value="${param.age}">
        <span style = "color:red">${error.age}</span>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" name="action" value="Save User">
    </form>
    <h2>Existing Users</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Username</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.age}</td>
                <td>
                    <form action="/user-management" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" name="action" value="Delete">
                        <button type="button" onclick="
                            document.getElementById('id').value='${user.id}';
                            document.getElementById('email').value='${user.email}';
                            document.getElementById('username').value='${user.username}';
                            document.getElementById('age').value='${user.age}';
                            document.getElementById('password').value='${user.password}';
                        ">Edit</button>

                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>