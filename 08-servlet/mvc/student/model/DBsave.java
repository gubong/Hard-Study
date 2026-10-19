package command.student;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;
import dto.StudentDto;

public class DBsave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String sno = request.getParameter("t_sno");
		String name = request.getParameter("t_name");
		int kor = Integer.parseInt(request.getParameter("t_kor"));
		int eng = Integer.parseInt(request.getParameter("t_eng"));
		int mat = Integer.parseInt(request.getParameter("t_mat"));
		StudentDto dto = new StudentDto(syear,sclass,sno,name,kor,eng,mat);
		int result = dao.studentSave(dto);
		String msg = result == 1? "등록성공~":"등록실패~";
		String url = "student";
		request.setAttribute("key", "");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}

}
