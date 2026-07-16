package l_exception;

public class Main4 {

	public static void main(String[] args) {
		//
		Main4_sub sub = new Main4_sub();
		
		int total = sub.getTotal("80","90");
		System.out.println("총점 : "+total);
		
		int ave = 0;
	
		
		//저짝에서 쓰로우 명령어를쓰면. 이짝에서 그 메소드를 쓰려면 반드시 저쪽이 던져주는 익셉션을 처리할 구조를 만들어야함.
		// 따라서 반드시 트라이-캐치를 써야함.
		
		try {
			ave = sub.getAve(total,"tk");
		} catch (Exception e) {
			System.out.println("오류");
		}
		
		System.out.println("평균 : "+ave);
			
		
		
			
		
	}

}
