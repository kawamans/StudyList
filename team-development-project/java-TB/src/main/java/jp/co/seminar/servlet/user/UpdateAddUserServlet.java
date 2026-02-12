package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException.NonExistentUserException;
import jp.co.seminar.bean.AppException.UpdateUserFailedException;
import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.UserBean;

/**
 * ユーザー情報を変更処理する
 * @author 川満 達也
 */

@WebServlet("/UpdateAddUser")
public class UpdateAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		String next = "userError.jsp";
		
		ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
		UserBean user = (UserBean)session.getAttribute("user");
		LoginUserBean loginUser = (LoginUserBean)session.getAttribute("loginUser");
		
		// 変更内容がログイン者本人かを確認
		boolean isChangeLoginUser = (loginUser.getId().equals(user.getId()));
		
		boolean isInputData = false;
		
		// 入力内容とsessionの内容と一致しているか確認
		try {
			isInputData = (user.getId().equals(request.getParameter("id"))
					&& user.getName().equals(request.getParameter("name")) 
					&& user.getAddress().equals(request.getParameter("address")) 
					&& user.getPassword().equals(request.getParameter("password"))
					&& user.getAdminflg().equals(request.getParameter("adminflg")));
		
		} catch(NullPointerException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// 入力内容の整合性が取れていれば実行
		if (isInputData) {
			try {
				ex.updateUser(user);
				user = ex.getUser();
				next = "userCompletion.jsp";
				
				// ログイン本人の内容の変更の場合はログイン情報の更新を実行
				if(isChangeLoginUser) {
					
					loginUser = new LoginUserBean(user.getId(), user.getPassword(),
							user.getName(), user.getAddress(), user.getAdminflg());
					session.setAttribute("loginUser", loginUser);
				}
				
				
				
			} catch(NonExistentUserException e) {
				request.setAttribute("error", "この利用者は存在しません。");
				System.out.println(e);
			} catch(UpdateUserFailedException e) {
				request.setAttribute("error", "変更に失敗しました。");
				System.out.println(e);
			} catch(Exception e) {
				request.setAttribute("error", "処理に失敗しました。");
				System.out.println(e);
			}
		} else {
			request.setAttribute("error", "正規の処理ではありません。");
		}
		
		session.setAttribute("user", user);
		session.setAttribute("page", "update");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}

}
