<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>AI 1기</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script src="js/common.js"></script>	
	<script type="text/javascript">
		function goSave(){
			if(isEmpty(mem.t_id,"id 입력!")) return;
			if(isEmpty(mem.t_name,"성명 입력!")) return;
			mem.t_gubun.value="save";
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
							<td class="th_left">
								<input name="t_id"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>지역</th>
							<td class="th_left">
								<select name="t_area" class="input_100px">
									<option value="">=선택=</option>
									<option value="서울">서울</option>
									<option value="대전">대전</option>
									<option value="대구">대구</option>
									<option value="부산">부산</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age"  class="input_100px" type="text">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" onclick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Member'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















