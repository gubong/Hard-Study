package e_method;

public class Java_01_sub {
/*		메소드만드는법.
 * 1.메소드명(){}   (괄호는 모든메소드기본)
 * 2.모든메소드는 리턴값이 있고, 리턴값의 타입을 지정해야함.
 * 메소드만드는법	
 */

	int getTotal(int kor, int eng) {
		int total = kor + eng;
		return total;
	}
	
	String getName(){
		String name = "홍길동";
		int age = 25;
		String point ="11";
		return name;
	}

	int getPoint() {
		return 0;
	}
	
	
	boolean getTrue(int a, int b) {
		boolean result;
		if(a>3) {
			if(b>4) {
				result = true;
			}else {
				result = false;
			}
		}else {
			result=false;
		}
		
		return result;
	}
	
	int getSum(int a, int b, int c) {
		int total = a+b+c;
		
		return total;
	}

	
	
	int getSum2(int a,int b,String c) {
		int d = Integer.parseInt(c);
		return a+b+d;
	}
	
	String getSum3(int a,int b) {
		return Integer.toString(a+b);
	}
	
	
	String getSum4(int a, String b, int c) {
		return Integer.toString(a+Integer.parseInt(b)+c);
		
	}
	
	
	
	
	
	
	
	
}
