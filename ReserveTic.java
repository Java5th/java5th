package miniproject3;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReserveTic implements ReserveMovie{
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
                System.out.println("���� �Է��ϼ���(max:5)");
                row = scan.nextInt();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                scan = new Scanner(System.in);
                System.out.println("�ִ� 5���� �Է��Ͻñ� �ٶ��ϴ�.");
            }
            if ((this.row <= 5 && this.row>0)) {
                break;
            } else {
                System.out.println("����: ��� ���� �ִ� 5�����Դϴ�.");
            }
        }
        while (true) {
            try {
                System.out.println("���� �Է��ϼ���(max:5)");
                col = scan.nextInt();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException f) {
                f.printStackTrace();
                scan = new Scanner(System.in);
                System.out.println("�ִ� 5���� �Է��Ͻñ� �ٶ��ϴ�.");
            }
            if ((this.col <= 5 && this.col>0)) {
                break;
            } else {
                System.out.println("����: ��� ���� �ִ� 5�����Դϴ�.");
            }
        }
        if ((seat[row-1][col-1]).equals("___")) {
//            seat[row-1][col-1] = pi.getUserID();
            seat[row-1][col-1] = "000";
//            setReservationNumber();
            System.out.println("Reservation Number: \r\n"+(row) + "��" + (col) + "�� �¼��� ����Ǿ����ϴ�.");
            checkSeat();
            SelectMovie sm = new SelectMovie();
            sm.selectMovie();
        } else {
            System.out.println("�̹� ����� �¼��Դϴ�");
            checkSeat();
        }
    }
    public void checkSeat() throws InterruptedException, IOException {
        char row = 'A';
        for(int i=0; i<5; i++){
            System.out.print(row +" Line: ");row++;
            for(int j=0; j<5; j++){
                String seat = (this.seat[i][j].equals("___"))? "X": "O";
                System.out.print((j+1)+seat +"  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);
    }



	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectMovie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancleTicket() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


}
