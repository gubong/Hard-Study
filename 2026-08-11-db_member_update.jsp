<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String area = request.getParameter("t_area");
	String age = request.getParameter("t_age");
	if(age.equals("")) age="0";
	
	MemberDto dto = new MemberDto(id,name,area,Integer.parseInt(age));
	int result = dao.memberUpdate(dto);
	

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>