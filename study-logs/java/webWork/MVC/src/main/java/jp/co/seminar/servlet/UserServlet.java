package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.seminar.beans.User;
import jp.co.seminar.logic.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        // 受信データを取得
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        // Userを生成
        User user = new User(name, age, email, location);
        // 自己紹介文作成メソッドを実行
        UserService userService = new UserService();
        String greetingMessage = userService.generateGreeting(user);
        // 作成した自己紹介文をリクエスト属性に設定
        request.setAttribute("greetingMessage", greetingMessage);
        // 出力画面にフォワード
        String nextPage = "/output.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}