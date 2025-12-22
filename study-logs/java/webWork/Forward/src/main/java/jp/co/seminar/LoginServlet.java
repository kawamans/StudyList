package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //正しいログイン情報を定数としておく
    private static final String UID = "admin";
    private static final String PWD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //データ受信
        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        //遷移先ページ格納変数
        String nextPage;
        //判定
        if(uid.equals(UID) && pwd.equals(PWD)) {
            //ログイン成功時
            nextPage = "/ok.jsp";
        } else {
            //ログイン失敗
            nextPage = "/ng.jsp";
        }
        //nextPageに遷移するためのディスパッチャを作成する。
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        //フォワードする
        rd.forward(request, response);
    }
}