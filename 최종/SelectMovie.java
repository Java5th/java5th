package miniproject2;

import java.io.IOException;
import java.util.Scanner;

import miniproject1.ReserveTic;



public class SelectMovie implements ReserveMovie{
	Scanner scan = new Scanner(System.in);
	Reserveticket rt = new Reserveticket();
	Movie mv = new Movie();
	String[][] seat = new String[5][5];
	
	boolean movieChartMenu = true;
	boolean startMenu = true;
	int select = 0;	
	

	public void selectMovie() throws InterruptedException, IOException {
			//예매하기 메뉴
			System.out.println("------------------");
			System.out.println("1.예매하기  | 2.예매상태 확인 | 3.예매 취소 | 4. 로그인으로 돌아가기 | 5. 종료");
			System.out.println("------------------");
			System.out.print("번호 입력>>");
			select = scan.nextInt();
			switch (select) {
				case 1:
					select();
					rt.resetSeat(seat);
//					rt.resetSeat2(seat);					
//					seat = rt.reserveTicket(seat);
					rt.reserveTicket(seat);
					System.out.println("***"+seat[1][1]);					
					selectMovie();
					break;
				case 2://
					rt.checkSeat(seat);
					selectMovie();
					break;
				case 3:
					rt.cinemaCancel(seat);
					selectMovie();
					break;
				case 4:
					LogIn login = new LogIn();
					login.logIn();
					break;
				case 5 :
					Close close= new Close();
					close.close();
					break;
				default:
					mv.selectError();
					break;
			}				
	}	
	public void select() {
		while (movieChartMenu) {
			boolean reservTimeMenu = true;
			mv.movieChart();
			mv.selectMenu();
			select = scan.nextInt();
	
			if (select < 5) {
				while (reservTimeMenu) {
				mv.reservDate();
				mv.selectMenu();
				select = scan.nextInt();
					if (select < 5) {
						mv.reservTime(mv.time);
						mv.selectMenu();
						select = scan.nextInt();
						if(select !=5) {
							reservTimeMenu = false;
							movieChartMenu = false;
							startMenu =false;
	//						System.out.println("------------------");
	//						System.out.println("<<좌석선택>>");
							break;
	//						ReserveExam re = new ReserveExam();
	//						ab.rt.start();
						}else if(select > 5){
							mv.selectError();
						}
					} else if (select == 5) {
						reservTimeMenu = false;							
					} else if (select > 5) {
						mv.selectError();
						break;						
					}
				}
				
			} else if (select == 5) {
				movieChartMenu = false;
			} else if (select > 5) {
				mv.selectError();
			}
				
		}	
	}
	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[][] reserveTicket(String[][] seat) throws InterruptedException, IOException {
		return seat;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cancleTicket(String[][] seat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void checkSeat(String[][] seat) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}