<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="pageName" value="${sessionScope.page}" />

<%-- Servlet元の種類に応じて表示と遷移先ページを切替 --%>
<c:choose> 
	<c:when test="${pageName == 'create'}">
		<c:set var="message" value="登録完了" />
	</c:when>
	<c:when test="${pageName == 'update'}">
		<c:set var="message" value="変更完了" />
	</c:when>
	<c:when test="${pageName == 'delete'}">
		<c:set var="message" value="削除完了" />
	</c:when>
	<c:otherwise>
		<c:set var="message" value="不明な操作です" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー完了画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>

	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2><c:out value="${message}" /></h2>
	</div>

	<div class="contents2">
		<div class="input-user">
			<span class="user-name">氏名：</span>
			<span class="user-data"><c:out value="${user.name}" /></span>
		</div>
		<div class="input-user">
			<c:choose>
				<c:when test="${page == 'create'}">
					<span class="user-name">出生年：</span>
					<span class="user-data"><c:out value="${user.birthYear}" /></span>
				</c:when>
				<c:otherwise>
					<span class="user-name">利用者ID：</span>
					<span class="user-data"><c:out value="${user.id}" /></span>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="input-user">
			<span class="user-name">PW：</span>
			<span class="user-data"><c:out value="${user.password}" /></span>
		</div>
		<div class="input-user">
			<span class="user-name">住所：</span>
			<span class="user-data"><c:out value="${user.address}" /></span>
		</div>
		<c:if test="${loginUser.adminflg == '1'}">
			<div class="input-user">
				<span class="user-name">管理者権限：</span>
				<span class="user-data">${user.adminflg == "1" ? "あり" : "なし"}</span>
			</div>
		</c:if>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp" method="get">
			<input type="submit" value="完了">
		</form>
	</div>
	
</body>
</html>