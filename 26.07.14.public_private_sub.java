package h_package_a;

public class Adto {
	public String id,name;		//private : 프라이빗은 다른 클래스에서는 직접 접근불가능함. 게터세터만가능해짐ㅇㅇ
	private int age;			//필드,게터세터들도 이 패키지에서만 가능하다. 임포트해도 마찬가지
	
						//public : 다른 패키지클래스들도 사용가능,(변수,게터세터둘다)
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
