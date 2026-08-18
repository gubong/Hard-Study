<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*,dto.*" %>

<%  
	SnackDao dao = new SnackDao();
System.out.println(" update dao : "+dao);

	String pcode = request.getParameter("t_pcode");
	SnackDto dto = dao.getSnackView(pcode);
	List<CompanyDto> arr = dao.getCompanyList();
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*		function goView(){
			history.back();	  }//이전화면으로.
*/		
	function goUpdate(){
				snack.method="post"
				snack.action="db_snack_update.jsp"
				snack.submit();
			}
	
	
	
</script>
</head>
<body>
	<h2>권구봉 SNACK update </h2>
	<form name="snack">
		<input type="hidden" name="t_pcode" value="<%=pcode %>">
		<table border="1" width="400">
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tr>
				<th>제품코드</th>
				<td name="aaa" value="<%=pcode%>"><%=pcode%></td>
			</tr>
			<tr>
				<th>제품명</th>
				<td><input type="text" name="t_pname" value="<%=dto.getPname()%>" size="8"></td>
			</tr>
			<tr>
				<th>제조사</th>
				<td>
					<select name="t_company" >
						<%for(CompanyDto comdto : arr){ %>
						<option value="<%=comdto.getCompany_code()%>" <%if(comdto.getCompany_code().equals(dto.getCompany())) out.print("selected"); %> ><%=comdto.getCompany_name() %></option>
						<%} %>
					</select>
				</td>
			</tr>	
			<tr>
				<th>가격</th>
				<td><input type="text" name="t_price" value="<%=dto.getPrice()%>" style="text-align: right" size="8"></td>
			</tr>
			<tr>
				<th>제조일자</th>
				<td><input type="date" name="t_makedate" value="<%=dto.getMakedate()%>"></td>
			</tr>
		</table>
	</form>
<table border="0" width="400">
	<tr>
		<td style="text-align: center">
			<input type="button" onclick="history.back();" value="이전">
			<input type="button" onclick="goUpdate()" value="등록">
		</td>
	</tr>
</table>

</body>
</html>
