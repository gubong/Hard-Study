<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	SnackDao dao = new SnackDao();
System.out.println(" view dao : "+dao);

	String pcode = request.getParameter("t_pcode");
	SnackDto dto = dao.getSnackView(pcode);
	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goUpdateForm(){
		work.method="post";
		work.action="snack_update.jsp";
		work.submit();
	}
	
	function goDelete(){
		if(confirm("정말삭제?")){		//컨펌창에서 확인누르면 트루, 취소누르면 폴스
			work.method="post";
			work.action="db_snack_delete.jsp";
			work.submit();			
		}
	}


</script>
</head>
<body>
	<form name = "work">
		<input type = "hidden" name = "t_pcode" value="<%=pcode%>">
	</form>
	<h2>권구봉 SNACK view</h2>
	<table border="1" width="400">
	<colgroup>
		<col width="30%">
		<col width="*">
	</colgroup>
	<tr>
		<th>제품코드</th>
		<td><%=pcode %></td>
	</tr>
	<tr>
		<th>제품명</th>
		<td><%=dto.getPname() %></td>
	</tr>
	<tr>
		<th>제조사</th>
		<td>[<%=dto.getCompany() %>] <%=dto.getCompanyname() %></td>
	</tr>	
	<tr>
		<th>가격</th>
		<td><%=dao.getWonComma(dto.getPrice())%>원</td>
	</tr>
	<tr>
		<th>제조일자</th>
		<td><%=dto.getMakedate()%></td>
	</tr>
</table>
<table border="0" width="400">
	<tr>
		<td style="text-align: center">
			<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
			<input type="button" onclick="goUpdateForm()" value="수정">
			<input type="button" onclick="goDelete()" value="삭제">
		</td>
	</tr>
</table>

</body>
</html>
