<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>好きな色</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/ThirdServlet">
        好きな色：<input type="text" name="color"><br>
        <input type="submit">
    </form>
</body>
</html>
