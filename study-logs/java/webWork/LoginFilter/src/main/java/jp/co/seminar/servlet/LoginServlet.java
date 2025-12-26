package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //セッションを取得する
        HttpSession session = request.getSession();
        //セッションタイムアウトを設定する
        session.setMaxInactiveInterval(60 * 10);
        //ログイン情報を取得する
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        //遷移先のパスを管理する変数を宣言
        String nextPage;
        //ログイン判定 admin passと一致するかどうか
        if(userId.equals("admin") && password.equals("password")) {
            //ログイン者情報をセッションに格納する
            session.setAttribute("userId", userId);
            //トップページのパスを作成
            nextPage = request.getContextPath() + "/index.jsp";
        } else {
            //ログインページのパスを作成
            nextPage = request.getContextPath() + "/login.jsp";
        }
        //リダイレクト
        response.sendRedirect(nextPage);
        return;
    }
}
