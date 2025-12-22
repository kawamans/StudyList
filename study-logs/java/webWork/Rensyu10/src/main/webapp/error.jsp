<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>エラー画面</title>
</head>
<body>
	エラーが発生しました<br>
	入力画面で文字列の入力をやり直してください<br>
	<form action="<%= request.getContextPath() %>/input.jsp">
		<input type="submit" value="戻る">
	</form>
</body>
</html>