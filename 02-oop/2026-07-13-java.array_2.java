package g_arraylist;

import java.util.ArrayList;

public class Java_02 {

	public static void main(String[] args) {
		// 
		ArrayList<Java_02_dto> arr = new ArrayList<Java_02_dto>();
		Java_02_dto dto1 = new Java_02_dto();
		Java_02_dto dto2 = new Java_02_dto("A101","차길동");
		Java_02_dto dto3 = new Java_02_dto("B101","박길동","총무",25);
		arr.add(dto1);
		arr.add(dto2);
		arr.add(dto3);
		
		for(int k=0; k<arr.size();k++) {
		System.out.print(arr.get(k).getNo()+"\t");
		System.out.print(arr.get(k).getName()+"\t");
		System.out.print(arr.get(k).getDepart()+"\t");
		System.out.print(arr.get(k).getAge()+"\n");
			
		}
		
		System.out.println("=============================");
		
		for(Java_02_dto a : arr) {
			System.out.print(a.getNo()+"\t");
			System.out.print(a.getName()+"\t");
			System.out.print(a.getDepart()+"\t");
			System.out.print(a.getAge()+"\n");
		}
		
		
		
	}

}
