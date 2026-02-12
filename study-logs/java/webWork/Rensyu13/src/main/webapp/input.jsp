<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
	郵便番号を入力しなさい<br>
    <form action="<%= request.getContextPath() %>/CheckZipCodeServlet" method="get">
        <input type="text" name="zipcode" maxlength="7" value=""><br>
        <input type="submit" value="送信">
    </form>
</body>
</html>
