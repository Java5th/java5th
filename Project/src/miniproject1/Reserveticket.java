package miniproject1;

public class Reserveticket implements ReserveMovie{
	int row, col, selectNum;
	Scanner scan = new Scanner(System.in);
	String userId;
	String userPw;
	String[][] seat = new String[5][5];
	public static void main(String[] args){
		CheckSeat();
	}

	@Override
	public void LogIn(String id,int password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReserveTicket()  {
        
    }

	@Override
	public void CancleTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CheckSeat() {
		char row = 'A';
		for(int i=0; i<5; i++){
			System.out.print(row +" Line: ");row++;
			for(int j=0; j<5; j++){
			String seat = (this.seat[i][j].equals("___"))? "◻": "◼";
			System.out.print((j+1)+seat +"  ");
			}
			System.out.print(System.lineSeparator());
			}
		TimeUnit.SECONDS.sleep(5);
		controller();
		}		
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
	}

}
