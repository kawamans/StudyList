package jp.co.seminar.bean;

import java.io.Serializable;

/** @author 川満 */
public class UserBean implements Serializable{
	
	// フィールド ====================================
	private static final long serialVersionUID = 1L;
	private String id; // 利用者ID
	private String password; // 利用者PW
	private String name; // 利用者名
	private String birthYear; // 出生年
	private String address; // 住所
	private String adminflg; // 管理者フラグ
	
	
	// コンストラクタ ==================================== 
	/** javabean仕様 */
	public UserBean() {}
	
	/**
	 * 利用者情報の初期化
	 * @param id
	 * @param password
	 * @param name
	 * @param address
	 * @param adminflg
	 * @param select
	 */
	public UserBean(String id, String password, String name,String address, String adminflg, String select) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.adminflg = adminflg;
	}
	
	
	
	/**
	 * 新規登録用 ※追加
	 * @param password
	 * @param name
	 * @param birthYear
	 * @param address
	 * @param adminflg
	 */
	public UserBean(String password, String name, String birthYear, String address,String adminflg) {
		this.password = password;
		this.name = name;
		this.birthYear = birthYear;
		this.address = address;
		this.adminflg = adminflg;
	}
	
	
	
	// メソッド ====================================
	
	// ※追加
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	// ※追加
	public String getBirthYear() {
		return birthYear;
	}
	
	public String getAddress() {
		return address;
	}
	
	// ※追加
	public String getAdminflg() {
		return adminflg;
	}
	
	@Override
	public String toString() {
		return "UserBean"
				+ "id = " + id + " / password = " + password + " / "
				+ "\nname = " + name + " / birthYear = " + birthYear + " / "
				+ "\naddress = " + address + " / adminflg = " + adminflg;
	}
}
