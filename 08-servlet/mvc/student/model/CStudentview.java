package command.student;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;
import dto.StudentDto;

public class CStudentview implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String key = request.getParameter("key");
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String sno = request.getParameter("t_sno");
		StudentDto dto = dao.getStudentView(syear,sclass,sno);
		
		int total = dto.getKor()+dto.getEng()+dto.getMat(); 

		
		DecimalFormat df = new DecimalFormat("0.##");
		double ave = total/3; 
		String ave2 = df.format(ave);
		
		request.setAttribute("ave", ave2);
		request.setAttribute("total", total);
		request.setAttribute("key", key);
		request.setAttribute("syear", syear);
		request.setAttribute("sclass", sclass);
		request.setAttribute("sno", sno);
		request.setAttribute("dto", dto);

		
	}

}
