package command.snack;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.CompanyDto;

public class SnackWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();
		List<CompanyDto> arr = dao.getCompanyList();
		String pcode = dao.getPcode();
		
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_pcode", pcode);

	}

}
