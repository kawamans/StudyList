<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/DBParameterServlet" method="post">
    英単語<input type="text" name="english" value=""><br>
        <input type="submit" value="取得">
    </form>
</body>
</html>
