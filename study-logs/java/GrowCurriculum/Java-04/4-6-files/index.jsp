<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MemberBean"%>

<%
    // 問① getAttributeに適切な引数をセットして、MemberControllerから渡されたBeanを取得する。
    MemberBean memberBean = (MemberBean) request.getAttribute("ここを改修");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
    <div align="center">
        <!-- 検索が成功した場合の表示 -->
        <%
            if (memberBean != null) {
        %>
        <!--  問②  社員名、コメント、ログインタイムをそれぞれ出力して下さい -->
        <table border="1">
            <tr>
                <th>社員名</th>
                <td><!-- ここに記述 --></td>
            </tr>
            <tr>
                <th>コメント</th>
                <td><!-- ここに記述 --></td>
            </tr>
            <tr>
                <th>ログインタイム</th>
                <td><!-- ここに記述 --></td>
            </tr>
        </table>

        <!-- 問③  エラーの場合の表示をさせて下さい。-->
        <% } else { %>
           【ここを修正】
        <% } %>
    </div>
</body>
</html>