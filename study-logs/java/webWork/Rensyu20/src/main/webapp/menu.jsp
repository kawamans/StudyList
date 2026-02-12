<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
    <h1>英和辞典</h1>
    <hr>
    <h2>単語検索</h2>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        英単語：<input type="text" name="keyword">
        <input type="hidden" name="language" value="english">
        <input type="submit" value="検索"><br>
    </form>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        日本語：<input type="text" name="keyword">
        <input type="hidden" name="language" value="japanese">
        <input type="submit" value="検索"><br>
    </form>
    <hr>
    <h2>単語登録</h2>
    <form action="<%= request.getContextPath() %>/AddServlet" method="get">
        英単語：<input type="text" name="english">
        <input type="hidden" name="search" value="search">
        日本語：<input type="text"name="japanese">
        <input type="submit" value="登録"><br>
    </form>
    <hr>
    <h2>単語削除</h2>
    <form action="<%= request.getContextPath() %>/DeleteServlet" method="get">
        英単語：<input type="text" name="delete">
         <input type="hidden" name="search" value="search">
        <input type="submit" value="削除"><br>
    </form>
</body>
</html>