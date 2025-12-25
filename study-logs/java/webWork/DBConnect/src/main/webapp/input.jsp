<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/DBConnServlet" method="post">
        <input type="submit" value="接続テスト">
    </form>
</body>
</html>
