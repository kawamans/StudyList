package LessonList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lesson02 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("ドライバが見つかりません");
			return;
		}
		
		String url = "jdbc:mysql://localhost:3306/book";
		String username = "root";
		String password = "pass";
		String keyWord = null;
		
		
		try (InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);) {
			System.out.print("author_idを入力してください：");
			keyWord = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("入力時エラー");
		}
		
		String searchKey = keyWord == null ? "%" : "%" + keyWord + "%";
		String beseSql = "SELECT * FROM author";
		String finalSql = beseSql +  " WHERE author_id LIKE '" + searchKey + "'";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(finalSql);
			ResultSet rs = pstmt.executeQuery()) {
			
			Boolean found = false;
			
			while (rs.next()) {
				System.out.println(
				rs.getString("author_id") + "\t"
				+ rs.getString("name") + "\t"
				+ rs.getString("name_kana"));
				found = true;
			}
			
			if (!found) {
				System.out.println("未登録です");;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}

}
