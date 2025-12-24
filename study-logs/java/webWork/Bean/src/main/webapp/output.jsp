<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報出力ページ</title>
</head>
<body>
*****出力結果確認*****<br> 
氏名：${ customer.name }<br>
区分：${ customer.job }<br>
年齢：${ customer.age }<br>
${String.format("入場料金：%,d円", customer.admission) }<br>
</body>
</html>
