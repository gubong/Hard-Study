<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();	

	String id = request.getParameter("t_id");
	MemberDto dto = dao.getMemberView(id);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권구봉 회원관리</title>
<script type="text/javascript">
	function goList(){
		location.href="member_list.jsp";
	}
	function goUpdateForm(){
		mem.method="post";
		mem.action="member_update.jsp";
		mem.submit();
	}
</script>
</head>
<body>




<h2>권구봉 회원관리</h2>

<%
	if(dto == null) {
%>		
		<table width="400" border="1">
			<tr>
				<th>
					정보 없음!
				</th>
			</tr>
			<tr>
				<th>
					<input type="button" onclick="goList()" value=" 목록 ">
				</th>
			</tr>
		</table>	
<%		
	} else {
%>
		<form name="mem">
			<input type="hidden" name="t_id" value="<%=dto.getId()%>">
		</form>
		
		<table width="400" border="1">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<tr>
				<th>I D</th>
				<td><%=dto.getId()%></td>
			</tr>
			<tr>
				<th>성 명</th>
				<td><%=dto.getName()%></td>
			</tr>
			<tr>
				<th>지 역</th>
				<td><%=dto.getArea()%>
				</td>
			</tr>
			<tr>
				<th>나 이</th>
				<td><%=dto.getAge()%></td>
			</tr>	
		</table>
		
		<table width="400" border="0">
			<tr>
				<th>
					<input type="button" onclick="goList()" value=" 목록 ">&nbsp;
					<input type="button" onclick="goUpdateForm()" value=" 수정 ">&nbsp;
					<input type="button" onclick="" value=" 삭제 ">
				</th>
			</tr>
		</table>	
<% } %>

</body>
</html>






