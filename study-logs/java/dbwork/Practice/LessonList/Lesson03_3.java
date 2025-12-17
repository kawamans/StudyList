package LessonList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lesson03_3 {
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
		int select = 0;
		String selectSql = ""; 
		
		try (InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);) {
			
			while (select != 9) {
				System.out.print("1)author 2)category 3)books 9)終了：");
				select = Integer.parseInt(br.readLine());
				
				if (1 <= select && select <= 3) {
					break;
				}
			}
			
			switch (select) {
				case 1:
					selectSql = "author";
					break;
				case 2:
					selectSql = "category";
					break;
				case 3:
					selectSql = "books";
					break;
				default:
					System.out.println("処理を終了します");
					return;
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.println("入力文字エラー");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("入力時エラー");
			return;
		}
		
		String beseSql = "SELECT * FROM ";
		String finalSql = beseSql + selectSql;
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(finalSql);
			ResultSet rs = pstmt.executeQuery()) {
			
			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			
			StringBuilder header = new StringBuilder();
			for (int i = 1; i <= count; i++) {
				header.append(metaData.getColumnName(i)).append("\t");
			}
			System.out.println("---" + selectSql.toUpperCase() + " データ ---");
			System.out.println(header.toString().trim());
			
			while (rs.next()) {
				StringBuilder row = new StringBuilder();
				for (int i = 1; i <= count; i++) {
					row.append(rs.getString(i)).append("\t");
				}
				System.out.println(row.toString().trim());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		
	}
	
}
