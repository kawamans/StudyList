import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

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
		
		String[][] products = {
			{"DE00000003", "電子書籍2", "2500"},
			{"IS00000003", "長椅子2", "1500"},
			{"MA00000003", "滑らかマウス2", "1200"}
		};
		
		String sql = "INSERT INTO product VALUES(?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			try {
				conn.setAutoCommit(false);
				int sum = 0;
				
				for (String[] product : products) {
					pstmt.setString(1, product[0]);
					pstmt.setString(2, product[1]);
					pstmt.setInt(3, Integer.parseInt(product[2]));
					
					sum += pstmt.executeUpdate();
				}
				
				conn.commit();
				System.out.println(sum + "件、登録しました。");
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("登録に失敗しました。");
				conn.rollback();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			
		}
		
	}

}
