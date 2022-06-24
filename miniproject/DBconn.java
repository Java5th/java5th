package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	private static Connection dbconn = null;
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##hr";
		String pw = "hr";
		
		Class.forName("oracle.jdbc.OracleDriver");
		dbconn = DriverManager.getConnection(url ,id, pw);
		
		return dbconn;
		
	}
	
}
