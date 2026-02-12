package jp.co.seminar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBParameterServlet")
public class DBParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Viewへ送るデータを格納する変数を宣言
        String message = null;
        List<String> elist = null;
        
        // データ受取
        request.setCharacterEncoding("UTF-8");
        String english = request.getParameter("english");
        
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
        String sql = "SELECT * FROM dictionary WHERE engword = ?";
        
        // try-with-resources構文でリソースを自動的にクローズ
        try (Connection conn = DriverManager.getConnection(url, username, password);
        		PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            // パラメータを設定
            pstmt.setString(1, english);
            
            // SQL文を実行して結果を取得
            try (ResultSet rs = pstmt.executeQuery()) {
            	
                // 結果セットをViewへ送るための準備
                elist = new ArrayList<String>();
                
                while(rs.next()){
                    elist.add(rs.getString("jpword"));
                }
                
            message="成功しました。";
            }
            
            // try-with-resourcesによりrsは自動的にクローズされる
        } catch (SQLException e) {
            message = "エラーが発生しました。";
        }
        
        // try-with-resourcesによりconn, pstmtは自動的にクローズされる
        // リクエスト属性へ設定
        request.setAttribute("elist", elist);
        request.setAttribute("mes", message);
        
        //結果表示ページに遷移
        String nextPage = "/output.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}