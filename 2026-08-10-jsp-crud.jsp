<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>   
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");	
	if(select == null){
		select = "id";
		search = "";
	}
	out.print(" select : "+select+"<br>");
	out.print(" search : "+search);
	
	ArrayList<MemberDto> arr = dao.getMemberList(select,search);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홍길동 회원관리</title>
<script type="text/javascript">
	function goWriteForm(){
		//document.write("ddddd");
		location.href="member_write.jsp";
	}
	function goSearch(){
//http://localhost:8080/jsp_member/member/member_list.jsp	  post	
//http://localhost:8080/jsp_member/member/member_list.jsp?t_select=name&t_search=동  get
		
		//member_view.jsp?t_id=101
		
		//location.href="member_list.jsp";
		mem.method="post"; // post, get
		mem.action="member_list.jsp";
		mem.submit();
	}
	
	function goView(id){
		work.t_id.value = id;
		work.method="post";
		work.action="member_view.jsp";
		work.submit();
	}
</script>


</head>
<body>
	<h2>홍길동 회원관리</h2>

	<form name="work">
		<input type="hidden" name="t_id" >
	</form>

 	<form name="mem">	
	<table width="400" border="0">
		<tr>
			<td style="text-align:right">
				<select name="t_select">
					<option value="id"  <%if(select.equals("id")) out.print("selected"); %>  >ID</option>
					<option value="name" <%if(select.equals("name")) out.print("selected"); %> >성명</option>
				</select>
				<input type="text" name="t_search" value="<%=search%>" size="5">
				<input type="button" onclick="goSearch()" value=" 검색 ">
			</td>
		</tr>
	</table>
	</form>
	
	
	<table width="400" border="1">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>I D</th>
			<th>성 명</th>
		</tr>
		
<%
		for(MemberDto dto : arr){
%>	
		<tr> 
			<td style="text-align:center">
				<a href="javascript:goView('<%=dto.getId()%>')"><%=dto.getId()%></a>
			</td> 
			<td style="text-align:center">
				<a href="member_view.jsp?t_id=<%=dto.getId()%>"><%=dto.getName()%></a>
			</td>
		</tr>
<%		} %>		
		
	</table>

	<table width="400" border="0">
		<tr>
			<td style="text-align:right">
				<input type="button" onclick="goWriteForm()" value=" 회원등록 ">
			</td>
		</tr>
	</table>	
	
</body>
</html>










