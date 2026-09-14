<%@page import="dto.NoticeDto"%>
<%@page import="dao.NoticeDao"%>
<%@page import="common.CommonUtil"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	NoticeDao dao = NoticeDao.getDao();
	request.setCharacterEncoding("UTF-8");

	String attachDir = CommonUtil.getNoticeDir();
	int maxSize = 1024 * 1024 * 10;   //단위:바이트, 1024바이트=1키로바이트, 1024키로= 1메가
							//넘어오는파라미터,저장경로,최대용량제한,한글형식지원,중복이름자동생성)
	MultipartRequest mpr = new MultipartRequest(request,attachDir,
												maxSize,"UTF-8",
												new DefaultFileRenamePolicy()
												);
	String no = dao.getNoticeNo();
	String title = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String attach = mpr.getFilesystemName("t_attach");
	if(attach==null) attach = "";
	String reg_id = (String) session.getAttribute("sessionId");
	String reg_date = CommonUtil.getToday();
	
	NoticeDto dto = new NoticeDto(no,title,content,attach,"hit",reg_id,"reg_name",reg_date);
	int result = dao.noticeSave(dto);
	String msg = result == 1? "등록성공":"등록실패";
	
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="notice_list.jsp"
</script>

















