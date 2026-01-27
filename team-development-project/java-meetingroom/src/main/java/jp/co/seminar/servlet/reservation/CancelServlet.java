package jp.co.seminar.servlet.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException;
import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.ReservationBean;

@WebServlet("/Cancel")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 予約を削除する。
	 * キャンセル成功時は予約キャンセル完了画面に遷移し，
	 * 例外を捕捉した場合は，例外メッセージをリクエスト属性にセットして
	 * 予約エラー画面に遷移する
	 * @author 飯田一心
	 */

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		
			//セッションがない場合ログインしなおし
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}

			MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
			ReservationBean reservation = (ReservationBean) session.getAttribute("reserve");
		
		try {
			meetingRoom.cancel(reservation);
			//成功で完了画面へ遷移
			response.sendRedirect(request.getContextPath() +
					"/jsp/cancel/canceled.jsp");
			//以下失敗
		} catch (AppException.TimePassedException e) {
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		} catch (AppException.UnauthorizedCancelException e) {
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		} catch (AppException.CancelFailedException e) {
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		}catch (NullPointerException e) {
			request.setAttribute("errorReason","バックキーを使わず、戻るボタンを使用してください" );
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;
			
		}catch (Exception e) {
			request.setAttribute("errorReason", "キャンセル処理に失敗しました。");
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		}

	}

}
