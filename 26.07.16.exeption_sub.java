package l_exception;

public class Main4_sub {

	public int getTotal(String a, String b) {
		int total = 0;
		try {
			total = Integer.parseInt(a)+Integer.parseInt(b);
			
		}catch (Exception e) {
			System.out.println("오류");
		}
		
		return total;
	}

	
	public int getAve(int a, String b) throws Exception {		//메소드실행하다가 오류발생하면 리턴대신에 익셉션을 던져줄거야~
		int ave = a / Integer.parseInt(b);
		return ave;
	}
	
	
	
	
	
	
	
}
