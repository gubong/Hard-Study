<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/common.js" ></script>
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">

	function goSave(){
/*		var a = 12.1234;
		var tf = isNaN(a);
		alert(tf);

	ajax는 웹페이지를 새롭게 읽지 않고, 서버와 데이터를 주고받는 자바스크립트 기술.
	페이지는 멈춰있고, 뒤에서 데이터를 주고받을 수 있음.
*/		
		if(isEmpty(stu.t_syear,"학년 선택!")) return;
		if(isEmpty(stu.t_sclass,"반선택!")) return;
		if(isEmpty(stu.t_name,"이름선택!")) return;
		
		if(stu.checkInfo.value == ""){
			alert("중복검사하시오!");
			return;
		}
		
		
		if(stu.checkInfo.value == "사용불가"){
			alert("중복된 학년반번호입니다.");
			return;
		}
		
		if(isEmpty(stu.t_kor,"국어선택!")) return;
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
		
		if(isEmpty(stu.t_eng,"영어선택!")) return;
		var eng = stu.t_eng.value;
		if(isNaN(stu.t_eng.value)){
			alert("정수 입력!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_eng.focus();
			return;
		}
		
		if(Number(eng)>100 || Number(kor)<0){
			alert("점수0~100!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_eng.select();
			return;
		}
		
		if(isEmpty(stu.t_mat,"수학선택!")) return;
		var mat = stu.t_mat.value;
		if(isNaN(stu.t_mat.value)){
			alert("정수 입력!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_mat.focus();
			return;
		}
		if(Number(mat)>100 || Number(kor)<0){
			alert("점수0~100!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			stu.t_mat.select();
			return;
		}
		
		stu.method="post";
		stu.action="db_student_save.jsp";
		stu.submit();
		
		
		
	}
	
	
	function checkStudent(){
		if(isEmpty(stu.t_syear,"학년 선택!")) return;
		if(isEmpty(stu.t_sclass,"반선택!")) return;
		
		var syear = stu.t_syear.value;
		var sclass = stu.t_sclass.value;
		var sno = stu.t_sno.value;
		
		$.ajax({
			type :"POST",
			url : "check_student.jsp",
			data: "a_syear="+syear+"&a_sclass="+sclass+"&a_sno="+sno,
			async:false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!');
			},
			success : function(data){
				var result = $.trim(data);
				if(result == "yes") result = "사용가능";
				else result = "사용불가";
				stu.checkInfo.value= result;
			}
		});		
		
		
		
	}


</script>
<style type="text/css">
	.checkinput{
		border:none;
	}

</style>

</head>
<body>
	<h2>권구봉 write</h2>
<form name="stu">
	<table border="2" width="500">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>학년</th>
			<td>
				<input type="radio" name="t_syear" value="1">1학년
				<input type="radio" name="t_syear" value="2">2학년
				<input type="radio" name="t_syear" value="3">3학년
			</td>
			
		</tr>
		
		<tr>
			<th>반</th>
			<td>
				<input style="text-align: left" type="radio" name="t_sclass" value="1">1반
				<input style="text-align: left" type="radio" name="t_sclass" value="2">2반
				<input style="text-align: left" type="radio" name="t_sclass" value="3">3반
				<input style="text-align: left" type="radio" name="t_sclass" value="4">4반
				<input style="text-align: left" type="radio" name="t_sclass" value="5">5반
			</td>
		</tr>		

		<tr>
			<th>번호</th>
			<td>
				<select name="t_sno"> 
					<option value="1">1번</option>
					<option value="2">2번</option>
					<option value="3">3번</option>
					<option value="4">4번</option>
				</select>
				<input type="button" value="중복검사" onclick="checkStudent()" >
				<input type="text" size="3" name="checkInfo" class="checkinput" readonly>
			</td>
		</tr>
		
		<tr>
			<th>성명</th>
			<td><input type="text" name="t_name"></td>
		</tr>
		
		<tr>
			<th>국어</th>
			<td><input type="text" style="text-align:center" name="t_kor"></td>
		</tr>
		
		<tr>
			<th>영어</th>
			<td><input type="text" style="text-align:center" name="t_eng"></td>
		</tr>
		
		<tr>
			<th>수학</th>
			<td><input type="text" style="text-align:center" name="t_mat"></td>
		</tr>


	</table>
	<table border="0" width="500">	
		<tr>
			<th > 
				<input type="button" onclick="location.href = 'student_list.jsp'" value="목록" >
			 	<input type="button" onclick="goSave()" value="등록" > 
			 </th>
		</tr>
	</table>
</form>



</body>
</html>
