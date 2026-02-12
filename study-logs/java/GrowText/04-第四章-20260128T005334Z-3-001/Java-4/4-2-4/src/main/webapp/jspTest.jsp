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
</header>
<!-- 問② testJspのスタイルを指定 -->
<div style="ここを修正">
    <!--
      以下はテーブルというタグを使用します。
      「表」をイメージするとわかりやすいと思います。

      ・table: 表データなどを作成する際に使用
        ・tr: テーブルの行の意（行が増えるとテーブルのレコードが増えるイメージです）
          ・th: テーブルヘッダー（見出し）の意
          ・td: テーブルデータ（見出しに対応する実際の値）の意
    -->
    <table>
        <!-- 問③ name・IDのテキストエリアを記述 -->
        <tr>
            <!-- name -->
            <th></th>
            <td></td>
        </tr>
        <tr>
            <!-- ID -->
            <th></th>
            <td></td>
        </tr>
    </table>
</div>
<footer>
<!-- 問④ footer.jspを呼び出し -->
</footer>
</body>
</html>