package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションの取得
    	HttpSession session = request.getSession();
        // セッションが初出かどうか確認
        if (session.isNew()) {
        	System.out.println("セッションを初めて用意します。");
        	// セッションのタイムアウト時間を設定
            session.setMaxInactiveInterval(60);
        }
        // 次の画面へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}