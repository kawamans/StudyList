package jp.co.seminar.bean;

import java.io.Serializable;

/** @author 川満 */
public class LoginUserBean implements Serializable{
	
	// フィールド ====================================
	private static final long serialVersionUID = 1L;
	private String id; // 利用者ID
	private String password; // 利用者PW
	private String name; // 利用者名
	private String address; // 住所
	private String adminflg; // 管理者フラグ
	
	
	// コンストラクタ ==================================== 
	/** javabean仕様 */
	public LoginUserBean() {}
	
	/**
	 * 利用者情報の初期化
	 * @param id
	 * @param password
	 * @param name
	 * @param address
	 * @param adminflg
	 * @param select
	 */
	public LoginUserBean(String id, String password, String name,String address, String adminflg) {
		this.id = id;
		this.password = password;
		this.name = name;
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
	
	public String getAddress() {
		return address;
	}
	
	// ※追加
	public String getAdminflg() {
		return adminflg;
	}
	
	@Override
	public String toString() {
		return "LoginUserBean"
				+ "id = " + id + " / password = " + password + " / "
				+ "\nname = " + name + " / address = " + address + " / "
				+ " adminflg = " + adminflg;
	}
}
