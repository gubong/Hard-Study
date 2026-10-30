package command.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = NoticeDao.getDao();
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
		NoticeDto dto = dao.getNoticeView(no);
		dto.setTitle(CommonUtil.getDoubleQuot(dto.getTitle()));
		request.setAttribute("dto", dto);
	}

}
