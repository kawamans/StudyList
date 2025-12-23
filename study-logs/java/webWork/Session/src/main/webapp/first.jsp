<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おすすめの街 </title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/SecondServlet">
        おすすめの街：<input type="text" name="place"><br>
        <input type="submit">
    </form>
</body>
</html>
