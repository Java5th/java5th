package miniproject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignDao {
	private Connection conn;

	
	public Connection connect() throws Exception {
		conn = DBconn.getConnection();
		return conn;
	}
	
	
	public Assign getAssign(int id) throws SQLException {
		ResultSet rs =null;
		PreparedStatement ps =null;
		ps = conn.prepareStatement(
		"SELECT emp_id, depart_id, first_name, last_name, salary from Assignment where emp_id = ?");
		ps.setInt(1,  id);
		rs= ps.executeQuery();
		if(rs.next()) {
			int emp_id =rs.getInt("emp_id");
			int depart_id =rs.getInt("depart_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			int salary =rs.getInt("salary");
			Assign assign = new Assign(emp_id, depart_id, first_name, last_name, salary);
			return assign;
			
		}
		return new Assign(id, 0, "자료없음", "자료없음", 0);

	}
	
	public int insert(Assign assign) throws Exception {
		PreparedStatement ps = null;
		String sql = "insert into Assignment(emp_id, depart_id, first_name, last_name, salary) values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, assign.emp_id);
		ps.setInt(2, assign.depart_id);
		ps.setString(3, assign.first_name);
		ps.setString(4, assign.last_name);
		ps.setInt(5, assign.salary);
		int ret = ps.executeUpdate();
		return ret;
		
	
	}
	
	
	public int update(Assign assign) throws SQLException {
		PreparedStatement ps = null;
		String sql = "Update Assignment set depart_id = ?, first_name = ?, last_name = ?, salary = ? where emp_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, assign.depart_id);
		ps.setString(2, assign.first_name);
		ps.setString(3, assign.last_name);
		ps.setInt(4, assign.salary);
		ps.setInt(5, assign.emp_id);
		
		int ret = ps.executeUpdate();
		return ret;
		
	}
	
	
	public int delete(Assign assign) throws Exception {
		PreparedStatement ps = null;
		String sql = "delete from Assignment where emp_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, assign.emp_id);
		int ret = ps.executeUpdate();
		return ret;
		
		
	}
	
	public ArrayList<Assign> lists() throws SQLException {
		ResultSet rs = null;
		Statement stat = conn.createStatement();
		rs = stat.executeQuery("select * from Assignment");
		ArrayList<Assign> list =  new ArrayList<Assign>();
		while(rs.next()) {
			int emp_id =rs.getInt("emp_id");
			int depart_id =rs.getInt("depart_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			int salary =rs.getInt("salary");
			list.add(new Assign(emp_id, depart_id, first_name, 
			 last_name, salary));
		
			   }

		return list;
				
		}
	
	public void getAllData(int emp_id, int depart_id, String first_name, String last_name, int salary) throws SQLException {
		for (Assign assign : lists()) {
			System.out.printf("%d, %d, %s, %s, %d\n", assign.emp_id, assign.depart_id, assign.first_name, assign.last_name, assign.salary);
		}

	}
		

}
	
	
	
	
	
	

