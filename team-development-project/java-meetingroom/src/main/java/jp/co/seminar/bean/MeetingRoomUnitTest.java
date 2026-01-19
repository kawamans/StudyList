package jp.co.seminar.bean;

public class MeetingRoomUnitTest {
	public static void main(String[] args) throws Exception {
		/**=======================================================*/
		/** テスト済みのメソッド 
		 * 
		 * ①コンストラクタ
		 * →会議室の一覧を読み込み、利用日を本日の日付で初期化OK
		 * 
		 * ②roomIndex()
		 * →正常値、異常値（例外）ともにOK
		 * 
		 * ③startPeriod()
		 * →正常値、異常値（例外）ともにOK
		 * 
		 * ④,⑤のgetterOK
		 * 
		 * ⑥getRoom()
		 * →正常値、例外ともにOK
		 * 
		 * ⑦getUser()OK
		 * 
		 * ⑧,⑨getter　OK
		 * 
		 * ⑩,⑪,⑫,⑬
		 * 
		 * ⑭cancel(ReservationBean reservation)
		 * →正常系、例外ともにOK
		 * **/
		
		/**=======================================================*/
		/** テスト数 **/
//		private int totalTest = 14;
//		private int passedTest = 14;
//		private int failedTest = 0;
//		
		/**=======================================================*/
		
		System.out.println("①コンストラクタのテスト");
		
		MeetingRoom mr = new MeetingRoom();
		System.out.println(mr);
		
		System.out.println("=============================================================");
		
		System.out.println("②roomIndexのテスト");
		
		System.out.println("＜正常値系＞");
		
		System.out.println("期待する結果：0(0201のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int a = mr.roomIndex("0201");
		System.out.println(a);
		
		System.out.println("期待する結果：1(0301のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int b = mr.roomIndex("0301");
		System.out.println(b);
		
		System.out.println("期待する結果：2(0302のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int c = mr.roomIndex("0302");
		System.out.println(c);
		
		System.out.println("＜異常値系＞");
		try {
			
		mr.roomIndex("9999");
		System.out.println("例外が発生しません。");
		
		}catch(Exception e) {
		
		System.out.println("期待する例外：入力値に対応する会議室は見つかりません。"+ "\n");
		System.out.println("結果："+ e.getMessage());
		}
		
		
		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("③startPeriod(String start)のテスト");
		
		
		System.out.println("＜正常値系＞");
		
		System.out.println("期待する結果：0(9:00のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int d = mr.startPeriod("9:00");
		System.out.println(d);
		
		System.out.println("期待する結果：1(10:00のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int f = mr.startPeriod("10:00");
		System.out.println(f);
		
		System.out.println("期待する結果：6(15:00のインデックスの値)"+ "\n");
		System.out.println("実行結果：");
		
		//戻り値を受け取って表示
		int g = mr.startPeriod("15:00");
		System.out.println(g);
		
		System.out.println("＜異常値系＞");
		try {
			
		mr.startPeriod("9999");
		System.out.println("例外が発生しません。");
		
		}catch(Exception e) {
		
		System.out.println("期待する例外：利用時間外です"+ "\n");
		System.out.println("結果："+ e.getMessage());
		}
		
		
		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("④getPeriod()のテスト");

		System.out.println("期待する結果：時間帯配列(9:00~16:00の8要素）" + "\n");
		System.out.println("実行結果：");

		String[] period = mr.getPeriod();
		
		//配列はそのままtostringできないので取り出す
		
		for (int i = 0; i < period.length; i++) {
			System.out.println(period[i]);
		}

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑤getRooms()のテスト");

		System.out.println("期待する結果：会議室配列が取得できる" + "\n");
		System.out.println("実行結果：");
		
		//配列はそのままtostringできないので取り出す
		RoomBean[] rooms = mr.getRooms();
		for (int i = 0; i < rooms.length; i++) {
			System.out.println(rooms[i]);
		}

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑥getRoom(String roomId)のテスト");

		System.out.println("＜正常値系＞");
		System.out.println("期待する結果：会議室ID:0201の情報" + "\n");
		System.out.println("実行結果：");

		try {
			RoomBean room = mr.getRoom("0201");
			System.out.println(room);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("＜異常値系＞");
		try {
			mr.getRoom("9999");
			System.out.println("例外が発生しません。");
		} catch (Exception e) {
			System.out.println("期待する例外：会議室は見つかりません。" + "\n");
			System.out.println("結果：" + e.getMessage());
		}

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑦getUser()のテスト");

		System.out.println("期待する結果：ログイン前はnull" + "\n");
		System.out.println("実行結果：");

		System.out.println(mr.getUser());
		
		System.out.println("期待する結果：ログイン後はユーザー情報が変わる");
		System.out.println("実行結果");
		
		boolean loginResult = mr.login("9900001", "a00001");
	    System.out.println("ログイン結果：trueならOK：："+ loginResult);
	    System.out.println(mr);
		

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑧getDate()のテスト");

		System.out.println("期待する結果：本日の日付（yyyy-MM-dd形式）" + "\n");
		System.out.println("実行結果：");

		System.out.println(mr.getDate());

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑨setDate(String date)のテスト");

		System.out.println("期待する結果：2026-01-20" + "\n");
		System.out.println("実行結果：");

		mr.setDate("2026-01-20");
		System.out.println(mr.getDate());

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑩login(String id, String password)のテスト");

		System.out.println("＜正常値系（ログイン成功）＞");
		System.out.println("期待する結果：true" + "\n");
		System.out.println("実行結果：");

		boolean loginResult2 = mr.login("9900001", "a00001");
		System.out.println(loginResult2);

		System.out.println("＜異常値系（ログイン失敗）＞");
		System.out.println("期待する結果：false" + "\n");
		System.out.println("実行結果：");

		MeetingRoom mr2 = new MeetingRoom();
		boolean loginResult3 = mr2.login("inomoto", "wrongpassword");
		System.out.println(loginResult3);

		
		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑪getReservations()のテスト");
		
		System.out.println("期待する結果：予約情報の二次元配列");
		System.out.println("実行結果：");
		
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
		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑫createReservation(String roomId, String start)のテスト");
		
		System.out.println("期待する結果：予約情報生成");
		System.out.println("実行結果");
		

		// ログイン済みなので正常に動作
		ReservationBean rb = mr.createReservation("0201", "09:00");
		System.out.println(rb);

		System.out.println("\n＜異常値系（ログインなし）＞");
		System.out.println("期待する結果：Exception" + "\n");
		System.out.println("実行結果：");

		try {
			MeetingRoom mr3 = new MeetingRoom();
			// ログインせずに実行
			mr3.createReservation("0201", "10:00");
			System.out.println("例外が発生しません。");
		} catch (NullPointerException e) {
			System.out.println("例外が発生しました。");
		}

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑬reserve(ReservationBean reservation)のテスト");
		
		System.out.println("＜正常値系＞");
		System.out.println("期待する結果：予約が登録される" + "\n");
		System.out.println("実行結果：");

		try {
			
			//予約時刻が現在時刻より前ならOK
			mr.login("9900001", "a00001");
			mr.setDate("2026-03-01");  // 未来の日付
			ReservationBean rb2 = mr.createReservation("0201", "10:00");
			mr.reserve(rb2);
			System.out.println("予約成功");
		} catch (Exception e) {
			System.out.println("エラー: " + e.getMessage());
		}

		System.out.println("\n＜異常値系1（過去の時刻）＞");
		System.out.println("期待する例外：TimePassedException" + "\n");
		System.out.println("実行結果：");

		try {
			mr.setDate("2020-01-01");  // 過去の日付
			ReservationBean rb3 = mr.createReservation("0201", "10:00");
			mr.reserve(rb3);
			System.out.println("例外が発生しません。");
		} catch (AppException.TimePassedException e) {
			System.out.println("結果: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("別の例外: " + e.getMessage());
		}

		System.out.println("\n＜異常値系2（既に予約済み）＞");
		System.out.println("期待する例外：AlreadyReservedException" + "\n");
		System.out.println("実行結果：");

		try {
			mr.setDate("2026-03-01");  // 未来の日付

			// 1回目の予約
			ReservationBean rb4 = mr.createReservation("0201", "14:00");
			mr.reserve(rb4);

			// 2回目の予約（同じ時間）
			ReservationBean rb5 = mr.createReservation("0201", "14:00");
			mr.reserve(rb5);

			System.out.println("例外が発生しません。");
		} catch (AppException.AlreadyRegisteredRoomException e) {
			System.out.println("結果: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("別の例外: " + e.getMessage());
		}

		/**=======================================================*/
		System.out.println("=============================================================");
		System.out.println("⑭cancel(ReservationBean reservation)のテスト");

		System.out.println("＜正常値系＞");
		System.out.println("期待する結果：キャンセル成功" + "\n");
		System.out.println("実行結果：");

		try {
			mr.login("9900001", "a00001");
			mr.setDate("2026-02-01");  // 未来の日付
			ReservationBean rb6 = mr.createReservation("0201", "15:00");
			mr.reserve(rb6);

			// すぐにキャンセル
			mr.cancel(rb6);
			System.out.println("キャンセル成功");
		} catch (Exception e) {
			System.out.println("エラー: " + e.getMessage());
		}

		System.out.println("＜異常値系1（過去の予約）＞");
		System.out.println("期待する例外：TimePassedException" + "\n");
		System.out.println("実行結果：");

		try {
			// 過去の予約を作成
			ReservationBean rbPast = new ReservationBean(1, "0201", "2020-01-01",
			                                              "10:00", "11:00", "9900001");
			mr.cancel(rbPast);
			System.out.println("例外が発生しません。");
		} catch (AppException.TimePassedException e) {
			System.out.println("結果: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("別の例外: " + e.getMessage());
		}

		System.out.println("＜異常値系2（他人の予約）＞");
		System.out.println("期待する例外：UnauthorizedCancelException" + "\n");
		System.out.println("実行結果：");

		try {
			// 他人の予約を作成
			ReservationBean rbOther = new ReservationBean(1, "0201", "2026-02-01",
			                                               "10:00", "11:00", "otherUser");
			mr.cancel(rbOther);
			System.out.println("例外が発生しません。");
		} catch (AppException.UnauthorizedCancelException e) {
			System.out.println("結果: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("別の例外: " + e.getMessage());
		}
		
		
		
	}
}
