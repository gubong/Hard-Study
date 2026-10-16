<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goUpdateForm(){
		stu.key.value="update";
		stu.method="post";
		stu.action="student";
		stu.submit();
	}
	
	function goDelete(){
		stu.key.value="DBdelete";
		if(confirm("정말 삭제?")){
			stu.method="post";
			stu.action="student";
			stu.submit();
		}
	}
	

</script>

</head>
<body>
	<h2>권구봉 view</h2>
<form name="stu">
	<input type="hidden" name = "key">
	<input type="hidden" name = "t_syear" value="${syear}">
	<input type="hidden" name = "t_sclass" value="${sclass}" >
	<input type="hidden" name = "t_sno" value="${sno}">
</form>
<table border="2" width="500">
	<colgroup>
		<col width="20%">
		<col width="80%">
	</colgroup>
	<tr>
		<th>학년</th>
		<td>${dto.getSyear()}</td>
	</tr>
	
	<tr>
		<th>반</th>
		<td>${dto.getSclass()} </td>
	</tr>		

	<tr>
		<th>번호</th>
		<td>${dto.getSno()}</td>
	</tr>
	
	<tr>
		<th>성명</th>
		<td>${dto.getName()}</td>
	</tr>
	
	<tr>
		<th>국어</th>
		<td>${dto.getKor()}</td>
	</tr>
	
	<tr>
		<th>영어</th>
		<td>${dto.getEng()}</td>
	</tr>
	
	<tr>
		<th>수학</th>
		<td>${dto.getMat()}</td>
	</tr>

	<tr>
		<th>총점</th>
		<td>
		${total}
		</td>
	</tr>

	<tr>
		<th>평균</th>
		<td>
		${ave}
		</td>
	</tr>


</table>
<table border="0" width="500">	
	<tr>
		<th > 
			<input type="button" onclick="location.href='student'" value="목록" >
		 	<input type="button" onclick="goUpdateForm()" value="수정" > 
		 	<input type="button" onclick="goDelete()" value="삭제" > 

		 </th>
	</tr>
</table>



</body>
</html>