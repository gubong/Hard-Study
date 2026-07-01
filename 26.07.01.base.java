package a_basic;

public class Java_01 {

	public static void main(String[] args) {
//정수 변수만들기: byte, short, int, long -길이에따른 데이터차이. 각각 1,2,4,8바이트의제한
//모든 변수 생성시에는 앞에 타입지정
		byte num1 = -128; //byte= -128~127 	
		short num2 = 32767; // -32768~32767
		int num3 = 2147483647; // 21억어쩌구까지
		long num4 = 9223372036854775807L;
//정수의 대표변수타입=INT (크기가무난함)
		//실수저장 타입 2가지,대표타입 double
		float num5 = 10.5f; //4바이트
		double num6 = 10.5; //8바이트
		
		//논리
		boolean tf = true;  //1바이트, true/false 만 가능.
		
		//문자
		char ch = '가';	//문자 한글자 만 가능. 작은따옴표 사용
		//위 까지가 기본변수타입
		
		//문자열
		String str = "홍길동";
		
	}
}
