package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストで受信した文字をUTF-8文字コードで受信する
    	request.setCharacterEncoding("utf-8");
    	// セッションの取得
        HttpSession session = request.getSession();
        // パラメータの取得
        String name = request.getParameter("name");
        // セッション属性の設定
        session.setAttribute("name", name);
        // 次の画面へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("first.jsp");
        rd.forward(request, response);
    }
}
