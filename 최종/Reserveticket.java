package miniproject2;

//package miniproject1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Reserveticket implements ReserveMovie{

    int row, col, selectNum;
    Scanner scan = new Scanner(System.in);
//    String[][] seat = new String[5][5];
    CinemaPersonalInfo cpi = new CinemaPersonalInfo();


//    public void start() throws InterruptedException, IOException {
////        System.out.println("---------------------------------");
////        System.out.println("|     MOVIE RESERVATION SYSTEM   |");
////        System.out.println("|                                |");
////        System.out.println("---------------------------------");
//        resetSeat();
////        controller();
////        selectNum();
////        select();
//        reserveTicket();
////      controller();
////      selectNum();
////      select();			
//    }
    public void resetSeat(String[][] seat) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){               
            	   seat[i][j] = "___";               
            }
        }
    }
    public void resetSeat2(String[][] seat) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
               if(!(seat[i][j].equals(("___")))) {
            	   seat[i][j]="reserved";            	   
               }else {
            	   seat[i][j] = "___";            	               	   
               }
            }
        }
    }
//    public void controller(){
//        System.out.println("\n1.좌석선택 | 2.예매 확인  | 3.로그인으로 돌아가기  | 4.종료  | 5.예매 취소");
//        System.out.print("번호 입력>>\r\n");
//    }
    public void selectNum(){
        while(true){
            while(true){
                try{
                    selectNum=scan.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    e.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("잘못입력하셨습니다. 숫자를 입력하세요");
//                    controller();
                }
            }
            if( !(this.selectNum >= 6) && !(this.selectNum<=0)){
                break;

            } else{
                System.out.println("잘못입력하셨습니다. 1번부터 5번까지의 숫자를 입력하세요.");
//                controller();
            }
        }
    }
//    public void select() throws InterruptedException, IOException {
//        switch(selectNum){
//            case 1:
//            	reserveTicket();
//                controller();
//                selectNum();
//                select();
//                break;
//            case 2:                
//                checkSeat();
//                controller();
//                selectNum();
//                select();
//                break;
//            case 3:
//                LogIn login = new LogIn();
//        		login.logIn();
//				break;
//            case 4:
//            	close();
//                break;            	
//            case 5:                
//                cinemaCancel();
//                controller();
//                selectNum();
//                select();
//                break;
//            default:
//        }
//   
//    }

    public String[][] reserveTicket(String[][] seat) throws IOException, InterruptedException {
        while(true) {
            while (true) {
                try {
                    System.out.println("행을 입력하세요(max:5)");
                    row = scan.nextInt();
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("최대 5까지 입력하시길 바랍니다.");
                }
                if ((this.row <= 5 && this.row > 0)) {
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
                if ((this.col <= 5 && this.col > 0)) {
                    break;
                } else {
                    System.out.println("에러: 행과 열은 최대 5까지입니다.");
                }
            }
            if ((seat[row - 1][col - 1]).equals("___")) {
                //            seat[row-1][col-1] = pi.getUserID();
                seat[row - 1][col - 1] = "reserved";
                setReservationNumber();
                System.out.println("Reservation Number: " + cpi.getReservationNumber() + "\r\n" + (row) + "행" + (col) + "열 좌석이 예약되었습니다.");
                cinemaPrint();
                break;
            } else {
                System.out.println("이미 예약된 좌석입니다");
                checkSeat(seat);
            }
            
        }
        return seat;
    }
    @Override
    public void checkSeat(String[][] seat) throws InterruptedException, IOException {
        char row = 'A';
        for(int i=0; i<5; i++){
            System.out.print(row +" Line: ");row++;
            for(int j=0; j<5; j++){            	
                String seat2 = (seat[i][j].equals("___"))? "X": "O";
                System.out.print((j+1)+seat2 +"  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);
    }
    public void cinemaCancel(String[][] seat) {
        while(true){
            try{
                System.out.println("예매 번호를 입력하세요.");
                cpi.setReservationNumber(scan.nextInt());
                seat[row-1][col-1] = "___";
                System.out.print(System.lineSeparator());
                System.out.println("예매가 취소되었습니다.");
            } catch (InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("없는 예매번호입니다. 다시 입력해주세요.");
            }
            if(!(cpi.getReservationNumber()<100000 | cpi.getReservationNumber()>=1000000)){
                break;
            } else{
                System.out.println("없는 예매번호입니다. 다시 입력해주세요(6자리).");
            }
        }

    }
    public void cinemaPrint() throws IOException, InterruptedException {
        System.out.println("예약내용을 출력하시려면 yes를 입력하세요");
        String printCheck = scan.next();
        if (printCheck.equals("yes")) {
            LocalDateTime curDateTime = LocalDateTime.now();
            LocalDate now = LocalDate.now();
            File file = new File("C:/Users/user/Desktop/" + cpi.getUserID() + cpi.getReservationNumber() + "cinemaPrint.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("=================================================\r\n");
            fw.write("<Movie Ticket >\r\n");
            fw.write(" Moive : " + "XXX" + "\r\n");
            fw.write(" ID : " + cpi.getUserID() + "\r\n");
            fw.write(" PW : " + cpi.getUserPW() + "\r\n");
            fw.write(" Reservation Number : " + cpi.getReservationNumber() + "\r\n");
            fw.write(" Seat : " + (row) + "행" + (col) + "열" + "\r\n");
            fw.write("=================================================\r\n");
            fw.flush();
            fw.close();
            System.out.println(System.lineSeparator() + "파일이 저장되었습니다@@");

        }
    }
    public void setReservationNumber() {
        cpi.setReservationNumber((int) (Math.random() * 899999) + 100000);
    }
    public void cinemaQuit() {
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
	public void cancleTicket(String[][] seat) {
		// TODO Auto-generated method stub
		
	}
	
	
		
	
	@Override
	public void close() {
		System.out.println("시스템을 종료합니다.");
		 System.exit(0);
	}
}