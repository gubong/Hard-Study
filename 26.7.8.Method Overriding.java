package e_method;

public class Java_02 {

	public static void main(String[] args) {
		Java_02_sub sub = new Java_02_sub();
										//java에서는 같은용법인데 매개변수만 다른 메소드들은 하나의 메소드로 설정가능.
												//ex)2개든 3개든 4개든 getTotal로 만들수있음
										//overloading(과적하다), 하나의 메소드에 매개변수의 자릿수, 자리의 타입만 변형하여
											// 메소드 하나로 돌려쓸 수 있다.
		//System.out.p   //<<컨+스페이스 해보면 print라는 메소드에 오버로딩되어있는걸 확인가능. 어떤 변수를 넣어도 프린트 될 수 있도록.
		
		int total = sub.getTotal(10,"20",30);
		double ave = sub.getAve(total,3);
		
		String result = sub.getResult(ave);  //80이상합격,이하불합격
		
		String kak = sub.getHak(ave);  // 90점이상a 80b 70c 나머지 f
		
		
		int basic = 100000;
		String gender = "여성";
		int age = 25;
		
		//여성 +3만
		//서른살이상 +5만원
		//총 용돈 기본10
		int money = sub.getMoney(basic, gender, age);
		
		
		
	}

}
