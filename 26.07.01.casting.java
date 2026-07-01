package a_basic;





public class Java_07_형변환 {

	public static void main(String[] args) {
		//85->85.0 int>double
		int a = 85;
		double aResult = (double)a;
		System.out.println("aResult : "+aResult);
	
		//90.12345 >> 90 double>int
		double b = 90.12345;
		int bResult = (int)b;
		System.out.println("bResult : "+bResult);
	
		//"85" > 85 String > int     ////Integer.pa~
		String c = "85";
		int cResult = Integer.parseInt(c);
		System.out.println("cResult : "+cResult);
		//자주사용하는 클래스의메소들은 new로 생성하지않고 클래스명.메소드 로 
		//바로 사용할 수 있다.  검색시 앞에 빨간색s가 붙음. static method
		
		//90>"90"
		int d = 90;
		String dResult = Integer.toString(d);
		System.out.println("dResult : "+dResult);
		//빈도가많은클래스들은 java.lang 이라는 패키지에 몰아놓고 import가 필요없게 해놨음.
		  
		
		
		
		
	
	}

}
