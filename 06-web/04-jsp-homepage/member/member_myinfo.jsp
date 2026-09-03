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

	<script type = "text/javascript">
		function goUpdateForm(){
			location.href="member_update.jsp";
		}
		
		function goExit(){
			if(confirm("정말 탈퇴하시겠습니까?")){
				location.href="db_member_exit.jsp";
			}
		}
		
		function goPasswordUpdateForm(){
			location.href="password_update.jsp";
		}
	</script>



	<!-- sub contents -->
	<div class="sub_title">
		<h2>My Information</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
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
                    	<th>아이디</th>
                        <th><label for="id"><%=dto.getId()%><span class="must"></span></label></th>

                    </tr>
                    <tr>
                    	<th>이름</th>>
                        <th><label for="name"><%=dto.getName()%></label></th>
                    </tr>
                    
                    <tr>
                        <th><span class="must"><b>직업</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                                <option value="기업" <%if(dto.getJob().equals("기업")) out.print("selected"); %>>기업</option>
                                <option value="교수자" <%if(dto.getJob().equals("교수자")) out.print("selected"); %>>교수자</option>
                                <option value="미취없자" <%if(dto.getJob().equals("미취없자")) out.print("selected"); %>>미취업자</option>
                                <option value="기타" <%if(dto.getJob().equals("기타")) out.print("selected"); %>>기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                           	<%=dto.getTell_1()%> - <%=dto.getTell_2()%> - <%=dto.getTell_3()%>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                        	<%=dto.getMobile_1() %> - <%=dto.getMobile_2() %> - <%=dto.getMobile_3() %>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                   			<%=dto.getEmail_1() %> @ <%dto.getEmail_2();%>
                        </td>
                    </tr>
                     <tr>
                        <th>회원가입일</th>
                        <td>
                   			<%=dto.getReg_date()%>
                        </td>
                    </tr>
                     <tr>
                        <th>최종정보수정일</th>
                        <td>
                   			<%=dto.getUpdate_date()%>
                        </td>
                    </tr>                    
         		 </tbody>
            </table>
       	</form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:goUpdateForm()" class="btn_round btn_large btn_BlueGray w180"><b>수 정</b></a>
        <a href="javascript:goPasswordUpdateForm()" class="btn_round btn_large btn_BlueGray w180"><b>비밀번호 변경</b></a>
        <a href="javascript:goExit()" class="btn_round btn_large btn_pointColor w180"><b>회원 탈퇴</b></a>
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
	
<% }%>	
<footer class="footer">
	<%@ include file="../common_footer.jsp" %>
</footer>

 </body>
</html>









    