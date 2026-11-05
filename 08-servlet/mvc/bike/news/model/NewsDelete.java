package command.news;

import java.io.File;

import javax.servlet.http.HttpServletRequest;


import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dao.NoticeDao;

public class NewsDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = NewsDao.getDao();
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_ori_attach");
		boolean tf = true;
		int result = 0;
		if(!attach.equals("")) {
			File file = new File(CommonUtil.getNoticeDir(request), attach);
			tf = file.delete();
			if(!tf) System.out.println("1. 공지사항 첨부 삭제 오류"); 
		}
		
		if (tf) {
			result = dao.noticeDelete(no);
		}
		String msg = result == 1? "삭제 성공":"삭제 실패";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
		
		
		
	}

}
