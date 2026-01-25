package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.UserBean;
import jp.co.seminar.util.DatabaseConnection;

/** @author 川満 */
public class UserDao {

	// コンストラクタ ==================================== 
	/** Dao仕様 */
	private UserDao() {}
	
	// メソッド ====================================
	/**
	 * 利用者認証
	 * @param id 利用者ID
	 * @param password パスワード
	 * @return 認証した利用者情報を返却する。無ければnull
	 */
	public static LoginUserBean certificate(String id, String password) {
		String selectSql = "SELECT * FROM user WHERE id = ? AND password = ? AND deleteflg = 0";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return new LoginUserBean(
						rs.getString("id"), rs.getString("password"),
						rs.getString("name"), rs.getString("address"), 
						rs.getString("adminflg")
					);
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
		return null;
	}
	
	
	
	// 追加メソッド ====================================
	/**
	 * 登録利用者全件取得
	 * @return
	 */
	public static List<UserBean> findUser(){
		String sql = "SELECT * FROM user WHERE deleteflg = 0 ORDER BY MOD(id, 100000) DESC";
		List<UserBean> userList = new ArrayList<>();
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
				
			while(rs.next()) {
				UserBean user = new UserBean(
						rs.getString("id"), rs.getString("password"),rs.getString("name"), 
						rs.getString("address"), rs.getString("adminflg"), "select");
				userList.add(user);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		if(userList.isEmpty()) {
			return null;
		}
		
		return userList;
	}
	
	
	/**
	 * 最新の利用者IDの下五桁を生成
	 * @return 五桁の連番
	 */
	public static int createId() {
		String selectSql = "SELECT id FROM user ORDER BY MOD(id, 100000) DESC LIMIT 1";
		int id = 0;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery()) {
			
			if(rs.next()) {
				String stringId;
				stringId = rs.getString("id");
				stringId = stringId.substring(2);
				id = Integer.parseInt(stringId);
				id++;
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバーが見つかりません");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("SQLに関するエラー");
		}
		
		return id;
	}
	
	
	/**
	 * パスワード確認
	 * @param userBean
	 * @return 新規PWの時 true
	 */
	public static boolean checkPass(UserBean userBean) {
		String selectSql = "SELECT * FROM user WHERE password = ?";
		boolean check = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, userBean.getPassword());
			
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
	 * 利用者確認
	 * @param userBean
	 * @return 新規利用者の時 true
	 */
	public static boolean checkId(UserBean userBean) {
		String selectSql = "SELECT * FROM user WHERE id = ?";
		boolean check = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, userBean.getId());
			
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
	 * 最終管理者人数確認
	 * @param userBean
	 * @return 管理者が2人以上で true
	 */
	public static boolean lastAdmin() {
		String selectSql = "SELECT COUNT(*) FROM user WHERE adminflg = 1";
		boolean check = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			
			try(ResultSet rs = pstmt.executeQuery()) {
				long count = 0;
				if(rs.next()) {
					count = rs.getLong("COUNT(*)");
				}
				if(count == 1) {
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
	 * 利用者検索
	 * @param id
	 * @return 検索した利用者情報を返却し、無ければnull
	 */
	public static UserBean searchUser(String id) {
		String selectSql = "SELECT * FROM user WHERE id = ? AND deleteflg = 0";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return new UserBean(
						rs.getString("id"), rs.getString("password"),
						rs.getString("name"), rs.getString("address"), 
						rs.getString("adminflg"), "select");
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
		
		return null;
	}
	

	/**
	 * 利用者登録
	 * @param userBean 利用者情報
	 * @return 登録処理完了時 true
	 */
	public static boolean insertUser(UserBean userBean) {
		String insertSql = "INSERT INTO user "
				+ "(id, password, name, address, deleteflg, adminflg)"
				+ " VALUES (?, ?, ?, ?, 0, ?)";
		boolean found = false;
		
		// 新規利用者かつ新規PW時に実行
		if(checkId(userBean) && checkPass(userBean)) {
			try(Connection conn = DatabaseConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
				pstmt.setString(1, userBean.getId());
				pstmt.setString(2, userBean.getPassword());
				pstmt.setString(3, userBean.getName());
				pstmt.setString(4, userBean.getAddress());
				pstmt.setString(5, userBean.getAdminflg());
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
	 * 利用者情報変更
	 * @param userBean 利用者情報
	 * @return 変更成功時 true
	 */
	public static boolean updateUser(UserBean userBean) {
		String updateSql = "UPDATE user SET password = ?, name = ?, address = ?, adminflg = ? WHERE id = ?";
		boolean found = false;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
			pstmt.setString(1, userBean.getPassword());
			pstmt.setString(2, userBean.getName());
			pstmt.setString(3, userBean.getAddress());
			pstmt.setString(4, userBean.getAdminflg());
			pstmt.setString(5, userBean.getId());
			
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
	 * 利用者論理削除処理
	 * @param userBean 利用者情報
	 * @return 論理削除成功時 true
	 */
	public static boolean logicalDeleteUser(UserBean userBean) {
		String updateSql = "UPDATE user SET deleteflg = ? WHERE id = ?";
		boolean found = false;
		boolean check = true;
		
		// 削除対象が管理者であれば、DB内の管理者人数を確認
		if(userBean.getAdminflg().equals("1") && UserDao.lastAdmin()) {
			check = false;
		}
		
		// 削除可能の対象で論理削除実行
		if(check || !checkId(userBean)) {
			try(Connection conn = DatabaseConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
				pstmt.setString(1, "1");
				pstmt.setString(2, userBean.getId());
				
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
