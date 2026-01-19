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
 * 会議室生成 
 * 遷移先は会議室確認JSP*/
@WebServlet("/Create")
public class CreateMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメーターゲット
		//メソッドの引数に何を使うかで変更予定
		String roomId = request.getParameter("roomId");
		String floorNum = request.getParameter("floorNum");
		String roomNum = request.getParameter("roomNum");
		
		//セッションゲット
		//暫定はExtraMRからのみ
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			return;
		}
		
		ExtraMR extramr = (ExtraMR)session.getAttribute("ExtraMR");
		
		//メソッド使用
		//→insertで使用するroombeanを戻り値に持つ、
		//入力パラメーターから会議室生成するメソッドを使用
		
		RoomBean rb = extramr.createRoom(roomId,floorNum,roomNum);
		
		//セッションにセット
		session.setAttribute("RoomBean", rb);
		
		//画面遷移
		response.sendRedirect(request.getContextPath()+"jsp/meetingRoom/meetingRoomConfirm.jsp");
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
	}


}
