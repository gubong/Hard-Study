<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String syear = request.getParameter("a_syear");
	String sclass = request.getParameter("a_sclass");
	String sno = request.getParameter("a_sno");
	out.print("학년 :"+syear+"반 : "+sclass+"번호"+sno);
	




%>