package miniproject3;

import java.io.IOException;

public interface ReserveMovie {
	String id [] = {"sung" , "jang", "jeonog"};
	String password = "1234";
	
	public void logIn(); 
	public void selectMovie() throws InterruptedException, IOException;
	public void reserveTicket() throws InterruptedException, IOException; 
	public void cancleTicket(); 
	public void checkSeat() throws InterruptedException, IOException; 
	public void close(); 
	
}
