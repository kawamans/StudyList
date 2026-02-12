package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.seminar.bean.RoomBean;
import jp.co.seminar.util.DatabaseConnection;

/** @author 川満 */
public class RoomDao {
	
	// コンストラクタ ====================================
	/** Dao仕様 */
	private RoomDao() {}
	
	// メソッド ====================================
	/**
	 * 全ての会議室情報取得
	 * @return 会議室情報を返却、無ければnull
	 */
	public static RoomBean[] findAll() {
		String sql = "SELECT * FROM room";
		List<RoomBean> roomList = new ArrayList<>();
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
				
			while(rs.next()) {
				RoomBean r = new RoomBean(rs.getString("id"), rs.getString("name"));
				roomList.add(r);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		if(roomList.isEmpty()) {
			return null;
		}
		
		RoomBean[] roomBean = roomList.toArray(new RoomBean[0]);
		
		return roomBean;
	}
	
	
	// 追加メソッド ====================================
	/**
	 * 新規会議室か確認
	 * @param roomBean
	 * @return 新規会議室であれば true
	 */
	public static boolean checkRoom(RoomBean roomBean) {
		String selectSql = "SELECT * FROM room WHERE id = ?";
		boolean check = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, roomBean.getId());
			
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
	 * 会議室登録
	 * @param roomBean 会議室情報
	 * @return 登録処理成功で true
	 */
	public static boolean insertRoom(RoomBean roomBean) {
		String insertSql = "INSERT INTO room (id,  name) VALUES (?, ?)";
		boolean found = false;
		
		// 新規の会議室の時に登録処理
		if(checkRoom(roomBean)) {
			try(Connection conn = DatabaseConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
				pstmt.setString(1, roomBean.getId());
				pstmt.setString(2, roomBean.getName());
				
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
		}
		return found;
	}
	
	
	/**
	 * 削除処理
	 * @param roomBean 会議室情報
	 * @return 削除成否でboolean
	 */
	public static boolean deleteRoom(RoomBean roomBean) {
		String deleteSql = "DELETE FROM room WHERE Id = ?";
		boolean found = false;
		
		// 会議室が存在する場合に削除処理
		if(!checkRoom(roomBean)) {
			try(Connection conn = DatabaseConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
				pstmt.setString(1, roomBean.getId());
				
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
		}
		
		return found;
	}
	
}
