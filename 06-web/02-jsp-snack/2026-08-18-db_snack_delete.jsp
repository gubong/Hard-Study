<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%  String pcode = request.getParameter("t_pcode");
	SnackDao dao = new SnackDao();
	int result = dao.snackDelete(pcode);
	
	String msg = result == 1? "성공":"실패";
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="snack_list.jsp"



</script>


</head>
<body>

</body>
</html>