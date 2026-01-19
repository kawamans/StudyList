<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<%@ page import="jp.co.seminar.bean.ReservationBean" %>
<%@ page import="jp.co.seminar.bean.RoomBean" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約入力画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	
	<%-- タイトル１ --%>
	<div class="title1">
		<h1>会議室予約</h1>
	</div>

	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>

	<%-- タイトル２ --%>
	<div class="title2">
		<h2>利用日</h2>
	</div>

	<%-- 日付変更 --%>
	<div class="date-change1">
		<form action="<%=request.getContextPath()%>/ChangeDate" method="post">
			<input type="date" name="date" value="${meetingRoom.date}"> 
			<input type="hidden" name="page" value="reserveInput.jsp"> 
			<input type="submit" value="日付変更">
		</form>
	</div>
	
	<br>

	<%-- タイトル２ --%>
	<div class="title2">
		<h2>予約可能時間帯( <c:out value="${meetingRoom.user.name}" /> ）</h2>
	</div>
	
	<%-- ２次元配列で予約状況の取得 --%>
	<c:set var="periods" value="${meetingRoom.period}" />
	<c:set var="rooms" value="${meetingRoom.rooms}" />
	<c:set var="reservations" value="${meetingRoom.reservations}" />

	<%-- カレンダー --%>
	<div class="calendar">
		<form action="<%=request.getContextPath()%>/ReserveCreate" name=""
			method="post">
			<table>
				<thead>
					<tr>
						<th>会議室名＼時間帯</th>
					<!-- 上部横方向時間（period）の繰り返し -->
					<c:forEach var="t" items="${meetingRoom.period}">
						<th><c:out value="${t}" /></th>
					</c:forEach>
					</tr>
				</thead>
				<c:forEach var="r" items="${meetingRoom.rooms}" varStatus="rs">
					<tr>

						<%--会議室名の表示 --%>
						<th scope="row"><c:out value="${r.name }" /></th>

						<%--時間帯ごとのセル生成 --%>
						<c:forEach var="t" items="${periods}">
							<c:set var="ri" value="${meetingRoom.roomIndex(r.id)}" />
							<c:set var="pi" value="${meetingRoom.startPeriod(t)}" />
							<c:set var="cell" value="${reservations[ri][pi]}" />
							
							<td><c:choose>
									<c:when
										test="${cell == null }">
										<form action="<%=request.getContextPath()%>/ReserveCreate"
											method="post" style="display: inline;">
											<input type="hidden" name="roomId" value="${r.id}"> <input
												type="hidden" name="time" value="${t}"> <input
												type="submit" value="〇">
										</form>
									</c:when>
									<c:otherwise>×</c:otherwise>
								</c:choose></td>
						</c:forEach>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>

	<%-- 戻るボタン --%>
	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/userSituation/menu.jsp"
			method="post">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>