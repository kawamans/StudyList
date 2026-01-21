package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.UserBean;
import jp.co.seminar.dao.UserDao;

/**
 * ユーザー変更情報を生成する
 * @author 川満 達也
 */

@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath()+"jsp/login.jsp");
			return;
		}
		
		
		String flg = request.getParameter("flg");
		String userId = request.getParameter("userId");
		ExtraMR ex = new ExtraMR();
		String next = "";
		
		if (flg.equals("search") && userId != null) {
			
			next = "userUpdate.jsp";
			
			UserBean user = ex.searchUser(userId);
			
			if (user != null) {
				request.setAttribute("flg", flg);
				session.setAttribute("user", user);
				
			} else {
				request.setAttribute("result", "利用者が見つかりません。");
			}
			
			
		} else {
		
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String adminflg = "0";
			if (request.getParameter("adminflg") != null) {
				adminflg = request.getParameter("adminflg");
			}
			next = "userConfirm.jsp";
			
			LoginUserBean loginUser = (LoginUserBean)session.getAttribute("loginUser");
			UserBean user = ex.instanceUser(id, password, name, address, adminflg, "select");
			
			if(loginUser.getId().equals(user.getId())) {
	
				if(loginUser.getPassword().equals(user.getPassword())) {
					
				} else {
					
					if(!UserDao.checkPass(user)) {
						next = "userError.jsp";
						request.setAttribute("error", "このパスワードは使用されています。");
					}
				}
				
			} else {
				
				if(!UserDao.checkPass(user)) {
					next = "userError.jsp";
					request.setAttribute("error", "このパスワードは使用されています。");
				}
			}
			
			session.setAttribute("user", user);
			session.setAttribute("page", "update");
			
			System.out.println(user.toString());
			System.out.println(loginUser.toString());
			
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}
}
