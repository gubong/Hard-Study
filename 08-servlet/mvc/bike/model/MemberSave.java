package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao 	= MemberDao.getDao();
		String id 		= request.getParameter("t_id");
		String name 	= request.getParameter("t_name");
		
		String password = request.getParameter("t_password");
		String password_length = Integer.toString(password.length());
		
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String area 	= request.getParameter("t_area");
		String address 	= request.getParameter("t_address");
		String email_1 	= request.getParameter("t_email_1");
		String email_2 	= request.getParameter("t_email_2");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String gender 	= request.getParameter("t_gender");
		String hobby_travel  = request.getParameter("t_hobby_travel");
		String hobby_reading = request.getParameter("t_hobby_reading");
		String hobby_sports  = request.getParameter("t_hobby_sports");
		if(hobby_travel ==null) hobby_travel = "n";
		if(hobby_reading ==null) hobby_reading = "n";
		if(hobby_sports ==null) hobby_sports = "n";
		String reg_date = CommonUtil.getTodayTime();
		
		MemberDto dto = new MemberDto(id, name, password, password_length, 
				area, address, mobile_1, mobile_2, mobile_3, 
				email_1, email_2, gender, hobby_travel, hobby_reading, hobby_sports, 
				reg_date, "", "");
		int result = dao.MemberSave(dto);
		String msg = result == 1? name+"님 회원가입 되었습니다." : "회원가입 실패";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "index");
	}

}
