<%@ page import="dao.*,dto.*,java.util.*"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	SnackDao dao = new SnackDao();

	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	
	if(select==null){
		select="all";
		search="";
	}
	List<SnackDto> arr = new ArrayList<>();
	arr = dao.allJo(select,search);
	List<CompanyDto> companyArr = dao.getCompanyList();
	

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권구봉</title>

<script type="text/javascript">
	function goSearch(){
		snack.method="post";
		snack.action="snack_list.jsp"
		snack.submit();
	}
	
	
	function goView(pcode){
		snack.t_pcode.value = pcode;	//스낵폼의,피코드의,벨류를,  넘어온pcode값으로지정.
		snack.method="post";
		snack.action="snack_view.jsp"
		snack.submit();
	}
	

</script>
</head>
<body>
<h2>권구봉 SNACK list</h2>

<form name="snack">
	<input type="hidden" name="t_pcode">


	<table border="0" width="400">
		<tr>
			<td style="text-align: right">
				<select name="t_select">
					<option value="all" <%if(select.equals("all")) out.print("selected"); %>  >전체</option>
						<% for(CompanyDto dto : companyArr){ %>
						<option value="<%=dto.getCompany_code() %>"  <%if(select.equals(dto.getCompany_code())) out.print("selected"); %>>
							<%=dto.getCompany_name() %></option>
						<% } %>
				</select>
				제품명
				<input type="text" name="t_search" value="<%=search%>" size="3">
				<input type="button" onclick="goSearch()" value="검색">
			</td>
		</tr>
	</table>
</form>

<table border="1" width="400">
	<colgroup>
		<col width="30%">
		<col width="*">
	</colgroup>
	<tr>
		<th>제품코드</th>
		<th>제품명</th>
	</tr>
	
	<% for(SnackDto dto : arr){ %>
	
	<tr>
		<td style="text-align: center"><a href="javascript:goView('<%=dto.getPcode() %>')"><%=dto.getPcode() %></a></td>
		<td style="text-align: center"><a ><%=dto.getPname() %></a></td>
		
	</tr>
	
	<%}%>
	
	<tr>
		<td></td>
		<td></td>
	</tr>
</table>


<table border="0" width="400">
	<tr>
		<td style="text-align: right">
			<input type="button" onclick="location.href='snack_write.jsp'" value="제품등록">
		</td>
	</tr>
</table>



</body>
</html>