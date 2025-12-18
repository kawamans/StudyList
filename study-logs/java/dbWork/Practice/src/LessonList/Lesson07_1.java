package LessonList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Lesson07_1 {

	public static void main(String[] args) {
		int fromUserId = 0;
		int toUserId = 0;
		double amount = 0.0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("送金者のuser_idを入力してください：");
		fromUserId = scan.nextInt();
		System.out.print("送金先のuser_idを入力してください：");
		toUserId = scan.nextInt();
		System.out.print("金額を入力してください：");
		amount = scan.nextInt();
		
		transserFunds(fromUserId, toUserId, amount);
	
	}
	
	public static void transserFunds(int fromUserId, int toUserId, double amount) {
		
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
		
		String stSql = "SELECT * FROM user WHERE id = ?";
		String upSql = "UPDATE user SET balance = ? WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			double fromBalance = 0.0;
			double toBalance = 0.0;
			
			try (PreparedStatement pstmt = conn.prepareStatement(stSql)) {
				pstmt.setInt(1, toUserId);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					toBalance = rs.getInt("balance");
				}
				
				pstmt.setInt(1, fromUserId);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					fromBalance = rs.getInt("balance");
				}
				
				if (fromBalance < amount) {
					System.out.println("残高不足または、ユーザーが存在していません。");
					return;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("閲覧に失敗しました。");
				return;
			}
		
			
			try (PreparedStatement pstmt = conn.prepareStatement(upSql)) {
				conn.setAutoCommit(false);
				
				double newFromBalance = fromBalance - amount;
				pstmt.setDouble(1, newFromBalance);
				pstmt.setInt(2, fromUserId);
				pstmt.executeUpdate();
				
				double newToBalance = toBalance + amount;
				pstmt.setDouble(1, newToBalance);
				pstmt.setInt(2, toUserId);
				pstmt.executeUpdate();
				
				conn.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("送金に失敗しました。");
				conn.rollback();
				return;
			}
			
			System.out.println("入金完了しました");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			return;
		}
	}

}
