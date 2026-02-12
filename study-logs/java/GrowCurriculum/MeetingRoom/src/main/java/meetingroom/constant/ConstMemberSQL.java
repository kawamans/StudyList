package meetingroom.constant;

public final class ConstMemberSQL {
	
	public static final String SELECT_BASE = "SELECT id, password, name, address, adminFlg FROM member";
	public static final String SELECT_BY_DELETE_FLG_ZERO = "WHERE deleteFlg = FALSE ORDER BY MOD(id, 100000) DESC";
	public static final String SELECT_BY_ID = "WHERE id = ? AND deleteFlg = FALSE";
	
	public static final String SELECT_LAST_ADMIN = "SELECT COUNT(*) FROM member WHERE adminflg = TRUE";
	public static final String SELECT_CREATE_ID = "SELECT id FROM member ORDER BY MOD(id, 100000) DESC LIMIT 1";
	
	public static final String INSERT_MEMBER = "INSERT INTO member (id, password, name, address, deleteFlg, adminFlg) VALUES (?, ?, ?, ?, FALSE, ?)";

	public static final String UPDATE_MEMBER = "UPDATE user SET password = ?, name = ?, address = ?, adminflg = ? WHERE id = ?";

	public static final String DELETE_MEMBER = "UPDATE user SET deleteflg = TRUE WHERE id = ?";
}
