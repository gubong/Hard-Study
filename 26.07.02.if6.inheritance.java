package b_if;

import java.util.Scanner;

public class Java_06 {

	public static void main(String[] args) {
		//기본150
		//총무10 영업 12 생산 15
		//군필10
		//나이30살이상+10
		//출력 권구봉 급여~
												//if문 안에서 만들어진 변수는 if문 안에서만 작동한다. 
		
		String gubun = "h";							//이퀄은 대소문자 구별함.
		if (gubun.equalsIgnoreCase("H")) {				//이퀄이그노어케이스>대소문자구별안한다~
			System.out.println("같다.");
		}
		
		String abc = "h";				//abc.wait 쳐보면 리턴타입이 void 로 뜨는데 리턴타입이 없이 그냥 실행되는거.
		// abc.wait();					// '상속' 부모의클래스들을 자식클래스가 이용할 수 있는 개념. 3대n대도 마찬가지.
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름은?");
		String name = sc.next();
		System.out.println("부서는?");
		String boo = sc.next();
		String answer = "0";
		int mon = 150;
		
		if(boo.equals("총무")) {
			mon +=10;
		}
		else if(boo.equals("영업")) {
			mon +=12;
		}
		else if(boo.equals("생산")) {
			mon +=15;
		}else {
			mon = 0;
			answer = "부서코드입력오류";
		}
		
		
		if (boo.equals("총무")||boo.equals("영업")||boo.equals("생산")) {
			System.out.println("군필?y/n");
			String arm = sc.next();
			System.out.println("나이?");
			String age2 = sc.next();
			int age = Integer.parseInt(age2);
			
			if(arm.equals("y")) {
				mon +=10;
			}
			if(age>=30) {
				mon +=10;
			}
			answer = name+"님의 급여는 총 "+mon+"만원 입니다.";
			
		}
		
			System.out.println(answer);
	}
}
