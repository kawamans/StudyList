<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スクリプティングテスト</title>
</head>
<body>
	<%
		String hello = "Hello World!";
		for (int i = 0; i < 5; i++) {
			out.println(hello + "<br>");
		}
	%>
	<%! 
		int num = 1;
		int num1 = 1;
	%>
	<%=
		num = num1 + num
	%>
	<form action="hello5.jsp">
		<input type="submit" value="更新">
	</form>
	<% for (int i = 0; i < 5; i++) { %>
		<p>Hello world!</p>
	<% } %>
</body>
</html>