<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	NewsDao dao = NewsDao.getDao();
	String no = request.getParameter("t_no");
	
	int result = dao.setHit(no);
	if(result !=1) System.out.print("news_view.jsp : 조회수 증가 오류");
	NewsDto dto = dao.getNewsView(no);
	NewsDto preDto = dao.getPreNews(no);
	NewsDto nextDto = dao.getNextNews(no);
	
%>
<%@ include file = "../common_header.jsp"%>
<script type="text/javascript">
	function goView(no){
		news.t_no.value = no;
		news.method="post";
		news.action="news_view.jsp";
		news.submit();
	}
	
	function goUpdateForm(no){
		news.method="post";
		news.action="news_update.jsp";
		news.submit();
	}
	
	function goDelete(){
		if(confirm("정말 삭제하겠습니까?")){
			news.method="post";
			news.action="db_news_delete.jsp";
			news.submit();
		}
	}
	
</script>
<form name = "news">
	<input type="hidden" name="t_no" value="<%=no%>">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>view</h2>
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
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="gratings.html">질문답변</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="board_view">
			<h2> <%=dto.getTitle() %> </h2>
			<p class="info"><span class="user"><%=dto.getName()%></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_body">
				<textarea disabled ><%=dto.getContent()%></textarea>	
			</div>
			<div class="prev_next">
				<%if(preDto != null){ %>
					<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev">
						<i class="fa fa-angle-left"></i>
						<span class="prev_wrap">
							<strong>이전글</strong>
							<span>
								<%
									String title = preDto.getTitle();
									if(title.length()>15) title = title.substring(0,15)+"...";
									out.print(title);
								%>
							</span>
						</span>
					</a>
				<%}%>
				<div class="btn_3wrap">
					<a href="news_list.jsp">목록</a> 
					<%
						if(sessionLevel.equals("top")){ 
					%>
							<a href="javascript:goUpdateForm()">수정</a> 
							<a href="javascript:goDelete()">삭제</a>
					<%
						}
					%>
				</div>
				
				<%if(nextDto != null){ %>
				<a href="javascript:goView('<%=nextDto.getNo() %>')" class="btn_next">
				<span class="next_wrap">
				
						<strong>다음글</strong>
						<span>
							<%
								String title = nextDto.getTitle();
								if(title.length()>15) title = title.substring(0,15)+"...";
								out.print(title);
							%>
						</span>
				</span>
				<i class="fa fa-angle-right"></i></a>
				<%}%>
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

	<%@ include file = "../common_footer.jsp"%>

</footer>

 </body>
</html>









    