<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>JspTest</title>
<style>
    input{
        border: 1px solid #000;
    }
</style>
</head>
<body>
<header>
	<!-- 問① header.jspを呼び出し -->
	<%@ include file="header.jsp" %>
</header>
<!-- 問② testJspのスタイルを指定 -->
<div style="padding-top: 50px; padding-bottom: 50px">
    <!--
      以下はテーブルというタグを使用します。
      「表」をイメージするとわかりやすいと思います。

      ・table: 表データなどを作成する際に使用
        ・tr: テーブルの行の意（行が増えるとテーブルのレコードが増えるイメージです）
          ・th: テーブルヘッダー（見出し）の意
          ・td: テーブルデータ（見出しに対応する実際の値）の意
    -->
    <form>
	    <table>
	        <!-- 問③ name・IDのテキストエリアを記述 -->
	        <tr>
	            <!-- name -->
	            <th>name</th>
	            <td><input type="text" name="name"></td>
	        </tr>
	        <tr>
	            <!-- ID -->
	            <th>ID</th>
	            <td><input type="text" name="id"></td>
	        </tr>
	    </table>
    </form>
</div>
<footer>
<!-- 問④ footer.jspを呼び出し -->
<%@ include file="footer.jsp" %>
</footer>
</body>
</html>