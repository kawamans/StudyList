package DAO_Delete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatebaseConnectonProvider implements DatabaseConfig {
	
	private DatebaseConnectonProvider() {}
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("ドライバが見つかりません。");
			return null;
		}
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	} 
}
