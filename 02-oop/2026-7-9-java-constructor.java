package f_생성자;

import java.util.Scanner;

public class Java_01 {

	public static void main(String[] args) {
		//
		String name = "홍길동";
		int age = 25;
		
		
		Java_01_sub sub1 = new Java_01_sub();
		
		sub1.setName("이상민");
		String sub1Name = sub1.getName();
		sub1.setName("박길동");
		System.out.println("sub1 : "+sub1Name);
		
		Java_01_sub sub2 = new Java_01_sub(name);
		//String n = sub2.name;
		String n = sub2.getName();
		System.out.println("sub2 : "+n);
		
		
		//constructor
		//Java_01_sub sub3 = new Java_01_sub(age);
		//sub클래스생성>sub안의 모든 메소드 사용가능.
		//Scanner sc = new Scanner();
		//따라서 스캐너클래스는 기본생성자가없는클래스다.
		
		
		
		
		
		
	}

}
