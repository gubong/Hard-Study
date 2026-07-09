package f_생성자;

public class Java_03_Dao {
`

	public int getTotal(int a, int b, int c) {
		return a+b+c;
	}

	public int getTotal(Java_03_Dto dto) {
		int total = dto.getKor()+dto.getEng()+dto.getMat();
		return total;
	}
	
}
