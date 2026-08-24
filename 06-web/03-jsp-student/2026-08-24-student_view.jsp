<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	StudentDao dao = StudentDao.getDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	StudentDto dto = dao.getStudentView(syear,sclass,sno);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goUpdateForm(){
		stu.method="post";
		stu.action="student_update.jsp";
		stu.submit();
	}
	
	function goDelete(){
		if(confirm("정말 삭제?")){
			stu.method="post";
			stu.action="db_student_delete.jsp";
			stu.submit();
		}
	}
	

</script>

</head>
<body>
	<h2>권구봉 view</h2>
<form name="stu">
	<input type="hidden" name = "t_syear" value="<%=syear%>">
	<input type="hidden" name = "t_sclass" value="<%=sclass%>" >
	<input type="hidden" name = "t_sno" value="<%=sno%>">
</form>
<table border="2" width="500">
	<colgroup>
		<col width="20%">
		<col width="80%">
	</colgroup>
	<tr>
		<th>학년</th>
		<td><%=dto.getSyear()%></td>
	</tr>
	
	<tr>
		<th>반</th>
		<td><%=dto.getSclass()%> </td>
	</tr>		

	<tr>
		<th>번호</th>
		<td><%=dto.getSno()%></td>
	</tr>
	
	<tr>
		<th>성명</th>
		<td><%=dto.getName() %></td>
	</tr>
	
	<tr>
		<th>국어</th>
		<td><%=dto.getKor() %></td>
	</tr>
	
	<tr>
		<th>영어</th>
		<td><%=dto.getEng() %></td>
	</tr>
	
	<tr>
		<th>수학</th>
		<td><%=dto.getMat() %></td>
	</tr>

	<tr>
		<th>총점</th>
		<td>
			<% int total = dto.getKor()+dto.getEng()+dto.getMat(); 
				out.print(total);
			%>
		</td>
	</tr>

	<tr>
		<th>평균</th>
		<td>
			<% 
				DecimalFormat df = new DecimalFormat("0.##");
				double ave = total/3; 
				out.print(df.format(ave));
				// 10.0 >>#.# : 10
				// 10.0 >>#.0 : 10.0
				
			%>
		</td>
	</tr>


</table>
<table border="0" width="500">	
	<tr>
		<th > 
			<input type="button" onclick="location.href = 'student_list.jsp'" value="목록" >
		 	<input type="button" onclick="goUpdateForm()" value="수정" > 
		 	<input type="button" onclick="goDelete()" value="삭제" > 

		 </th>
	</tr>
</table>



</body>
</html>