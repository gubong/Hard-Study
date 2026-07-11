package e_dsa;

public class Java_03_dao {
	int getTotal(int a, int b, int c) {
		return a+b+c;
	}
	
	
	int getTotal(Java_03_dto a) {
		int total = a.getKor()+ a.getEng()+ a.getMat();
		return total;
	}
	
	Java_03_dto getTotaldto () {
		Java_03_dto a = new Java_03_dto("홍길동",10,20,30);
		return a;
	}
	
	
	Java_03_dto getALL(String a,int b, int c,int d) {
		Java_03_dto asd = new Java_03_dto(a,b,c,d);
		asd.setTotal(getTotal(asd));
		asd.setAve(asd.getTotal()/3);
		return asd;
	}
	
	
	
	

}
