<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	FaqDao dao = FaqDao.getDao();
	String no = request.getParameter("t_no");
	int result = dao.getDelete(no);
	String msg = result == 1 ? "삭제완료":"삭제실패";	
%>
<script>
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>