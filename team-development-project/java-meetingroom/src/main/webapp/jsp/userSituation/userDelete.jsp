<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報削除画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	
	<c:set var="ex" value="${sessionScope.ExtraMR}" />
	
	<%-- 表示内容をセット --%>
	<%-- 削除対象の情報をセット --%>
	<c:if test="${not empty searchUser}">
		<c:set var="users" value="${searchUser}" />
	</c:if>
	
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>ユーザー情報削除</h2>
	</div>
	
	<c:if test="${error != null}">
		<div class="error">
			${error}
		</div>
	</c:if>

	<div class="contents1">
		<form action="<%= request.getContextPath() %>/DeleteUser" method="POST">
			
			<div class="input-user">
				<span class="user-name">ID：</span>
				<span class="user-data"><c:out value="${users != null ? users.id : ''}" /></span>
				<input type="hidden" name="id" value="${users != null ? users.id : ''}">
			</div>
			
			<div class="input-user">
				<span class="user-name">氏名：</span>
				<span class="user-data"><c:out value="${users != null ? users.name : ''}" /></span>
				<input type="hidden" name="name" value="${users != null ? users.name : ''}">
			</div>
			
			<div class="input-user">
				<span class="user-name">住所：</span>
				<span class="user-data"><c:out value="${users != null ? users.address : ''}" /></span>
				<input type="hidden" name="address" value="${users != null ? users.address : ''}">
			</div>
			
			<div class="input-user">
				<span class="user-name">PW：</span>
				<span class="user-data"><c:out value="${users != null ? users.password : ''}" /></span>
				<input type="hidden" name="password" value="${users != null ? users.password : ''}">
			</div>
			
			<div class="input-user">
				<span class="user-name">管理者権限：</span>
				<span class="user-data">${users != null ? (users.adminflg == '1' ? 'あり' : 'なし') : ''}</span>
				<input type="hidden" name="adminflg" value="${users != null ? users.adminflg : ''}">
			</div>
			
			<div class="hr">
				<hr>
			</div>
			
			<div class="button3">
				<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/userSituation/userSearch.jsp'">戻る</button>
				
				<c:if test="${empty error && error == null}">
					<input type="submit" value="決定">
				</c:if>
			</div>
		
		</form>
	</div>
</body>
</html>