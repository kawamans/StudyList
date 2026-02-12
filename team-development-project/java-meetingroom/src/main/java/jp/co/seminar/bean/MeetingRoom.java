package jp.co.seminar.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jp.co.seminar.bean.AppException.AlreadyReservedException;
import jp.co.seminar.bean.AppException.ReservationFailedException;
import jp.co.seminar.bean.AppException.TimePassedException;
import jp.co.seminar.dao.ReservationDao;
import jp.co.seminar.dao.RoomDao;
import jp.co.seminar.dao.UserDao;

	/**@author 猪本 **/

public class MeetingRoom implements Serializable {
	
	/**	フィールド ===========================================*/
	private String date; //利用日
	private final int INTERVAL; //時間間隔
	private final String[] PERIOD; //時間帯配列
	private RoomBean[] rooms; //会議室配列
	private static final long serialVersionUID = 1L;
	private LoginUserBean LoginUser; //ログイン中のユーザー
	
	
	/** コンストラクタ========================================
	 * 
	 *  会議室予約システムの初期化をします。
	 *  会議室の一覧を読み込み、利用日を本日の日付で初期化します。
	 *  @param なし
	 *  @return なし
	 * **/
	
	public MeetingRoom() {
		
		//時間間隔を設定		
		this.INTERVAL = 60;
		
		//時間帯配列を作成（9:00~16:00の1時間ごと）
		this.PERIOD = new String[] {
				"9:00","10:00","11:00","12:00",
				"13:00","14:00","15:00","16:00"
		};
		
		//DBから会議室一覧を読み込む（☆☆DAOをstaticメソッドにするか設計要確認）
			
		this.rooms = RoomDao.findAll();
		
		//利用日を本日の日付で初期化（時間は含めず日付のみ初期化）
		LocalDate today = LocalDate.now();
		
		//Stringにキャスト不可のためLocalDateオブジェクトのtoString()を呼び出し
		this.date = today.toString();
		
	}
	
	/** メソッド =================================================**/
	
	
	/**===============================================================**/
	/** roonIdから会議室配列の添え字を取得
	 * @param roomId
	 * @return int
	 * @throws Exception 
	 *  **/
	
	public int roomIndex(String roomId) throws Exception {
		for (int i = 0; i< rooms.length; i++ ) {
			if(rooms[i].getId().equals(roomId)) {
				return i;
			}
		}
		
		//見つからない場合は例外処理
		throw new Exception(roomId +"に対応する会議室は見つかりません。");
	}
	
	
	/**===============================================================**/
	/** 利用開始時刻に対応する利用時間帯の添え字を取得
	 * @param start
	 * @return int
	 * @throws Exception 
	 *  **/
	 
	public int startPeriod(String start) throws Exception {

		// 出力フォーマッタ: "H:mm" (1桁の時間 'H'、2桁の分 'mm') ※PERIOD配列と同じ形式
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("H:mm");

		// 入力文字列を LocalTime オブジェクトに解析
		// 複数の形式（H:mm, HH:mm, HH:mm:ss）に対応
		LocalTime localTime;
		try {
			// まず（HH:mm, HH:mm:ss）を試す
			localTime = LocalTime.parse(start);
		} catch (Exception e) {
			// 失敗した場合、H:mm形式を試す
			DateTimeFormatter flexibleFormatter = DateTimeFormatter.ofPattern("H:mm");
			localTime = LocalTime.parse(start, flexibleFormatter);
		}

		// LocalTime オブジェクトを出力フォーマット(H:mm)の文字列に変換
		String outputTime = localTime.format(outputFormatter);
		
		for (int i = 0; i < PERIOD.length; i++) {
			if(PERIOD[i].equals(outputTime)) {
				return i;
			}
		}

		//利用時間帯配列に存在しない利用時間が指定された場合は、例外処理をする
		throw new Exception("利用時間外です。"); 
	}
	
	public void setRooms(RoomBean[] rooms) {
		this.rooms = rooms;
	}
	
	/**===============================================================**/
	/** 利用時間帯の配列を取得
	 * @param なし
	 * @return String[] **/
	
	public String[] getPeriod() {
		return PERIOD ;
	}
	
	/**===============================================================**/
	/** 会議室予約システムで利用できるすべての会議室を取得する
	 * @param なし
	 * @return RoomBean[] **/
	
	public RoomBean[] getRooms() {
		return rooms;
	}
	
	/**===============================================================**/
	/** 利用会議室取得
	 * @param roomId
	 * @return RoomBean 
	 * @throws Exception 
	 * 			→インデックス取得中に例外を投げてる**/
	
	public RoomBean getRoom(String roomId) throws Exception {
		int i = roomIndex(roomId); 
		return rooms[i] ;
	}
	
