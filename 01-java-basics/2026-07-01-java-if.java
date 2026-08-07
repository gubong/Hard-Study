package b_if;

public class Java_01 {

	public static void main(String[] args) {
		int a=10, b=5;
		if (a>b){
			System.out.println("1.true~");			
		}
		if (a>=b){
			System.out.println("2.true~");			
		}
		if (a>b || a<10){
			System.out.println("3.true~");			
		}
		if (a>b && a<20 || b!=5){
			System.out.println("4.true~");			
		}
		if (a>b || a<2 || b==124){
			System.out.println("5.true~");			
		}
		if (a<b){
			System.out.println("6.true~");			
		}
		else {
			System.out.println("6.false~");
		}
		
		if(a>30) {
			System.out.println("7.30");
		}else if(a>20) {
			System.out.println("7.20");
		}else if(a>10) {
			System.out.println("7.10");
		}else {
			System.out.println("7.00");
		}
		
		
	}

}
