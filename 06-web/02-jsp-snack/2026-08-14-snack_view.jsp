<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	SnackDao dao = new SnackDao();
	String pcode = request.getParameter("t_pcode");
	SnackDto dto = dao.getSnackView(pcode);
	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<td><%=dto.getPrice() %>원</td>
	</tr>
	<tr>
		<th>제조일자</th>
		<td><%=dto.getMakedate()%></td>
	</tr>
</table>
<table border="0" width="400">
	<tr>
		<td style="text-align: center">
			<input type="button" value="목록">
			<input type="button" value="수정">
			<input type="button" value="삭제">
		</td>
	</tr>
</table>

</body>
</html>