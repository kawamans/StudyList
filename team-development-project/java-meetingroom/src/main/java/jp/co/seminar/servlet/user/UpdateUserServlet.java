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
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		
		String next = "error.jsp";
			
		try{
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String adminflg = (request.getParameter("adminflg") != null) ? "1" : "0";
			
			LoginUserBean loginUser = (LoginUserBean)session.getAttribute("loginUser");
			UserBean searchUser = (UserBean)session.getAttribute("searchUser");
			UserBean originUser = null;
			
			// 検索ユーザーかログインユーザーを判別
			if(searchUser != null) {
				// 検索ユーザーであればオリジン変数に代入
				originUser = searchUser;
			} else {
				// ログインユーザーであればLoginUserBeanをUserBeanに変換してオリジン変数に代入
				originUser = new UserBean(
						loginUser.getId(), loginUser.getPassword(),loginUser.getName(),
						loginUser.getAddress(), loginUser.getAdminflg(), "select");
			}
			
			ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
			
			// submitした内容を代入
			UserBean inputUser = ex.instanceUser(id, password, name, address, adminflg, "select");
			next = "userConfirm.jsp";
			
			// 氏名の変更
			boolean isNameChanged = !originUser.getName().equals(inputUser.getName());
			// 住所の変更
			boolean isAddressChanged = !originUser.getAddress().equals(inputUser.getAddress());
			// パスワードの変更
			boolean isPassChanged = !originUser.getPassword().equals(inputUser.getPassword());
			// 管理者権限の変更
			boolean isAdminChanged = !originUser.getAdminflg().equals(inputUser.getAdminflg());
			
			// 全ての変更
			boolean isNoChange = !(isNameChanged || isAddressChanged || isPassChanged || isAdminChanged);
			
			
			// 変更内容が無い場合
			if(isNoChange) {
				
				next = "userUpdate.jsp";
				request.setAttribute("error", "変更がありません。");
			
			// 変更対象が管理権限、管理権限を無くす変更、最後の管理者の場合の場合
			} else if(originUser.getAdminflg().equals("1") && isAdminChanged 
					&& inputUser.getAdminflg().equals("0") && UserDao.lastAdmin()) {
			
				next = "userUpdate.jsp";
				request.setAttribute("error", "最後の管理者は管理権限の変更ができません。");
			
			// 変更対象がログイン者本人で管理権限を無くす変更の場合
			} else if(originUser.getAdminflg().equals("1") && isAdminChanged 
					&& inputUser.getAdminflg().equals("0")
					&& inputUser.getId().equals(loginUser.getId())) {
				
				next = "userUpdate.jsp";
				request.setAttribute("error", "管理者は自身の管理権限の変更はできません。");
				
			// パスワードの変更があり、パスワードが既に使用されている場合
			} else if(isPassChanged && !UserDao.checkPass(inputUser)) {
			
				next = "userUpdate.jsp";
				request.setAttribute("error", "このパスワードは使用されています。");
			
			// 変更内容に問題がない場合
			} else {
			
				next = "userConfirm.jsp";
			
			}
			
			// 入力内容をsessionへ
			session.setAttribute("user", inputUser);
			
		}  catch (NullPointerException e) {
			next = "userError.jsp";
			request.setAttribute("error", "不正な操作です。");
			System.out.println(e);
		} catch (Exception e) {
			next = "userError.jsp";
			request.setAttribute("error", "不明なエラーです。");
			System.out.println(e);
		}
		
		session.setAttribute("page", "update");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}
}
