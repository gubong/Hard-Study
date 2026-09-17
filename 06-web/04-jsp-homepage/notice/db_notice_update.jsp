<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	NoticeDao dao = NoticeDao.getDao();
	int maxSize = 1024*1024*10;
	MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getNoticeDir(),
												maxSize,"utf-8",new DefaultFileRenamePolicy());
	String no = mpr.getParameter("t_no");
	String content = mpr.getParameter("t_content");
	String title = mpr.getParameter("t_title");
	String attach = mpr.getFilesystemName("t_attach"); //첨부파일받는건데,첨부안했으면 null옴
	if(attach==null) attach = "";
	
	String deleteattach = mpr.getParameter("t_delete_checkbox");
	String ori_attach = mpr.getParameter("t_ori_attach");
	if(ori_attach==null) ori_attach="";
	
	String dbAttachName = "";
	
	if(deleteattach!=null){
		File file = new File(CommonUtil.getNoticeDir(),deleteattach);
		boolean tf = file.delete();
		if(!tf) System.out.print("1.공지사항 수정시 첨부파일 삭제오류");
	}else{
		dbAttachName = ori_attach;
	}
	//새로운첨부 첨부함. 기존의 첨부파일은 삭제.
	if(!attach.equals("")){
		if(!ori_attach.equals("")){
			File file = new File(CommonUtil.getNoticeDir(),ori_attach);	
			if(file.exists()){
				boolean tf = file.delete();
				if(!tf) System.out.print("2.공지사항 수정시 첨부파일 삭제오류");
			}
		}
		dbAttachName = attach;
	}

	NoticeDto dto = new NoticeDto(no,title,content,dbAttachName,"hit","reg_id","reg_name","reg_date");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>