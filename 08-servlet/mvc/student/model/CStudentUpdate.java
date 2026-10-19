package command.student;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;
import dto.StudentDto;

public class CStudentUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String sno = request.getParameter("t_sno");
		StudentDto dto = dao.getStudentView(syear,sclass,sno);
		String key = request.getParameter("key");
		
		request.setAttribute("key", key);
		request.setAttribute("syear", syear);
		request.setAttribute("sclass", sclass);
		request.setAttribute("sno", sno);
		request.setAttribute("dto", dto);
		
	}

}
