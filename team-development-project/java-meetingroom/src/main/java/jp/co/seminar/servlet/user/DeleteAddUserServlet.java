package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException.DeleteRoomFailedException;
import jp.co.seminar.bean.AppException.LogicalDeleteAdminException;
import jp.co.seminar.bean.AppException.LogicalDeleteUserFailedException;
import jp.co.seminar.bean.AppException.NonExistentUserException;
import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.UserBean;

/**
 * ユーザー情報を削除処理する
 * @author 川満
 */
@WebServlet("/DeleteAddUser")
public class DeleteAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		String next = "userError.jsp";
		
		ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
		UserBean user = (UserBean)session.getAttribute("user");
		LoginUserBean loginUser = (LoginUserBean)session.getAttribute("loginUser");
		
		boolean isInputData = false;
		
		// 入力情報とsession情報の整合性を確認
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
		
		// 入力情報に整合性が取れていれば実行
		if (isInputData) {
			try {
				// 削除対象がログイン本人で無ければ実行
				if(loginUser != null && user != null && !loginUser.getId().equals(user.getId())) {
					
					ex.logicalDeleteUser(user);
					session.setAttribute("user", ex.getUser());
					next = "userCompletion.jsp";
					
				} else {
					
					request.setAttribute("error", "利用者本人は削除できません。");
				}
				
			} catch(NonExistentUserException e) {
				request.setAttribute("error", "この利用者は存在しません。");
				System.out.println(e);
			} catch (LogicalDeleteAdminException e) {
				request.setAttribute("error", "最後の管理者は削除できません。");
				System.out.println(e);
			} catch (LogicalDeleteUserFailedException e) {
				request.setAttribute("error", "削除に失敗しました。");
				System.out.println(e);
			} catch (DeleteRoomFailedException e) {
				request.setAttribute("error", "会議室予約の削除ができませんでした。");
				System.out.println(e);
			} catch (Exception e) {
				request.setAttribute("error", "不明なエラーです。");
				System.out.println(e);
			}
		} else {
			request.setAttribute("error", "正規の処理ではありません。");
		}
		
		session.setAttribute("page", "delete");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}
}
