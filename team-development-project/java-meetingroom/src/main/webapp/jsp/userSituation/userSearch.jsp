<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録変更画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	
	<%-- ページング機能用の情報をセット --%>
	<%-- 1ページ内での表示限界数 --%>
	<c:set var="pageSize" value="${10}" />
	<%-- 現在のページ --%>
	<c:set var="requestedPage" value="${empty param.page ? 1 : param.page + 0}" />
	<%-- 1未満（0やマイナス）が指定されたら強制的に1にする --%>
	<c:set var="currentPage" value="${requestedPage < 1 ? 1 : requestedPage}" />
	<%-- 表示する件数の位置を決定 --%>
	<c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
	
	<%-- 表示内容の情報をセット --%>
	<c:set var="ex" value="${sessionScope.ExtraMR}" />
	<c:set var="userList" value="${ex.userList}" />
	<c:set var="targetUser" value="${flg == 'search'? searchUser : userList}" />
	
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>ユーザー情報変更</h2>
	</div>
	
	<div class="user-search">
		<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
			<span>検索ID：</span>
			<input type="text" name="userId" value="${userId}" pattern="[0-9]*">
			<input type="hidden" name="flg" value="search">
			<input type="submit" value="検索">
		</form>
	</div>
			
	<c:if test="${flg == 'search'}">
		<div class="contents1">
			${result != null ? result : ""}
		</div>
	</c:if>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="room-admin">
		<table>
			<thead>
				<th>利用者ID</th>
				<th>氏名</th>
				<th>管理者権限</th>
				<th>変更</th>
				<th>削除</th>
			</thead>
			<tbody>
				<%-- 表示内容をforeachで全件表示 --%>
				<%-- startIndexでどこから表示し、endで表示末尾を指定 --%>
				<c:forEach var="users" items="${targetUser}"
							begin="${startIndex}" end="${startIndex + pageSize - 1}">
							
					<tr>
						<td><c:out value="${users.id}" /></td>
						<td><c:out value="${users.name}" /></td>
						<td><c:out value="${users.adminflg != null ? (users.adminflg == '1' ? '〇' : '×') : ''}" /></td>
						<td>
							<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
								<input type="hidden" name="userId" value="${users.id}">
								<input type="hidden" name="flg" value="update">
								<button type="submit">変更</button>
							</form>
						</td>
				
						<td>
							<c:if test="${users.id != loginUser.id}">
								<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
									<input type="hidden" name="userId" value="${users.id}">
									<input type="hidden" name="flg" value="delete">
									<button type="submit">削除</button>
								</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<%-- ページ番号の表示 --%>
	<div class="pageNumber">
		<%-- fn:lengthで表示件数を取得 --%>
		<c:set var="Item" value="${fn:length(targetUser)}" />
		
		<%-- 2ページ以降であれば表示 --%>
		<c:if test="${currentPage > 1}">
			<a href="<%= request.getContextPath() %>/jsp/userSituation/userSearch.jsp?page=${currentPage - 1}">前へ</a>
		</c:if>
		
		<%-- 現在ページ --%>
		<span>ページ${currentPage}</span>
		
		<%-- 現在のstartIndexの表示件数が11件以上の場合表示 --%>
		<c:if test="${startIndex + pageSize < Item}">
			<a href="<%= request.getContextPath() %>/jsp/userSituation/userSearch.jsp?page=${currentPage + 1}">次へ</a>
		</c:if>
	</div>
	
	<div class="hr">
		<hr />
	</div>
	
	<div class="button3">
		<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">戻る</button>
	</div>
</body>
</html>