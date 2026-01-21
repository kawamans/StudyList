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

	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<c:if test="${flg == 'search'}">
		<c:if test="${user.adminflg == '1'}">
			<c:set var="admin" value="あり" />
		</c:if>
		<c:if test="${user.adminflg == '0'}">
			<c:set var="admin" value="なし" />
		</c:if>
	</c:if>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>ユーザー情報削除</h2>
	</div>
	
	<div class="user-search">
		<form action="<%= request.getContextPath() %>/DeleteUser" method="POST">
			<span>検索ID:</span>
			<input type="text" name="userid" pattern="[0-9]*">
			<input type="hidden" name="flg" value="search">
			<input type="submit" value="検索">
		</form>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<c:if test="${flg == 'search'}">
		<div class="contents1">
			
			検索した利用者を表示します。
		</div>
	</c:if>

	<div class="contents1">
		<form action="<%= request.getContextPath() %>/DeleteUser" method="POST">
			<div class="input-user">
				<span class="user-name">氏名:</span>
				<span class="user-data">${flg == 'search' ? user.name : ''}</span>
			</div>
			
			<div class="input-user">
				<span class="user-name">ID:</span>
				<span class="user-data">${flg == 'search' ? user.id : ''}</span>
			</div>
			
			<div class="input-user">
				<span class="user-name">住所:</span>
				<span class="user-data">${flg == 'search' ? user.address : ''}</span>
			</div>
			
			<div class="input-user">
				<span class="user-name">PW:</span>
				<span class="user-data">${flg == 'search' ? user.password : ''}</span>
			</div>
			
			<div class="input-user">
				<span class="user-name">管理者権限:</span>
				<span class="user-data">${flg == 'search' ? admin : ''}</span>
			</div>
			
			<input type="hidden" name="flg" value="input">
		</form>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button3">
		<form action="<%= request.getContextPath() %>">
			<input type="submit" value="決定">
		</form>

		<form action="<%= request.getContextPath() %>/jsp/menu.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>

</body>
</html>