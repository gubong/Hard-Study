package b_if;

import java.util.Scanner;

public class Java_02 {

	public static void main(String[] args) {
		//용돈구하기  기본용돈10만원 나이가 스무살 이상이면 5만원을 더 주고, 20살 이하면 기본용돈만.  출력:용돈150000원
		// 나이>30이상이면 5만원
		// 나이> 20이상이면 2만원추가
		// 나이 20살 이하면 기본
		// 출력:용돈 123원
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 몇살임?");
		int age = sc.nextInt();
		int mon = 100000;
		
		if (age>=20) {
			mon +=20000;
			if (age>=30) {
				mon += 50000;
			}
		}
		System.out.println("출력 : 용돈 "+mon+"만원");
		
		
		
		
		
	}

}
