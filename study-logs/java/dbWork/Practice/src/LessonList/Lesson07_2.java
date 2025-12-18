package LessonList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Lesson07_2 {
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
		
		try { //ドライバー接続
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
		
		// SQL接続
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			conn.setAutoCommit(false);
			double fromBalance = 0.0;
			double toBalance = 0.0;
			
			
			// 閲覧処理
			try (PreparedStatement pstmt = conn.prepareStatement(stSql)) {
				
				// 送金先確認
				pstmt.setInt(1, toUserId);
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next()) {
					toBalance = rs.getInt("balance");
				} else {
					System.out.println("送金先IDが見つかりません。");
					conn.rollback();
					return;
				}
				
				// 送金元確認
				pstmt.setInt(1, fromUserId);
				rs = pstmt.executeQuery();
					
				if (rs.next()) {
					fromBalance = rs.getInt("balance");
					
					if (fromBalance < amount) {
						System.out.println("残高不足です。");
						conn.rollback();
						return;
					}
					
				} else {
					System.out.println("送金元IDが見つかりません。");
					conn.rollback();
					return;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("閲覧に失敗しました。");
				conn.rollback();
				return;
			}
		
			// 更新処理
			try (PreparedStatement pstmt = conn.prepareStatement(upSql)) {
				
				// 送金元更新 出金
				double newFromBalance = fromBalance - amount;
				pstmt.setDouble(1, newFromBalance);
				pstmt.setInt(2, fromUserId);
				pstmt.executeUpdate();
				
				// 送金先更新 入金
				double newToBalance = toBalance + amount;
				pstmt.setDouble(1, newToBalance);
				pstmt.setInt(2, toUserId);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("送金に失敗しました。");
				conn.rollback();
				return;
			}
			
			conn.commit();
			System.out.println("入金完了しました");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			return;
			
		}
	}
}
