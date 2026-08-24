<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*" %>
<%
	StudentDao dao = StudentDao.getDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	int kor = Integer.parseInt(request.getParameter("t_kor"));
	int eng = Integer.parseInt(request.getParameter("t_eng"));
	int mat = Integer.parseInt(request.getParameter("t_mat"));
	
	StudentDto dto = new StudentDto(syear,sclass,sno,"",kor,eng,mat);
	int result = dao.studentUpdate(dto);
	
	String msg = result == 1 ? "수정완료":"수정실패";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<form name="stu">
	<input type="hidden" name = "t_syear" value="<%=syear%>">
	<input type="hidden" name = "t_sclass" value="<%=sclass%>" >
	<input type="hidden" name = "t_sno" value="<%=sno%>">
</form>


<script type="text/javascript">
	alert("<%=msg%>");
	stu.method="post";
	stu.action="student_view.jsp";
	stu.submit();

</script>


</head>
<body>

</body>
</html>