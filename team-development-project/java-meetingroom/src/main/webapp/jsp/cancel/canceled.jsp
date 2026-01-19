<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確定</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class = title1>
	<h1>会議室予約キャンセル</h1>
	</div>
	
	<hr>
	
	
	<div class = title2>
	<h2>キャンセル完了</h2>
	</div>
	
	<div class = contents1>
		<p>予約日 <c:out value="${reservation.date}" /></p>
		<p>会議室 <c:out value="${room.name}"/></p>
		<p>予約時刻 <c:out value =" ${reservation.start}"/>～<c:out value = "${reservation.end}"/></p>
		<p>予約者 <c:out value =" ${meetingRoom.user.name }"/> </p>
	</div>
	
	<hr>
	<div class = button1>
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="post">
			<input type = submit value ="完了" >
		</form>
	</div>


</body>
</html>