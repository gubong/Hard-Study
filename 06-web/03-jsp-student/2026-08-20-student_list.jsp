<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*, java.util.*" %>

<%
	StudentDao dao = StudentDao.getDao();
	List<StudentDto> arr = dao.getStudentList();
	
	

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>권구봉 list</h2>
	<table border="0" width="500">
		<tr>
			<td style="text-align:right">
				
				학년 <select>
					<option value="all">=전체=</option>
					<option value="1">1학년</option>
					<option value="2">2학년</option>
					<option value="3">3학년</option>
				</select>&nbsp;&nbsp;
				
				반 <select>
					<option value="all">=전체=</option>
					<option value="1">1반</option>
					<option value="2">2반</option>
					<option value="3">3반</option>
					<option value="4">4반</option>
					<option value="5">5반</option>
				</select>
				
				구분 <select>
					<option value="">번호</option>
					<option value="">성명</option>
				</select>&nbsp;&nbsp;				
				<input type="text" size="3">
				<input type="button" value="검 색">
			</td>
		</tr>
	</table>
	
	
	<table border="1" width="500">
		<colgroup>
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="40%">
		</colgroup>
		<tr>
		<th>학년</th><th>반</th><th>번호</th><th>성명</th>
		</tr>	
		
		<% for(StudentDto dto : arr){ %>
		<tr>
			<td style="text-align: center"><%=dto.getSyear()%></td>		
			<td style="text-align: center"><%=dto.getSclass()%></td>		
			<td style="text-align: center"><%=dto.getSno()%></td>		
			<td style="text-align: center"><%=dto.getName() %></td>		
		</tr>
		<%}%>
	</table>
	<table border="0" width="500">	
		<tr>
			<td style="text-align: right"> <input type="button" value="등록" > </td>
		</tr>
	</table>
	

</body>
</html>
