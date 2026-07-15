package k_interface;

public class Lion implements InterA {
//클래스만들때 인터페이스 창에서 intera 참조하면 형식은 알아서 만들어줌.
	@Override
	public String getSkin() {
		return "사자";
	}

	@Override
	public String getHigh() {
		return "12";
	}

}
