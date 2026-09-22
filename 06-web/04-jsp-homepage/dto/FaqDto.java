package dto;

public class FaqDto {
	String no,question,answer,reg_id,reg_date;

	
	public FaqDto(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public FaqDto(String no, String question, String answer, String reg_id, String reg_date) {
		this.no = no;
		this.question = question;
		this.answer = answer;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}

	public String getNo() {
		return no;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}
	
	

}
