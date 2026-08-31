<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*,dto.*,common.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = MemberDao.getDao();
	
	String id = request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String job = request.getParameter("t_job");
	String tell_1 = request.getParameter("t_tell_1");
	String tell_2 = request.getParameter("t_tell_2");
	String tell_3 = request.getParameter("t_tell_3");
	String mobile_1 = request.getParameter("t_mobile_1");
	String mobile_2 = request.getParameter("t_mobile_2");
	String mobile_3 = request.getParameter("t_mobile_3");
	String email_1 = request.getParameter("t_email_1");
	String email_2 = request.getParameter("t_email_2");
	String update_date = CommonUtil.getTodayTime();
	
	MemberDto dto = new MemberDto(id,name,"password",job,tell_1,tell_2,tell_3,
			mobile_1,mobile_2,mobile_3,
			email_1,email_2,
			"reg_date",update_date,"exit_date");	

	int result = dao.memberUpdate(dto);
	String msg = result == 1 ? name+"님 수정완료 되었습니다.":" 수정 실패!";
	String url = result == 1 ? "member_myinfo.jsp":"member_myinfo.jsp";
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>"
</script>




