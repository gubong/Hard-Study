package c_반복문;

import java.util.Scanner;   //빠진 모든 import 구문 알아서 해줌  컨+쉬프트+알파벳o 

public class Java_06_dowhile {

	public static void main(String[] args) {
		//do는 무조건실행,후에 조건판별후 다시실행.  
		Scanner sc = new Scanner(System.in);
		
		int gubun = 0;
		do {
			System.out.println("선택? 검색:1 등록:2 삭제:3 종료:0");
			gubun = sc.nextInt();
			if (gubun ==1) {
				System.out.println("검색맨");
			}
			else if(gubun==2) {
				System.out.println("등록맨");
			}
			else if(gubun==3) {
				System.out.println("삭제맨");
			}
			else if(gubun!=0){
				System.out.println("작업선택 오류");
			}
		}while(gubun !=0);

		System.out.println("종료");
	}

}
