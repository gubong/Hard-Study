<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	NewsDao dao = NewsDao.getDao();
	String no = request.getParameter("t_no");
	int result = dao.newsDelete(no);
	String msg = result == 1? "삭제완료" : "삭제실패";
	
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>