<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%
	MemberDao dao = MemberDao.getDao();
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password = dao.encryptSHA256(password);
	String name = dao.getLoginInfo(id, password);
	if(name.equals(""))out.print("no");
	else out.print("yes");
	
%>