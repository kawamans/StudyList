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
		HttpServletResponse httpRessonse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		String path = httpRequest.getServletPath();
		
		// ログイン状態の判定
		boolean isLogin = (session != null && session.getAttribute("loginUser") != null);
		
		// 公開ページの判定(startsWith を使用してフォルダ配下を許可）
		boolean isPublicPage = (path.equals("/jsp/login.jsp") || path.equalsIgnoreCase("/Login") || path.startsWith("/css/") || path.startsWith("/img/"));
		
		// 各URL直打ち禁止ページの判定
		boolean isReservePage = (path.equals("/jsp/reservation/reserveConfirm.jsp") || path.equals("/jsp/reservation/reserveError.jsp") || path.equals("/jsp/reservation/reserved.jsp"));
		boolean isRoomPage = (path.equals("/jsp/meetingRoom/meetingRoomConfirm.jsp") || path.equals("/jsp/meetingRoom/meetingRoomError.jsp") || path.equals("/jsp/meetingRoom/meetingRoomCompletion.jsp"));
		boolean isUserPage = (path.equals("/jsp/userSituation/userConfirm.jsp") || path.equals("/jsp/userSituation/userError.jsp") || path.equals("/jsp/userSituation/userCompletion.jsp"));
		boolean isCancelPage = (path.equals("/jsp/cancel/cancelConfirm.jsp") || path.equals("/jsp/cancel/cancelError.jsp") || path.equals("/jsp/cancel/canceled.jsp"));
		
		// ログインの場合
		if (isLogin) {
			
			// ログイン済みでログイン画面へのアクセスはメニュー
			if(path.equals("/jsp/login.jsp")) {
				httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
				return;
			}
			
			// ===直打ちブロック===
			// 予約系
			if(isReservePage && session.getAttribute("reserve") == null) {
					httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
					return;
			}

			// 会議室系
			if(isRoomPage && session.getAttribute("room") == null) {
					httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
					return;
			}

			// 利用者系
			if(isUserPage && session.getAttribute("user") == null) {
					httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
					return;
			}

			// キャンセル系
			if(isCancelPage && session.getAttribute("reserve") == null) {
					httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/menu.jsp");
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
				httpRessonse.sendRedirect(httpRequest.getContextPath() + "/jsp/login.jsp");
				return;
			
			}
		}
	}

	/** @see Filter#destroy() */
	public void destroy() {}
	
	/** @see Filter#init(FilterConfig) */
	public void init(FilterConfig fConfig) throws ServletException {}

}
