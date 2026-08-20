<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>

<% 
	request.setCharacterEncoding("UTF-8");
	StudentDao dao = StudentDao.getDao();
	
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	String name = request.getParameter("t_name");
	int kor = Integer.parseInt(request.getParameter("t_kor"));
	int eng = Integer.parseInt(request.getParameter("t_eng"));
	int mat = Integer.parseInt(request.getParameter("t_mat"));
	
	StudentDto dto = new StudentDto(syear,sclass,sno,name,kor,eng,mat);
	
	int result = dao.studentSave(dto);
	String msg = result == 1? "등록성공~":"등록실패~";
%>
<script>
	alert("<%=msg%>");
	location.href="student_list.jsp";
</script>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
