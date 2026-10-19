package command.student;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;

public class DBdelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String sno = request.getParameter("t_sno");
		
		int result = dao.studentDelete(syear,sclass,sno);
		
		String msg = result == 1 ? "삭제완료":"삭제실패";
		String url = "student";

		request.setAttribute("key", "");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
	}

}
