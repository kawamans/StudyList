<%@page import="jp.co.seminar.util.DictionaryList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
</head>
<body>
    <h1>検索単語</h1>
    <hr>
    <%
    DictionaryList list = (DictionaryList)request.getAttribute("list"); 
    for (int i = 0; i < list.size(); i++) {
    %>
    英単語：<%= list.get(i).getEnglish() %><br>
    日本語：<%= list.get(i).getJapanese() %><br>
    <hr>
    <% } %>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る">
    </form>
</body>
</html>