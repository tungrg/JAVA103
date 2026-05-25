<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dang ky</title>
</head>
<body>
    <h1>Dang ky</h1>
    <form action="/dangky" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for = "age">Age:</label>
        <input type="number" id="age" name="age" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Dang ky">
    </form>
</body>
</html>