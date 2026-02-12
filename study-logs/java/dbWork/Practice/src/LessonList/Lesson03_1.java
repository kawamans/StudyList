package LessonList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lesson03_1 {
	
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
		String select = "";
		String selectSql = ""; 
		
		try (InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);) {
			
			System.out.print("1)author 2)category 3)books 9)終了：");
			select = br.readLine();
			
			if (select.equals("1")) {
				selectSql = "author";
			} else if (select.equals("2")) {
				selectSql = "category";
			} else if (select.equals("3")) {
				selectSql = "books";
			} else {
				System.out.println("処理を終了します");
				return;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("入力時エラー");
		}
		
		String beseSql = "SELECT * FROM ";
		String finalSql = beseSql + selectSql;
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(finalSql);
			ResultSet rs = pstmt.executeQuery()) {
			
			if (selectSql.equals("author")) {
				while (rs.next()) {
					System.out.println(
					rs.getString("author_id") + "\t"
					+ rs.getString("name") + "\t"
					+ rs.getString("name_kana"));
				}
				
			} else if (selectSql.equals("category")) {
				while (rs.next()) {
					System.out.println(
					rs.getString("category_id") + "\t"
					+ rs.getString("category_name"));
				}
			} else if (selectSql.equals("books")) {
				while (rs.next()) {
					System.out.println(
					rs.getString("isbn") + "\t"
					+ rs.getString("title") + "\t"
					+ rs.getString("price") + "\t"
					+ rs.getString("publish") + "\t"
					+ rs.getString("publish_date") + "\t"
					+ rs.getString("category_id"));
				}
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}

}
