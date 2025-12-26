<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>登録エラー</h1>
    <hr>
    ${english}は登録済です<br>
    <hr>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る"><br>
    </form>
</body>
</html>