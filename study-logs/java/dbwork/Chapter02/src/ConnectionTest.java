import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("ドライバが見つかりません。");
			return;
		}
		
		String url = "jdbc:mysql://localhost:3306/book";
		String username = "root";
		String password = "pass";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("データベースの状態：" + conn.isClosed());
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
	}

}
