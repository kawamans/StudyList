<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセルエラー</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	
	<div class = title1>
	<h1>会議室予約キャンセル</h1>
	</div>
	
	<hr>
	
	
	<div class = title2>
	<h2>キャンセルエラー</h2>
	</div>
	
	<div class = contents1>
	<p>既にキャンセルされています</p>
	<p>予約日 ${reservation.date}</p>
	<p>会議室 ${room.name}</p>
	<p>予約時刻 ${reservation.start}～${reservation.end}</p>
	<p>予約者 ${meetingRoom.user.name }</p>
	</div>
	
	<hr>
	<div class = button1>
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="post">
			<input type = submit value ="確認" >
		</form>
	</div>

</body>
</html>