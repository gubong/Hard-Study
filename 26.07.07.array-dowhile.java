package d_array;

import java.util.Scanner;

public class Java_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = {"이상민", "박만수", "이찬우", "김성식", "김지우", 
				"김인수", "안상수", "이미옥", "백현수", "이찬우", 
				"허상수", "김이우", "김미순", "허정우", "임민수", 
				"윤석민", "안태정", "최순실", "송민수", "강유현", 
				"강민기", "신강식", "허준용", "김형수", "안강현"};	
		int gubun = 0;
		int count = 0;
		do {
			System.out.println("1:검색 0:종료");
			gubun = sc.nextInt();
			if(gubun ==1) {
				System.out.println("뭘검색?");
				String a = sc.next();
				for(int k=0; k< name.length; k++) {
					if(name[k].indexOf(a)!=-1) {
						System.out.println(name[k]);
						count ++;
					}
				}
				
				if(count==0) {
					System.out.println("결과없음");
				}
				else{
					System.out.println("총:"+count);	
				}
				
			}
			count =0;
		}while(gubun !=0);
		System.out.println("종료");
		
		
		
	
	
	
	}

}
