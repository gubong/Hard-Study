package c_반복문;

import java.util.Scanner;

public class Java_02 {

	public static void main(String[] args) {
		// 5개 수를 입력받아 총 합계구하기
		
		Scanner sc = new Scanner(System.in);
				int result = 0;
		
		for(int k=1; k<=5; k++) {
			System.out.println("무슨수임");
			int a = sc.nextInt();
			result += a;
			if(a==0) {
				break;
			}
		}
		System.out.println(result);
		
	}

}
