package o_database;

public class SnackDto {
	private String pcode, pname, company, makedate;
	private int price;
	public SnackDto(String pcode, String pname, String company, String makedate, int price) {
		this.pcode = pcode;
		this.pname = pname;
		this.company = company;
		this.makedate = makedate;
		this.price = price;
	}
	String getPcode() {
		return pcode;
	}
	String getPname() {
		return pname;
	}
	String getCompany() {
		return company;
	}
	String getMakedate() {
		return makedate;
	}
	int getPrice() {
		return price;
	}
	
	
	
	
	
	
}
