package miniproject3;

import java.io.IOException;
import java.util.Scanner;


public class SelectMovie implements ReserveMovie{
	
	private String[][] seat;
	ReserveTic rt = new ReserveTic();
	
	void selectMovie (ReserveTic rt) {
    	this.rt =rt;
    }


	public void selectMovie(String[][] seat) {
		// TODO Auto-generated constructor stub
	}


	public void selectMovie() throws InterruptedException, IOException {
		Movie mv = new Movie();
		boolean startMenu = true;
		Scanner scan = new Scanner(System.in);
		int select = 0;

		while (startMenu) {
			boolean movieChartMenu = true;

			//�����ϱ� �޴�
			System.out.println("------------------");
			System.out.println("1.�����ϱ�  | 2.������� Ȯ�� | 3.�α������� ���ư��� | 4. ����");
			System.out.println("------------------");
			System.out.print("��ȣ �Է�>>");
			select = scan.nextInt();

			switch (select) {
			case 1:
				while (movieChartMenu) {
					boolean reservTimeMenu = true;
					mv.movieChart();
					mv.selectMenu();
					select = scan.nextInt();

					if (select < 4) {
						while (reservTimeMenu) {
						mv.reservDate();
						mv.selectMenu();
						select = scan.nextInt();

							if (select < 4) {
								mv.reservTime(mv.time);
								mv.selectMenu();
								select = scan.nextInt();
								if(select !=4) {
									reservTimeMenu = false;
									movieChartMenu = false;
									startMenu =false;
									System.out.println("------------------");
									System.out.println("<<�¼�����>>");
								}else if(select > 4){
									mv.selectError();
								}
							} else if (select == 4) {
								reservTimeMenu = false;							
							} else if (select > 4) {
								mv.selectError();
								break;						
							}
						}
						
					} else if (select == 4) {
						movieChartMenu = false;
					} else if (select > 4) {
						mv.selectError();
					}

				}
				break;
			case 2:
				ReserveTic rt = new ReserveTic();
				rt.checkSeat();
				break;
			case 3:
				LogIn login = new LogIn();
				login.logIn();
				break;
			case 4:
				startMenu = false;
				System.out.println("�ý����� ����Ǿ����ϴ�.");
				break;
			default:
				mv.selectError();
				break;
			}
		}
		

	}


	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reserveTicket() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void cancleTicket() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkSeat() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



}