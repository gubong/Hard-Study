package c_반복문;

import java.util.Scanner;

public class Java_05_while {

	public static void main(String[] args) {
		//0을 입력하기전까지 수를계속 입력받아서 짝수의합계와 홀수의 합계를 출력.
		
		Scanner sc = new Scanner(System.in);
		int jjack = 0;
		int hole =0;
		while(true) {
			System.out.println("수입력??");
			int ans = sc.nextInt();
			
			if(ans % 2 == 0) {
				jjack += ans;
			}
			else {
				hole += ans;
			}
			if(ans == 0) {
				break;
			}
			System.out.println("1."+jjack);
			System.out.println("2."+hole);
		}
	}

}
