<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	FaqDao dao = FaqDao.getDao();
	request.setCharacterEncoding("utf-8");
	String no = dao.getNewNo();
	String question = request.getParameter("t_question");
	String answer = request.getParameter("t_answer");
	String reg_id = request.getParameter("t_reg_id");
	String reg_date = request.getParameter("t_reg_date");
	
	FaqDto dto = new FaqDto(no,question,answer,reg_id,reg_date);
	int result = dao.getSave(dto);
	String msg = result == 1 ? "저장성공":"저장실패"; 
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>




