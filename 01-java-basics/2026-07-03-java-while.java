package c_반복문;

import java.util.Scanner;

public class Java_04_while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int k=0;
		while(true) {
			
			System.out.println("수입력?");
			int value = sc.nextInt();
			if (value ==0) {
				break;
			}
		}
		System.out.println("종료");
	}

}
