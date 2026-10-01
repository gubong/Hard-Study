<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>

<%
	MemberDao dao = MemberDao.getDao();
	String sessionId = request.getParameter("t_id");
	if(sessionId == null){
%>			
	<script type="text/javascript">
	alert("로그인 정보가 만료되었습니다. 다시 로그인 하세요");
	location.href="../member/member_login.jsp";
	</script>	
<%	}else{
		String exit = dao.getExit(sessionId);
		if(exit==null){
%>			
	<script type="text/javascript">
	alert("소생할 수 없는 회원입니다.");
	location.href="member_list.jsp";
	</script>	

<% 			
		}
		String exit_date = "";
		int result = dao.memberExit(sessionId,exit_date);
		String msg = result == 1? "소생완료":"실패";	
%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href="member_list.jsp";
	</script>
<%}%>