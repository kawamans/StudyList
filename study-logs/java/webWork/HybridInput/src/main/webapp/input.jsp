<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>入力画面</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/MessageServlet" method="GET">
		メッセージ：<input type="text" name="message" value="メッセージ"><br>
		回数：<input type="number" name="num" value="0"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>