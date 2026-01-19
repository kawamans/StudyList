package jp.co.seminar.servlet.meetingRoom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException;
import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.RoomBean;

/**
 * 会議室登録 
 * 遷移先は会議室完了JSPかエラーJSP*/
@WebServlet("/CreateAdd")
public class CreateAddMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメーターなし
		
		//セッションゲット
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"jsp/login.jsp");
			return;
		}
		
		ExtraMR extramr = (ExtraMR)session.getAttribute("ExtraMR");
		RoomBean rb = (RoomBean)session.getAttribute("RoomBean");
		
		//メソッド使用と画面遷移
		
		try {
			
			extramr.insertRoom(rb);
			
			//成功したら予約完了画面へ
			response.sendRedirect(request.getContextPath()+"/jsp/meetingRoom/meetingRoomCompletion.jsp");
			
		} catch (AppException.AlreadyRegisteredRoomException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError").forward(request, response);
				
		}catch(AppException.InsertRoomFailedException e) {
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError").forward(request, response);
		}
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
	}


}
