package meetingroom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {
	
	private static final String POSTGERS_URL = "jdbc:postgresql://localhost:5432/meeting_room?useUnicode=true&characterEncoding=utf8";
	private static final String POSTGRES_USER = "postgres";
	private static final String POSTGRES_PASS = "postgres";
	
	private DBUtil() {
		throw new AssertionError("DBUtil not Instance");
	}
	
	public static Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(POSTGERS_URL, POSTGRES_USER, POSTGRES_PASS);
	}
	
}
