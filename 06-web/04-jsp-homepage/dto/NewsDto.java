package dto;

public class NewsDto {
	private String no,title,content,hit,reg_id,name,reg_date;
	
	//목록,상세조회
	public NewsDto(String no, String title, String content, String hit, String reg_id, String name, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_id = reg_id;
		this.name = name;
		this.reg_date = reg_date;
	}

	//저장용,db_news_save.jsp
	public NewsDto(String no, String title, String content, String reg_id, String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
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


	public String getHit() {
		return hit;
	}


	public String getReg_id() {
		return reg_id;
	}

	public String getName() {
		return name;
	}


	public String getReg_date() {
		return reg_date;
	}


	
	
}
