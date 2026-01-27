package jp.co.seminar.bean;

import java.io.Serializable;
import java.util.List;

import jp.co.seminar.bean.AppException.AlreadyRegisteredRoomException;
import jp.co.seminar.bean.AppException.AlreadyRegisteredUserException;
import jp.co.seminar.bean.AppException.DeleteRoomFailedException;
import jp.co.seminar.bean.AppException.InsertRoomFailedException;
import jp.co.seminar.bean.AppException.InsertUserFailedException;
import jp.co.seminar.bean.AppException.LogicalDeleteAdminException;
import jp.co.seminar.bean.AppException.LogicalDeleteUserFailedException;
import jp.co.seminar.bean.AppException.NonExistentRoomException;
import jp.co.seminar.bean.AppException.NonExistentUserException;
import jp.co.seminar.bean.AppException.UpdateUserFailedException;
import jp.co.seminar.dao.ReservationDao;
import jp.co.seminar.dao.RoomDao;
import jp.co.seminar.dao.UserDao;

/**
 * 追加ServiceClass
 * @author 川満 達也
 */
public class ExtraMR implements Serializable {
	
	// フィールド ====================================
	private RoomBean room; // 会議室情報
	private UserBean user; // 利用者情報
	private List<UserBean> userList;
	private static final long serialVersionUID = 1L;
	
	public ExtraMR() {
		this.userList = UserDao.findUser();
	}
	
	public RoomBean getRooms() {
		return room;
	}
	
	public UserBean getUser() {
		return user;
	}
	
	public List<UserBean> getUserList() {
		return userList;
	}
	
