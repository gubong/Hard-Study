<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../common_header.jsp" %>
<script>
	function goWriteForm(){
		noti.t_gubun.value="writeForm";
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	
	function goSearch(){
		noti.t_gubun.value="list";
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	
	function goPage(num){
		noti.t_clickPage.value=num;
		noti.t_gubun.value="list";
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	
	function goView(no){
		view.t_gubun.value="view";
		view.t_no.value=no;
		view.method="post";
		view.action="Notice";
		view.submit();
	}
</script>
<form name="view">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>
		<div id="b_left">
			<%@ include file = "../common_notice.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${totalcount} </span>건</p>
			</div>
			<form name="noti">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_clickPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="title" <c:if test="${select eq 'title' }">selected</c:if> >Title</option>
					<option value="content" <c:if test="${select eq 'content' }">selected</c:if> >Content</option>
				</select>
				<input type="text" name="t_search" value="${search }" class="sel_text">
				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="60%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="seq" value="${order}" />
				<c:forEach items="${arr}" var="dto">
					<tr>
						<td>${seq}</td><c:set var="seq" value="${seq - 1}" />
						<td class="t_left"><a href="javascript:goView('${dto.no }')">${dto.title }</a></td>
						<td>
							<c:if test="${not empty dto.attach }"><img src="images/clip.png"></c:if> 
						</td>
						<td>${dto.reg_name }</td>
						<td>${dto.reg_date }</td>
						<td>${dto.hit }</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
			<!-- 
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
			 -->	
			 ${pageDisplay}
				<c:if test="${sessionLevel eq 'top'}">
					<a href="javascript:goWriteForm()" class="write">글쓰기</a>
				</c:if>
			</div>
		</div>	
	</div>
	<div id="footer_div">	
		<div id="footer">
			<%@ include file = "../common_footer.jsp" %>	
		</div>	
	</div>	
</body>
</html>
