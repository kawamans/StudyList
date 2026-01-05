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
    <form action="<%= request.getContextPath() %>/UpdateServlet" method="get">
        英単語：<input type="text" name="english" value="<%= list.get(i).getEnglish() %>"><br>
        日本語：<input type="text"name="japanese" value="<%= list.get(i).getJapanese() %>"><br>
        <input type="hidden" name="oldeng" value="<%= list.get(i).getEnglish() %>"><br>
        <input type="hidden" name="oldjp" value="<%= list.get(i).getJapanese() %>"><br>
        <input type="submit" value="修正"><br>
    </form>
    <hr>
    <% } %>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る">
    </form>
</body>
</html>