package e_method;

import java.util.Scanner;

public class Java_01 {

	public static void main(String[] args) {
		//Scanner   sc  = new Scanner(System.in);
		Java_01_sub sub = new Java_01_sub();    //타입 자체가 Java_01_sub이기대문에 문자,정수 싹다안됨 Java_01_sub타입만 넣을수있음
		System.out.println(sub); //e_method.Java_01_sub@6615435c <<메모리주소
	
		
		Java_01_sub sub2 = new Java_01_sub(); 
		System.out.println(sub2);
		
		String a = sub.getName();
		System.out.println(a);

		int point = sub.getPoint();
		int kor = 50;
		int eng = 60;
		int total = sub.getTotal(kor, eng);
		System.out.println(total);
	
	
		int sum = sub.getSum(kor, eng, 60);
	
		boolean result = sub.getTrue(5, 4);
		System.out.println(result);
	
	
		int sum2 = sub.getSum2(kor,eng,"60");
	
		String sum3 = sub.getSum3(kor,eng);
		System.out.println(sum3);
		
		
		String sum4 = sub.getSum4(10,"20",30);
		
		
		
		
		
		
		
		
		
		
		
	
	
	}
	
			
	
		

}
