package jp.co.seminar.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.LoginUserBean;

/** 
 * @author 川満
 */
@WebFilter("/*")
public class LoginUrlFilter extends HttpFilter implements Filter {

	/** @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//未ログイン時、ログイン画面へリダイレクト
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		String path = httpRequest.getServletPath();
		String method = httpRequest.getMethod();
		
		LoginUserBean loginUser = null;
		boolean isLogin = false;
		
		// ログイン情報を取得し、ログインの有無を確認
		if(session != null) {
			loginUser = (LoginUserBean)session.getAttribute("loginUser");
			isLogin = (loginUser != null);
		}
		
		boolean isLoginNotAdmin = false;
		// 管理権限の無い人物かを確認
		if(loginUser != null) {
			isLoginNotAdmin = (session != null && "0".equals(loginUser.getAdminflg()));
		}
		
		// 公開ページの判定(startsWith を使用してフォルダ配下を許可）
		boolean isPublicPage = (path.equals("/jsp/login.jsp") || path.equalsIgnoreCase("/Login") || path.startsWith("/css/") || path.startsWith("/img/"));
		
		// 各URL直打ち禁止ページの判定
		// 予約画面系
		boolean isReservePage = (path.equals("/jsp/reservation/reserveConfirm.jsp") || path.equals("/jsp/reservation/reserveError.jsp") || path.equals("/jsp/reservation/reserved.jsp"));
		// 会議室画面
		boolean isRoomPage = (path.equals("/jsp/meetingRoom/meetingRoomConfirm.jsp") || path.equals("/jsp/meetingRoom/meetingRoomError.jsp") || path.equals("/jsp/meetingRoom/meetingRoomCompletion.jsp"));
		// 利用者画面
		boolean isUserPage = (path.equals("/jsp/userSituation/userConfirm.jsp") || path.equals("/jsp/userSituation/userError.jsp") || path.equals("/jsp/userSituation/userCompletion.jsp"));
		// 予約キャンセル画面
		boolean isCancelPage = (path.equals("/jsp/cancel/cancelConfirm.jsp") || path.equals("/jsp/cancel/cancelError.jsp") || path.equals("/jsp/cancel/canceled.jsp"));
		
		// 管理者画面
		boolean isAdminPage = (path.equals("/jsp/userSituation/userSearch.jsp") || path.equals("/jsp/userSituation/userDelete.jsp") || path.equals("/jsp/userSituation/userCreate.jsp")
				|| path.equals("/jsp/meetingRoom/meetingRoomInput.jsp") || path.equals("/jsp/meetingRoom/meetingRoomDelete.jsp"));
		
		// Servlet
		boolean isServletPage = (
				// mainServlet
				path.equals("/ChangeDate") || path.equals("/Login") || path.equals("/Logout") ||
				// meetingRoomServlet
				path.equals("/CreateAddMeetingRoom") || path.equals("/CreateMeetingRoom") || path.equals("/DeleteAddMeetingRoom") || path.equals("/DeleteMeetingRoom") ||
				// reservationServlet
				path.equals("/CancelCreate") || path.equals("/Cancel") || path.equals("/Reserve") || path.equals("/ReserveCreate") || 
				// userServlet
				path.equals("/CreateAddUser") || path.equals("/CreateUser") || path.equals("/DeleteAddUser") || path.equals("/DeleteUser") || path.equals("/SearchUser") || path.equals("/UpdateAddUser") || path.equals("/UpdateUser"));
		
		// ログインの場合
		if (isLogin) {
			
			// ログイン済みでServletページにURL直打ちでのアクセスをブロック
			if("GET".equalsIgnoreCase(method) && isServletPage) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			// ログイン済みでログイン画面へのアクセスはメニュー
			if(path.equals("/jsp/login.jsp")) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			// ===直打ちブロック===
			// 予約系
			if(isReservePage && session.getAttribute("reserve") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}

			// 会議室系
			if(isRoomPage && session.getAttribute("room") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}

			// 利用者系
			if(isUserPage && session.getAttribute("user") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			// 削除対象の情報を持たない削除ページへの遷移をブロック
			if(path.equals("/jsp/userSituation/userDelete.jsp") && session.getAttribute("searchUser") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}

			// キャンセル系
			if(isCancelPage && session.getAttribute("reserve") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			// 管理者系
			if(isLoginNotAdmin && isAdminPage) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			chain.doFilter(request, response);

		// 未ログインの場合
		} else {
			
			// ログイン処理、ログイン処理、CSSは許可
			if(isPublicPage) {
			
				chain.doFilter(request, response);
				return;
				
			} else {
				
				// それ以外はログイン画面へリダイレクト
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/login.jsp");
				return;
			
			}
		}
	}

	/** @see Filter#destroy() */
	public void destroy() {}
	
	/** @see Filter#init(FilterConfig) */
	public void init(FilterConfig fConfig) throws ServletException {}

}
