package l_exception;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		try {

			System.out.println("국어점수?");
			int kor = sc.nextInt();
			total += kor;

			System.out.println("영어점수?");
			int eng = sc.nextInt();
			total +=eng;
			
			
			
		} catch (Exception e) {
			total = 0;
			e.printStackTrace();
			System.out.println("오류");
		}
		
		System.out.println("chd"+total);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
