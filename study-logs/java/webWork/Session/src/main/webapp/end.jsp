<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
    <p>あなたの入力した内容は以下の通りです</p>
    <ol>
        <li><%= session.getAttribute("name") %></li>
        <li><%= session.getAttribute("place") %></li>
        <li><%= session.getAttribute("color") %></li>
        <li><%= session.getAttribute("drink") %></li>
    </ol>
    <a href="TopServlet">さいしょのページに戻る</a>
</body>
</html>
