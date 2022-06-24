package minipj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDao {
	private Connection conn;

	public Connection connect() throws ClassNotFoundException, SQLException {
		conn = Dbconn.getConnection();
		return conn;
	}

	public int insert(Emp emp) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement("insert into empinfo(emp_id,name,hire_date,job_id,email) values(?,?,?,?,?)");
		ps.setInt(1, emp.empId);
		ps.setString(2, emp.name);
		ps.setString(3, emp.hireDate);
		ps.setString(4, emp.jobId);
		ps.setString(5, emp.email);
		int res = ps.executeUpdate();
		return res;
	}

	public int update(Emp emp) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement("update empinfo set email = ? where emp_id = ?");
		ps.setString(1, emp.email);
		ps.setInt(2, emp.empId);
		int res = ps.executeUpdate();
		return res;
	}

	public Emp search(int inputEmpId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
 		ps = conn.prepareStatement("select * from empinfo where emp_id = ?");
		ps.setInt(1, inputEmpId);
		rs = ps.executeQuery();
		rs.next();
		int empId = rs.getInt("emp_id");
		String name = rs.getString("name");
		String hireDate = rs.getString("hire_date");
		String jobId = rs.getString("job_id");
		String email = rs.getString("email");
		return new Emp(empId,name,hireDate,jobId,email);
		
	}

	public int delete(Emp emp) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement("delete from empinfo where emp_id = ?");
		ps.setInt(1,emp.empId);
		int res = ps.executeUpdate();
		return res;
	}
}
