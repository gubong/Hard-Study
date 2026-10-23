package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberInfo implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		MemberDao dao = MemberDao.getDao();
		MemberDto dto = dao.getMemberInfo(id);
		request.setAttribute("dto", dto);
		String a = dto.getHobby_travel();
		String b= dto.getHobby_reading();
		String c= dto.getHobby_sports();
	}

}
