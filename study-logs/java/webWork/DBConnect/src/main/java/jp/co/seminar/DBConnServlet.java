package jp.co.seminar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBConnServlet")
public class DBConnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(
    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        // JDBCドライバのロード
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ドライバのロードに失敗しました。");
            return;
        }
        // データベース接続
        String url = "jdbc:mysql://localhost:3306/sample_java_web";
        String username = "root"; // ユーザー名
        String password = "pass"; // パスワード
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            message = "データベースの状態:" + conn.isClosed();
        } catch (SQLException e) {
            message = "エラーが発生しました。";
        }
        // try-with-resourcesによりconnは自動的にクローズされる
        request.setAttribute("mes", message);
        //結果表示ページに遷移
        String nextPage = "/output.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
