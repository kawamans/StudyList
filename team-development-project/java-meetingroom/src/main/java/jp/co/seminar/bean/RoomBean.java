package jp.co.seminar.bean;

import java.io.Serializable;

/** @author 川満 */
public class RoomBean implements Serializable{
	
	// フィールド ====================================
	private static final long serialVersionUID = 1L;
	private String id; // 会議室ID
	private String name; // 会議室名
	private String floor; // 階層 ※追加
	private String roomNumber; // 部屋番号 ※追加
	
	
	// コンストラクタ ==================================== 
	/** javabean仕様 */
	public RoomBean() {}
	
	/**
	 * 会議室情報の初期化
	 * @param id 
	 * @param name 
	 */
	public RoomBean(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 会議室新規登録情報の初期化 ※追加
	 * @param floor 
	 * @param roomNumber 
	 * @param name 
	 */
	public RoomBean(String name, String floor, String roomNumber) {
		this.name = name;
		this.floor = floor;
		this.roomNumber = roomNumber;
	}
	
	
	
	// メソッド ====================================
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	// ※追加
	public String getFloor() {
		return floor;
	}
	
	// ※追加
	public String getRoomNumber() {
		return roomNumber;
	}
	
	@Override
	public String toString() {
		return "id = " + id + " / name = " + name + " / "
				+ "floor = " + floor + " / roomNumber = " + roomNumber;
	}
}