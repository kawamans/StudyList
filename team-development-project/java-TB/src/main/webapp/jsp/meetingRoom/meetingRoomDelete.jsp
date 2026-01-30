<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.seminar.bean.RoomBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会議室削除</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp"%>

	<%--必要なセッションをゲット --%>
	<c:set var="extramr" value="${sessionScope.ExtraMR}" />
	<c:set var="mr" value="${sessionScope.meetingRoom }" />
	<c:set var="rooms" value="${mr.rooms }" />

	<div class="title1">
		<h1>会議室削除</h1>
	</div>

	<div class="hr">
		<hr />
	</div>


	<div class="room-admin">
		<table>
			<thead>
				<tr>
					<th>会議室ID</th>
					<th>会議室名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${rooms}">
					<tr>
						<td><c:out value="${t.id}" /></td>
						<td><c:out value="${t.name}" /></td>
						<td>
							<form action="<%=request.getContextPath()%>/DeleteMeetingRoom"
								method="post" style="margin: 0;">
								<input type="hidden" name="roomId" value="${t.id }"/>
								<input type="hidden" name="roomName" value="${t.name }"/>
								<button type="submit" value="${t.id}">削除</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="hr">
		<hr />
	</div>
	<div class="button2">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="get">
			<input type="submit" value="戻る" />
		</form>
	</div>
</body>
</html>
