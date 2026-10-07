package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class CMemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String area = request.getParameter("t_area");
		String age = request.getParameter("t_age");
		MemberDto dto = new MemberDto(id, name, area,Integer.parseInt(age));
		int result = dao.memberUpdate(dto);
		
		String msg ="";
		String gubun="list";
		if(result==1) { 
			msg="수정성공";
		}else {
			msg="수정실패!";
			gubun="updateForm";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
		request.setAttribute("t_gubun", gubun);
		request.setAttribute("t_id", id);

	}

}
