package miniproject2;

import java.io.IOException;

public interface ReserveMovie {
	String id [] = {"sung" , "jang", "jeonog"};
	String password = "1234";
	
	public void logIn(); 
	public void selectMovie() throws InterruptedException, IOException; 	
	public String[][] reserveTicket(String[][] seat) throws InterruptedException, IOException; 
	public void cancleTicket(String[][] seat); 
	public void checkSeat(String[][] seat) throws InterruptedException, IOException; 
	public void close(); 
	
}
