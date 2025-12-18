package LessonList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Lesson05 {

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
		System.out.print("キーワードを入力してください：");
		String keyWord = scan.nextLine();
		
		String searchWord = keyWord == null ? "%" : "%" + keyWord + "%";
		String sql = "SELECT * FROM books WHERE title LIKE ?";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, searchWord);
			
			ResultSet rs = pstmt.executeQuery();
			
			boolean found = false;
			
			while (rs.next()) {
				System.out.println(
				rs.getString("title") + "\t"
				+ rs.getString("publish") + "\t"
				+ rs.getString("price"));
				found = true;
			}
			
			if (!found) {
				System.out.println("書籍が見つかりません。");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}

}
