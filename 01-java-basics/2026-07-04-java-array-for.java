package d_array;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("몇칸?");
		int count = sc.nextInt();
		int[] arr = new int[count];
		
		for(int k=0; k<count; k++) {
			System.out.println("뭐넣음?");
			arr[k] = sc.nextInt();
		}

		for(int k=0; k<count; k++) {
			System.out.println(arr[k]);
		}
	}
}
