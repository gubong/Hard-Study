<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*"%>
<%
	NewsDao dao = NewsDao.getDao();
	request.setCharacterEncoding("UTF-8");
	String no = dao.getNewsNo();
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_id = (String)session.getAttribute("sessionId");
	String reg_date = CommonUtil.getToday();
	NewsDto dto = new NewsDto(no,title,content,reg_id,reg_date);
	int result = dao.newsSave(dto);
	String msg = result == 1 ? "등록":"실패";
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";

</script>