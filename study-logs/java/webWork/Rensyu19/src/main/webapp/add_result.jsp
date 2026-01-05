<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果画面</title>
</head>
<body>
    <h1>登録単語</h1>
    <hr>
    次の単語を登録しました<br>
    英単語：${dict.english}<br>
    日本語：${dict.japanese}<br>
    <hr>
    <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="戻る"><br>
    </form>
</body>
</html>