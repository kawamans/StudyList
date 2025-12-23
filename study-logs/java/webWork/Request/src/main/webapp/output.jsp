<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出力画面</title>
</head>
<body>
    <%
        //スクリプトレット内の為、javaプログラムで記載可能
        //リクエスト属性の取得
        double circle = (Double)request.getAttribute("circle");
        double square = (Double)request.getAttribute("square");
        out.println("円の面積＝" + circle + "<br>");
        out.println("正方形の面積＝" + square + "<br>");
    %>
</body>
</html>
