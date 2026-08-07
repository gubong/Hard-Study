package g_arraylist;

import java.util.ArrayList;

public class Java_02_dto {
	String no, name, depart;
	int age;
	
	
	public Java_02_dto() {}

	public Java_02_dto(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Java_02_dto(String no, String name, String depart, int age) {
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.age = age;
	}

	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
}
