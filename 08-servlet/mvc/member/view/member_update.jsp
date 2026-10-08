<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>
<%
	MemberDto dto = (MemberDto)request.getAttribute("t_dto");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>AI 1기</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">
		function goUpdate(){
			mem.t_gubun.value="update";
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>JSL 홍길동 회원관리</h1>
		</div>		
		<div class="write_wrap">
			<form name="mem">
			<input type="hidden" name="t_id" value="<%=dto.getId()%>">
			<input type="hidden" name="t_gubun">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td class="th_left"><%=dto.getId() %></td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name" value="<%=dto.getName() %>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>지역</th>
							<td class="th_left">
								<select name="t_area" class="input_100px">
									<option value="서울" <%if(dto.getArea().equals("서울")) out.print("selected");%>>서울</option>
									<option value="대전" <%if(dto.getArea().equals("대전")) out.print("selected");%>>대전</option>
									<option value="대구" <%if(dto.getArea().equals("대구")) out.print("selected");%>>대구</option>
									<option value="부산" <%if(dto.getArea().equals("부산")) out.print("selected");%>>부산</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age" value="<%=dto.getId() %>" class="input_100px" type="text">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="수정저장" onclick="goUpdate()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Member'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















