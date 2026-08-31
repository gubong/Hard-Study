<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>

<script type="text/javascript">
	function fn_save(){
		if(isEmpty(mem.t_id,"아이디 입력!")) return;
		if(mem.t_id_check.value==""){
			alert("id 중복검사 하시오!")
			mem.t_id.focus();
			return;
		}
		
		if(mem.t_id_check.value=="사용불가"){
			alert("중복된 ID입니다")
			mem.t_id.focus();
			return;
		}
		
		
		if(isEmpty(mem.t_name,"성명 입력!")) return;
		if(isEmpty(mem.t_password,"비밀번호 입력!")) return;
		if(isEmpty(mem.t_password_confirm,"비밀번호 확인 입력!")) return;
		if(mem.t_password.value != mem.t_password_confirm.value){
			alert("비밀번호가 같지 않습니다.");
			mem.t_password_confirm.focus();
			return;
		}	
		if(isEmpty(mem.t_job,"소속 선택!")) return;
		if(isEmpty(mem.t_mobile_2,"휴대전화 번호 입력!")) return;
		if(isEmpty(mem.t_mobile_3,"휴대전화 번호 입력!")) return;
		if(isEmpty(mem.t_email_1,"이메일 입력!")) return;
		
		mem.method="post";
		mem.action="db_member_save.jsp";
		mem.submit();
		
	}
	
	function goCheckId(){
		if(isEmpty(mem.t_id,"아이디 입력!")) return;
		var id = mem.t_id.value;
		$.ajax({
			type :"POST",
			url : "check_id.jsp",
			data: "t_id="+id,
			async:false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!');
			},
			success : function(data){
				var result = $.trim(data);
				mem.t_id_check.value = result;
			//	alert(result);
			}
		});		
	
		
	}
	
	function setEmpty(){
		mem.t_id_check.value = "";
	}
	

</script>



	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원가입</h2>
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
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
        <form name="mem">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                            <input type="text" name="t_id" oninput="setEmpty()" id="mbrId" autofocus class="w150" >
							<a href="javascript:goCheckId()" class="btn_write"><b>ID중복검사</b></a>
                            <input type="text" name="t_id_check" style="border:none" readonly>
						</td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="t_name" id="mbrName"  class="w150">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_password" id="scrtNo" class="200">
                            <p class="guideTxt"><span class="tc_point"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw_confirm">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_password_confirm" id="scrtNoConfirm" class="w200">
                            <p class="guideTxt"></p>
                        </td>
                    </tr>
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                                <option value="">선택</option>
                                <option value="기업">기업</option>
                                <option value="교수자">교수자</option>
                                <option value="미취없자">미취업자</option>
                                <option value="기타">기타</option>
                            </select>
                            <p class="guideTxt">학생 신분은 '미취업자-학생' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="t_tell_1" id="telNo1" class="w95">
                                <option value="">선택</option>
                                    <option value="02">02</option>
                                    <option value="042">042</option>
                                    <option value="051">051</option>
                                    <option value="061">061</option>
                                    <option value="070">070</option>
                            </select>
                            <input type="text" name="t_tell_2" id="telNo2" class="w100" value="" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" id="telNo3" class="w100" value="" maxlength="4"><label for="phone_number3" class="blind">마직막번호</label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                            </select>
                            <input type="text" name="t_mobile_2" id="mphonNo2" class="w100"  maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" id="mphonNo3" class="w100"  maxlength="4"><label for="mphonNo3" class="blind">마직막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" name="t_email_1" id="email" class="w150" >
                            <select name="t_email_2">
                            	<option value="naver.com">naver.com</option>
                            	<option value="gmail.com">gmail.com</option>
                            	<option value="daum.net">daum.net</option>
                            </select>
                        </td>
                    </tr>
         		 </tbody>
            </table>
       	</form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취 소</b></a>
        <a href="javascript:fn_save()" class="btn_round btn_large btn_pointColor w180"><b>확 인</b></a>
    </div>
	
	
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









    