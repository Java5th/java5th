package miniproject2;

import java.util.Calendar;

public class Movie {
	public static final String [] movieList = {"탑건-매버릭", "범죄도시2","브로커"};
	public static final String [] today = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일","일요일","월요일","화요일"};
	String time [] = {"10:10" ,"15:20" , "20:40"};
	
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH)+1;
	int day = now.get(Calendar.DAY_OF_MONTH);
	int week = now.get(Calendar.DAY_OF_WEEK)-1;
	
	int movieselect ;

	
	void selectMenu() {
		System.out.println("4.*이전 메뉴로 돌아가기*");
		System.out.println("------------------");
		System.out.print("번호 입력>>");
		
	}
	
	void selectError() {
		System.out.println("------------------");
		System.out.println("없는 번호를 입력하셨습니다.");
		System.out.println("번호를 다시 입력 하세요.");
	}
	
	void movieChart() {
		System.out.println("------------------");
		System.out.println("<<무비차트>>");
		for(int i=0; i<movieList.length;i++) {
			System.out.println((i+1)+"."+movieList[i]);
		}
	}
	

	void reservDate() {
		System.out.println("------------------");
		System.out.println("<<예매 가능 날짜>>");
		for(int i=1; i<=3; i++) {
			System.out.println(i+"."+month+"월 "+(day+i)+"일 "+today[week+i]);
		}
	}
	

	void reservTime(String time[]) {
		System.out.println("------------------");
		System.out.println("<<상영시간>>");
		for(int i=0; i<3;i++) {
			System.out.println((i+1)+"."+time[i]);
		}
	}
	
}

