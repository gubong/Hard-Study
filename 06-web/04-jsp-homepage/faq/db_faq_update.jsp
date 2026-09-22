<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*,dto.*"%>
<%
	FaqDao dao = FaqDao.getDao();
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("t_no");
	String question = request.getParameter("t_question");
	String answer = request.getParameter("t_answer");
	String reg_id = request.getParameter("t_reg_id");
	String reg_date = request.getParameter("t_reg_date");
	FaqDto dto = new FaqDto(no,question,answer,reg_id,reg_date);
	int result = dao.getUpdate(dto);
	String msg = "";
	String url = "";
	if(result==1){
		msg= "수정완료";
		url= "faq_list.jsp";
	}else{
		msg="수정실패";
		url="faq_update.jsp?t_no="+no+"";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>







