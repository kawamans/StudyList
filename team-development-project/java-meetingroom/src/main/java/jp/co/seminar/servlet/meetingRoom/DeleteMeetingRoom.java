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
 * 削除したい会議室を生成する。
 * @author 谷田　将平
 */

@WebServlet("/DeleteMeetingRoom")
public class DeleteMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		String roomName = request.getParameter("roomName");
		
		//セッション 取得(セッション切れの場合ログイン画面へ遷移させる)
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "jsp/login.jsp");
			return;
		}

		
		ExtraMR extramr = (ExtraMR)session.getAttribute("ExtraMR");
		
		//メソッド使用
		RoomBean rb = extramr.instanceRoom(roomId,roomName);
		
		//セッションにセット
		session.setAttribute("room", rb);
		String delete = "delete";
		session.setAttribute("page", delete);


			response.sendRedirect(request.getContextPath() + "/jsp/meetingRoom/meetingRoomConfirm.jsp");
			//対象の会議室が存在しない場合
		
	}

	
	}

