<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索エラー画面</title>
</head>
<body>
    <h1>検索エラー</h1>
    <hr>
    ${english}${japanese}は未登録です<br>
    <hr>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る">
    </form>
</body>
</html>