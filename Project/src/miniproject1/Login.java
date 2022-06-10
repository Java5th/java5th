package miniproject1;

import java.util.Scanner;

public class Login implements ReserveMovie{
	

	@Override
	public void LogIn() {
		String id = "sung";
		String password = "1234";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("아이디를 입력해주세요 :");
			String input_id = sc.next();
			
			if (id.equals(input_id)){
				System.out.print("비밀번호를 입력해주세요 :");
				
				while(true) {
				
				String input_pass = sc.next();
				if (input_pass.equals(password)) {
					
					System.out.println("로그인 되었습니다.");
					break;
					
				}
				
				else {
					System.out.println("비밀번호가 틀렸습니다.");
					System.out.print("비밀번호를 입력해주세요 :");
					
				}
				}
			 
			}else {
				System.out.print("아이디가 틀렸습니다.");
				System.out.println();
//		
			}						
			break;
			}
			
		}
				 						
	

	@Override
	public void ReserveTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CancleTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CheckSeat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
	}

}
