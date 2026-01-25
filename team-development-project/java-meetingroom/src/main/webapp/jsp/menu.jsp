<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.LoginUserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
	<body>
	
		<%-- ログイン中のユーザー名表示 --%>
		<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
		
		<div class="title1">
			<h1>会議室予約</h1>
		</div>

		<div class="hr">
			<hr>
		</div>

		<div class="title2">
			<h2>メニュー</h2>
		</div>

		<div class="menu-container">
		
		<div class="menu-left">
		<div class="button2">
			<form
				action="<%=request.getContextPath()%>/jsp/reservation/reserveInput.jsp"
				method="post">
				<input type="submit" value="会議室予約">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/cancel/cancelInput.jsp"
				method="post">
				<input type="submit" value="予約キャンセル">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userUpdate.jsp"
				method="post">
				<input type="submit" value="登録情報変更">
			</form>

			<form
				action="<%=request.getContextPath()%>/Logout"
				method="post">
				<input type="submit" value="ログアウト">
			</form>
		</div>
		
		</div>
			
			<%-- セッションからuserAdwminFlgを取得 --%>
		<c:set var="loginUser" value="${ sessionScope.loginUser }" />
			<%-- "1"かどうかを判定 --%>
   		<c:if test="${loginUser.adminflg == '1'}" > 
			<%-- 管理者の処理 --%>
		
		<div class="menu-right">
		<div class="button2">

			<form
				action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomInput.jsp"
				method="post">
				<input type="submit" value="会議室登録">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomDelete.jsp"
				method="post">
				<input type="submit" value="会議室削除">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userCreate.jsp"
				method="post">
				<input type="submit" value="ユーザー新規登録">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userSearch.jsp"
				method="post">
				<input type="submit" value="ユーザー変更・削除">
			</form>

		</div>
		</div>
		
		
		</c:if>
		</div>
	</body>
</html>