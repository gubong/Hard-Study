package j_추상;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Commom Tiger = new Tiger();
		String voice = Tiger.getVoice();
		System.out.println("호랭 : "+voice);
		
		Commom wolf = new Wolf();
		voice = wolf.getVoice();
		System.out.println("늑대 : "+voice);
		
		Commom cat = new Cat();
		voice = cat.getVoice();
		System.out.println("괭 : "+voice);
		
		
	}

}
