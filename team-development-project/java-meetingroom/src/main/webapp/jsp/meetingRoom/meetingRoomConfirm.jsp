
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.RoomBean" %>
<%
    RoomBean room = (RoomBean) session.getAttribute("room");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会議室削除確認</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="title1"><h1>会議室削除</h1></div>
    <div class="hr"><hr></div>
    <div class="title2"><h2>入力確認</h2></div>

    <div class="contents1">
        <% if (room != null) { %>
            会議室ID：<%= room.getId() %><br>
            会議室名：<%= room.getName() %><br>
            <p>この会議室を削除してもよろしいですか？</p>
        <% } %>
    </div>
        
    <div class="hr"><hr></div>
    
    <div class="button3">
        <%-- 戻るボタン --%>
        <form action="<%= request.getContextPath() %>/jsp/meetingRoom/meetingRoomDelete.jsp" method="post">
            <input type="submit" value="戻る">
        </form>
        
        <%-- 決定ボタン：実際の削除サーブレットへ送信 --%>
        <form action="<%= request.getContextPath() %>/DeleteMeetingRoom" method="post">
            <input type="submit" value="決定">
        </form>
    </div>
</body>
</html>