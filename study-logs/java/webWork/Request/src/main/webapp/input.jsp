<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/CalculateServlet" method="get">
        長さ：
        <input type="number" name="len" step="any" value="0.0"><br>
        <input type="submit" value="送信">
    </form>
</body>
</html>
