package k_interface;

public class Tiger extends Common implements InterA, InterB{

	//임플먼트 구현하다.
	@Override
	public String getSkin() {
		return "까죽";
	}
	
	@Override
	public String getHigh() {
		return "3";
	}
	
	@Override
	String getVoice() {
		return "호랭";
	}

	@Override
	public int getLegCount() {
		return 1;
	}
	




}
