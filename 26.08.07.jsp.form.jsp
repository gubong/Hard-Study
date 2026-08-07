<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*" %>
<%
	MemberDao dao = new MemberDao();
	request.setCharacterEncoding("utf-8");
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select==null){
		select = "id";
		search = "";
	}
	out.print("select : "+select+"<br>");
	out.print("search : "+search);	
	ArrayList<MemberDto> arr = dao.getMemberList(select,search);
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권구봉 회원관리</title>
<script type="text/javascript">
	function goWriteForm() {
		//alert("abc~"); 말풍선
		location.href="member_write.jsp";
	}						
	
	function goSearch(){
			//location.href="member_list.jsp";
		mem.method="post";
		mem.action="member_list.jsp";
		mem.submit();
	}
	
	
	
</script>



</head>
<body>
	<h2>권구봉 회원관리</h2>
	
	<form name="mem">
		<table border="0" width="400">
			<tr>
				<td style="text-align:right">
					<select name="t_select">
						<option value="id"<%if(select.equals("id")) out.print("selected"); %>>ID</option>
						<option value="name"<%if(search.equals("name")) out.print("selected"); %> >성명</option>
					</select>
					<input type="text" value="<%= search %>" size="5" name="t_search"/>
					<input type="button" onclick="goSearch()" value="검색">
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1" width="400">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>ID</th>
			<th>성명</th>
		</tr>
		
		<% for(MemberDto dto : arr){ %>
		
		
		<tr>
			<td style="text-align:center">
				<a href="member_view.jsp"><%=dto.getId() %></a>
			</td>
			<td style="text-align:center">
				<a href="member_view.jsp"><%=dto.getName() %></a>   
			</td>
		</tr>
		
		<%} %>
		
	
	</table>

	<table border="0" width="400">
		<tr>
			<td style="text-align:right">
				<input type="button" onclick="goWriteForm()" value="회원등록">
			</td>
		</tr>
	</table>
	
	
	


</body>
</html>