package o_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnackDao dao = new SnackDao();
		int gubun =0;
		do {
			System.out.println("검색 제품코드:1, 제품명:2, 제조사:3, ");
			System.out.print("전체출력4, 제품명검색5, 제품등록:6, 종료:0");
			gubun = sc.nextInt();
			
			
			
			
			if(gubun==6) {
				
				
			
			}else if(gubun==1) {
				System.out.println("조회할제품코드?");
				String code = sc.next();	//완벽히일치하는놈만찾기
				SnackDto dto = dao.getSnackInfo(code);
				if(dto==null) {
					System.out.println("없는코드임ㅇㅇ");
				} else {
					dao.snackPrint(dto);
				}
				
			}else if(gubun==2) {		//제품명 뭐 넣으면 들어가있는제품명 쭈르륵다나와라
				System.out.println("제품명?");
				String searchName = sc.next();
				ArrayList<SnackDto> arr = dao.getSnackList(searchName);
				if(arr.size()==0) {
					System.out.println("제품정보없음");
				}else {
					dao.snackPtintAll(arr);
				}
				
				
			}else if(gubun==3) {
				System.out.println("제조사 농심:1 롯데:2 해태:3 오리온:4 ");
				String searchCompany = sc.next();
				if(searchCompany.equals("1")||searchCompany.equals("2")||searchCompany.equals("3")||searchCompany.equals("4")) {
					ArrayList<SnackDto> arr = dao.getSnackCompany(searchCompany);
					
					if(arr.size() == 0) System.out.println("111");
					dao.snackPtintAll(arr);
				}
				
			}else if(gubun==4) {
				ArrayList<SnackDto> arr = dao.getSnackAll();
				dao.snackPtintAll(arr);
			
			}else if (gubun ==5) {
				System.out.println("제품코드는?");
				String searchName = sc.next();
				String result = dao.getName2(searchName);
				if(result.equals(null)) {
					System.out.println("제품명없음");
				}
				else {
					System.out.println(result);
				}
				
			}
			
			
		
		}while(gubun !=0);		
		
		System.out.println("system 종뇨^6 :D");
		
		
		
	}

}
