package e_dsa;

public class Java_03_dto {
	String name;
	int kor,eng,mat,total;
	double ave;
	
	public Java_03_dto() {}
	
	public Java_03_dto(String a,int b,int c,int d) {
		this.name = a;
		this.kor = b;
		this.eng = c;
		this.mat = d;
	}
	
	
	public Java_03_dto (String a, int b, int c, int d, int e, double f) {
		this.name = a;
		this.kor = b;
		this.eng = c;
		this.mat = d;
		this.total = e;
		this.ave = f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAve() {
		return ave;
	}

	public void setAve(double ave) {
		this.ave = ave;
	}
	
	
	
	
	
	
	
	
	
}
