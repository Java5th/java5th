package miniproject2;

import java.io.IOException;

public class Close implements ReserveMovie{

	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectMovie() {
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
	public void close() {
		System.out.println("시스템을 종료합니다.");
		 System.exit(0);
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkSeat(String[][] seat) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	}

}
