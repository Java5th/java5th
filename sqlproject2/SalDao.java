package sqlproject2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




	public class SalDao {
    private Connection conn;
	int selectNum;
	Scanner sc = new Scanner(System.in);
	
	
    public Connection connect() throws Exception {
    	conn = DBconn.getConnection();
		System.out.println("드라이버 로드중...\n\n");
		System.out.println("-----------------------");
		System.out.println("|데이터베이스에 접속했습니다.|");
		System.out.println("-----------------------\n\n");
		return conn;
    }
    
    
    
    public void close() {
		System.out.println("시스템을 종료합니다.");
		 System.exit(0);
    }
    
    
    public void PrintName() throws SQLException {
		Statement stat = null;
		ResultSet rs = null;
		
		stat = conn.createStatement();
		rs = stat.executeQuery("SELECT first_name|| ' '|| last_name from Test05");
		
		try {
	    	while(rs.next()) {
	    		String ss1 = rs.getString(1);
	    		System.out.printf("이름 : %s\n", rs.getString(1));
	    	}
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
    }
    
    
    public void Calculate() {
    	PreparedStatement ps = null;
		Statement stat = null;
		ResultSet rs = null;
		
		
		try {  
			 
		Scanner scan= new Scanner(System.in);
	        System.out.print("검색하고 싶은 사원 이름을 입력하세요>>");
	        String name =scan.nextLine();
    	
	   
	        
    	String sql = "SELECT first_name||' '||last_name, to_char(hire_date, 'yyyy\"년 \"mm\"월 \"dd\"일 \"'), to_char(hire_date, 'yyyy'),salary, 12*salary, employee_id from Test05 "
    			+ "where first_name= ?" + "order by hire_date";
			
		ps = conn.prepareStatement(sql);
    	ps.setString(1, name);
    	stat = conn.createStatement();
    	rs = ps.executeQuery();

		while(rs.next()) {
			
				double ss5 =rs.getInt(5);
				int cw = 2008-rs.getInt(3);
				double rate = 0.03;
		
	
				boolean result = true;
				System.out.printf("사원 번호 : %s 이름 : %s, 입사일 : %s, 월급 : %s, 연봉 : %s", rs.getString(6), rs.getString(1), rs.getString(2), rs.getInt(4),rs.getInt(5));
				for(int i =0; i<=cw; i++) {
					ss5 = ss5+(ss5*rate); 
					if(cw == 0) {
						System.out.printf("\n연봉 동결 %s\n", rs.getInt(5));
						result = false;
						break;
					}else if (i >= 1) {
					}else if(i==cw) {
						break;
					}
				}
			if (result) {
				System.out.printf("\n인상된 연봉 : %s\n", Math.round(ss5*100)/100.0);	
			}
		
		}
			}catch (SQLException e) {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}
		
		
	
	
    public void update(Sal sal) {
    	try {
    	
    	System.out.println("변경할 직원 번호를 입력하세요>>");
		sal.employee_id = sc.nextInt();
		System.out.print("수정할 First name 입력 >>");
		sal.first_name = sc.next();
		System.out.print("수정할 Last name 입력 >>");
		sal.last_name = sc.next();
		System.out.print("수정할 월급 입력 >>");
		sal.salary = sc.nextInt();
		System.out.print("수정할 입사일 입력 >>");
		sal.hire_date = sc.next();
    	PreparedStatement ps = null;
    	String sql = "Update Test05 " + 
    			"set first_name = ?, last_name = ?, salary = ?, hire_date = ?" + 
    			"where employee_id =?";
    	
		ps = conn.prepareStatement(sql);
		
	
    	ps.setString(1, sal.first_name);
    	ps.setString(2, sal.last_name);
    	ps.setInt(3, sal.salary);
    	ps.setString(4, sal.hire_date);
    	ps.setInt(5, sal.employee_id);
    	System.out.println("수정되었습니다.");
    } catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("잘못된 입력입니다. 다시 입력해주세요");
	}
    	
    }
    
    
    
   
    public void remove(Sal sal) {
    	try {
    	System.out.println("삭제할 직원 번호를 입력하세요>>");
		sal.employee_id = sc.nextInt();	
    		
    	PreparedStatement ps = null;
    	String sql = "delete from Test05 where employee_id = ?";
    	ps = conn.prepareStatement(sql);
		ps.setInt(1, sal.employee_id);
		
    	System.out.println("삭제되었습니다.");
    	} catch (Exception e) {
    		System.out.println("잘못된 입력입니다. 다시 입력해주세요");
		}
    	
    }
    
    public ArrayList<Sal> lists() throws SQLException {
    	ResultSet rs = null;
    	Statement stat = conn.createStatement();
    	rs = stat.executeQuery("select * from Test04");
    	ArrayList<Sal> list = new ArrayList<Sal>();
    	while(rs.next()) {
    		String first_name =rs.getString("first_name");
    		String last_name =rs.getString("last_name");
    		int salary =rs.getInt("salary");
    		String hire_date=rs.getString("hire_date");
    		list.add(new Sal(first_name, last_name, salary, hire_date));
    	}
		return lists();
    	
    }
    
    
    public void menu() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("메뉴출력");
		System.out.println("------");
		System.out.println("1. 사원 이름 출력 | 2. 사원 연봉 출력 | 3. 사용자 정보 수정 | 4. 사용자 정보 삭제 | 5. 종료");
		System.out.print("입력>>");
		int num =sc.nextInt();
    }

    
    
}
    