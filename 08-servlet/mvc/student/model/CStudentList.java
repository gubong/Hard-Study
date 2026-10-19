package command.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.StudentDao;
import dto.StudentDto;

public class CStudentList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		String key = request.getParameter("key");
		String syear = request.getParameter("t_syear");
		String sclass = request.getParameter("t_sclass");
		String gubun = request.getParameter("t_gubun");
		String search = request.getParameter("t_search");
		String workGubun = request.getParameter("t_workGubun");
		
		if(syear==null){
			syear = "1";
			sclass = "1";
			gubun = "sno";
			search = "";
			workGubun = "all";
		}
		List<StudentDto> arr = dao.getStudentList(syear,sclass,gubun,search,workGubun);
		
		request.setAttribute("key", key);
		request.setAttribute("syear", syear);
		request.setAttribute("sclass", sclass);
		request.setAttribute("gubun", gubun);
		request.setAttribute("search", search);
		request.setAttribute("workGubun", workGubun);
		request.setAttribute("arr", arr);
		
		
	}

}
