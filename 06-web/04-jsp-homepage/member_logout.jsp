<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginName = (String)session.getAttribute("sessionName");	//세션 겟해옴. 리턴타입이 오브젝트니까 스트링으로 캐스팅.

	String msg = loginName +"님 로그아웃 되었습니다.";
	if(loginName == null) msg = "로그아웃 되었습니다.";
	
	session.invalidate();  //세션변수들 만료.
%>    
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="../index.jsp";

</script>