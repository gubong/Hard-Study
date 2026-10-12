package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();
		String pcode = request.getParameter("t_pcode");
		String pname = request.getParameter("t_pname");
		String company = request.getParameter("t_company");
		int price = Integer.parseInt(request.getParameter("t_price"));
		String makedate = request.getParameter("t_makedate");
		SnackDto dto = new SnackDto(pcode,pname,company,makedate,price);
		int result = dao.snackUpdate(dto);
		String msg = result == 1 ? "수정완료":"수정실패";
		String gubun = result == 1 ? "list" : "updateForm";
		request.setAttribute("t_pcode", pcode);
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Snack");
		request.setAttribute("t_gubun", gubun);
	}

}
