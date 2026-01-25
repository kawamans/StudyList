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
import javax.servlet.http.HttpSession;

/**
 * Session管理用フィルター
 * @author 川満
 */
@WebFilter("/jsp/menu.jsp")
public class SessionFilter extends HttpFilter implements Filter {

	/** @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		// sessionの有無を判定
		if(session != null) {
			//ログイン以外の全てのsessionを削除
			session.removeAttribute("reserve");
			session.removeAttribute("room");
			session.removeAttribute("user");
			session.removeAttribute("page");
			session.removeAttribute("searchUser");
		}
		
		chain.doFilter(request, response);
	}

	/** @see Filter#init(FilterConfig) */
	public void init(FilterConfig fConfig) throws ServletException {}
	
	/** @see Filter#destroy() */
	public void destroy() {}

}
