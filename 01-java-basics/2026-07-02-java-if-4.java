package b_if;

import java.util.Scanner;

public class Java_04 {
	public static void main(String[] args) {
		//원래는 스트링 name 이면 name 클래스를 만드는것과같다. 편이를위해서 new String 을 안쓰기로함.
		// 따라서 name. 까지해보면 name클래스 아래의 method들이 나열된다.
		String name = new String("가나다");
		Scanner sc = new Scanner(System.in);
		int avc = 1;
		//질문 학년:1~6학년?
		//기본 5
		//12=1  34=2 56=3 56남자0 여자1
		
		//문법을보면 괄호안에 object를 넣으라고되어있다. java에선object가 가장상위개념인데 
		//object아래에 포함되는 모든 개체는 object의 형태로써 괄호안에 들어갈수있다.(제한없음)
		if(!name.equals("가8다")) {
			System.out.println("1.같다");
		}
		//equals쓸떄 같지 않으면~하고싶으면 !붙임.
		
		System.out.println("몇학년이세요?");
		int grade = sc.nextInt();
		int mon = 50000;
		if(grade ==1 || grade ==2) {
			mon +=10000;
		}
		else if(grade==3 || grade==4) {
			mon +=20000;
		}
		else if(grade==5 ||grade==6) {
			mon+=30000;
			System.out.println("성별은?");
			String gen = sc.next();
			if (gen.equals("여자") || gen.equals("녀")){
				mon +=10000;
			}
		}
		else {
			mon = -1000000000;
		}
		System.out.println(mon);
		
		
		
		
		
		
	}

}
