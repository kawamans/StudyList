import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlDateConverterTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		String url = "jdbc:mysql://localhost:3306/book";
		String username = "root"; 
		String password = "pass"; 
		
		String sql = "INSERT INTO books "
				+ "(isbn, title, price, publish, publish_date, category_id) VALUES "
				+ "('978-4877832402', 'みんなのJava', 2680, '技術評論社', ?, 'PJ001')";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			String stringDate = "2022-12-25";
			Date sqlDate = Date.valueOf(stringDate);
			pstmt.setDate(1, sqlDate);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "件、挿入しました。");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}