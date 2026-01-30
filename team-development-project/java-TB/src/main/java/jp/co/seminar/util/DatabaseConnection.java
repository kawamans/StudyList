package jp.co.seminar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データーベース接続
 * @author 川満 達也
 */

public class DatabaseConnection implements DatabaseConfig  {
	
	public DatabaseConnection() {}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
