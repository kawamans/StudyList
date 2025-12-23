<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/CookieServlet" method="post">
        メールアドレス<br>
        <input type="email" name="mail"><br>
        <input type="submit" value="送信">
    </form>
</body>
</html>
