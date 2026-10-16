<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goSearch(){
		stu.key.value = "";
		stu.method="post";
		stu.action="student";
		stu.submit();
	}

	
	function goALLStudent(){
		stu.key.value="";
		stu.t_workGubun.value = "all";
		stu.method="post";
		stu.action="student";
		stu.submit();
	}
	
	function goView(a,b,c){
		view.key.value="view";
		view.t_syear.value= a;
		view.t_sclass.value= b;
		view.t_sno.value= c;

		view.method="post";
		view.action="student";
		view.submit();
	}
	
	function gowrite(){
		view.key.value="write";
		view.method="post";
		view.action="student";
		view.submit();
	}
	

</script>


</head>
<body>
<form name="view">
	<input type="hidden" name = "key">
	<input type="hidden" name = "t_syear">
	<input type="hidden" name = "t_sclass">
	<input type="hidden" name = "t_sno">
</form>
		<h2>권구봉 list</h2>
	<form name = "stu">
		<input type="hidden" name = "key">
		<input type= "hidden" name="t_workGubun">
		<table border="0" width="500">
			<tr>
				<td style="text-align:right">						
					학년 <select name="t_syear">
						<option value="1"<c:if test="${syear eq '1'}">selected</c:if>>1학년</option>
						<option value="2"<c:if test="${syear eq '2'}">selected</c:if>>2학년</option>
						<option value="3"<c:if test="${syear eq '3'}">selected</c:if>>3학년</option>
						</select>&nbsp;&nbsp;
					반 <select name="t_sclass">
							<option value="1" <c:if test="${sclass eq '1'}">selected</c:if>>1반</option>
							<option value="2" <c:if test="${sclass eq '2'}">selected</c:if>>2반</option>
							<option value="3" <c:if test="${sclass eq '3'}">selected</c:if>>3반</option>
							<option value="4" <c:if test="${sclass eq '4'}">selected</c:if>>4반</option>
							<option value="5" <c:if test="${sclass eq '5'}">selected</c:if>>5반</option>
						</select>
					
					구분 <select name="t_gubun">
						<option value="sno" <c:if test="${gubun eq 'sno'}">selected</c:if>>번호</option>
						<option value="name" <c:if test="${gubun eq 'name'}">selected</c:if>>성명</option>
						</select>&nbsp;&nbsp;				
					<input type="text" size="3" name="t_search" value="${search}" >
					<input type="button" onclick="goSearch()" value="검 색">
					<input type="button" onclick="goALLStudent()" value="전체출력">
	
				</td>
			</tr>
		</table>
	</form>
	<c:if test="${workGubun eq 'all'}">
		<p>[전체출력]</p>
	</c:if>
	<p>총 : ${arr.size()}명</p>
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
		<c:if test="${arr.size() eq '0'}">
		<tr>
			<th colspan="4"> 정보없음 </th>
		</tr>
		</c:if>
		
		<c:forEach items="${arr}" var="dto">
		<tr>
			<td style="text-align: center">${dto.getSyear()}</td>		
			<td style="text-align: center">${dto.getSclass()}</td>		
			<td style="text-align: center">${dto.getSno()}</td>		
			<td style="text-align: center">
				<a href="javascript:goView('${dto.getSyear()}','${dto.getSclass()}','${dto.getSno()}')"> ${dto.getName()} </a>
				<br>  
				<a href="javascript:goView('${dto.getSyear()}','${dto.getSclass()}','${dto.getSno()}')"> ${dto.getName()} </a>
			 </td>		
		</tr>
		</c:forEach>
	</table>
	<table border="0" width="500">	
		<tr>
			<td style="text-align: right"> <input type="button"  onclick="gowrite()" value="등록" > </td>
		</tr>
	</table>


</body>
</html>