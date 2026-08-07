package e_method;

public class Java_02_sub {				//overloading(과적하다), 하나의 메소드에 매개변수의 자릿수, 자리의 타입만 변형하여
										// 메소드 하나로 돌려쓸 수 있다.
/*	int getTotal(int a, int b) {
		return a+b;
	}
	
	int getTotal(int a, String b) {
		return  0;
	}
	
	
	int getTotal(int a,int b,int c) {
		return a+b+c;
	}
	
	
	int getTotal(int a,int b,String c, int e) {
		int d = Integer.parseInt(c);
		return a+b+d;
	}
*/
	
	int getTotal(int a, String b, int c) {
		return a+Integer.parseInt(b)+c;
	}
	
	double getAve(int a, int b) {
		return (double)a/b;
	}
	
	
	String getResult(double a) {
		String b = "";
		if(a>=80) {
			b = "합격";
		}
		else {
			b = "불합격";
		}
		return b;
	}
	
	
	String getHak(double a) {
		if(a>=90) {
			return "a";
		}
		else if (a>=80) {
			return "b";
		}
		else if (a>=70) {
			return "c";
		}
		else {
			return "븅신";
		}
		
	}
	
	int getMoney(int a, String b, int c ) {
		int mon = a;
		if(b == "여성") {
			mon +=30000;
		}
		if(c>=30) {
			mon += 50000;
		}
		return mon;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
