package miniproject1;

public class Reserveticket implements ReserveMovie{

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
    int row, col;
    Scanner scan = new Scanner(System.in);
    String[][] seat = new String[5][5];

    public void resetSeat() {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                seat[i][j] = "___";
            }
        }
    }

    public void reserveTicket() throws IOException, InterruptedException {
        while (true) {
            try {
                System.out.println("행을 입력하세요(max:5)");
                row = scan.nextInt();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                scan = new Scanner(System.in);
                System.out.println("최대 5까지 입력하시길 바랍니다.");
            }
            if (!(this.row > 5)) {
                break;
            } else {
                System.out.println("에러: 행과 열은 최대 5까지입니다.");
            }
        }
        while (true) {
            try {
                System.out.println("열을 입력하세요(max:5)");
                col = scan.nextInt();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException f) {
                f.printStackTrace();
                scan = new Scanner(System.in);
                System.out.println("최대 5까지 입력하시길 바랍니다.");
            }
            if (!(this.col > 5)) {
                break;
            } else {
                System.out.println("에러: 행과 열은 최대 5까지입니다.");
            }
        }
        if ((seat[row-1][col-1]).equals("___")) {
//            seat[row-1][col-1] = pi.getUserID();
            seat[row-1][col-1] = "000";
//            setReservationNumber();
            System.out.println("Reservation Number: +\r\n"+(row) + "행" + (col) + "열 좌석이 예약되었습니다.");
            cinemaSeatQuery();
        } else {
            System.out.println("이미 예약된 좌석입니다");
            cinemaSeatQuery();
        }
    }
    public void cinemaSeatQuery() throws InterruptedException, IOException {
        CinemaReserve rv = new CinemaReserve();
        char row = 'A';
        for(int i=0; i<5; i++){
            System.out.print(row +" Line: ");row++;
            for(int j=0; j<5; j++){
                String seat = (this.seat[i][j].equals("___"))? "◻": "◼";
                System.out.print((j+1)+seat +"  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);
        rv.controller();
        rv.selectNum();
        rv.select();

    }

}
	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
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


}
