<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 問① SimpleDateFormatをimport -->
<%@ page import="java.text.SimpleDateFormat" %>
<!-- 問② Calendarをimport -->
<%@ page import="java.util.Calendar" %>
<!-- 問③ headerのスタイルを指定 -->
<div style="background-color:  gray;">
 <label style="display: inline-block; padding: 10px; color: white;">
  login
 </label>
 <!-- 問④ 日付のスタイルを指定 -->
 <label style="padding: 10px; font-size: 10px">
 <!-- 問⑤ 課題のフォーマットに合わせて日付を表示するように改修 -->
 <% Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String formatDate = sdf.format(cal.getTime());
    out.print(formatDate);%>
 </label>
</div>

