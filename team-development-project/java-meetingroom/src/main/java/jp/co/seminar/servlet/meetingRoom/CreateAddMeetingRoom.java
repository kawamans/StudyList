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
import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.RoomBean;
import jp.co.seminar.dao.RoomDao;

/**
 * @author 猪本
 * 会議室登録
 * */

@WebServlet("/CreateAddMeetingRoom")
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
		
		ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
		RoomBean rb = (RoomBean)session.getAttribute("room");
		MeetingRoom meetingRoom = (MeetingRoom)session.getAttribute("meetingRoom");
		
		//セッションにセット
		session.setAttribute("room", rb);

		//pageをキーにして削除ならdelete、登録ならinsert
		String create = "create";
			session.setAttribute("page", create);
		
		try {
			
			ex.insertRoom(rb);
			meetingRoom.setRooms(RoomDao.findAll());
			
			//成功したら予約完了画面へ
			session.setAttribute("meetingRoom", meetingRoom);
			response.sendRedirect(request.getContextPath()+"/jsp/meetingRoom/meetingRoomCompletion.jsp");
			
		} catch (AppException.AlreadyRegisteredRoomException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp").forward(request, response);
				
		}catch(AppException.InsertRoomFailedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp").forward(request, response);
		}catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp").forward(request, response);
		}
		
		
		
	}
	
	


}
