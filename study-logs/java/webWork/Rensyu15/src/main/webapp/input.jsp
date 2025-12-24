<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String userId = "";
	String userPw = "";
	String check = "";
	if(cookies!=null) {
		for(int i = 0; i < cookies.length; i++) {
	        if(cookies[i].getName().equals("check")) {
	        	check = "checked";
	            break;
	        }
	    }
		if (check.equals("checked")) {
		    for(int i = 0; i < cookies.length; i++) {
		        if(cookies[i].getName().equals("userId")) {
		            userId = cookies[i].getValue();
		            break;
		        }
		    }
		    for(int i = 0; i < cookies.length; i++) {
		        if(cookies[i].getName().equals("userPw")) {
		        	userPw = cookies[i].getValue();
		            break;
		        }
		    }
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>入力画面</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
		　　　　ID<input type="text" name="userId" value="<%= userId %>"><br>
		パスワード<input type="text" name="userPw" value="<%= userPw %>"><br>
		<input type="checkbox" name="check" value="check" <%= check %>>ブラウザで記憶<br>
		<input type="submit" value="送信">
	</form>
</body>
</html>
