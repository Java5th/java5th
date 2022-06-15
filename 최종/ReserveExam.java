package miniproject2;

import java.io.IOException;

public class ReserveExam {
	public static void main(String[] args) throws InterruptedException, IOException {
		Ab ab = new Ab();
		ab.st();
	}
}
	
	class Ab{
		LogIn log = new LogIn();
		SelectMovie sm = new SelectMovie();
		Close close = new Close();
//		String[][] seat = new String [5][5];	
		
		void st() throws InterruptedException, IOException {
	//	String[][] seat = new String [5][5];	
	//		ReserveTic rt = new ReserveTic(seat);	
//			sm.rt.resetSeat(sm.seat);
			log.logIn();
			sm.selectMovie();
		}
	}

