package b_if;

import java.util.Scanner;

public class Java_07 {

	public static void main(String[] args) {
/*1.직업: 학생1 주부2 회사원3
 *2.월에 얼마?
 *3.몇년?
 *이자: 학생20퍼,주부10퍼,회사원5퍼
 *출력
 *만기금액:1500000원
 */
		Scanner sc = new Scanner(System.in);
		System.out.println("학생1 주부2 회사원3");
		int job = sc.nextInt();
		System.out.println("월에얼마?");
		int month = sc.nextInt();
		System.out.println("몇년?");
		int year = sc.nextInt();
		double mon = month*12*year;
		
		
		if(job ==1) {
			mon *= 1.2;
		}
		else if (job ==2) {
			mon *= 1.1;
		}
		else if (job ==3){
			mon *= 1.05;
		}else {
			mon=0;
		}
		System.out.println(mon);
		
		
		
		
		
		
		
	}
}
