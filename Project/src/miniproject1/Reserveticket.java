package miniproject1;

public class Reserveticket implements ReserveMovie{
	int row, col, selectNum;
	Scanner scan = new Scanner(System.in);
	String userId;
	String userPw;
	String[][] seat = new String[5][5];

	@Override
	public void LogIn(String id,int password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReserveTicket() throws InterruptedException, IOException {
        while(true) {

                while(true) {
                    try {
                        System.out.println("행을 입력하세요(max:5)");
                        row = scan.nextInt();
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        scan = new Scanner(System.in);
                        System.out.println("최대 5까지 입력하시길 바랍니다.");
                    }
                    if(!(this.row>5)){
                        break;
                    } else{
                        System.out.println("에러: 행과 열은 최대 5까지입니다.");
                    }
                }

                while(true) {
                    try {
                        System.out.println("열을 입력하세요(max:5)");
                        col = scan.nextInt();
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException f) {
                        f.printStackTrace();
                        scan = new Scanner(System.in);
                        System.out.println("최대 5까지 입력하시길 바랍니다.");
                    }
                    if (!(col>5)){
                        break;
                    } else {
                        System.out.println("에러: 행과 열은 최대 5까지입니다.");
                    }
                }
            break;
        }
        if(seat[row][col].equals("___")){
            seat[row-1][col-1] = userId;
            System.out.println((row)+"행"+(col)+"열 좌석이 예약되었습니다.");
            cinemaPrint();
            cinemaSeatQuery();
        } else{
            System.out.println("이미 예약된 좌석입니다");
        }

    }

	@Override
	public void CancleTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CheckSeat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
	}

}
