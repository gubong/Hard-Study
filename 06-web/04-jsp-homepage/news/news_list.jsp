<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*" %>

<%
	NewsDao dao = NewsDao.getDao();

	request.setCharacterEncoding("UTF-8");
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select="title";
		search="";
	}
	
	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(select,search);
	int list_setup_count = 4;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	String nowPage = request.getParameter("t_clickPage");

	
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	/* paging 설정 end*/	
	int order = totalCount - ( start - 1 ); // 

	
	List<NewsDto> arr = dao.getNewsList(select,search,start,end);
	
%>
<%@ include file = "../common_header.jsp"%>
	
	<script type="text/javascript">
		function goSearch(){
			news.method="post";
			news.action="news_list.jsp";
			news.submit();
		}
		
		function goPage(pageNumber){
			news.t_clickPage.value= pageNumber;
			news.method="post";
			news.action="news_list.jsp";
			news.submit();
		}
		
		function goView(no){
			view.t_no.value = no;
			view.method="post";
			view.action="news_view.jsp";
			view.submit();
		}
		
	</script>
	<form name="view">
		<input type="hidden" name="t_no">
	</form>
			
		<!-- sub contents -->
		<div class="sub_title">
			<h2>NEWS</h2>
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
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount%></span>건</p>
		</div>
		<div class="search_group">
			<form name="news">
				<input type="hidden" name="t_clickPage" >
				<select name="t_select" class="select">
					<option value="title" <%if(select.equals("title")) out.print("selected"); %> >제목</option>
					<option value="content" <%if(select.equals("content")) out.print("selected"); %> >내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search%>" class="search_word" >
				<button class="btn_search"  onclick="goSearch()" type="button"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<% for(NewsDto dto : arr){ %>
				<tr>
					<td><%=order%> <%order --;%></td>
					<td class="title"><a href="javascript:goView('<%=dto.getNo()%>')"><%=dto.getTitle()%></a></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getReg_date()%></td>
					<td><%=dto.getHit()%></td>
				</tr>
			<%} %>
			</tbody>
		</table>
		<div class="paging">
		<%
			String pageDisplay = CommonUtil.getPageSetting(current_page, total_page, pageNumber_count);
			out.print(pageDisplay);
		%>
<!--
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
-->
			<%if(sessionLevel.equals("top")){%>
				<a href="news_write.jsp" class="btn_write">글쓰기</a>
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
	<%@ include file = "../common_footer.jsp" %>
</footer>

 </body>
</html>

