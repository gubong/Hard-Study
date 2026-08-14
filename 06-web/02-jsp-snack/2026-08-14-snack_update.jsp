<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>권구봉 SNACK update </h2>
	<table border="1" width="400">
	<colgroup>
		<col width="30%">
		<col width="*">
	</colgroup>
	<tr>
		<th>제품코드</th>
		<td>001</td>
	</tr>
	<tr>
		<th>제품명</th>
		<td><input type="text" value="새우깡" size="8"></td>
	</tr>
	<tr>
		<th>제조사</th>
		<td>
			<select>
				<option selected>농심</option>
				<option>롯데</option>
				<option>해태</option>
			</select>
		</td>
	</tr>	
	<tr>
		<th>가격</th>
		<td><input type="text" value="1,230" style="text-align: right" size="8"></td>
	</tr>
	<tr>
		<th>제조일자</th>
		<td><input type="date" value="2026-08-25"></td>
	</tr>
</table>
<table border="0" width="400">
	<tr>
		<td style="text-align: center">
			<input type="button" value="목록">
			<input type="button" value="등록">
		</td>
	</tr>
</table>

</body>
</html>