package b_if;

import java.util.Scanner;

public class Java_05 {
	public static void main(String[] args) {
		//기본:50
		//기혼:30, 자녀수물어봄
		//자녀수*10
		//출력 생활비어쩌구
		
		Scanner sc = new Scanner(System.in);
		int mon = 50;
		System.out.println("결혼여부?");
		String marry = sc.next();
		if(marry.equals("기혼")) {
			mon +=30;
			System.out.println("자식수?");
			int baby = sc.nextInt();
			mon += baby * 10;
		}
		System.out.println(mon);
	}
}
