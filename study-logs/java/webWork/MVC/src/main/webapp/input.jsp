<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>入力画面</title>
</head>
<body>
    <h1>Enter Your Information</h1>
    <form action="<%= request.getContextPath() %>/UserServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="location">Location:</label>
        <input type="text" id="location" name="location"><br>
        <input type="submit" value="Greet Me">
    </form>
</body>
</html>
