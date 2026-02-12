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
		<input type="text" name="num1" value="0">
		+
		<input type="text" name="num2" value="0">
		=<br>
		<input type="submit" value="計算">
	</form>
</body>
</html>