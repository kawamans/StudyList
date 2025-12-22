<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NG画面</title>
</head>
<body>
    <h1>NG</h1>
    <form action="<%= request.getContextPath() %>/input.jsp" method="get">
        <input type="submit" value="Retry">
    </form>
</body>
</html>