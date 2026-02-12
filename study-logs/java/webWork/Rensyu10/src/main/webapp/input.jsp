<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>入力画面</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/result.jsp" method="GET">
		文字列：<input type="text" name="message" value="-"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>