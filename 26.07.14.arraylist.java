package g_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		//몇명의사원을 등록하겠니?,, 성명~직위,>dto, arr에 집어넣기.
		Java_03_dao dao = new Java_03_dao();
		Scanner sc = new Scanner(System.in);
		ArrayList<Java_03_dto> arr = new ArrayList<>(); //두번째 Java_03_dto는 생략가능.
		
		
		Java_03_dto dto1 = new Java_03_dto("101","홍길동","c","10",15);
		Java_03_dto dto2 = new Java_03_dto("201","김길동","c","10",20);
		Java_03_dto dto3 = new Java_03_dto("301","박길동","y","20",10);
		Java_03_dto dto4 = new Java_03_dto("401","차길동","j","30",40);
		Java_03_dto dto5 = new Java_03_dto("501","차길통","j","30",40);
		
		arr.add(dto1);
		arr.add(dto2);
		arr.add(dto3);
		arr.add(dto4);
		arr.add(dto5);
		arr.add(new Java_03_dto("601","d","j","30",40));
		
		int gubun = 0;
		
		do {
			System.out.println("구분 등록:1, 조회:2, 출력:3,삭제:4, 종료:0");
			gubun = sc.nextInt();
			if(gubun ==1) {
				
				
				
				System.out.println("사번?");
				String no = sc.next();
				System.out.println("성명?");
				String name = sc.next();
				System.out.println("부서 총무:c 재무:j 영업:y ? ");
				String depart = sc.next();
				System.out.println("직위 사원:10 대리:20 과장:30 ?");
				String rank = sc.next();
				System.out.println("나이?");
				int age = sc.nextInt();
				
				Java_03_dto a = new Java_03_dto(no,name,depart,rank,age);
				arr.add(a);
			
			}
			else if(gubun ==2){
				System.out.println("조회 사번1 성명2 부서3");
				int work = sc.nextInt();
				if(work ==1) {
					System.out.println("사번 검색?");
					String search = sc.next(); //예를들어"2"
					
					
					
					
					
					System.out.println("===========================");
					System.out.println("사번\t성명\t부서\t직위\t나이");
					System.out.println("===========================");
					int count = 0;
					for(Java_03_dto a : arr) {
						if(a.getNo().indexOf(search)!=-1){
							
							System.out.print(a.getNo()+"\t");
							System.out.print(a.getName()+"\t");
							System.out.print(dao.getDepartName(a.getDapart())+"\t");
							System.out.print(dao.getRankName(a.getRank())+"\t");
							System.out.print(a.getAge()+"\n");
							count ++;
						}	
					}
					
					if(count==0) {
						System.out.println("검색없음");
					}
					
				}else if(work==2) {
					System.out.println("성명검색?");
					String name = sc.next();
					
					
					System.out.println("===========================");
					System.out.println("사번\t성명\t부서\t직위\t나이");
					System.out.println("===========================");
					int count = 0;
					for(Java_03_dto a : arr) {
						if(a.getName().indexOf(name)!=-1){
							
							System.out.print(a.getNo()+"\t");
							System.out.print(a.getName()+"\t");
							System.out.print(dao.getDepartName(a.getDapart())+"\t");
							System.out.print(dao.getRankName(a.getRank())+"\t");
							System.out.print(a.getAge()+"\n");
							count ++;
						}	
					}
					
					if(count==0) {
						System.out.println("검색없음");
					}
					
				}else if(work==3){
					System.out.println("부서?");
					String depart = sc.next();
					
					System.out.println("===========================");
					System.out.println("사번\t성명\t부서\t직위\t나이");
					System.out.println("===========================");
					int count = 0;
					for(Java_03_dto a : arr) {
						if(a.getDapart().equalsIgnoreCase(depart)){
							System.out.print(a.getNo()+"\t");
							System.out.print(a.getName()+"\t");
							System.out.print(dao.getDepartName(a.getDapart())+"\t");
							System.out.print(dao.getRankName(a.getRank())+"\t");
							System.out.print(a.getAge()+"\n");
							count ++;
						}	
					}
					
					if(count==0) {
						System.out.println("검색없음");
					}
					
				}
					
				}
			else if(gubun ==3){
				
				dao.printAll(arr);
				
			}
			else if(gubun == 4) {
				System.out.println("삭제할사번?");
				String no = sc.next();
				Java_03_dto dto = null;
				for(int k=0; k<arr.size(); k++) {
					if(arr.get(k).getNo().equals(no)) {
						System.out.println(arr.get(k).getNo()+"의 정보");
						dto = arr.remove(k);	//삭제한dto의 메모리주소가나옴.
						
					}
				}
				
				if(dto ==null) {
					System.out.println("삭제실패");
				}
				else System.out.println("삭제되었습니다.");
				
				
				
				
			}
			else {
				System.out.println("입력오류");
			}
			
			
		}while(gubun !=0);
		
		System.out.println("시스템종료");
		
		
}
	}
		
		



