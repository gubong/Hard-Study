package dto;

public class NoticeDto {
	private String no,title,content,attach,hit,reg_id,reg_name,reg_date;

	//목록용
	public NoticeDto(String no, String title, String attach, String hit, String reg_name, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.attach = attach;
		this.hit = hit;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
	}
	
	
	//등록,상세조회,수정,
	public NoticeDto(String no, String title, String content, String attach, String hit, String reg_id, String reg_name,
			String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.hit = hit;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
	}

	

	public String getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAttach() {
		return attach;
	}

	public String getHit() {
		return hit;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_name() {
		return reg_name;
	}

	public String getReg_date() {
		return reg_date;
	}
	
}
