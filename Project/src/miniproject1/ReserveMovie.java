import java.util.Scanner;

public class ReserveMovie {
	public static void main(String[] args) {
		Movie mv = new Movie();
		boolean startMenu = true;
		Scanner scan = new Scanner(System.in);
		int select = 0;

		while (startMenu) {
			boolean movieChartMenu = true;

			//예매하기 메뉴
			System.out.println("------------------");
			System.out.println("1.예매하기  | 2.종료");
			System.out.println("------------------");
			System.out.print("번호 입력>>");
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
									System.out.println("<<좌석선택>>");
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
				System.out.println("프로그램 종료");
				startMenu = false;
				break;
			default:
				mv.selectError();
				break;
			}
		}
		select = scan.nextInt();

	}
}
