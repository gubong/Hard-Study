<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../common_header.jsp"%>
<%@ page import = "common.*" %>
<%
	if(!sessionLevel.equals("top")){
%>
	<script>
		alert("관리자 메뉴입니다.");
		location.href="faq_list.jsp";
	</script>
<%
	}else{
%>
	<script type="text/javascript">
		function goSave(){
			if(isEmpty(faq.t_question,"질문입력")) return;
			if(isEmpty(faq.t_answer,"답변입력")) return;
			faq.method="post";
			faq.action="db_faq_save.jsp";
			faq.submit();
		}
	
	
	</script>


	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
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
					<a href="">자주하는질문<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">자주하는질문</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">글쓰기</h2>
	  <form name="faq">
	  	<input type="hidden" name="t_reg_id" value="<%=sessionName%>">
	  	<input type="hidden" name="t_reg_date" value="<%=CommonUtil.getToday()%>">
			<table class="bord_table">
				<caption class="sr-only">자주하는 질문 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>질문</th>
						<td colspan="3"><input type="text" name="t_question"></td>
					</tr>
					<tr>
						<th>답변</th>
						<td colspan="3"><textarea name="t_answer"></textarea></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><%=sessionName%></td>
						<th>등록일자</th>
						<td><%=CommonUtil.getToday()%></td>
					</tr>					
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onclick="goSave()">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='faq_list.jsp';">
			</div>
		</form>
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
	<%@ include file = "../common_footer.jsp" %>
</footer>
 </body>
</html>

<%
	}
%>








