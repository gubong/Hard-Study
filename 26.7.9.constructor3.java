package f_생성자;

public class Java_03 {

	public static void main(String[] args) {
		Java_03_Dao dao = new Java_03_Dao();
		
		String name="혹길자";
		int kor=80, eng=90, mat=100;
		
		Java_03_Dto dto1 = new Java_03_Dto(name, kor, eng, mat);
		int total = dao.getTotal(kor,eng,mat);
		System.out.println(total);
		
		dto1.setKor(100);
		int total2 = dao.getTotal(dto1);
		System.out.println(total2);
		
		
		
		
		
	}

	
	
}



dto1=         (혹길자, 80, 90, 100)     배열x int doule 
name =dsa
kor = 24
eng=23
mat=523