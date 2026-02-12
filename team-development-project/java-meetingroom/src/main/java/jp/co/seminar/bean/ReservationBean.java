package jp.co.seminar.bean;

import java.io.Serializable;

/** @author 川満 */
public class ReservationBean implements Serializable{
	
	
	// フィールド ====================================
	private static final long serialVersionUID = 1L;
	private int id; // 予約番号
	private String roomId; // 会議室ID
	private String date; // 利用日
	private String start; // 利用開始時刻
	private String end; // 利用終了時刻
	private String userId; // 利用者ID
	
	
	// コンストラクタ ==================================== 
	/** javabean仕様 */
	public ReservationBean() {}
	
	/**
	 * 予約情報の初期化
	 * @param id 
	 * @param roomId 
	 * @param date 
	 * @param start 
	 * @param end 
	 * @param userId 
	 */
	public ReservationBean(int id, String roomId, String date, String start, String end, String userId) {
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}
	
	/**
	 * 予約ID未定で初期化、予約IDは0 ※追加
	 * @param id
	 * @param roomId
	 * @param date
	 * @param start
	 * @param end
	 * @param userId
	 */
	public ReservationBean(String roomId, String date, String start,  String end, String userId) {
		this.id = 0;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}	
	

	
	// メソッド ====================================
	
	// ※追加
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getRoomId() {
		return roomId;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getStart() {
		return start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public String getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "id = " + id + " / roomId = " + roomId + " / "
				+ "\ndate = " + date + " / start = " + start + " / "
				+ "\nend = " + end + " / userId = " + userId;
	}
}