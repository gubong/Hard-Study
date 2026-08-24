<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>    
<%
	StudentDao dao = StudentDao.getDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	StudentDto dto = dao.getStudentView(syear,sclass,sno);
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/common.js" ></script>
<script type="text/javascript">
	function goD(){
		if(isEmpty(stu.t_kor,"국어점수!")) return;
		var kor = stu.t_kor.value;
		if(isNaN(kor)){
			alert("정수 입력!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_kor.focus();
			return;
		}
		
		if(Number(kor)>100 || Number(kor)<0){
			alert("점수0~100!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_kor.select();
			return;
		}
		
		if(isEmpty(stu.t_eng,"영어점수!")) return;
		var eng = stu.t_eng.value;
		if(isNaN(stu.t_eng.value)){
			alert("정수 입력!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_eng.focus();
			return;
		}
		
		if(Number(eng)>100 || Number(eng)<0){
			alert("점수0~100!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_eng.select();
			return;
		}
		
		if(isEmpty(stu.t_mat,"수학점수!")) return;
		var mat = stu.t_mat.value;
		if(isNaN(stu.t_mat.value)){
			alert("정수 입력!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_mat.focus();
			return;
		}
		if(Number(mat)>100 || Number(mat)<0){
			alert("점수0~100!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_mat.select();
			return;
		}
		
		stu.method="post";
		stu.action="db_student_update.jsp";
		stu.submit();
		
		
	}

</script>

</head>
<body>
	<h2>권구봉 update</h2>
<form name="stu">
	<input type="hidden" name = "t_syear" value="<%=syear%>">
	<input type="hidden" name = "t_sclass" value="<%=sclass%>" >
	<input type="hidden" name = "t_sno" value="<%=sno%>">
	<table border="2" width="500">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>학년</th>
			<td><%=dto.getSyear()%></td>
		</tr>
		
		<tr>
			<th>반</th>
			<td><%=dto.getSclass()%> </td>
		</tr>		
	
		<tr>
			<th>번호</th>
			<td><%=dto.getSno()%></td>
		</tr>
		
		<tr>
			<th>성명</th>
			<td><%=dto.getName() %></td>
		</tr>
		
		<tr>
			<th>국어</th>
			<td><input type="text" style="text-align:center" name="t_kor" value="<%=dto.getKor()%>" size="3"></td>
		</tr>
		
		<tr>
			<th>영어</th>
			<td><input type="text" style="text-align:center" name="t_eng" value="<%=dto.getEng() %>" size="3"></td>
		</tr>
		
		<tr>
			<th>수학</th>
			<td><input type="text" style="text-align:center" name="t_mat" value="<%=dto.getMat() %>" size="3"></td>
		</tr>


	</table>
	<table border="0" width="500">	
		<tr>
			<th > 
				<input type="button" onclick="location.href = 'student_list.jsp'" value="목록" >
			 	<input type="button" onclick="goD()" value="수정" > 
			 </th>
		</tr>
	</table>
</form>



</body>
</html>