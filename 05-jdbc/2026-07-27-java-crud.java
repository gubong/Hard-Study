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
			System.out.print("전체출력4, 제품명검색5, 제품등록:6,제품수정:7,제품삭제:8 종료:0");
			gubun = sc.nextInt();
			if(gubun==8) {
				System.out.println("삭제할제품코드?");
				String pcode = sc.next();
				SnackDto dto = dao.getSnackInfo(pcode);
				if(dto !=null) {
					dao.snackPrint(dto);
					System.out.println("찐?y/아무거나");
					String work = sc.next();
					if(work.equalsIgnoreCase("y")||work.equals("ㅛ")) {
						int result = dao.snackDelete(pcode);
						if(result ==1) {
							System.out.println("삭제완료");
						}else {
							System.out.println("삭제오류");
						}
					}
					
				}else {
					System.out.println("제품정보없음");
				}
			}else if(gubun==7) {
				System.out.println("제품코드?");
				String pcode = sc.next();
				SnackDto dto = dao.getSnackInfo(pcode);
				if(dto != null) {
					dao.snackPrint(dto);
					System.out.println("수정하겠습니까? 예:y, 아니오:아무거나");
					String work = sc.next();
					if(work.equalsIgnoreCase("y")|| work.equals("ㅛ")) {
						 System.out.println("수정 제품명:n, 제조사:c, 가격:p, 제조일:d");
						 String updateGubun = sc.next();
						 if(updateGubun.equalsIgnoreCase("n")||updateGubun.equalsIgnoreCase("ㅜ")) {
							 System.out.println("수정 제품명?");
							 String updatePname = sc.next();
							 SnackDto updateDto = new SnackDto(pcode, updatePname, "", "", 0);
							 int result = dao.snackUpdateName(updateDto);
							 if(result ==1) {
								 System.out.println("수정성공");
							 }else {
								 System.out.println("실패~");
							 }
						 }else if(updateGubun.equalsIgnoreCase("c")||updateGubun.equalsIgnoreCase("ㅊ")) {
							 System.out.println("수정 제조사명?");
							 String updateCompany = sc.next();
							 SnackDto updateDto = new SnackDto(pcode, "", updateCompany, "", 0);
							 int result = dao.snackUpdateCompany(updateDto);
							 if(result==1) {
								 System.out.println("성공~");
							 }else {
								 System.out.println("실패~");
							 }
						 }else if(updateGubun.equalsIgnoreCase("ㅔ")||updateGubun.equalsIgnoreCase("p")) {
							 System.out.println("수정 가격?");
							 int updatePrice = sc.nextInt();
							 SnackDto updateDto = new SnackDto(pcode, "", "", "", updatePrice);
							 int result = dao.snackUpdatePrice(updateDto);
							 if(result==1) {
								 System.out.println("성공~");
							 }else {
								 System.out.println("실패~");
							 }
						 }else if(updateGubun.equalsIgnoreCase("d")||updateGubun.equalsIgnoreCase("ㅇ")) {
							 System.out.println("수정 제조일?");
							 String updateDate = sc.next();
							 SnackDto updateDto = new SnackDto(pcode, "", "", updateDate, 0);
							 int result = dao.snackUpdateDate(updateDto);
							 if(result==1) {
								 System.out.println("성공~");
							 }else {
								 System.out.println("실패~");
							 }
						 }
						
					}
						
				}else {
					System.out.println("존재하지않는제품코드");
				}
				
				
				
			
			}else if(gubun==6) {
				System.out.println("제품코드?");
				String pcode = sc.next();
				SnackDto dto = dao.getSnackInfo(pcode);
				if(dto != null) {
					System.out.println("중복된제품코드");
				}else {
					System.out.println("제품명?");
					String pname = sc.next();
					System.out.println("제조사?");
					String company = sc.next();
					System.out.println("제조일?");
					String makedate = sc.next();
					System.out.println("가격?");
					int price = sc.nextInt();
					SnackDto saveDto = new SnackDto(pcode, pname, company, makedate, price);
					int result = dao.snackSave(saveDto);
					if(result>0) {
						System.out.println("ㅇㅇ됨");
					}else {
						System.out.println("안됨");
					}
					
				}
				
				
				
				
				
				
			
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
