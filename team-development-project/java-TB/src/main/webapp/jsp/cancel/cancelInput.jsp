<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約キャンセル</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	
	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>会議室予約キャンセル</h1>
	</div>


	<hr>
	
	<c:if test="${ empty meetingRoom.rooms }">
	<div>
	 <h2>会議室が存在しません。<br>
	 会議室登録を行ってください。</h2>
	</div>
	</c:if>
	
	<c:if test="${ not empty meetingRoom.rooms }">

	<div class="title2">
		<h2>利用日</h2>
	</div>
	<%--日付変更フォーム --%>
	<div class="date-change1">
		<form action="<%=request.getContextPath()%>/ChangeDate" method="post">
			<input type="date" name="date" value="${meetingRoom.date}"> 
			<input type="hidden" name="page" value="cancelInput.jsp"> 
			<input type="submit" value="日付変更">
		</form>
	</div>

	<br>

	<div class="title2">
	<h2>
		<fmt:parseDate value="${meetingRoom.date}" pattern="yyyy-MM-dd" var="d" />
			キャンセル可能時間帯(<fmt:formatDate value="${d}" pattern="yyyy/MM/dd" />）
	</h2>
	</div>

	<%-- ２次元配列で予約状況の取得 --%>
	<c:set var="periods" value="${meetingRoom.period}" />
	<c:set var="rooms" value="${meetingRoom.rooms}" />
	<c:set var="reservations" value="${meetingRoom.reservations}" />
	
	<div class="calendar">
		<table>
			<thead>
				<tr>
					<th>会議室名(ID)＼時間帯</th>
					<!-- 上部横方向時間（period）の繰り返し -->
					<c:forEach var="t" items="${meetingRoom.period}">
						<th><c:out value="${t}" /></th>
					</c:forEach>
				</tr>

			</thead>

			<tbody>
				<c:forEach var="r" items="${meetingRoom.rooms}" varStatus="rs">
					<tr>

						<%--会議室名の表示 --%>
						<th scope="row"><c:out value="${r.name}" />(<c:out value="${r.id }"></c:out>)</th>

						<%--時間帯ごとに予約情報を入れるセル生成 --%>
						<c:forEach var="t" items="${periods}">
							<c:set var="ri" value="${meetingRoom.roomIndex(r.id)}" />
							<c:set var="pi" value="${meetingRoom.startPeriod(t)}" />
							<c:set var="cell" value="${reservations[ri][pi]}" />

							<td><c:choose>
									<c:when
										test="${cell != null && cell.userId == meetingRoom.user.id}">
										<form action="<%=request.getContextPath()%>/CancelCreate"
											method="post" >
											<input type="hidden" name="roomId" value="${r.id}"> 
											<input type="hidden" name="time" value="${t}"> 
											<div class="reservation-available">
											<input type="submit" value="〇">
											</div>
										</form>
									</c:when>
									
									<c:otherwise>
									<div class="reservation-unavailable">×</div>
									</c:otherwise>
									
								</c:choose>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>

	<hr>

	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp"
			method="post">
			<input type=submit value="戻る">
		</form>
	</div>

</body>
</html>