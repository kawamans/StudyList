package LessonList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Lesson04 {

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
		System.out.print("最大金額を入力してください：");
		String maxNum = scan.nextLine();
		System.out.print("最低金額を入力してください：");
		String minNum = scan.nextLine();
		
		String sql = "SELECT * FROM books WHERE price >= ? AND price <= ? ORDER BY price asc";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, maxNum);
			pstmt.setString(2, minNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(
				rs.getString("title") + "\t"
				+ rs.getString("publish") + "\t"
				+ rs.getString("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}

}
