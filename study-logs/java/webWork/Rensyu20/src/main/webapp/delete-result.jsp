<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除結果画面</title>
</head>
<body>
	<h1>削除単語</h1>
		<hr>
		次の単語を削除しました<br>
		英単語：${deleteword}<br>
	<hr>
	<form action="<%= request.getContextPath() %>/menu.jsp" method="get">
		<input type="submit" value="戻る"><br>
	</form>

</body>
</html>