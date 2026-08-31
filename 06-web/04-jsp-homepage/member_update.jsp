<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>
<%@ page import ="dao.*, dto.*" %>

<%
	if(sessionId.equals("")){
%>
	<script type="text/javascript">
		alert("로그인 정보가 만료되었습니다. 다시 로그인 하세요");
		location.href="member_login.jsp";
	</script>
<% 	
	}else{
		MemberDao dao = MemberDao.getDao();
		MemberDto dto = dao.getMemberInfo(sessionId);	
%>




<script type="text/javascript">
	var password_TF = true;
	
	function fn_update(){
		
		if(isEmpty(mem.t_name,"성명 입력!")) return;
		if(isEmpty(mem.t_mobile_2,"휴대전화 번호 입력!")) return;
		if(isEmpty(mem.t_mobile_3,"휴대전화 번호 입력!")) return;
		if(isEmpty(mem.t_email_1,"이메일 입력!")) return;
		if(isEmpty(mem.t_password_confirm,"비밀번호 확인 입력!")) return;
		
		goCheckPassword();
		
		if(password_TF == false){
			alert("비밀번호가 정확하지 않습니다.");
			mem.t_password_confirm.focus();
			return;
		}else{
			
		}
		
		mem.method="post";
		mem.action="db_member_update.jsp";
		mem.submit();
		
	}
	
	function goCheckPassword(){
		var id = mem.t_id.value;
		var password = mem.t_password_confirm.value;
		
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
        	<input type="hidden" name="t_id" value="<%=dto.getId()%>">
        
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td><%=dto.getId()%></td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="t_name" id="mbrName" value="<%=dto.getName()%>" class="w150">
                        </td>
                    </tr>
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                                <option value="기업" <%if(dto.getJob().equals("기업")) out.print("selected"); %>>기업</option>
                                <option value="교수자" <%if(dto.getJob().equals("교수자")) out.print("selected"); %>>교수자</option>
                                <option value="미취없자" <%if(dto.getJob().equals("미취없자")) out.print("selected"); %>>미취업자</option>
                                <option value="기타" <%if(dto.getJob().equals("기타")) out.print("selected"); %>>기타</option>
                            </select>
                            <p class="guideTxt">학생 신분은 '미취업자-학생' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="t_tell_1" id="telNo1" class="w95">
                               	 	<option value="" <%if(dto.getTell_1().equals("")) out.print("selected"); %> >선택</option>
                                    <option value="02" <%if(dto.getTell_1().equals("02")) out.print("selected"); %> >02</option>
                                    <option value="042" <%if(dto.getTell_1().equals("042")) out.print("selected"); %> >042</option>
                                    <option value="051" <%if(dto.getTell_1().equals("051")) out.print("selected"); %> >051</option>
                                    <option value="061" <%if(dto.getTell_1().equals("061")) out.print("selected"); %> >061</option>
                                    <option value="070" <%if(dto.getTell_1().equals("070")) out.print("selected"); %> >070</option>
                            </select>
                            <input type="text" name="t_tell_2" value="<%=dto.getTell_2() %>" id="telNo2" class="w100" value="" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" value="<%=dto.getTell_3() %>" id="telNo3" class="w100" value="" maxlength="4"><label for="phone_number3" class="blind">마직막번호</label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010" <%if(dto.getMobile_1().equals("010")) out.print("selected"); %> >010</option>
                                    <option value="011" <%if(dto.getMobile_1().equals("011")) out.print("selected"); %> >011</option>
                            </select>
                            <input type="text" name="t_mobile_2" value="<%=dto.getMobile_2() %>" id="mphonNo2" class="w100"  maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" value="<%=dto.getMobile_3() %>" id="mphonNo3" class="w100"  maxlength="4"><label for="mphonNo3" class="blind">마직막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" name="t_email_1" value="<%=dto.getEmail_1() %>" id="email" class="w150" >
                            <select name="t_email_2">
                            	<option value="naver.com" <%if(dto.getEmail_2().equals("naver.com")) out.print("selected"); %>>naver.com</option>
                            	<option value="gmail.com" <%if(dto.getEmail_2().equals("gmail.com")) out.print("selected"); %>>gmail.com</option>
                            	<option value="daum.net"  <%if(dto.getEmail_2().equals("daum.net")) out.print("selected"); %>>daum.net</option>
                            </select>
                        </td>
                    </tr>
                    
                    
                  	<tr>
                        <th><label for="pw_confirm">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_password_confirm" id="scrtNoConfirm" class="w200">
                            <p class="guideTxt"></p>
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
        <a href="javascript:fn_update()" class="btn_round btn_large btn_pointColor w180"><b>수 정</b></a>
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
<% } %>

 </body>
</html>









    