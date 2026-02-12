<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修正結果画面</title>
</head>
<body>
<h1>登録単語</h1>
    下記の通り修正を行いました<br>
    <hr>
    修正後<br>
    英単語：${dict.english}<br>
    日本語：${dict.japanese}<br>
    <hr>
    修正前<br>
    英単語：${oldeng}<br>
    日本語：${oldjp}<br>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る"><br>
    </form>
</body>
</html>