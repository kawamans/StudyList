<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>入力画面</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/BmiServlet" method="POST">
		身長：<input type="number" name="height" value="" step="0.01"><br>
		体重：<input type="number" name="weight" value="" step="0.1"><br>
		<input type="submit" value="送信"><input type="reset" value="リセット">
	</form>
</body>
</html>