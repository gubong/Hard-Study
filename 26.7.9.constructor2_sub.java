package f_생성자;

public class Java_02_sub {
	String id, name, area;			//얘네 세팅하는애들 세터메소드, 겟해오는애들 게터메소드
	int age;
	
	public Java_02_sub() {}
	public Java_02_sub(String id,String name,String area,int age){
		this.id = id;
		this.name = name;
		this.area = area;
		this.age = age;
	}
	
	
	public Java_02_sub(String a,String b){
		this.id = a;
		this.name = b;
	}
	
	
	
	String getId() {
		return id;
	}
	String getname() {
		return name;
	}
	String getarea() {
		return area;
	}
	int getage() {
		return age;
	}
	
	
	void setId(String id) {
		this.id = id;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setArea(String area) {
		this.area = area;
	}
	
	void setAge(int a) {
		this.age = a;
	}
	
	
	
	
	
}
