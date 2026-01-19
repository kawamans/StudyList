package jp.co.seminar.bean;

public class sampleTest {
public static void main(String[] args) {
	System.out.println("=============================================================");
	System.out.println("⑪getReservations()のテスト");
	
	System.out.println("期待する結果：予約情報の二次元配列");
	System.out.println("実行結果：");
	
	MeetingRoom mr = new MeetingRoom();
	 ReservationBean[][] reservations = mr.getReservations();

	 if (reservations != null && reservations.length > 0) {
	        System.out.println("配列サイズ: [" + reservations.length + "][" + reservations[0].length + "]");

	        for (int i = 0; i < reservations.length; i++) {
	                for (int j = 0; j < reservations[i].length; j++) {
	                        if (reservations[i][j] != null) {
	                                System.out.println("[" + i + "][" + j + "]: " + reservations[i][j]);
	                        }
	                }
	        }
	  } else {
	        System.out.println("予約情報が取得できません");
	  }
}
}
