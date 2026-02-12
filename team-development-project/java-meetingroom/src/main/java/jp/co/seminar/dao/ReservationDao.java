package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.seminar.bean.ReservationBean;
import jp.co.seminar.util.DatabaseConnection;

/** @author 川満 */
public class ReservationDao {

	// コンストラクタ ==================================== 
	/** Dao仕様 */
	private ReservationDao() {}
	
	// メソッド ====================================
	/**
	 * 利用日の予約情報取得
	 * @param date 利用日
	 * @return List型の予約情報、予約が無ければnull
	 */
	public static List<ReservationBean> findByDate(String date) {
		String sql = "SELECT * FROM reservation WHERE date = ?";
		List<ReservationBean> rvList = new ArrayList<>();
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, date);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ReservationBean rvBean = new ReservationBean(
							rs.getInt("id"), rs.getString("roomId"), rs.getString("date"),
							rs.getString("start"), rs.getString("end"), rs.getString("userId"));
					rvList.add(rvBean);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		if(rvList.isEmpty()) {
			return null;
		}
		
		return rvList;
	}
	
	/**
	 * 規予約情報確認 ※追加
	 * @param reservation
	 * @return 新規の予約であればtrue
	 */
	public static boolean checkReservation(ReservationBean reservation) {
		String selectSql = "SELECT * FROM reservation WHERE "
				+ "roomId = ? AND date = ? AND start = ? AND end = ?";
		boolean check = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, reservation.getRoomId());
			pstmt.setString(2, reservation.getDate());
			pstmt.setString(3, reservation.getStart());
			pstmt.setString(4, reservation.getEnd());
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(!rs.next()) {
					check = true;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		return check;
	}
	
	
	/**
	 * 利用者の会議室の予約の有無を判定する ※追加
	 * @param userId
	 * @return 予約がある場合 true
	 */
	public static boolean checkReserveUser(String userId) {
		String selectSql = "SELECT * FROM reservation WHERE userid = ?";
		boolean isCheck = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, userId);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					isCheck = true;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		return isCheck;
	}
	
	
	/**
	 * 予約登録
	 * @param reservation 予約情報Bean
	 * @return 登録の成否をBooleanで返却
	 * 登録成功時にReservationBeanに予約IDをセット
	 */
	public static boolean insert(ReservationBean reservation) {
		String insertSql = "INSERT INTO reservation "
				+ "(id, roomid, date, start, end, userid)"
				+ "VALUES (null, ?, ?, ?, ?, ?)";
		boolean found = false;
		
		// RETURN_GENERATED_KEYSで新規予約IDを登録時に取得
		if(ReservationDao.checkReservation(reservation)) {
			try(Connection conn = DatabaseConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(
						insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, reservation.getRoomId());
				pstmt.setString(2, reservation.getDate());
				pstmt.setString(3, reservation.getStart());
				pstmt.setString(4, reservation.getEnd());
				pstmt.setString(5, reservation.getUserId());
				
				int num = pstmt.executeUpdate();
				
				if (num > 0) {
					try(ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							reservation.setId(generatedKeys.getInt(1));
							found = true;
						}
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("ドライバーが見つかりません");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println();
				System.out.println("SQLに関するエラー");
			}
		}
		
		return found;
	}
	
	/**
	 * 予約削除
	 * @param reservation 予約情報Bean
	 * @return 予約削除成否をBooleanで返却
	 */
	public static boolean delete(ReservationBean reservation) {
		String deleteSql = "DELETE FROM reservation WHERE Id = ?";
		boolean found = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
			pstmt.setInt(1, reservation.getId());
			
			int num = pstmt.executeUpdate();
			
			if (num > 0) {
				found = true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		return found;
	}
	
	
	/**
	 * 利用者論理削除時に利用者が予約した予約情報を全削除
	 * @param userId
	 * @return 実行されれば true
	 */
	public static boolean userReserveDelete(String userId) {
		String deleteSql = "DELETE FROM reservation WHERE userid = ?";
		boolean found = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
			pstmt.setString(1, userId);
			
			int num = pstmt.executeUpdate();
			
			if (num > 0) {
				found = true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		return found;
	}
}
