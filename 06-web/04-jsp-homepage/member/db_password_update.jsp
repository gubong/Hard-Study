<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*" %>
<%
	MemberDao dao = MemberDao.getDao();
	String id = request.getParameter("t_id");
	String new_password = request.getParameter("t_new_password");
	new_password = dao.encryptSHA256(new_password);
	
	int result = dao.memberPasswordUpdate(id,new_password);
	String msg="", url="";
	if(result==1){
		msg="비밀번호 변경 되었습니다.";
		url="member_login.jsp";
		session.invalidate();
	}else{
		msg="변경실패";
		url="member_myinfo.jsp";
	}
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>


