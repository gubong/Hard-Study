<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*"%>
<%
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
	function goList() {
		location.href="member_list.jsp";
	}
	
	function goUpdate(){
		if(mem.t_name.value ==""){
			alert("성명기입");
			mem.t_name.focus();
			return;
		}
		mem.method="post";
		mem.action="db_member_update.jsp";
		mem.submit();
	}
	
	

</script>
</head>
<body>

	<h2>권구봉 회원관리</h2>
	
	<form name="mem">
	
		<input type="hidden" value="<%=id %>" name="t_id">
		<table border="1" width="400">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<tr>
				<th>ID</th>
				<td><%=id %></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name = "t_name" value="<%=dto.getName()%>" size="5" /></td>
			</tr>
			<tr>
				<th>지역</th>
				<td>
					<select name="t_area">
						<option value="" <% if(dto.getArea().equals("")) out.print("selected");%>>=선택=</option>
						<option value="서울" <% if(dto.getArea().equals("서울")) out.print("selected");%>>서울</option>
						<option value="대전" <% if(dto.getArea().equals("대전")) out.print("selected");%>>대전</option>
						<option value="대구" <% if(dto.getArea().equals("대구")) out.print("selected");%>>대구</option>
						<option value="부산" <% if(dto.getArea().equals("부산")) out.print("selected");%>>부산</option>
					</select>
				</td>
			</tr>					
			<tr>
				<th>나이</th>
				<td><input type="text" name="t_age" value="<%=dto.getAge() %>" size="2"/></td>
			</tr>
		</table>	
		<table border="0" width="400">
			<tr>
				<th>
					<input type="button" onclick="goList()" value="목록">
					<input type="button" onclick="goUpdate()" value="저장">
				</th>
			</tr>
		</table>
	</form>
		
		
	
	


</body>
</html>
