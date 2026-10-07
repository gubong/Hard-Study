package command.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dto.MemberDto;

public class CMemberList {

	public void excute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select==null) {
			select="id";
			search="";
		}
		
		List<MemberDto> arr = dao.getMemberList(select, search);	
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_arr", arr);
	}
	
}
