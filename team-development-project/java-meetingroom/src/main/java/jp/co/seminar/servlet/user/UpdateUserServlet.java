package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ユーザー変更情報を生成する
 * @author 川満 達也
 */

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
