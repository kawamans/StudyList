<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>入力画面</title>
</head>
<body>
    <h1>BMI測定</h1>
    <form action="<%= request.getContextPath() %>/BmiServlet" method="post">
        <label for="height">身長:</label>
        <input type="number" id="height" name="height" step="0.01" required><br>
        <label for="weight">体重:</label>
        <input type="number" id="weight" name="weight" step="0.1" required><br>
        <input type="submit" value="送信">
    </form>
</body>
</html>
