package jp.co.seminar.bean;

/**
 * @author 猪本 川満
 */
public class AppException extends RuntimeException {
	/**コンストラクタ =============================================================**/
	public AppException(String message) {
        super(message);
    }
	
	/** 基本要求の例外==============================================================**/

	/** 予約時間が過ぎている場合の例外 */
	public static class TimePassedException extends AppException {
		private static final long serialVersionUID = 1L;
		public TimePassedException(String message) {
			super(message);
		}
	}

	/** 既に予約されている場合の例外 */
	public static class AlreadyReservedException extends AppException {
		private static final long serialVersionUID = 1L;
		public AlreadyReservedException(String message) {
			super(message);
		}
	}

	/** 予約登録に失敗した場合の例外 */
	public static class ReservationFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public ReservationFailedException(String message) {
			super(message);
		}
	}

	/** キャンセル権限がない場合の例外 */
	public static class UnauthorizedCancelException extends AppException {
		private static final long serialVersionUID = 1L;
		public UnauthorizedCancelException(String message) {
			super(message);
		}
	}

	/** キャンセルに失敗した場合の例外 */
	public static class CancelFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public CancelFailedException(String message) {
			super(message);
		}
	}



	/**追加要件の例外==============================================================**/
	
	/** 存在しないuserへの処理の場合の例外 */
	public static class NonExistentUserException extends AppException {
		private static final long serialVersionUID = 1L;
		public NonExistentUserException(String message) {
			super(message);
		}
	}
	
	/** user規登録例外 */
	public static class AlreadyRegisteredUserException extends AppException {
		private static final long serialVersionUID = 1L;
		public AlreadyRegisteredUserException(String message) {
			super(message);
		}
	}
	
	/** user登録処理に失敗した場合の例外 */
	public static class InsertUserFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public InsertUserFailedException(String message) {
			super(message);
		}
	}
	
	/** user変更処理に失敗した場合の例外 */
	public static class UpdateUserFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public UpdateUserFailedException(String message) {
			super(message);
		}
	}
	
	/** user管理人人数確認の場合の例外 */
	public static class LogicalDeleteAdminException extends AppException {
		private static final long serialVersionUID = 1L;
		public LogicalDeleteAdminException(String message) {
			super(message);
		}
	}
	
	/** user論理削除処理に失敗した場合の例外 */
	public static class LogicalDeleteUserFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public LogicalDeleteUserFailedException(String message) {
			super(message);
		}
	}
	
	/** 存在しないroomへの処理の場合の例外 */
	public static class NonExistentRoomException extends AppException {
		private static final long serialVersionUID = 1L;
		public NonExistentRoomException(String message) {
			super(message);
		}
	}
	
	/** room規登録例外 */
	public static class AlreadyRegisteredRoomException extends AppException {
		private static final long serialVersionUID = 1L;
		public AlreadyRegisteredRoomException(String message) {
			super(message);
		}
	}
	
	/** room登録処理に失敗した場合の例外 */
	public static class InsertRoomFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public InsertRoomFailedException(String message) {
			super(message);
		}
	}
	
	/** room変更処理に失敗した場合の例外 */
	public static class UpdateRoomFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public UpdateRoomFailedException(String message) {
			super(message);
		}
	}
	
	
	/** room削除処理に失敗した場合の例外 */
	public static class DeleteRoomFailedException extends AppException {
		private static final long serialVersionUID = 1L;
		public DeleteRoomFailedException(String message) {
			super(message);
		}
	}
	
}
