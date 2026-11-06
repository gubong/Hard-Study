package command.news;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dao.NoticeDao;
import dto.NoticeDto;

public class NewsUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = NewsDao.getDao();
		String attachDir = CommonUtil.getNoticeDir(request);
		int maxSize = 1024* 1024 * 10;
		MultipartRequest mpr = null;
		try {
			mpr = new MultipartRequest(request, attachDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String no = mpr.getParameter("t_no");
		String title = mpr.getParameter("t_title");
		String content = mpr.getParameter("t_content");
		String attach = mpr.getFilesystemName("t_attach");
		String ori_attach = mpr.getParameter("t_ori_attach");
		
		//첨부 바꿔치기
		if (attach == null) attach = "";
		if (!attach.equals("")) {
			if(!ori_attach.equals("")) {
				File file = new File(attachDir, ori_attach);
				boolean tf = file.delete();
				if(!tf) System.out.println("1. 공지사항 첨부 삭제 오류"); 
			}
		} else {
			attach = ori_attach;
		}
		
		
		String update_id = CommonUtil.getSessionId(request);
		String update_date = CommonUtil.getTodayTime();
		
		NoticeDto dto = new NoticeDto(no, title, content, attach, update_id, update_date);
		
		int result = dao.noticeUpdate(dto);
		String msg = result == 1? "수정 완료":"수정 실패";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
		request.setAttribute("t_gubun", "list");
		request.setAttribute("t_no", no);
	
	}

}
