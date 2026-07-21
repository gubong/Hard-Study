package o_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할이름");
		String name = sc.next();
	
		ArrayList<MemberDto> arr = dao.getMemberList(name);
		if(arr.size()==0) System.out.println("데이터없음");
		for(MemberDto dto : arr) {
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getArea()+"\t");
			System.out.print(dto.getAge()+"\n");
			
		}
		
		
		
		
		
		
		
		
//		String id = "101";
	
/*		int age = dao.getAge(id);
		System.out.println(age);
		
		
		
		
/*		String area = dao.getAreaName(id);
		System.out.println(area);
		
*/		
		
		
		
		
/*		//이름만조회하기 연습
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("id검색");
		String id = sc.next();
		String name  = dao.getMemberName(id);
		
		if(name.equals("")) {
			System.out.println("정보없음");		
		}
		else {
			System.out.println(id+"의 성명 : "+name);
		}
		
		
		
		MemberDto dto = dao.getMemberInfo(id);
		if(dto!=null) {
		System.out.println(dto.getName());
		System.out.println(dto.getArea());
		System.out.println(dto.getAge());
		}
		else {
			System.out.println("정보없음");
		}
		
		
		
*/		
		
		
	}

}
