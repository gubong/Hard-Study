package d_array;

public class Java_02 {

	public static void main(String[] args) {
		// 배열총합, 50보다 큰 수의 총합.
		int[] arr = {662,7,4,74,89,56,52,86,45,56,12,45,92,45,56,8,396,
					 299,95,89,56,52,26,55,36,52,45,36,78,41};
		int total = 0, totala = 0, count = 0;
		
		for(int k =0; k<arr.length; k++) {
			total += arr[k];
			if(arr[k]>=50) {
				totala += arr[k];
				count ++;
			}
		}
		System.out.println(total);
		System.out.println(totala);
		System.out.println(count);
	}
}
