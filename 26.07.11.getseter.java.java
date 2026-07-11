package e_dsa;

public class Java_03 {

	public static void main(String[] args) {

		Java_03_dao dao = new Java_03_dao();
		
		String name="혹길자";
		int kor=80, eng=90, mat=100;
		
		Java_03_dto dto1 = new Java_03_dto(name, kor, eng, mat);
		int total = dao.getTotal(kor,eng,mat);
		System.out.println(total);
		
		dto1.setKor(100);
		int total2 = dao.getTotal(dto1);
		System.out.println(total2);
		
		
		Java_03_dto asd = dao.getALL("권",1,2,3);
		
		System.out.println(dao.getTotal(asd));

		
		
		
		

	}

}
