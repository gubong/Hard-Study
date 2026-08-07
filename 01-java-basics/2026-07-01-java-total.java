package a_basic;

public class Java_02 {

	public static void main(String[] args) {
//한줄삭제 컨+d , 한줄복사 컨+알+방향키
		int kor = 50;
		int eng = 62;
		int mat = 70;
		int total = kor + eng + mat ; //만들어놓고 사용안한 변수는 노란밑줄쳐짐.
		int count = 3;
		System.out.println("총점 : "+total); //ln 줄바꿈
		int ave1 = total/3;
		System.out.println("평균 : "+ave1);
		double ave2 = total/(double)count;			
		//int나누기int는 형식도int가됨. 한쪽은double형식이어야함. (double)count=3.0 
		//int를 double로 캐스팅한다.
		System.out.println("평균 : "+ave2);
		// 재생(run) 단축키> 컨+F11
	}
}
