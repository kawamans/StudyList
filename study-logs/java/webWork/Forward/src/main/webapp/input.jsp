<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
        ユーザー名： <input type="text" name="uid" value=""><br>
        パスワード：<input type="password" name="pwd" value=""><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
