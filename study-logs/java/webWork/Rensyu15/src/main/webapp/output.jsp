<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String userId = null;
	if(cookies!=null) {
	    for(int i = 0; i < cookies.length; i++) {
	        //クッキー配列の中から目的のクッキーをキーから取得
	        if(cookies[i].getName().equals("userId")) {
	            //クッキーのデータを取得
	            userId = cookies[i].getValue();
	            break;
	        }
	    }
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>出力画面</title>
</head>
<body>
	ようこそ<%= userId %>さん<br>
	<a href="<%= request.getContextPath() %>/input.jsp">戻る</a>
</body>
</html>