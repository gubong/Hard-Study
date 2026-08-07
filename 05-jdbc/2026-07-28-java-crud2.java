package o_database_권구봉;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Scanner sc = new Scanner(System.in);
		
		int gubun =0;
		do {
			System.out.println("------------------------------------------------");
			System.out.println("등록:1, 조회:2, 수정:3, 삭제:4 전체출력:5 종료:0 ?");
			System.out.println("------------------------------------------------");
			gubun = sc.nextInt();
			if(gubun ==4) {
				System.out.println("삭제할id");
				String id = sc.next();
				MemberDto dto = dao.getMemberInfo(id);
				if(dto !=null) {
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getArea()+"\t");
				System.out.println(dto.getAge());
				}
				System.out.println("삭제할겨말겨 y/n");
				String ans = sc.next();
				if(ans.equalsIgnoreCase("y")||ans.equals("ㅛ")) {
					int result =  dao.getDelete(id);
					if(result==1) {
						System.out.println("삭제성공");
					}else {
						System.out.println("삭제실패");
					}
				}else {
					System.out.println("ㅇㅋ");
				}
				
				
			}else if(gubun ==3) {
				System.out.println("수정할id");
				String id = sc.next();
				MemberDto dto = dao.getMemberInfo(id);
				if(dto!=null) {
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getArea()+"\t");
				System.out.println(dto.getAge());
				
				System.out.println("어떤거수정할래. 이름n 지역z 나이a ");
				String ans = sc.next();
				System.out.println("뭘로바꿀랭");
				String ans2 = sc.next();
				if(ans.equalsIgnoreCase("n")||ans.equals("ㅜ")) {
					ans = "name";
				}else if(ans.equalsIgnoreCase("z")||ans.equals("ㅋ")) {
					ans = "area";
				}else if(ans.equalsIgnoreCase("a")||ans.equals("ㅁ")) {
					ans = "age";
				} 
				int result = dao.getSujeong(ans,ans2,id);
				
				if(result==1) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				
				
				}else {
					System.out.println("수정할정보없음");
				}
				
			
			}else if(gubun ==1) {
				System.out.print("id?");	//301
				String id = sc.next();
				
				int checkresult = dao.checkId(id);
				if(checkresult==0) {	
					System.out.print("이름??");
					String name = sc.next();
					System.out.print("에리아?");
					String area = sc.next();
					System.out.print("나이?");
					int age = sc.nextInt();
					
					MemberDto dto = new MemberDto(id, name, area, age);
					// 인서트할때는 리턴을 int로 받음.이유는안알야줌
					int result = dao.memberSave(dto);
					if(result ==1) {
						System.out.println("잘됐따");
					}else {
						System.out.println("dksehoEK~");
					}
				}else {
					System.out.println("이미있음");
				}
			}else if(gubun==2) {
				System.out.println("id?");
				String id = sc.next();
				MemberDto dto = dao.getMemberInfo(id);
				if(dto!=null) {
					System.out.print(dto.getId()+"\t");
					System.out.print(dto.getName()+"\t");
					System.out.print(dto.getArea()+"\t");
					System.out.print(dto.getAge()+"\n");
				}
				else {
					System.out.println("정보없음");
				}
			}else if(gubun==5) {
				ArrayList<MemberDto> arr = dao.getMemberList("");
				if(arr.size()==0) System.out.println("데이터없음");
				for(MemberDto dto : arr) {
					System.out.print(dto.getId()+"\t");
					System.out.print(dto.getName()+"\t");
					System.out.print(dto.getArea()+"\t");
					System.out.print(dto.getAge()+"\n");
					
				}
			}
			
			
		}while(gubun!=0);
		
		System.out.println("시스템종료");
		
	}

}
