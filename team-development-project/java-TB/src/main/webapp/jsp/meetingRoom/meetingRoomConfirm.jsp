
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- ページに入ってる内容によってタイトルを変更 --%>
<title>会議室確認</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp"%>
	
	<%--セッションからゲット --%>
	<c:set var="room" value="${sessionScope.room }"/>
	<c:set var="page" value="${sessionScope.page }"/>
	
	

	
	<div class="title1">

		<c:choose>
			<c:when test="${page == 'create'}">
				<h1>会議室登録</h1>

			</c:when>

			<c:otherwise>
				<h1>会議室削除</h1>
			</c:otherwise>

		</c:choose>
	</div>
	<div class="hr">
		<hr>
	</div>
	<div class="title2">
		<h2>会議室確認</h2>
	</div>

	<div class="contents2">


		<c:choose>
			<c:when test="${page == 'create'}">
				<c:if test="${room != null}">
	<div class="input-user">
		<span class="user-name">会議室名：</span>
		<span class="user-data"><c:out value="${room.name}" /></span><br>
	</div>
	<div class="input-user">
		<span class="user-name">階層：</span>
		<span class="user-data"><c:out value="${room.floor}" /></span><br>
	 </div>
	 <div class="input-user">
		<span class="user-name">部屋番号：</span>
		<span class="user-data"><c:out value="${room.roomNumber}"/></span><br>
	</div>
				<p>この会議室を登録してもよろしいですか？</p>
				</c:if>
			</c:when>

			<c:otherwise>
				<c:if test="${room != null}">
		<div class="input-user">
		<span class="user-name">会議室ID：</span>
		<span class="user-data"><c:out value="${room.id}" /></span><br> 
		</div>
		<div class="input-user">
		<span class="user-name">会議室名：</span>
		<span class="user-data"><c:out value="${room.name}" /></span><br>
		</div>
				<p>この会議室を削除してもよろしいですか？</p>
				</c:if>
			</c:otherwise>

		</c:choose>

	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button3">
		<%-- 戻るボタン --%>
		
		<c:choose>
			<c:when test="${page == 'create'}">
			<form action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomInput.jsp"
			method="post">
			<input type="submit" value="戻る">
			</form>

			</c:when>

			<c:otherwise>
			<form action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomDelete.jsp"
			method="post">
			<input type="submit" value="戻る">
			</form>
			</c:otherwise>

		</c:choose>
		
			
		

		<%-- 決定ボタン：実際の削除サーブレットへ送信 --%>
		
		<c:choose>
			<c:when test="${page == 'create'}">
			
			<form action="<%=request.getContextPath()%>/CreateAddMeetingRoom"
			method="post">
			<input type="submit" value="決定">
			</form>

			</c:when>

			<c:otherwise>
			<form action="<%=request.getContextPath()%>/DeleteAddMeetingRoom"
			method="post">
			<input type="submit" value="決定">
			</form>
			</c:otherwise>

		</c:choose>
		
	</div>
</body>
</html>