<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<c:set var="pageName" value="${sessionScope.page}" />

<%-- Servlet元の種類に応じて表示と遷移先ページを切替 --%>
<c:choose> 
	<c:when test="${pageName == 'create'}">
		<c:set var="message" value="登録確認" />
		<c:set var="nextPage" value="/jsp/userSituation/userCreate.jsp" />
		<c:set var="nextServlet" value="CreateAddUser" />
	</c:when>
	<c:when test="${pageName == 'update'}">
		<c:set var="message" value="変更確認" />
		<c:set var="nextPage" value="/jsp/userSituation/userUpdate.jsp" />
		<c:set var="nextServlet" value="UpdateAddUser" />
	</c:when>
	<c:when test="${pageName == 'delete'}">
		<c:set var="message" value="削除確認" />
		<c:set var="nextPage" value="/jsp/userSituation/userDelete.jsp" />
		<c:set var="nextServlet" value="DeleteAddUser" />
	</c:when>
	<c:otherwise>
		<c:set var="message" value="不明な操作です" />
		<c:set var="nextPage" value="jsp/menu.jsp" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー確認画面</title>
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
		<form action="<%= request.getContextPath() %>/${nextServlet}" method="POST">
			<div class="input-user">
				<span class="user-name">氏名：</span>
				<span class="user-data"><c:out value="${user.name}" /></span>
				<input type="hidden" name="name" value="${user.name}">
			</div>
			<div class="input-user">
				<c:choose>
					<c:when test="${page == 'create'}">
						<span class="user-name">出生年：</span>
						<span class="user-data"><c:out value="${user.birthYear}" /></span>
						<input type="hidden" name="birthYear" value="${user.birthYear}">
					</c:when>
					<c:otherwise>
						<span class="user-name">利用者ID：</span>
						<span class="user-data"><c:out value="${user.id}" /></span>
						<input type="hidden" name="id" value="${user.id}">
					</c:otherwise>
				</c:choose>
			</div>
			<div class="input-user">
				<span class="user-name">PW：</span>
				<span class="user-data"><c:out value="${user.password}" /></span>
				<input type="hidden" name="password" value="${user.password}">
			</div>
			<div class="input-user">
				<span class="user-name">住所：</span>
				<span class="user-data"><c:out value="${user.address}" /></span>
				<input type="hidden" name="address" value="${user.address}">
			</div>
			<c:if test="${loginUser.adminflg == '1'}">
				<div class="input-user">
					<span class="user-name">管理者権限：</span>
					<span class="user-data">${user.adminflg == "1" ? "あり" : "なし"}</span>
				</div>
			</c:if>
			<input type="hidden" name="adminflg" value="${user.adminflg == '1' ? '1' : '0'}">
			
			<div class="button3">
				<button type="button" onclick="location.href='<%= request.getContextPath() %>${nextPage}'">戻る</button>
				<input type="submit" value="確定">
			</div>
		</form>
	</div>
</body>
</html>