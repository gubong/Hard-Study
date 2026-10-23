package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = MemberDao.getDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
      
		String area    = request.getParameter("t_area");
		String address    = request.getParameter("t_address");
		String email_1    = request.getParameter("t_email_1");
		String email_2    = request.getParameter("t_email_2");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String gender    = request.getParameter("t_gender");
		String hobby_travel  = request.getParameter("t_hobby_travel");
		String hobby_reading = request.getParameter("t_hobby_reading");
		String hobby_sports  = request.getParameter("t_hobby_sports");
		if(hobby_travel == null) hobby_travel ="n";
		if(hobby_reading == null) hobby_reading ="n";
		if(hobby_sports == null) hobby_sports ="n";
		String update_date = CommonUtil.getTodayTime();
		
		
		MemberDto dto = new MemberDto(id, name, "password","password_length", 
				area, address, mobile_1, mobile_2, mobile_3, email_1, email_2, 
				gender, hobby_travel, hobby_reading, hobby_sports, 
				"reg_date", update_date, "exit_date");
		
		int result = dao.memberUpdate(dto);
		
		String msg = result == 1 ? "정보 수정되었습니다" : "수정 실패!";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "index");
	
		
	}

}
