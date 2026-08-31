<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common_header.jsp"%>
<%
//onkeypress-키 눌릴때마다 실행,  event>자바스크립트에있는기본클래스, keycode값을 돌려줌.
%>
<script type="text/javascript">	

	function checkEnter(){
		var keyValue = event.keyCode;			
		if(keyValue == 13){
			mem.t_new_password.focus();
		}
	}
	
	function checkEnter2(){
		var keyValue = event.keyCode;			
		if(keyValue == 13){
			mem.t_new_password_confirm.focus();
		}
	}	
		
	function checkEnterPassword(){
		var keyValue = event.keyCode;			
		if(keyValue == 13){
			fn_goPasswordUpdate();
		}
	}
	
	var password_TF = true;
	function fn_goPasswordUpdate(){
		if(isEmpty(mem.t_now_password,"현재 비밀번호 입력")) return;
		if(isEmpty(mem.t_new_password,"새 비밀번호 입력")) return;
		if(isEmpty(mem.t_new_password_confirm,"새 비밀번호 확인 입력")) return;
		
		if(mem.t_new_password.value != mem.t_new_password_confirm.value){
			alert("새 비밀번호 확인이 같지 않습니다.");
			mem.t_new_password_confirm.focus();
			return;
		}
		
		goCheckPassword();
		if(password_TF ==false){
			alert("현재 비밀번호 틀림");
			mem.t_now_password.focus();
		}else{
			mem.method="post";
			mem.action="db_password_update.jsp";
			mem.submit();
		}
		}
	
	
	function goCheckPassword(){
		var id = mem.t_id.value;
		var password = mem.t_now_password.value;
		
		$.ajax({
			type :"POST",
			url : "check_password.jsp",
			data: "t_id="+id+"&t_password="+password,
			async:false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!');
			},
			success : function(data){
				var result = $.trim(data);
				if(result == "no") password_TF = false;
				else password_TF = true;
			}
		});		
	
		
	}
	
	
</script>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>비밀번호 변경</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="member_boxL">
			<h2>회원 비밀번호 변경</h2>
			<div class="login_form">
				<form name="mem" >
				<input type="hidden" name="t_id" value="<%=sessionId %>">
				<div class="fl_clear"><label for="mbrId" class="pw">현재 비밀번호</label><input name="t_now_password" onkeypress="checkEnter()"  id="t_now_pass" type="text"  autofocus ></div>
				<div class="fl_clear"><label for="scrtNo" class="pw">새 비밀번호</label><input name="t_new_password" onkeypress="checkEnter2()" id="scrtNo" type="password"></div>
				<div class="fl_clear"><label for="scrtNo" class="pw">새 비밀번호 확인</label><input name="t_new_password_confirm" onkeypress="checkEnterPassword()" id="scrtNo" type="password"></div>
				<a class="btn_login btn_Blue btn_password" href="javascript:fn_goPasswordUpdate()">변경</a>
				</form>
			</div>
		   
		</div>

	  
	</div>
	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<footer class="footer">
	<%@ include file="../common_footer.jsp" %>
</footer>

 </body>
</html>









