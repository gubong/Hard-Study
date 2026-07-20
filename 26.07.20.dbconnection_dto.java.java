package o_database;

public class MemberDto {
	private String id,name,area;
	private int age;
	
	public MemberDto(String id, String name, String area, int age) {
		this.id = id;
		this.name = name;
		this.area = area;
		this.age = age;
	}

	String getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getArea() {
		return area;
	}

	int getAge() {
		return age;
	}
	
	
	
	
	
	
	
	
}
