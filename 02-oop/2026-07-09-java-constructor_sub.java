package f_생성자;

public class Java_01_sub {
	//메소드들의 집합=클래스
	//메소드이름이 클래스이름이고, 타입과리턴이없다 >>'생성자메소드'
	//()아무것도없는거 기본생성자.
	//new로 메소드를 선언할때 Java_01_sub sub = new Java_01_sub();   에서 우측 java~부분이 기본생성자, 이미 sub에 
	//안보이지만 존재하는 상태고 그걸 메소드로 끌어와서 선언하는 방법임.
	//  한번에 주석처리, 영역> 컨+슬래쉬,
	//매개변수가 있는 기본생성자를 생성하면, 기본생성자를 대체한다. 변수가없는 기본생성자를 사용하고 싶으면 추가로 입력해줘야한다.
	
	String name;  //아무것도안넣음>초기화하지않았음>null상태.   넣는행위>초기화한다.
	int age;      //상기이유로 0 상태.
	//메인메소드 밖의 영역에서 만들어지는 변수 >>> 멤버변수.
	//어떠한 메소드 안에서 만들어진 변수 >> 지역변수.
	//기본적인구조. 멤버변수>생성자>메소드들~
	
	
	public Java_01_sub() {		
		
	}
	public Java_01_sub(String name) {		
		this.name = name;
	}
	
	public Java_01_sub(int name) {		
		
	}
	
	void setName(String name){			//void타입> 리턴값이 없는 메소드.(의 타입) //setname 들어온 name값을 멤버변수에대입
		this.name =name;
	}
	
	
	
	public String getName() {
//		name = "123";
//		String name = "대전";		//String name >지역변수생성한거,   그냥 name ="대전"; <멤버변수를초기화한거.
//		this.name = "dsa";		// 멤버변수를 사용하는거랑헷갈리니까  this.name(멤버변수) 이라고 쓴다.
//		name = "서울";
//		this.name = "fds";
		return name;				//지역에서는 멤버변수를 사용할 수 있다.
}
	
	
	
	
	
	
	
	
	
	
}
