package b_if;

public class Java_09_switch {

	public static void main(String[] args) {
		/*
		 *   switch > 뭐일때,뭐해라~ 뭐일때,뭐해라~ 
		 */
		String month = "13월";
		
		switch(month) {
			case "3월": case "4월": case "5월":
				System.out.println("1.봄");
				break;
			case "6월": case "7월": case "8월":
				System.out.println("1.여름");
				break;
			case "9월": case "10월": case "11월":
				System.out.println("1.가을");
				break;
			case "12월": case "1월": case "2월":
				System.out.println("1.겨울");
				break;
			default:
				System.out.println("4.없다.");
		}
		
		

	}

}
