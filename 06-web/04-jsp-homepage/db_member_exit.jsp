<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>

<%
	MemberDao dao = MemberDao.getDao();
	
	String sessionId = (String)session.getAttribute("sessionId");
	
	if(sessionId == null){
%>			
	<script type="text/javascript">
	alert("로그인 정보가 만료되었습니다. 다시 로그인 하세요");
	location.href="member_login.jsp";
	</script>	
<%	}else{
		String exit_date = CommonUtil.getTodayTime();
		int result = dao.memberExit(sessionId,exit_date);
		
		if(result==1) session.invalidate();
		String msg = result == 1? "탈퇴":"실패";	
%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href="../index.jsp";
	</script>
<%}%>