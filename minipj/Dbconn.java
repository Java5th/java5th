package minipj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {//DB연결하는 클래스
	private static Connection dbconn = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##hr";
		String pw = "hr";
		
		Class.forName("oracle.jdbc.OracleDriver");
		dbconn = DriverManager.getConnection(url, id, pw);
		
		return dbconn;
		
	}
}
