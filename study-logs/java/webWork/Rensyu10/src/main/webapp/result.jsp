<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>出力画面</title>
</head>
<body>
	あなたが入力した文字列は「<%= message %>」<br>
	文字数は<%= message.length() %>です
</body>
</html>