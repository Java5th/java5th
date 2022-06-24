package sqlproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArrayExam {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Connection conn = null;
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String id = "c##hr";
			String pw = "hr";
			Statement stat = null;
			ResultSet rs = null;
			List<Array> list = new ArrayList<Array>();
		
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT first_name|| ' '|| last_name as Name, last_name, salary, hire_date from Array");
			while(rs.next()) {
				String ss1 = rs.getString(1);
				String ss2 = rs.getString(2);
				int ss3 = rs.getInt(3);
				String ss4 = rs.getString(4);
				list.add(new Array(ss1,ss2,ss3,ss4));
				
			}
			for(Array cal : list) {
				System.out.println(cal.first_name);
			}
			
		}
}