	/**===============================================================**/
	/** 会議室予約システムにログインしている利用者を取得
	 * @param なし
	 * @return UserBean **/
	
	public LoginUserBean getUser() {
		return LoginUser;
	}
	
	/**===============================================================**/
	/** 利用日取得
	 * @param なし
	 * @return String **/
	
	public String getDate() {
		return date;
	}
	
	/**===============================================================**/
	/** 利用日設定
	 * @param date
	 * @return なし **/
	
	public void setDate(String date) {
		this.date = date;
	}
	
	/**===============================================================**/
	/** 認証機能
	 * 　→利用者情報を取得し、フィールドに設定する
	 * @param なし
	 * @return Boolean (成功時にtureを返す) **/
	
	public Boolean login(String id, String password) {
		LoginUserBean loginUser = UserDao.certificate(id, password);
		
		if(loginUser != null) {
			this.LoginUser = loginUser;
			return true;			
		}
		
		return false;
		
	}
	
	/**===============================================================**/
	/** 会議室予約システムの利用日における利用状況を取得
	 * 　→予約リストを二次元配列で取得し、予約がなければnullを返す
	 * @param なし
	 * @return ReservationBean[][] **/
	
	public ReservationBean[][] getReservations(){
		
		//ReservationBean[][]を生成
		ReservationBean[][] reservations = new ReservationBean[rooms.length][PERIOD.length];
		
		//→配列に入れる予約リストの取得
		//（初期値はthis.dateの予約情報）
		List<ReservationBean> list = ReservationDao.findByDate(this.date);

		//Listの中身をReservationBean[][]の二次元配列に入れる
		//startPeriod(), roomIndex()の例外はtry-catch
		//listがnullの場合は処理をスキップ
		if (list != null) {
			try {
			for(ReservationBean rb : list) {
				int periodIndex = startPeriod(rb.getStart());
				int roomIndex = roomIndex(rb.getRoomId());

				reservations[roomIndex][periodIndex] = rb;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("インデックス取得中のエラー :"+ e.getMessage());
			}
		}
		
		return reservations;
	}
	
	/**===============================================================**/
	/** 予約生成機能
	 * 　→会議室IDと利用開始時間を受け取り予約情報を生成し、出力する
	 * @param roomId, start
	 * @return ReservationBean **/
	
	public ReservationBean createReservation(String roomId, String start) {

		//endを計算（start + INTERVAL:minutes）
		// 1桁の時間（"9:00"など）にも対応するためDateTimeFormatterを使用
		LocalTime startTime;
		try {
			// まず標準形式（HH:mm, HH:mm:ss）を試す
			startTime = LocalTime.parse(start);
		} catch (Exception e) {
			// 失敗した場合、H:mm形式（1桁の時間）を試す
			DateTimeFormatter flexibleFormatter = DateTimeFormatter.ofPattern("H:mm");
			startTime = LocalTime.parse(start, flexibleFormatter);
		}

	    LocalTime endTime = startTime.plusMinutes(INTERVAL);

	    //コンストラクタの引数残り
	    String end = endTime.toString();
	    
		String userId = this.LoginUser.getId();
		String date = this.date;

        //予約情報の生成
		ReservationBean rb = new ReservationBean(roomId, date, start, end, userId);
		return rb;

	}


	/**===============================================================**/
	/** 予約登録機能
	 * 　→現在時刻を取得し、利用時間チェックを行う
	 * 　　利用時間が過ぎている場合、すでに予約されている場合は例外を出す。
	 * 
	 * @param resavation
	 * @return なし 
	 * @throws TimePassedException（予約時間が過去）,
				AlreadyReservedException（既に予約あり）,
	 			ReservationFailedException（データベースに登録できない）
	  **/
	
	public void reserve(ReservationBean reservation) {
		
		//現在日時の取得
		LocalDateTime currentTime = LocalDateTime.now();
		
		//予約日時取得→reservation.getDate(), reservation.getStart()
		String reservationDate = reservation.getDate(); //String
		String start = reservation.getStart(); //String
		
		// 時刻を2桁形式に変換してからLocalDateTimeへ変換する
		LocalTime startTime;
		try {
			// まず標準形式（HH:mm, HH:mm:ss）を試す
			startTime = LocalTime.parse(start);
		} catch (Exception e) {
			// 失敗した場合、H:mm形式（1桁の時間）を試す
			DateTimeFormatter flexibleFormatter = DateTimeFormatter.ofPattern("H:mm");
			startTime = LocalTime.parse(start, flexibleFormatter);
		}

		// LocalDateTimeを作成
		LocalDate date = LocalDate.parse(reservationDate);
		LocalDateTime reservationDateTime = LocalDateTime.of(date, startTime);

        //日時の比較(予約時刻が過去の場合に例外)
		if(currentTime.isAfter(reservationDateTime)) {
			throw new AppException.TimePassedException("予約時間がすぎています。");
		}
		
		//既に予約されている場合の確認(予約があれば例外)
		ReservationBean[][] reservations = getReservations();
		
		//roomIndex()とstartPeriod()の例外はここでcatchする
		try {
		
			int roomIndex = roomIndex(reservation.getRoomId());
			int periodIndex = startPeriod(reservation.getStart());
	
		
			if(reservations[roomIndex][periodIndex] != null) {
				throw new AlreadyReservedException("既に予約されています。");
			}
		}catch(Exception e) {
			System.out.println("インデックス取得中のエラー："+e.getMessage());
		}
		
		//確認がOKだったらデータベースに登録(登録できなければ例外)
		
		//ReservationDaoにinsertメソッド入れてもらう
		boolean result = ReservationDao.insert(reservation);
	      if(!result) {
	          throw new ReservationFailedException("予約の登録に失敗しました。");
	      }
	}
	
	/**===============================================================**/
	/** 予約キャンセル
	 *
	 * 　→会議室IDと開始時刻から既存の予約を取得し、キャンセル処理を行う
	 * 　　現在時刻を取得し、キャンセル時間チェックを行う
	 * 　　キャンセル時間が過ぎている場合、すでにキャンセルできない場合は、例外を出す
	 * @param reservation
	 * @return なし
	 * @throws　TimePassedException（予約時間過ぎてキャンセル不可）,
				UnauthorizedCancelException（自分の予約ではない）,
				CancelFailedException（データベースにキャンセル登録できなかった）
	 *
	 * **/

	public void cancel(ReservationBean reservation) {

		//引数のreservationからroomIdとstartを取得
		String roomId = reservation.getRoomId();
		String start = reservation.getStart();

		//既存の予約を取得
		ReservationBean existingReservation = null;
		try {
			ReservationBean[][] reservations = getReservations();
			int roomIndex = roomIndex(roomId);
			int periodIndex = startPeriod(start);
			existingReservation = reservations[roomIndex][periodIndex];
		} catch (Exception e) {
			throw new AppException.CancelFailedException("予約情報の取得に失敗しました。");
		}

		//予約が存在しない場合→getReservationのなかのfindByDateで
		//予約がなければnullを返す設計になってるのでぬるぽ対策（ユニットテストより）
		if(existingReservation == null) {
			throw new AppException.CancelFailedException("予約が見つかりません。");
		}

		//現在日時の取得
		LocalDateTime currentTime = LocalDateTime.now();
		//予約日時取得→existingReservation.getDate(), existingReservation.getStart()
		String date = existingReservation.getDate(); //String""
		String reservationStart = existingReservation.getStart();//String

		// 時刻を2桁形式に変換してからLocalDateTimeへ変換する
		LocalTime startTime;
		try {
			// まず標準形式（HH:mm, HH:mm:ss）を試す
			startTime = LocalTime.parse(reservationStart);
		} catch (Exception e) {
			// 失敗した場合、H:mm形式（1桁の時間）を試す
			DateTimeFormatter flexibleFormatter = DateTimeFormatter.ofPattern("H:mm");
			startTime = LocalTime.parse(reservationStart, flexibleFormatter);
		}

		// LocalDateTimeを作成
		LocalDate reservationDate = LocalDate.parse(date);
		LocalDateTime reservationDateTime = LocalDateTime.of(reservationDate, startTime);

		 //キャンセル時刻が過ぎている場合（開始時間が過ぎた場合）
	     if(currentTime.isAfter(reservationDateTime)) {
	          throw new AppException.TimePassedException("予約開始時刻を過ぎているためキャンセルできません。");
	      }

	     //予約者のみがキャンセルできるようにする
	     if(!this.LoginUser.getId().equals(existingReservation.getUserId())) {
	          throw new AppException.UnauthorizedCancelException("自分の予約のみキャンセルできます。");
	      }

	     //確認がOKだったらキャンセル
	     //reservationDaoにdeleteいれてもらう
	     boolean result = ReservationDao.delete(existingReservation);

	     if(!result) {
	          throw new AppException.CancelFailedException("予約のキャンセルに失敗しました。");
	      }

	}

	/** デバック用のtoStringメソッド ===================================**/
	
	  @Override
	  public String toString() {
	      return "MeetingRoom ["+"\n" 
	      		+ "date=" + date + "\n" +
	      		", INTERVAL=" + INTERVAL + "\n" +
//	      		配列を文字で出力
	      		", PERIOD=" + java.util.Arrays.toString(PERIOD) + "\n" +
	      		", rooms=" + java.util.Arrays.toString(rooms) + "\n" +
	      		", user=" + LoginUser + "\n" +
	      		"]";
	  }

		
	  /**===============================================================**/
			}
	