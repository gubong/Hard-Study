package g_arraylist;

import java.util.ArrayList;

public class Java_01 {

	public static void main(String[] args) {
		//고무줄배열/타입은 스트링타입
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("첫번쨰");
		arr.add("2번쨰");		//추가
		arr.add("3번쨰");
		
		arr.add(1, "끼워");  //n번째에 끼워넣기
		int length = arr.size(); //배열크기구하기
		System.out.println("길이 : "+length);
		
		arr.get(0); //0번째 배열
		String value = arr.get(0);
		System.out.println(value);
	
		arr.remove(2);  //삭제
		String abc = arr.remove(1);		//원하는곳지우기
		System.out.println("del : "+abc);
		//arr.clear();  		//배열 안 내용 지우기
		for(int k=0; k<arr.size();k++) {
			System.out.println(arr.get(k));	
		}
		
		
		//향상된 for문.  arr배열에서 스트링타입으로 str을뽑아서 출력
		for(String str : arr) {
			System.out.println("str : "+str);
		}
		
		
	}

}
