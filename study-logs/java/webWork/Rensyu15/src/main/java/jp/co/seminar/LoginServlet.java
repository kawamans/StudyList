package jp.co.seminar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = "root";
		String PW = "P@ssw0rd";
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String check = request.getParameter("check");
		
		String nextPage = request.getContextPath();
		
		if (userId.equals(ID) && userPw.equals(PW)) {
			Cookie cook = new Cookie("userId", userId);
			cook.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cook);
			cook = new Cookie("userPw", userPw);
			cook.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cook);
			nextPage = nextPage + "/output.jsp";
			
			if (check != null) {
				cook = new Cookie("check", check);
				cook.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(cook);
			} else {
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if ("check".equals(cookie.getName())) {
			            cookie.setMaxAge(0); 
			            response.addCookie(cookie);
			        }
			    }
			}
				
		} else {
			nextPage = nextPage + "/input.jsp";
			Cookie[] cookies = request.getCookies();
		    for (Cookie cookie : cookies) {
		        if ("userId".equals(cookie.getName())) {
		            cookie.setMaxAge(0); 
		            response.addCookie(cookie);
		        }
		        if ("userPw".equals(cookie.getName())) {
		            cookie.setMaxAge(0); 
		            response.addCookie(cookie);
		        }
		    }
		}
		
		
        response.sendRedirect(nextPage);
	}

}
