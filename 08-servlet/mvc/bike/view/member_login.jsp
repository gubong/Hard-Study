<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>	
<script>
	function memberLogin(){
		if(isEmpty(Login.t_id,"id 입력!")) return;
		if(isEmpty(Login.t_password,"비밀번호 입력!")) return;
		Login.t_gubun.value = "memberLogin";
		Login.method="post";
		Login.action="member";
		Login.submit();
	}
</script>
		<div id="b_left">
			<%@ include file="../common_member.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="Login">
							<input type="hidden" name="t_gubun">
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" autofocus type="text" onkeypress="if( event.keyCode==13 ){Login.t_password.focus()}"></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_password" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){memberLogin()}"></div>
							<a class="btn_login btn_Blue" href="javascript:memberLogin()">로그인</a>
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






    