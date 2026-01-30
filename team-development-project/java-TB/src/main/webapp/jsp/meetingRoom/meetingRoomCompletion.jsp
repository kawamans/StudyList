<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page import="jp.co.seminar.bean.RoomBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室削除</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp"%>

	<%--セッションからゲット --%>
	<c:set var="room" value="${sessionScope.room }"/>
	
	
	<%-- タイトル→削除か登録 --%>
	<div class="title1">
		<c:choose>
		<c:when test="${page == 'create'}">
		<h2>会議室登録</h2>
		</c:when>
		
		<c:otherwise>
		<h1>会議室削除</h1>
		</c:otherwise>
		</c:choose>
	</div>
	
	
	
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	
	
	<%-- タイトル→削除か登録--%>
	<div class="title2">
		<c:choose>
		<c:when test="${page == 'create'}">
		<h2>登録完了</h2>
		</c:when>
		
		<c:otherwise>
		<h2>削除完了</h2>
		</c:otherwise>
		</c:choose>
	</div>

	

	<%-- コンテンツ --%>
	<div class="contents2">
	<c:if test="${room != null}">
	<div class="input-user">
		<span class="user-name">会議室ID：</span>
		<span class="user-data"><c:out value="${room.id }"/></span><br>
	</div>
	<div class="input-user">
		<span class="user-name">会議室名：</span>
		<span class="user-data"><c:out value="${room.name }"/></span><br>
	</div>
		</c:if>

		<c:choose>
		<c:when test="${page == 'create'}">
		<p>会議室登録を完了しました。</p>
		</c:when>
		
		<c:otherwise>
		<p>会議室削除を完了しました。</p>
		</c:otherwise>
		</c:choose>

	</div>

	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>

	<%-- 完了・戻るボタン --%>
	<div class="button3">
		<form action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomConfirm.jsp"
			method="post">
			<input type="submit" value="戻る">
		</form>
		
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp"
			method="post">
			<input type="submit" value="完了">
		</form>
	</div>

</body>
</html>