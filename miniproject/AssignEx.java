package miniproject;

public class AssignEx {
	public static void main(String[] args) throws Exception {
		AssignDao ad = new AssignDao();
		Assign assign = new Assign();
		ad.connect();
		ad.getAllData(0, 0, null, null, 0);
		
	}
	
}
