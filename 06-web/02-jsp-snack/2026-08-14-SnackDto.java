package dto;

public class SnackDto {
	private String pcode,pname,company,companyname,makedate;
	private int price;
	
	
	
	//코드만 받아서 상세조회할 때 company2개표시
	public SnackDto(String pcode, String pname, String company, String companyname, String makedate, int price) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.company = company;
		this.companyname = companyname;
		this.makedate = makedate;
		this.price = price;
	}

	//다 받아서 등록	
	public SnackDto(String pcode, String pname, String company, String makedate, int price) {
		this.pcode = pcode;
		this.pname = pname;
		this.company = company;
		this.makedate = makedate;
		this.price = price;
	}
	
	//목록
	public SnackDto(String pcode, String pname) {
		super();
		this.pcode = pcode;
		this.pname = pname;
	}




	

	public String getCompanyname() {
		return companyname;
	}

	public String getPcode() {
		return pcode;
	}

	public String getPname() {
		return pname;
	}

	public String getCompany() {
		return company;
	}

	public String getMakedate() {
		return makedate;
	}

	public int getPrice() {
		return price;
	}
	
	
	
	
	
	
	
	

}
