<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
	var passwordConfirm;
	function goUpdate(){
		if(isEmpty(mem.t_name,"성명 입력!")) return;
		

		if(isEmpty(mem.t_address,"주소 입력!")) return;	
		if(isEmpty(mem.t_email_1,"이메일 입력!")) return;	
		if(isEmpty(mem.t_mobile_1,"연락처 입력!")) return;	
		if(isEmpty(mem.t_mobile_2,"연락처 입력!")) return;	
		if(isEmpty(mem.t_mobile_3,"연락처 입력!")) return;	
		
		
		if(isEmpty(mem.t_password_confirm,"비밀번호 확인 입력!")) return;
		
		goCheckPassword();
		if(passwordConfirm == "fail"){
			alert("비밀번호가 정확하지 않습니다.");
			mem.t_password_confirm.focus();
			return;
		}
		
		mem.t_gubun.value="memberUpdate";
		mem.method="post";
		mem.action="member";
		mem.submit();
}
	
	function goCheckPassword(){
		var id = mem.t_id.value; //aaa
		var password = mem.t_password_confirm.value;//111
		$.ajax({
			type :"POST",
			url : "MemberCheckPassword",
			data: "t_id="+id+"&t_password="+password,
			async:false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!');
			},
			success : function(data){
				//var result = $.trim(data); 
				//passwordConfirm = result;
				passwordConfirm = $.trim(data);
				//mem.check_id.value = result;
				//alert("passwordConfirm : "+passwordConfirm);
			}
		});	
		
		
	}
	

</script>

		<div id="b_left">
			<%@ include file= "../common_member.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER IMFORMATION UPDATE
			</p>
		<form name="mem">
		<input type ="hidden" name="t_gubun">	
		<input type ="hidden" name="t_id" value="${dto.getId()}">	
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${dto.getId()}</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text"  name ="t_name" value="${dto.getName()}" size="8" id="nana"></td>
				</tr>

				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${dto.getArea() eq '서울'}"></c:if>>서울</option>
						<option value="대전" <c:if test="${dto.getArea() eq '대전'}"></c:if>>대전</option>
						<option value="대구"<c:if test="${dto.getArea() eq '대구'}"></c:if>>대구</option>
						<option value="부산"<c:if test="${dto.getArea() eq '부산'}"></c:if>>부산</option>        
						<option value="그 외"<c:if test="${dto.getArea() eq '그 외'}"></c:if>>그 외</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" name="t_address"  value="${dto.getAddress()}" size="40"></td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td><input type="text" name="t_email_1" value="${dto.getEmail_1()}" size="15">@
				  <select name="t_email_2">
				  <option value="gamil.com"<c:if test="${dto.getEmail_2() eq 'gamil.com'}">selected</c:if>>gamil.com</option>
				  <option value="naver.com"<c:if test="${dto.getEmail_2() eq 'naver.com'}">selected</c:if>>naver.com</option>
				  <option value="daum.net"<c:if test="${dto.getEmail_2() eq 'daum.net'}">selected</c:if>>daum.net</option>
				  </select>
				  </td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" name="t_mobile_1" value="${dto.getMobile_1()}" size="2"> -
					<input type="text" name="t_mobile_2" value="${dto.getMobile_2()}" size="3"> -
					<input type="text" name="t_mobile_3" value="${dto.getMobile_3()}" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" <c:if test="${dto.getGender() eq 'f'}">checked</c:if>  class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" <c:if test="${dto.getGender() eq 'm'}">checked</c:if> class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_hobby_travel" <c:if test="${dto.getHobby_travel() eq 'y'}">checked</c:if> class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_reading" <c:if test="${dto.getHobby_reading() eq 'y'}">checked</c:if> class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_sports" <c:if test="${dto.getHobby_sports() eq 'y'}">checked</c:if> class="middleCheck" /> 운동   
				  </td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input type="password" name="t_password_confirm" size="13"></td>
				</tr>
			  </tbody>
			</table>
			</form>	
			<div class="buttonGroup_center">
				<a href="javascript:goUpdate()" class="butt">UPDATE</a>
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
    