	/**
	 * 利用者情報新規取得用メソッド
	 */
	public void renewUserList() {
		this.userList = UserDao.findUser();
	}
	
	
	/**
	 * ユーザー登録情報の生成
	 * @param password
	 * @param name
	 * @param birthYear
	 * @param address
	 * @param adminflg
	 * @return
	 */
	public UserBean inputUser(String password, String name, String birthYear, String address,String adminflg) {
		return new UserBean(password, name, birthYear, address, adminflg);
	}
	
	
	/**
	 * ユーザー登録情報の生成
	 * @param password
	 * @param name
	 * @param birthYear
	 * @param address
	 * @param adminflg
	 * @return
	 */
	public UserBean instanceUser(String id, String password, String name, String address, String adminflg, String select) {
		return new UserBean(id, password, name, address, adminflg, select);
	}
	
	
	/**
	 * 利用者新規ID生成
	 * 出生年の西暦下二桁と最新のIDの連番下五桁を結合する
	 * @param userBean
	 * @return 新規ID
	 */
	private UserBean newUserId(UserBean userBean) {
		// 出生年(西暦)を取得
		String newId = userBean.getBirthYear();
		// 出生年(西暦)の下二桁を抽出
		newId = newId.substring(2);
		// 最新の利用者IDの下五桁の連番の次の連番を取得
		int intId = UserDao.createId();
		// String.format("%05d", intId)で五桁以下の数字を0埋めする
		String formatId = String.format("%05d", intId);
		// 西暦二桁＋連番五桁で新規IDを生成
		userBean.setId(newId + formatId);
		
		return userBean;
	}
	
	
	/**
	 * 会議室新規ID生成
	 * 出生年の西暦下二桁と最新のIDの連番下五桁を結合する
	 * @param userBean
	 * @return 新規ID
	 */
	private RoomBean newRoomId(RoomBean roomBean) {
		// 新規登録会議室の階層と部屋番号を加工
		String frontId = formatRoomId(roomBean.getFloor());
		String backId = formatRoomId(roomBean.getRoomNumber());
		// 加工した階層と部屋番号を結合して新規会議室IDを生成し格納
		roomBean.setId(frontId + backId);
		
		return roomBean;
	}
	
	
	/**
	 * 会議室の階層と部屋番号を加工する
	 * @param parts
	 * @return 文字列にも対応した下二桁の文字列
	 */
	private String formatRoomId(String parts) {
		// 文字数をカウントする
		int intId = parts.length();
		
		// 文字数を確認
		if(intId == 1) {
			// 1文字なら頭に0を追加して返却
			return "0" + parts;
			
		} else {
			// 3文字以上なら下2桁に加工して返却
			return parts.substring(intId - 2);
		}
	}
	
	
	/**
	 * 新規利用者登録
	 * @param userBean
	 * @throws AlreadyRegisteredUserException 既存利用者時に例外
	 * @throws InsertUserFailedException 登録処理失敗時に例外
	 */
	public void createUser(UserBean userBean) {
		// 新規利用者IDを生成
		newUserId(userBean);
		
		// PWが被っていないか確認
		if(!UserDao.checkPass(userBean)) {
			throw new AppException.AlreadyRegisteredUserException("このパスワードは既に登録されています。");
		}
		
		// 登録実行処理
		if(!UserDao.insertUser(userBean)) {
			throw new AppException.InsertUserFailedException("利用者の登録に失敗しました。");
		}
		
		// ユーザーリストを更新
		renewUserList();
		
		// 登録成功時に登録情報を格納
		this.user = userBean;
	}
	
	
	/**
	 * 利用者検索
	 * @param id 利用者ID
	 * @return 利用者が存在していれば true
	 */
	public UserBean searchUser(String id) {
		// 利用者IDを検索して格納する
		UserBean userBean = UserDao.searchUser(id);
		
		// 利用者IDから利用者が存在するか確認
		if (userBean != null) {
			return this.user = userBean;
		}
		
		return null;
	}
	
	
	/**
	 * 利用者情報変更
	 * @param userBean
	 * @throws NonExistentUserException 利用者がいない時に例外
	 * @throws UpdateUserFailedException 変更処理失敗時に例外
	 */
	public void updateUser(UserBean userBean) {
		// 対象の利用者が存在する確認
		if(UserDao.checkId(userBean)) {
			throw new AppException.NonExistentUserException("この利用者は存在しません。");
		}
		
		// 変更処理を実行
		if(!UserDao.updateUser(userBean)) {
			throw new AppException.UpdateUserFailedException("利用者情報の変更に失敗しました。");
		}
		
		// ユーザーリストを更新
		renewUserList();
		
		// 変更成功時に登録情報を格納
		this.user = userBean;
	}
	
	
	/**
	 * 利用者論理削除
	 * @param userBean
	 * @throws NonExistentUserException 利用者がいない時に例外
	 * @throws LogicalDeleteAdminException 最後の管理者時に例外
	 * @throws LogicalDeleteUserFailedException 削除処理失敗時に例外
	 */
	public void logicalDeleteUser(UserBean userBean) {
		// 対象の利用者が存在するか確認
		if(UserDao.checkId(userBean)) {
			throw new AppException.NonExistentUserException("この利用者は存在しません。");
		}
		
		// 対象が管理者の場合は削除可能かを確認
		if(userBean.getAdminflg().equals("1") && UserDao.lastAdmin()) {
			throw new AppException.LogicalDeleteAdminException("最後の管理者は削除できません。");
		}
		
		// 削除処理を実行
		if(!UserDao.logicalDeleteUser(userBean)) {
			throw new AppException.LogicalDeleteUserFailedException("削除に失敗しました。");
		}
		
		// 削除対象が予約をしていた場合実行
		if(ReservationDao.checkReserveUser(userBean.getId())) {
			// 予約削除処理を実行
			if(!ReservationDao.userReserveDelete(userBean.getId())) {
				throw new AppException.DeleteRoomFailedException("会議室の削除に失敗しました。");
			}
		}
		
		// ユーザーリストを更新
		renewUserList();
		
		// 削除成功時に登録情報を格納
		this.user = userBean;
	}
	
	
	/**
	 * 会議室情報生成
	 * @param id
	 * @param name
	 * @return
	 */
	public RoomBean instanceRoom(String id, String name) {
		this.room = new RoomBean(id, name);
		return this.room;
	}
	
	
	/**
	 * 会議室新規登録生成
	 * @param name
	 * @param floor
	 * @param roomNumber
	 * @return
	 */
	public RoomBean createRoom(String name, String floor, String roomNumber) {
		this.room = new RoomBean(name, floor, roomNumber);
		return this.room;
	}
	
	
	/**
	 * 会議室新規登録処理
	 * @param roomBean
	 * @throws AlreadyRegisteredRoomException 既存の会議室時に例外
	 * @throws InsertRoomFailedException 会議室登録失敗時に例外
	 */
	public void insertRoom(RoomBean roomBean) {
		// 新規会議室IDを実行
		newRoomId(roomBean);
		
		// 新規の会議室か確認
		if(!RoomDao.checkRoom(roomBean)) {
			throw new AppException.AlreadyRegisteredRoomException("この会議室は既に登録されています。");
		}
		
		// 登録処理を実行
		if(!RoomDao.insertRoom(roomBean)) {
			throw new AppException.InsertRoomFailedException("会議室の登録に失敗しました。");
		}
	}
	

	/**
	 * 会議室削除
	 * @param roomBean
	 * @throws NonExistentRoomException 会議室が存在しない時に例外
	 * @throws DeleteRoomFailedException 会議室削除失敗時に例外
	 */
	public void deleteRoom(RoomBean roomBean) {
		// 対象の会議室が存在するか確認
		if(RoomDao.checkRoom(roomBean)) {
			throw new AppException.NonExistentRoomException("この会議室は存在しません。");
		}
		
		// 削除処理を実行
		if(!RoomDao.deleteRoom(roomBean)) {
			throw new AppException.DeleteRoomFailedException("会議室の削除に失敗しました。");
		}
	}
}
	