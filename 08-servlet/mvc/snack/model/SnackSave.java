package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = SnackDao.getDao();
		String pcode = request.getParameter("t_pcode");
		String pname = request.getParameter("t_pname");
		String company = request.getParameter("t_company");
		String makedate = request.getParameter("t_makedate");
		int price = Integer.parseInt(request.getParameter("t_price"));
		SnackDto dto = new SnackDto(pcode,pname,company,makedate,price);
		int result = dao.snackSave(dto);
		String msg = result ==1 ? "등록성공":"등록실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_gubun", "list");
		request.setAttribute("t_url", "Snack");
		
	}

}
