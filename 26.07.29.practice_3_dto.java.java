package o_student_권구봉;

public class StuDto {
	String grade,ban,number,name;
	int kor,eng,mat;
	
	
	public StuDto(String grade, String ban, String number, String name, int kor, int eng, int mat) {
		super();
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	
	
	String getGrade() {
		return grade;
	}
	String getBan() {
		return ban;
	}
	String getNumber() {
		return number;
	}
	String getName() {
		return name;
	}
	int getKor() {
		return kor;
	}
	int getEng() {
		return eng;
	}
	int getMat() {
		return mat;
	}
	
	
	
	
}
