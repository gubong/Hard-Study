package a_basic;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		Scanner   sc   = new Scanner(System.in);
		//	클래스(타입)+변수명 = new 클래스		
		System.out.print("성명?");
		String name = sc.next();
		//sc.next치면 string - scanner 나옴
		//			 타입으로~  클래스명
		
		System.out.print("몇과?");
		int count = sc.nextInt();
		
		System.out.print("국어점수?");
		int kor = sc.nextInt();
		
		System.out.print("영어점수?");
		int eng = sc.nextInt();
		
		int total = kor + eng;
		double ave = (double)total/count;
		if (ave>=80){
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
		
		System.out.println("이름 : "+name);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+ave);
	
	}

}
