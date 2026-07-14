package g_arraylist;

import java.util.ArrayList;

public class Java_03_dao {
	String getDepartName(String a){
		String b = " ";
		if(a.equalsIgnoreCase("c")) {				//대소문자 구분x이그노어
			b = "총무";
		}
		else if( a.equalsIgnoreCase("j")) {
			b = "재무";
		}
		else if(a.equalsIgnoreCase("y")){
		
			b= "영업";
		}
		else {
			b = "입력오류";
		}
		return b;
	}
	
	
	String getRankName(String a ) {
		String b = " ";
		if(a.equals("10")) {				//대소문자 구분x이그노어
			b = "과장";
		}
		else if( a.equals("20")) {
			b = "미장";
		}
		else if(a.equals("30")){
		
			b= "대장";
		}
		else {
			b = "입력오류";
		}
		return b;
		
	}


	public void printAll(ArrayList<Java_03_dto> arr) {
		
		System.out.println("===========================");
		System.out.println("사번\t성명\t부서\t직위\t나이");
		System.out.println("===========================");
		for(Java_03_dto a : arr) {
			System.out.print(a.getNo()+"\t");
			System.out.print(a.getName()+"\t");
			System.out.print(getDepartName(a.getDapart())+"\t");
			System.out.print(getRankName(a.getRank())+"\t");
			System.out.print(a.getAge()+"\n");
		
		
		
	}
}
	
}
