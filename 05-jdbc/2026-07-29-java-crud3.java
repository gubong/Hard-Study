package o_student_권구봉;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StuDao dao = new StuDao();
		int gubun = 0;
		do {
			System.out.println("[구분] 조회:1, 등록:2, 수정:3, 삭제:4, 종료:0 ?");
			gubun = sc.nextInt();
			if(gubun==1) {
				//전체출력1, 성명검색2, 번호검색3,
				System.out.println("전체출력:1, 성명검색:2, 번호검색:3");
				int a123 = sc.nextInt();
				if(a123==1) {
					ArrayList<StuDto> arr = new ArrayList<>();
					arr = dao.realJo();
					dao.getPrint(arr);
				}else if(a123 ==2) {
					System.out.println("검색할 성명. 이름의 일부도 가능.");
					String searchname = sc.next();
					ArrayList<StuDto> arr = new ArrayList<>();
					arr = dao.nameJo(searchname);
					if(arr.size()!=0) {
						dao.getPrint(arr);
					}else {System.out.println("검색성명없음~");}
				}else if(a123 ==3) {
					System.out.println("검색번호~");
					String searchnumb = sc.next();
					ArrayList<StuDto> arr = new ArrayList<>();
					arr = dao.numbJo(searchnumb);
					if(arr.size()!=0) {
						dao.getPrint(arr);
					}else {System.out.println("검색번호없음~");
					
					}
				}
				
				
			}else if(gubun==2) {
				//학년반번호 조회해보고 등록가능하면 뒤에도 다 
				StuDto dto = null;
				System.out.println("학년?");
				String grade = sc.next();
				System.out.println("반?");
				String ban = sc.next();
				System.out.println("번호?");
				String number = sc.next();
				int result = dao.getOK(grade,ban,number);
				if(result ==0) {
					System.out.println("성명?");
					String name = sc.next();
					System.out.println("국어점수");
					int kor = sc.nextInt();
					System.out.println("영어점수");
					int eng = sc.nextInt();
					System.out.println("수학점수");
					int mat = sc.nextInt();
					dto = new StuDto(grade, ban, number, name, kor, eng, mat);
					int result2 = dao.getInsert(dto);
					if(result2 ==1) {
						System.out.println("등록 성공");
					}else {
						System.out.println("등록 실패");
					}
				}else {
					System.out.println("학년,반,번호 중복오류");
				}
				
			}else if(gubun==3) {
				//학년반번호 입력하면 정보보여주고 수정한다하면 국영수 싹다 수정하는걸로.
				System.out.println("학년?");
				String grade = sc.next();
				System.out.println("반?");
				String ban = sc.next();
				System.out.println("번호?");
				String number = sc.next();
				int result = dao.getOK(grade,ban,number);
				if(result !=0) {
					dao.getAllprint(grade,ban,number);
					System.out.println("수정하시겠습니까? y/n");
					String sujong = sc.next();
					if(sujong.equalsIgnoreCase("y")||sujong.equals("ㅛ")) {
						System.out.println("국어점수");
						int kor = sc.nextInt();
						System.out.println("영어점수");
						int eng = sc.nextInt();
						System.out.println("수학점수");
						int mat = sc.nextInt();
						StuDto dto = new StuDto(grade, ban, number, "", kor, eng, mat);
						int result2 = dao.getSujong(dto);
						if(result2 ==1) {
							System.out.println("수정완료.");
						}else {
							System.out.println("수정오류발생");
						}
					}else {
						System.out.println("수정종료");
					}
				}else {
					System.out.println("검색오류");
				}
				
				
			}else if(gubun==4) {
				System.out.println("학년?");
				String grade = sc.next();
				System.out.println("반?");
				String ban = sc.next();
				System.out.println("번호?");
				String number = sc.next();
				int result = dao.getOK(grade,ban,number);
				if(result !=0) {
					dao.getAllprint(grade,ban,number);
					System.out.println("삭제하시겠습니까? y/n");
					String sak = sc.next();
					if(sak.equalsIgnoreCase("y")||sak.equals("ㅛ")) {
						int resultsak = dao.getSak(grade,ban,number);
						if(resultsak==1) {
							System.out.println("삭제완료");
						}else {
							System.out.println("삭제오류");
						}
					}else {
						System.out.println("다른검색해주세요그럼~");
					}
				}else {
					System.out.println("삭제할정보없음");
				}
					
				
			}
			
			
		}while(gubun!=0);
		System.out.println("시스템종료");
		
		
		
	}

}
