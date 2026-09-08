<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	NewsDao dao = NewsDao.getDao();
	String no = request.getParameter("t_no");
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_date = CommonUtil.getToday();
	NewsDto dto = new NewsDto(no,title,content,"",reg_date);
	int result = dao.newsUpdate(dto);
	String msg = result == 1 ? "등록":"실패";
	String url = result == 1 ? "news_list.jsp" : "news_update.jsp";
%>

<head>
</head>
<body>
	<form>
		<input type="hidden" name="news" value="<%=no %>">
	</form>
</body>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
