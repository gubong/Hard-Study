<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");

	List<MemberDto> arr	= 
					(List<MemberDto>)request.getAttribute("t_arr");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");

%>
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>권구봉 AI 1기</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script>
		function gosearch(){
			mem.method="post";
//			mem.action="MemberList";
			mem.action="Member";
			mem.submit();
		}
		
		function goView(id){
			work.t_gubun.value="view";
			work.t_id.value=id;
			work.method="post";
//			work.action="MemberView";
			work.action="Member";
			work.submit();
		}
		function goWriteForm(){
			work.t_gubun.value="writeForm";
			work.method="post";
			work.action="Member";
			work.submit();			
		}
	</script>
	
</head>
<body>
<form name="work">
	<input type="hidden" name="t_id">
	<input type="hidden" name="t_gubun" >
</form>
	<div class="container">
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>JSL 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총 회원수 : <span><%=arr.size() %></span>명</p>
			</div>
			<form name="mem">
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="id" <%if(select.equals("id")) out.print("selected"); %>>ID</option>
						<option value="name"<%if(search.equals("name")) out.print("selected"); %>>성명</option>
					</select>
					<input type="text" name="t_search" value="" class="search_word">
					<button class="btn_search" onclick="gosearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
				</tr>
			</thead>
			<tbody>
			<% for(MemberDto dto : arr){ %>
				<tr>
					<td><a href=""><%=dto.getId() %></a></td>
					<td><a href="javascript:goView('<%=dto.getId()%>')"><%=dto.getName() %></td>
				</tr>
			<%} %>	
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:goWriteForm()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







    