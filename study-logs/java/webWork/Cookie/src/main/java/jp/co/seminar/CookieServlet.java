package jp.co.seminar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //パラメータを取得する
        String mail = request.getParameter("mail");
        //クッキーを生成
        Cookie cook = new Cookie("mail", mail);
        //有効期限をセット30日
        cook.setMaxAge(60 * 60 * 24 * 30);
        //クッキーをセット
        response.addCookie(cook);
        //違うページにリダイレクト
        String nextPage = request.getContextPath() + "/output.jsp";
        response.sendRedirect(nextPage);
    }
}
