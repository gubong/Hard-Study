<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	page import="dao.*" %>
<%
	MemberDao dao = MemberDao.getDao();
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password  = dao.encryptSHA256(password);
	
	String name = dao.getLoginInfo(id,password);
	String msg ="", url="";
	if(name.equals("")){
		msg = "ID나 비밀번호가 정확하지 않습니다.";
		url = "member_login.jsp";
	}else{
		msg = name+"님 환영합니다.";
		url = "../index.jsp";
	
		session.setAttribute("sessionId", id );  //jsp생성하면 request,out,session 객체 만들어줌자동으로. 
		session.setAttribute("sessionName", name);	//(만들세션변수명, 올타입(오브젝트벨류))
		session.setMaxInactiveInterval(60*60*4);		//세션타이머.  시간지나면 세션을null로바꿈
	}
	
	
	
%>    

<script type="text/javascript">
alert("<%=msg%>");
location.href="<%=url%>";
</script>