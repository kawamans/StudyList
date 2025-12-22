<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>出力画面</title>
</head>
<body>
	<%= num1 %>
	+
	<%= num2 %>
	=
	<%= num1 + num2 %>
</body>
</html>