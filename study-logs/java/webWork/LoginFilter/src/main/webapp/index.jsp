<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
	ようこそ、${sessionScope.userId}さん<br>
	ここはトップページです
	<form action="logout.jsp" method="get">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>