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
        英単語：<input type="text" name="engword">
        <input type="submit" value="検索"><br>
    </form>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        日本語：<input type="text" name="jpword">
        <input type="submit" value="検索"><br>
    </form>
    <hr>
    <h2>単語登録</h2>
    <form action="<%= request.getContextPath() %>/AddServlet" method="get">
        英単語：<input type="text" name="english">
        日本語：<input type="text"name="japanese">
        <input type="submit" value="登録"><br>
    </form>
    <hr>
</body>
</html>