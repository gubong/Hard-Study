package command.notice;

import java.io.IOException;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = NoticeDao.getDao();
		
		//String attach_dir = "C:/AI 1기 연습/java_work/servlet_bike/src/main/webapp/attach/notice";
		//String attach_dir = "C:/AI 1기 연습/java_work/.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\servlet_bike\\attach";
		String attach_dir = CommonUtil.getNoticeDir(request);
		
		int maxSize = 1024*1024*10;
		MultipartRequest mpr = null;
		try {
			 mpr = 
					new MultipartRequest(request,
										attach_dir,
										maxSize,
										"utf-8",
										new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String no = dao.getNoticeNo();
		String title = mpr.getParameter("t_title");
		String content = mpr.getParameter("t_content");
		String attach = mpr.getFilesystemName("t_attach");
		if(attach==null) attach="";
		String reg_id = CommonUtil.getSessionId(request);	
		String reg_date = CommonUtil.getTodayTime();
		
		NoticeDto dto = new NoticeDto(no, title, content, attach, reg_id, reg_date);
		int result = dao.noticeSave(dto);
		String msg = result == 1? "등록성공":"등록실패";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");
	}

}
