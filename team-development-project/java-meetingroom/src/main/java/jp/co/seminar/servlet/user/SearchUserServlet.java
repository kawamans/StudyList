package jp.co.seminar.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.UserBean;

/**
 * ユーザー情報を検索する
 * @author 川満
 */
@WebServlet("/SearchUser")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		String flg = request.getParameter("flg");
		String userId = request.getParameter("userId");
		String next = "userError.jsp";
		UserBean user = null;
		List<UserBean> searchUser = new ArrayList<>();
		
		try {
			
			ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
			List<UserBean> userList = ex.getUserList();
			
			if (userId != null && !userId.isEmpty()) {
				
				if("search".equals(flg)) {
					
					for (UserBean users : userList) {
						if(users.getId().equals(userId)) {
							searchUser.add(users);
						}
					}
					
					if (searchUser.size() > 0) {
						request.setAttribute("searchUser", searchUser);
						request.setAttribute("userId", userId);
						request.setAttribute("result", "該当の利用者を表示します。");
						
					} else {
						request.setAttribute("userId", userId);
						request.setAttribute("result", "利用者が見つかりません。");
					}
					
					next = "userSearch.jsp";
					
				} else {
					
					for (UserBean users : userList) {
						if(users.getId().equals(userId)) {
							user = users;
						}
					}
					
					session.setAttribute("searchUser", user);
					
					if("delete".equals(flg)) {
						next = "userDelete.jsp";
					} else {
						next = "userUpdate.jsp";
					}
				} 
				
				request.setAttribute("flg", flg);
				
			} else {
				next = "userSearch.jsp";
				session.removeAttribute("searchUser");
			}
			
		} catch (NullPointerException e) {
			request.setAttribute("error", "不正な操作です。");
			System.out.println(e);
		} catch (Exception e) {
			request.setAttribute("error", "不明なエラーです。");
			System.out.println(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}

}
