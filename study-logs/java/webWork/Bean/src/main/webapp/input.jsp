<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力ページ</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/CreateServlet" method="get">
        氏名：<input type="text" name="name" value="-"><br>
        区分：<br>
        <input type="radio" name="job" value="student" checked="checked">学生
        <input type="radio" name="job" value="society">一般
        <input type="radio" name="job" value="other">その他<br>
        年齢：
        <select name="age">
            <% for (int age = 0; age < 100; age++) { %>
                <option value="<%= age %>"><%= age %></option>
            <% } %>
        </select><br>
        <input type="submit" value="送信">
        <input type="reset" value="クリア">
    </form>
</body>
</html>