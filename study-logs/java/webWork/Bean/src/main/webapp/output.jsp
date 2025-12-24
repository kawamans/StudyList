<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@page import=" jp.co.seminar.Customer" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報出力ページ</title>
</head>
<body>
*****出力結果確認*****<br>
<%
    // リクエストインスタンスから会員情報インスタンスを取得
    Customer cst = (Customer)request.getAttribute("customer");
    // 会員情報インスタンスから各値を取得して出力
    out.println("氏名：" + cst.getName() + "<br>");	
    out.println("区分：" + cst.getJob() + "<br>");
    out.println("年齢：" + cst.getAge() + "歳<br>");
    out.println(String.format("入場料金：%,d円", cst.getAdmission()) + "<br>");
%>
</body>
</html>
