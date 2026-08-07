package l_exception;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		int total = 0;
		//finally try에서 오류발생하든안하든 무조건실행되는부분.
		
		
		try {
			System.out.println("국어점수?");
			int kor = sc.nextInt();
			total += kor;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			total = 0;
		} finally {
			System.out.println("");
		}
		
		
		
		System.out.println("chd"+total);
		
		
	}

}
