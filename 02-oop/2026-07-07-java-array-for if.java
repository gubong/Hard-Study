package d_array;

import java.util.Scanner;

public class Java_06 {

	public static void main(String[] args) {
		/* 성명?
		 * 몇과목?
		 * 과목별로 점수를 입력받음. 배열. 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇과목?");
		int count = sc.nextInt();
		String arr[] = new String[count+1];
		int sum = 0;
		
		for(int k=0; k<count+1; k++) {
			if(k==0) {System.out.println("성명");
				arr[k] = sc.next();
			}
			else {
				System.out.println("점수");
				arr[k] = sc.next();
				int a = Integer.parseInt(arr[k]);
				sum += a;
			}		
		}
		
		
		double ave = (double)sum/count;
		
		for(int k=0; k<count+1;k++) {
			System.out.println(arr[k]);
		}
		System.out.println(sum);
		System.out.println(ave+"\t");
		// \t 는 간격띄우기
	
		
		
		
		
		
	}

}

























