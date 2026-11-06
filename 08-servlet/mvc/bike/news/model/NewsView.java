package command.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dao.NoticeDao;
import dto.NoticeDto;

public class NewsView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = NewsDao.getDao();
		String no = request.getParameter("t_no");
		String gubun = request.getParameter("t_gubun");
		if(gubun.equals("view")) {
			int result = dao.setHitCount(no);
			if(result != 1)System.out.println("공지사항 조회수 증가 오류 발생");			
			//이전글 다음글
			List<NoticeDto> arr = dao.getPreNextInfo(no);
			NoticeDto preDto = arr.get(0);  //이전글
			NoticeDto nextDto = arr.get(1); //다음글		
			request.setAttribute("preDto", preDto);
			request.setAttribute("nextDto", nextDto);
		}
		HttpSession session = request.getSession();
		NoticeDto dto = dao.getNoticeView(no);
		String a = CommonUtil.getDoubleQuot(dto.getTitle());
		dto.setTitle(a);
		int likes = dao.getlikes(no);
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		int likesOpen = dao.getOpen(no,sessionId);
		request.setAttribute("dto", dto);
		request.setAttribute("likes", dao.getLikeCount(no));
		request.setAttribute("likesOpen", (sessionId != null && dao.isLiked(no, sessionId)) ? "0" : "1");		
	}

}
