package d_array;

import java.util.Scanner;

public class Java_01 {

	public static void main(String[] args) {
		//자바의배열은 넣을때마다 늘어나고 줄어들지않는다. 
		//클래스를 만들면 넓은 메모리 칸 중에 어느 하나에 배정돼서 저장된다.ex) scanner를 선언하면 한 칸을
		//배정하고 sc 칸이 생기고 scanner하위 정보들이 그 칸에 들어감. ex) sc.next
		//integer 같은 스테틱메쏘드는 이미 어딘가에 저장되어있는것.
		// Null = 메모리 안에 저장된 게 없다. 라는뜻. > 어떤 값과 참,거짓을 판별할수없고 null인지, 아닌지만 판별가능한 상태
		
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[3];				//배열선언법
		int[] in = new int[3];  //int 는 null이없음. 기본값이 0으로 설정돼있음.
		
		//Null 인지 판별하는법. 
		if(arr[0] == null) {
			System.out.println("Null");
		}else {
			boolean tf = arr[0].equals("a"); 
			System.out.println(tf);    //>>NullPointerException 오류메시지: 실행이 Null 과 관련된 거임ㅇㅇ 
		}
					
		System.out.println("String 0번째 : "+arr[0]);
		System.out.println("int 0번째 : "+in[0]);
		System.out.println(sc);
		//---------------------------------------------------------------------------------------
		String[] aaa = new String[4];
		aaa[0] = "홍길동";
		aaa[1] = "박실동";
		aaa[2] = "이길동";
		aaa[3] = "차길동";
		for (int k=0; k<aaa.length; k++) {
			System.out.println((k+1)+"번째 : "+aaa[k]);
		}
		
		String[] name = {"홍길동","이상민","김태영"};  //자바에서는 대량으로 넣을때 {}를 사용.
		for (int k=0; k<name.length; k++) {
			System.out.println((k+1)+"번째 : "+name[k]);
		}
		
		
		
		
		
		
	}
}
