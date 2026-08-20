<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String syear = request.getParameter("a_syear");
	String sclass = request.getParameter("a_sclass");
	String sno = request.getParameter("a_sno");
	
	StudentDao dao = StudentDao.getDao();
	StudentDto dto = new StudentDto(syear,sclass,sno);
	
	int count = dao.checkStudent(dto);
	
	if(count==0) out.print("yes");
	else out.print("no");
	



%>
