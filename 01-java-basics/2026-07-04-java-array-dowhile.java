package d_array;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		//몇명? 이름 배열에 집어넣기
		Scanner sc = new Scanner(System.in);
		System.out.println("몇명?");
		int count = sc.nextInt();
		String[] name = new String[count];
		
		for(int k=0; k<count; k++) {
			System.out.println((k+1)+"번째 이름");
			name[k] = sc.next();
		}
		System.out.println("끝");
		for(int k=0; k<count; k++) {
			System.out.println(name[k]);
		}
		System.out.println("끝");
		
		
		int gubun = 0;
		do {
			System.out.println("검색:1, 종료:0");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.println("무슨이름?");
				String search = sc.next();
				for (int k=0; k<count;k++) {
					if(name[k].indexOf(search)!=-1) {
						System.out.println(name[k]);	
					}
				}
			}
			
		}while(gubun != 0);
		System.out.println("종료");
		

		

	}

}
