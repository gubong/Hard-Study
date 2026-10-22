<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>   


<script>
	function goJoin(){
		if(isEmpty(mem.t_id,"ID 입력!")) return;
		var id_length = mem.t_id.value.length;
		if(id_length < 3 || id_length > 10){
			alert("ID는 3자리 이상 10자리 이내 입니다!")
			mem.t_id.focus();
			return;
		}
		
		if(mem.check_id.value == ""){
			alert("ID 중복검사 하시오!");
			mem.t_id.focus();
			return;
		}
			if (mem.check_id.value == "사용불가") {
			    alert("사용 불가 ID입니다.");
			    mem.t_id.focus();
			    return;
			}
		
		if(isEmpty(mem.t_name,"성명 입력!")) return;
		if(isEmpty(mem.t_password,"비밀번호 입력!")) return;
		if(isEmpty(mem.t_password_confirm,"비밀번호 확인 입력!")) return;
		if(mem.t_password.value != mem.t_password_confirm.value){
			alert("비밀번호가 같지 않습니다!");
			mem.t_password_confirm.focus();
			return;
		}
		

		if(isEmpty(mem.t_address,"주소 입력!")) return;	
		if(isEmpty(mem.t_email_1,"이메일 입력!")) return;	
		if(isEmpty(mem.t_mobile_1,"연락처 입력!")) return;	
		if(isEmpty(mem.t_mobile_2,"연락처 입력!")) return;	
		if(isEmpty(mem.t_mobile_3,"연락처 입력!")) return;	
		if(isEmpty(mem.t_gender,"성별 입력!")) return;	
		
		mem.t_gubun.value="memberSave";
		mem.method="post";
		mem.action="Member";
		mem.submit();
}
	
	function goCheckId(){
		if(isEmpty(mem.t_id,"id 입력 후 중복검사!")) return;
		var id = mem.t_id.value;
		$.ajax({
			type :"POST",
			url : "MemberCheckId",
			data: "t_id="+id,
			async:false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!');
			},
			success : function(data){
				var result = $.trim(data); //$.trim 앞 뒤 공백을 없애줌
				mem.check_id.value = result;
				//alert("=="+result+"==");
			}
		});	
		
		
	}

	function setEmpty(){
		mem.check_id.value="";
		
	}
	

</script>

		<div id="b_left">
			<%@ include file= "../common_member.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
		<form name="mem">
		<input type ="hidden" name="t_gubun">	
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" oninput="setEmpty()" size="10" id="id">
					<input type="button" onclick="goCheckId()" value="ID중복검사" class="checkB">
					<input type = "text" name ="check_id" disabled style="border:none">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text"  name ="t_name" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input type="password" name="t_password" size="13"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input type="password" name="t_password_confirm" size="13"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="부산">부산</option>        
						<option value="그 외">그 외</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" name="t_address" size="40"></td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td><input type="text" name="t_email_1" size="15"> @
				  <select name="t_email_2">
				  <option value="gamil.com">gamil.com</option>
				  <option value="naver.com">naver.com</option>
				  <option value="daum.net">daum.net</option>
				  </select>
				  </td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" name="t_mobile_1" size="2"> -
					<input type="text" name="t_mobile_2" size="3"> -
					<input type="text" name="t_mobile_3" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_hobby_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_sports" class="middleCheck" /> 운동   
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>	
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">JOIN</a>
			</div>	
		</div>	
	</div>
	<div id="footer_div">	
		<div id="footer">
			<%@ include file = "../common_footer.jsp" %>  
			</div>		
		</div>	
	</div>	
</body>
</html>
    