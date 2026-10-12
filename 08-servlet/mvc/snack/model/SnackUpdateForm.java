package command.snack;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.CompanyDto;
import dto.SnackDto;

public class SnackUpdateForm implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();

		System.out.println(" update dao : "+dao);

		String pcode = request.getParameter("t_pcode");
		SnackDto dto = dao.getSnackView(pcode);
		List<CompanyDto> arr = dao.getCompanyList();
		
		request.setAttribute("t_pcode", pcode);
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_arr", arr);
	}

}
