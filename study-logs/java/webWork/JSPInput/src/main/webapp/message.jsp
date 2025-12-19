<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String msg = request.getParameter("message");
	String tmp = request.getParameter("num");
	int num = Integer.parseInt(tmp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出力画面</title>
</head>
<body>
	<%
		for (int i = 0; i < num; i++) {
			out.print(msg + "<br>");
		}
	%>
</body>
</html>