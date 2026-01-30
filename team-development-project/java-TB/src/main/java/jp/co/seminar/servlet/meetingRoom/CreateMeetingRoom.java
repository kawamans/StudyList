package jp.co.seminar.servlet.meetingRoom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.RoomBean;

/**
 * @author 猪本
 * 会議室生成
 * */
@WebServlet("/CreateMeetingRoom")
public class CreateMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメーターゲット
		String roomId = request.getParameter("roomId");
		String floor = request.getParameter("floorNum");
		String roomNumber = request.getParameter("roomNum");
		
		//セッションゲット
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			return;
		
		}
		
		ExtraMR extramr = (ExtraMR)session.getAttribute("ExtraMR");
		
		
		
		
		//メソッド使用
		RoomBean rb = extramr.createRoom(roomId,floor,roomNumber);
		
		//セッションにセット
		session.setAttribute("room", rb);
		//pageをキーにして削除ならdelete、登録ならinsert
		String create = "create";
		session.setAttribute("page", create);
		//画面遷移
	
		response.sendRedirect(request.getContextPath()+"/jsp/meetingRoom/meetingRoomConfirm.jsp");
		
	}
	
	


}
