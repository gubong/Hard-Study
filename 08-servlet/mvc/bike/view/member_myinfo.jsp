<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>   


<script>
	function goUpdateForm(){
		mem.t_gubun.value="updateForm";
		mem.method="post";
		mem.action="member";
		mem.submit();
	}	
	
	
</script>

		<div id="b_left">
			<%@ include file= "../common_member.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER INFORMATION
			</p>
		<form name="mem">
		<input type ="hidden" name="t_gubun">	
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${dto.id}</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${dto.name}</td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td>
				  	<c:forEach begin="1" end="${dto.password_length}" > 
				  		*
				  	</c:forEach>
				  </td>
				</tr>
				<tr>
				  <th>주소</th>
				  <td>${dto.address}</td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td>${dto.email_1}@${dto.email_2}</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>${dto.mobile_1}-${dto.mobile_2}-${dto.mobile_3}</td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
				  <c:if test="${dto.gender eq 'm'}">남</c:if>
				  <c:if test="${dto.gender eq 'f'}">여</c:if>
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
				  <c:if test="${dto.hobby_travel eq 'y'}">여행&nbsp;&nbsp;</c:if>
				  <c:if test="${dto.hobby_reading eq 'y'}">독서&nbsp;&nbsp;</c:if>
				  <c:if test="${dto.hobby_sports eq 'y'}">운동</c:if>
				  </td>
				</tr>
				<tr>
				  <th>회원가입일</th>
				  <td>${dto.reg_date}</td>
				</tr>
				<tr>
				  <th>정보수정일</th>
				  <td>${dto.update_date}</td>
				</tr>
				
			  </tbody>
			</table>
			</form>	
			<div class="buttonGroup_center">
				<a href="javascript:goUpdateForm()" class="butt">UPDATE</a>
				<a href="javascript:goExit()" class="butt">EXIT</a>
			</div>	
		</div>	
	</div>
	<div id="footer_div">	
		<div id="footer">
			<%@ include file = "../common_footer.jsp" %>  
			</div>		
		</div>	
	</div>	
</body>
</html>
    