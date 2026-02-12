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

@WebFilter("/index.jsp")
public class LoginFilter extends HttpFilter implements Filter {
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
        System.out.println("ログインチェックが行われました。");
        // セッションが存在しない場合NULLを返す
        HttpSession session = ((HttpServletRequest)request).getSession();
        if(session.getAttribute("userId") != null) {
            // セッションがNULLでなければフィルタの先へ進む
            chain.doFilter(request, response);
        } else {
            // セッションがNullならばログインページにリダイレクト
            String nextPage = ((HttpServletRequest)request).getContextPath() + "/login.jsp";
            ((HttpServletResponse)response).sendRedirect(nextPage);
            return;
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {}
	
    @Override
    public void destroy() {}
    
}