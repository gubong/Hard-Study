<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	SnackDao dao = new SnackDao();
	String pcode = request.getParameter("t_pcode");
	String pname = request.getParameter("t_pname");
	String company = request.getParameter("t_company");
	String makedate = request.getParameter("t_makedate");
	int price = Integer.parseInt(request.getParameter("t_price"));
	SnackDto dto = new SnackDto(pcode,pname,company,makedate,price);
	int result = dao.snackSave(dto);
	String msg = result ==1 ? "등록성공":"등록실패";
	
%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href="snack_list.jsp";
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