<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>	
<script>
	var	passwordConfirm = "";	
	function goPassword(){
		 if(isEmpty(pw.t_now_password,"현재 비밀번호 입력!")) return;
		 if(isEmpty(pw.t_new_password,"새 비밀번호 입력!")) return;
		 if(isEmpty(pw.t_new_password_confirm,"새 비밀번호 확인!")) return;
		 if(pw.t_new_password.value != pw.t_new_password_confirm.value){
			 alert("새 비밀번호 오타남ㅇ");
			 pw.t_new_password.focus();
			 return;
		 }
		 
		 goCheckPassword();
		 if(passwordConfirm != "success"){
			 alert("현재 비밀번호 오타");
			 pw.t_now_password.focus();
			 return;
		 }else{
			 if(pw.t_now_password.value==pw.t_new_password.value){
				 alert("기존 비번하고 같습니다");
				 pw.t_new_password.focus();
				 return;
			 }
			 
		 }
		 pw.t_gubun.value="passwordUpdate";
		 pw.method="post";
		 pw.action="member";
		 pw.submit();
	 }
	 
	function goCheckPassword(){
		var id = pw.t_id.value; //aaa
		var password = pw.t_now_password.value;//111
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
			<%@ include file="../common_member.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER PASSWORD UPDATE
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>PASSWORD</h2>
					<div class="login_form">
						<form name="pw">
							<input type="hidden" name="t_gubun">
							<input type="hidden" name="t_id" value="${sessionId}">
							<div class="fl_clear"><label class="pw" for="mbrId">현재 비밀번호</label><input name="t_now_password" id="mbrId" autofocus type="password" onkeypress="if( event.keyCode==13 ){Login.t_password.focus()}"></div>
							<div class="fl_clear"><label class="pw" for="scrtNo">새 비밀번호</label><input name="t_new_password" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){memberLogin()}"></div>
							<div class="fl_clear"><label class="pw" for="scrtNo">새 비밀번호 확인</label><input name="t_new_password_confirm" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){memberLogin()}"></div>
							<a class="btn_password btn_Blue" href="javascript:goPassword()">변경</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
	<div id="footer_div">	
		<%@ include file = "../common_footer.jsp" %>
		</div>	
	</div>	
</body>
</html>






    