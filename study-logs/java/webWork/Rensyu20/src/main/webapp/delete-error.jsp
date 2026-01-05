<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>削除失敗画面</title>
</head>
<body>
	<h1>削除エラー</h1>
    <hr>
    ${deleteword}の削除ができません<br>
    <hr>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る"><br>
    </form>
</body>
</html>