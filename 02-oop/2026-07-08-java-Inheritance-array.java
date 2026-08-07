package e_method;

public class Java_03 {

	public static void main(String[] args) {
		
		Java_03_sub sub = new Java_03_sub();
		int[] score = {85,89,75,86};
		int total = sub.getTotal(score);
		
		int[] abc = {89,5,2,48,56,23,89,456,};
		int total2 = sub.getTotal(abc);
		System.out.println(total2);
		
		double ave = sub.getAve(abc);
		System.out.println(ave);
		
		String result = sub.getResult(score);	//전체숫자의 평균,80 기준 합,불합.
		System.out.println(result);
		
		int grade = 4;
		String result2 = sub.getResult(score,grade);  //1~3학년까지는 60점이상합격, 4~6학년은 80합격
		System.out.println(result2);
		
	}

}
