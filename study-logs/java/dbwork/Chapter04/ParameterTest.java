import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ParameterTest {

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
		
		Scanner scan = new Scanner(System.in);
		System.out.print("author_idを入力してください：");
		String inputAuthord = scan.nextLine();
		String sql = "SELECT * FROM author WHERE author_id = ?";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, inputAuthord);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(
						rs.getString("author_id") + "\t" +
						rs.getString("name") + "\t" +
						rs.getString("name_kana"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		

	}

}
