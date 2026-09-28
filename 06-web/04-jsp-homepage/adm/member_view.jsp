<%@page import="java.util.List"%>
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
		String select = "id";
		String id = request.getParameter("t_no");
		MemberDao dao = MemberDao.getDao();
		List<MemberDto> arr = dao.getAdmList(select, id);	
		MemberDto dto = arr.get(0);
%>

	<script type = "text/javascript">
		function goExit(){
			if(confirm("정말 탈퇴시키키시겠습니까?")){
				mem.method="post";
				mem.action="db_member_exit.jsp";
				mem.submit();
			}
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
            <h1>회원정보</h1>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
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
                    	<th>아이디</th>
                        <th><label for="id"><%=dto.getId()%><span class="must"></span></label></th>

                    </tr>
                    <tr>
                    	<th>이름</th>
                        <th><label for="name"><%=dto.getName()%></label></th>
                    </tr>
                    
                    <tr>
                        <th><span class="must"><b>직업</b></span></th>
                        <td>
							<%=dto.getJob() %>
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
                        	<%=arr.get(0).getMobile_1() %> - <%=arr.get(0).getMobile_2() %> - <%=arr.get(0).getMobile_3() %>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                   			<%=arr.get(0).getEmail_1() %> @ <%=dto.getEmail_2()%>
                        </td>
                    </tr>
                     <tr>
                        <th>회원가입일</th>
                        <td>
                   			<%=arr.get(0).getReg_date()%>
                        </td>
                    </tr>
                     <tr>
                        <th>최종정보수정일</th>
                        <td>
                   			<%=arr.get(0).getUpdate_date()%>
                        </td>
                    </tr>                    
         		 </tbody>
            </table>
       	</form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
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









    