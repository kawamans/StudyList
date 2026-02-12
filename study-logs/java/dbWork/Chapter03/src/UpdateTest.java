import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

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
		int ret = -1;
		String sql = "UPDATE author SET "
				+ "name = '北見竜二', "
				+ "name_kana = 'キタミリュウジ' WHERE author_id = 'K0002'";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ret = pstmt.executeUpdate();
			System.out.println(ret + "件、更新しました。");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}

}
