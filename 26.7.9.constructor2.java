package f_생성자;

public class Java_02 {

	public static void main(String[] args) {
		Java_02_sub sub = new Java_02_sub();
		sub.setId("101");
		sub.setName("홍길자");
		sub.setArea("서울");
		sub.setAge(12);
		
		Java_02_sub sub2 = new Java_02_sub("201", "박길자", "대전", 35);		
		
		Java_02_sub sub3 = new Java_02_sub("301","ck길자");
		
		System.out.println(sub2.age);
		System.out.println(sub3.age);
		
		
		
		
		
		
		
	}

}
