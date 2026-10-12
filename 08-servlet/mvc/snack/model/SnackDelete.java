package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;

public class SnackDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		String pcode = request.getParameter("t_pcode");
		SnackDao dao = SnackDao.getDao();
		int result = dao.snackDelete(pcode);
		String msg = result == 1? "성공":"실패";
		String gubun = result == 1 ? "list" : "view";
		
		request.setAttribute("t_pcode", pcode);
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Snack");
		request.setAttribute("t_gubun", gubun);
		
	}

}
