<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*,dto.*" %>
  
 <%
 	request.setCharacterEncoding("UTF-8");
 	MemberDao dao = new MemberDao();
 	String id = request.getParameter("t_id");
 	String name = request.getParameter("t_name");
 	String area = request.getParameter("t_area");
 	String age = request.getParameter("t_age");	//리턴타입은무조건스트링
	if(age.equals("")) age="0";
	
 	MemberDto dto = new MemberDto(id,name,area,Integer.parseInt(age));
 	int result = dao.memberSave(dto);
 	
 	String msg = "등록 성공!";
 	if(result!=1) msg= "등록실패!";
 	
 	String aaa = result == 1 ? "":""; 
 	
 	
 	
 %>
   
   
   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	alert("<%=msg%>");
	
	location.href="member_list.jsp";
	
</script>

</head>
<body>

</body>
</html>
