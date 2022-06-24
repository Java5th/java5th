package sqlproject2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class exam {
		public static void main(String[] args) {
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String id = "c##hr";
			String pw = "hr";
			Scanner sc = new Scanner(System.in);
			Connection conn = null;
			PreparedStatement ps = null;
			Statement stat = null;
			ResultSet rs = null;
	
			
			try {
			System.out.println("드라이버 로드중...\n\n");
			System.out.println("-----------------------");
			System.out.println("|데이터베이스에 접속했습니다.|");
			System.out.println("-----------------------\n\n");
			
			
//			System.out.printf("이름 %s", rs.getString(1));
			
			 Scanner scan= new Scanner(System.in);
		        System.out.print("검색하고 싶은 사원 이름을 입력하세요>>");
		        String name =scan.nextLine();
		       

		    Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT first_name||' '||last_name, to_char(hire_date, 'yyyy\"년 \"mm\"월 \"dd\"일 \"'), to_char(hire_date, 'yyyy'),salary, 12*salary from employees "
	    			+ "where first_name= ?" + "order by hire_date";
				
			ps = conn.prepareStatement(sql);
	    	ps.setString(1, name);
	    	stat = conn.createStatement();
	    	rs = ps.executeQuery();

			while(rs.next()) {
				try {
				double ss5 =rs.getInt(5);
				int cw = 2008-rs.getInt(3);
				double rate = 0.03;
		

				boolean result = true;
				System.out.printf("이름 %s, 입사일 %s, 월급 %s, 연봉 %s", rs.getString(1), rs.getString(2), rs.getInt(4),rs.getInt(5));
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
					System.out.printf("\n인상된 연봉 %s\n", Math.round(ss5*100)/100.0);	
				}
				
				}catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				}
			}
			}
			catch (Exception e) {			
				System.out.println(e.getMessage());		}	
	    	
			    finally {
				    	try {
							rs.close();
							ps.close();
							conn.close();
				    	} catch(Exception e) {
				    		System.out.println(e.getMessage());
				    	}
				}
			}
}	
	
	
	
			
//			
//			rs = stat.executeQuery
//			("SELECT first_name||' '||last_name as Name, to_char(hire_date, 'yyyy\"년 \"mm\"월 \"dd\"일 \"') as Hire, to_char(hire_date, 'yyyy'), salary, 12*salary from employees order by hire_date");
//			while(rs.next()) {
//				String ss1 = rs.getString(1);
//				String ss2 = rs.getString(2);
//				int ss3 = rs.getInt(3);
//				double ss4 =rs.getInt(4);
//				double ss5 =rs.getInt(5);
//				int cw = 2008-ss3;
//				double rate = 0.03;
//				double salary = ss5;
//				boolean result = true;
//				
//				System.out.printf("이름 %s, 입사일 %s, 월급 %s, 연봉 %s", ss1 ,ss2 ,ss4 ,ss5);
//				for(int i =0; i<=cw; i++) {
//					salary = salary+(salary*rate); 
//					if(cw == 0) {
//						System.out.printf("\n연봉 동결 %s\n", ss5);
//						result = false;
//						break;
//					}else if (i >= 1) {
//					}else if(i==cw) {
//						break;
//					}
//				}
//				if (result) {
//					System.out.printf("\n인상된 연봉 %s\n", Math.round(salary*100)/100.0);	
//				}
				
				
//				 PreparedStatement pstmt = null;                   
//				 System.out.println("검색하고 싶은 사원 이름을 입력하세요>>");         
//				 String searchname = sc.nextLine();
//				
//				 String sqlSelect = "select first_name||' '||last_name as Name employees";                  
//				 pstmt = conn.prepareStatement(sqlSelect);         
//				 pstmt.setString(1, searchname);                  
//				 ResultSet rs1 = pstmt.executeQuery();
//			
//				 if (rs1.equals(searchname)) {
//					 System.out.println("검색 결과 X");
//				 }else {
//					 System.out.printf("이름 %s, 입사일 %s, 월급 %s, 연봉 %s, \\n인상된 연봉 %s\\n", ss1 ,ss2 ,ss4 ,ss5 ,Math.round(salary*100)/100.0);
//				 }

//		public static void Serach(Scanner scan, Statement stat) {
//			System.out.println("검색하고 싶은 사원 이름을 입력하세요>>");         
//			String searchname = sc.nextLine();
//			ResultSet rs = null;
//			try {
//	            rs = stat.executeQuery("SELECT first_name||' '||last_name as Name, to_char(hire_date, 'yyyy\\\"년 \\\"mm\\\"월 \\\"dd\\\"일 \\\"') as Hire, to_char(hire_date, 'yyyy'), salary, 12*salary from employees order by hire_date");
//	            rs.next();
//	            System.out.printf("이름 %s, 입사일 %s, 월급 %s, 연봉 %s", rs.getString(1) ,rs.getString(2) ,rs.getString(4) ,rs.getString(5) );
//		} catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//		}
		

