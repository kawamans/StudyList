<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>pageディレクティブテスト</title>
</head>
<body>
	今日の日付<br>
	<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時MM分"); %>
	<%= sdf.format(new Date()) %>
</body>
</html>