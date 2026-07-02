package b_if;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		//질문 초딩1 중딩2 고딩3  >>답은 int로 ㅇㅇ 
		//기본 5, 초딩1,중딩2,고딩5 > 다른건0원
		
		Scanner sc = new Scanner(System.in);
		System.out.println("초딩1,중딩2,고딩3으로대답하셈");
		int grade = sc.nextInt();
		int mon = 0;
		if (grade == 1) {
			 mon = 60000; 
		}
		else if(grade ==2){
			mon =70000;
		}
		else if(grade ==3) {
			mon = 80000;
		}
		System.out.println("출력 : 용돈 "+mon+"원");
			
	
			
		
		
		
		
		

	}

}
