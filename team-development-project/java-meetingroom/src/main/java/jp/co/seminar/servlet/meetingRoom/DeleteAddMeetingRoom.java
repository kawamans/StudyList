package jp.co.seminar.servlet.meetingRoom;

import java.io.IOException;

/**
 * 会議室を削除する
 * 削除成功時は、削除完了画面に遷移し、例外処理を補足した場合
 * 例外メッセージをリクエスト属性にセットして
 * 削除エラー画面に遷移する
 * @author 谷田　将平
 */

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

@WebServlet("/DeleteAddMeetingRoom")
public class DeleteAddMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		//extramrとmeetingRoomの初期
		ExtraMR extramr = (ExtraMR) session.getAttribute("ExtraMR");
		RoomBean rb = (RoomBean) session.getAttribute("room");
		//遷移先分岐の変数追加
		//session取得
		session.setAttribute("room", rb);
		
		String delete = "delete";
		session.setAttribute("page", delete);
		//画面遷移

		try {

			//extramrのメソッドを実行
			extramr.deleteRoom(rb);
			
			RoomBean[] updatedRooms = RoomDao.findAll();
			
			MeetingRoom mr = (MeetingRoom)session.getAttribute("meetingRoom");
			
			mr.setRooms(updatedRooms);
		
			response.sendRedirect(request.getContextPath()+"/jsp/meetingRoom/meetingRoomCompletion.jsp");

			
			//対象の会議室が存在しない場合
		} catch (AppException.NonExistentRoomException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp")
					.forward(request, response);

			//会議室削除に失敗した場合
		} catch (AppException.DeleteRoomFailedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp")
					.forward(request, response);
		}

	}

	
	}

