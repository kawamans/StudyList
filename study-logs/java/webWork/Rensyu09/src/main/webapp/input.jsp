<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
	<form action="<%= fequest.getContextPath() %>/greeting.jsp" method="get">
		名前：<input type="text" name="name" value="-"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>