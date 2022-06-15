package miniproject3;

import java.io.IOException;

public class ReserveExam {
	static String seat[][] = new String [5][5];
	
	public static void main(String[] args) throws InterruptedException, IOException {
	LogIn log = new LogIn();
	ReserveTic rt = new ReserveTic();
	SelectMovie sm = new SelectMovie();
	log.logIn();
	sm.selectMovie();
	rt.resetSeat();
	rt.reserveTicket();
	}
}

