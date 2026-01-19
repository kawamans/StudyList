<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約キャンセル</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- セッション 取得(セッション切れの場合ログイン画面へ遷移させる) --%>
	<%
	HttpSession ses = request.getSession(false);
	if (ses == null) {
    response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    return;
	}
	%>
	
	<div class="title1">
		<h1>会議室予約キャンセル</h1>
	</div>


	<hr>

	<div class="title2">
		<h3>利用日</h3>
	</div>
	<%--日付変更フォーム --%>
	<div class="datechange">
		<form action="<%=request.getContextPath()%>/ChangeDate" method="post">
			<input type="date" name="date" value="${meetingRoom.date}"> 
			<input type="hidden" name="page" value="cancelInput.jsp"> 
			<input type="submit" value="日付変更">
		</form>
	</div>

	<br>


	<h2>
		キャンセル可能時間帯(
		<c:out value="${meetingRoom.user.name}" />
		）

	</h2>

	<%-- ２次元配列で予約状況の取得 --%>
	<c:set var="periods" value="${meetingRoom.period}" />
	<c:set var="rooms" value="${meetingRoom.rooms}" />
	<c:set var="reservations" value="${meetingRoom.reservations}" />
	
	<div class="calendar">
		<table>
			<thead>
				<tr>
					<th>会議室＼時間帯</th>
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
						<th scope="row"><c:out value="${r.name }" /></th>

						<%--時間帯ごとのセル生成 --%>
						<c:forEach var="t" items="${periods}">
							<c:set var="ri" value="${meetingRoom.roomIndex(r.id)}" />
							<c:set var="pi" value="${meetingRoom.startPeriod(t)}" />
							<c:set var="cell" value="${reservations[ri][pi]}" />

							<td><c:choose>
									<c:when
										test="${cell != null && cell.userId == meetingRoom.user.id}">
										<form action="<%=request.getContextPath()%>/CancelCreate"
											method="post" style="display: inline;">
											<input type="hidden" name="roomId" value="${r.id}"> 
											<input type="hidden" name="time" value="${t}"> 
											<input type="submit" value="〇">
										</form>
									</c:when>
									<c:otherwise>×</c:otherwise>
								</c:choose>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<hr>

	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp"
			method="post">
			<input type=submit value="戻る">
		</form>
	</div>

</body>
</html>