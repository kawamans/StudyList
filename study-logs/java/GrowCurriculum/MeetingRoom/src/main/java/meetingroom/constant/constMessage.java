package meetingroom.constant;

public final class constMessage {
	
	public static final String SUCCESS_LOGIN = "ログインに成功しました。";
	
	public static final String SUCCESS_INSERT_MEMBER = "ユーザー情報を登録しました。";
	public static final String SUCCESS_UPDATE_MEMBER = "ユーザー情報を更新しました。";
	public static final String SUCCESS_DELETE_MEMBER = "ユーザー情報を削除しました。";
	
	public static final String ERROR_SESSION_MEMBER = "セッションがタイムアウトしました。<br>再ログインしてください。";
	
	public static final String ERROR_UNMATCH_MEMBER_ID_PASS = "IDまたはパスワードが違います。";
	
	public static final String ERROR_EXISTS_MEMBER_ID = "IDは既に登録済みです。";
	public static final String ERROR_EXISTS_MEMBER_PASS = "パスワードは既に使用されています。";
	
	public static final String ERROR_UNKNOWN_REQUEST = "不明なリクエストが実行されました。";


	
	public static final String EXCEPTION_NO_SESSION = "セッション情報がありません。";
	public static final String EXCEPTION_ARGUMENT = "メソッドに指定外の引数が指定されている可能性があります。";
	public static final String EXCEPTION_JDBC = "JDBC関連の例外です。";
	public static final String EXCEPTION_SQL = "SQL関連の例外です";
	public static final String EXCEPTION_DB = "情報テーブルのレコードがありません";
	public static final String EXCEPTION_INDEX = "配列やList使用時のインデックスに誤りがあります";
    public static final String EXCEPTION_NULL = "nullです";
}
