import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UtilDateConverterTest {
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
		String sql = "SELECT * FROM books ORDER BY publish_date asc";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date unConvertDate = rs.getDate("publish_date");
				java.util.Date convertDate = new java.util.Date(unConvertDate.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
				String dateStr = sdf.format(convertDate);
				System.out.println(dateStr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}

	}
}
