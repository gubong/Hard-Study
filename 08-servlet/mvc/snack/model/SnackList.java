package command.snack;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.CompanyDto;
import dto.SnackDto;

public class SnackList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select==null){
			select="all";
			search="";
		}
		List<SnackDto> arr = new ArrayList<>();
		arr = dao.allJo(select,search);
		List<CompanyDto> companyArr = dao.getCompanyList();
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_companyArr", companyArr);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
	}
	

}
