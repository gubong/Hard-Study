<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	//SnackDao dao = new SnackDao();
	SnackDao dao = SnackDao.getDao();

	String pcode = request.getParameter("t_pcode");
	String pname = request.getParameter("t_pname");
	String company = request.getParameter("t_company");
	int price = Integer.parseInt(request.getParameter("t_price"));
	String makedate = request.getParameter("t_makedate");
	
	SnackDto dto = new SnackDto(pcode,pname,company,makedate,price);
	int result = dao.snackUpdate(dto);
	String msg = result == 1 ? "수정완료":"수정실패";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="snack_list.jsp";

</script>

</head>
<body>

</body>
</html>