<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //クッキーを取得
    Cookie[] cookies = request.getCookies();
    String mail = null;
    if(cookies!=null) {
        for(int i = 0; i < cookies.length; i++) {
            //クッキー配列の中から目的のクッキーをキーから取得
            if(cookies[i].getName().equals("mail")) {
                //クッキーのデータを取得
                mail = cookies[i].getValue();
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
    メールアドレス<br>
    <%= mail %>
</body>
</html>
