<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>入力画面</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/TotalServlet" method="POST">
		氏名：<input type="number" name="height" value="" step="0.01"><br>
		：<input type="number" name="weight" value="" step="0.1"><br>
		<input type="submit" value="送信">
	</form>
	<form action="<%= request.getContextPath() %>/input.jsp" method="POST">
		<input type="submit" value="リセット">
	</form>
		
</body>
</html>