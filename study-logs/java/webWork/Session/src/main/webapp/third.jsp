<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おすすめの飲み物</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/EndServlet">
        おすすめの飲み物：<input type="text" name="drink"><br>
        <input type="submit">
    </form>
</body>
</html>
