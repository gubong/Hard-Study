package d_array;

import java.util.Scanner;

public class 연습 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("몇과?");
		int count = sc.nextInt();
		String[] arr = new String[count+1];
		int total =0;
		
		for(int k=0; k<count; k++) {
			if(k==0) {
				System.out.println("성면?");
				arr[k]=sc.next();
			}
			else {
				System.out.println("점수?");
				arr[k]=sc.next();
				int a = Integer.parseInt(arr[k]);
				total += a;
			}
		}
		double ave = (double)total/count;
		for(int k=0; k<count; k++) {
			System.out.println(arr[k]);
			System.out.println(total);
			System.out.println(ave);
		}
	
	
	
	}

}
