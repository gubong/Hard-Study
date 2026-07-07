package d_array;

public class Java_07 {

	public static void main(String[] args) {
		//다차원배열
		String[] info_1 = {"홍길동","서울","25"};
		String[] info_2 = {"박길동","대전","45"};
		
		
		String[][] info = {
				{"홍길동","서울","25"},
				{"박길동","대전","45"}
		};
		
		
		
		String[][]arr= new String[2][3];
		arr[0][0]="홍길동";
		arr[0][1]="서울";
		arr[0][2]="25";
		
		arr[1][0]="박길동";
		arr[1][1]="대전";
		arr[1][2]="45";
		
		for(int k=0;k<arr.length;k++) {
			for(int j=0; j<arr[k].length;j++) {
				System.out.print(arr[k][j]);
			}
			System.out.println(" ");
		}
		
		
		
		
	}

}
