package command.student;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;
import dto.StudentDto;

public class DBupdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String sno = request.getParameter("t_sno");
		int kor = Integer.parseInt(request.getParameter("t_kor"));
		int eng = Integer.parseInt(request.getParameter("t_eng"));
		int mat = Integer.parseInt(request.getParameter("t_mat"));
		
		StudentDto dto = new StudentDto(syear,sclass,sno,"",kor,eng,mat);
		int result = dao.studentUpdate(dto);
		
		String msg = result == 1 ? "수정완료":"수정실패";
		String url = "student";
		
		request.setAttribute("key", "");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}

}
