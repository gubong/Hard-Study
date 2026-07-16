package l_exception;

import java.util.Scanner;

import m_static.Dao;

public class Main {

	public static void main(String[] args) {
		// try{}catch(Exception e){}
		//트라이영역에서 오류발생시에는 캐치로 바로 넘어옴. 그 뒤로는 그대로실행
		//try + 컨+스페이스바
		
		Dao.getName();
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("시스템시작");
		
			
			
			try {
				System.out.println("국어점수?");
				String kor = sc.next();
				System.out.println("영어점수?");
				String eng = sc.next();
				
				int total = Integer.parseInt(kor)+Integer.parseInt(eng);
				System.out.println("total : "+total);
				
			}catch(Exception e) {			//NumberFormatException처럼 하나의오류를 잡을수도있음. 
				e.printStackTrace();		//오류상세설명출력.
				System.out.println("형변환 오류");
			}
			
		System.out.println("시스템시작");
		
		
		
	}

}
