package command.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class CMemberSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String area = request.getParameter("t_area");
		String age = request.getParameter("t_age");
		MemberDto dto = new MemberDto(id, name, area,Integer.parseInt(age));
		int result = dao.memberSave(dto);
		String msg ="";
		String gubun = "";
		if(result==1) { 
			msg="등록성공";
			gubun="list";
		}else {
			msg="등록실패!";
			gubun ="writeForm";
		}
		request.setAttribute("t_gubun", gubun);
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}
