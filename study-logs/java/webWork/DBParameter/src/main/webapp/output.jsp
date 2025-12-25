<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    List<String> elist = (List<String>) request.getAttribute("elist");
    String mes = (String)request.getAttribute("mes");
    for(String item :elist) {
        mes += "<br>" + item;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出力画面</title>
</head>
<body>
    <%= mes %>
</body>
</html>
