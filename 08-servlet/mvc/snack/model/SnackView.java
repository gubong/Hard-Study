package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();
		String pcode = request.getParameter("t_pcode");
		SnackDto dto = dao.getSnackView(pcode);
		
		request.setAttribute("t_pcode", pcode);
		request.setAttribute("t_dto", dto);

	}

}
