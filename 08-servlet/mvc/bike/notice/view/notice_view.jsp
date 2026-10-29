<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../common_header.jsp" %>
<script>

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
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2">${dto.title }</td>
						<td> <i class="far fa-eye"></i> ${dto.hit }</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${dto.content }</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">${dto.attach }</td>
					</tr>	
					<c:if test="${empty dto.update_name }">
						<tr>
							<th>Writer</th>
							<td>${dto.reg_name }</td>
							<th>RegDate</th>
							<td>${dto.reg_date }</td>
						</tr>	
					</c:if>
					<c:if test="${not empty dto.update_name }">
						<tr>
							<th>UpdateWriter</th>
							<td>${dto.update_name }</td>
							<th>UpdateDate</th>
							<td>${dto.update_date }</td>
						</tr>	
					</c:if>
					
				</tbody>
			</table>
			<div class="preNext">
			<c:if test="${not empty preDto}">
				<a href="javascript:goView('${preDto.no }')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
							<c:if test="${fn:length(preDto.title) > 20}">
								${fn:substring(preDto.title,0,20)}...
							</c:if>
							<c:if test="${fn:length(preDto.title) <= 20}">
								${preDto.title}
							</c:if>
						</span>
					</p>
				</a>
			</c:if>	
			<c:if test="${not empty nextDto }">
				<a href="javascript:goView('${nextDto.no }')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
							<c:choose>
								<c:when test="${fn:length(nextDto.title) > 20}">
									${fn:substring(nextDto.title,0,20)}...
								</c:when>
								<c:otherwise>
									${nextDto.title }
								</c:otherwise>
							</c:choose>
						</span>
					</p>
				</a>
			</c:if>	
			</div>			
			<div class="buttonGroup">
				<a href="" class="butt">Delete</a>
				<a href="" class="butt">Update</a>
				<a href="Notice" class="butt">List</a>
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
