<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*, java.util.*" %>

<%
	StudentDao dao = StudentDao.getDao();
	request.setCharacterEncoding("UTF-8");
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	String workGubun = request.getParameter("t_workGubun");
	
	if(syear==null){
		syear = "1";
		sclass = "1";
		gubun = "sno";
		search = "";
		workGubun = "all";
	}
	List<StudentDto> arr = dao.getStudentList(syear,sclass,gubun,search,workGubun);
	
	

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goSearch(){
		stu.method="post";
		stu.action="student_list.jsp";
		stu.submit();
	}

	
	function goALLStudent(){
		stu.t_workGubun.value = "all";
		stu.method="post";
		stu.action="student_list.jsp";
		stu.submit();
	}
	
	function goView(a,b,c){
		view.t_syear.value= a;
		view.t_sclass.value= b;
		view.t_sno.value= c;

		view.method="post";
		view.action="student_view.jsp";
//		view.submit();
		
		
	}
	

</script>


</head>
<body>
<form name="view">
	<input type="text" name = "t_syear">
	<input type="text" name = "t_sclass">
	<input type="text" name = "t_sno">
		<h2>권구봉 list</h2>
	<form name = "stu">
		<input type= "hidden" name="t_workGubun">
		<table border="0" width="500">
			<tr>
				<td style="text-align:right">						
					학년 <select name="t_syear">
						<option value="1"<%if(syear.equals("1")) out.print("selected"); %> >1학년</option>
						<option value="2"<%if(syear.equals("2")) out.print("selected"); %> >2학년</option>
						<option value="3"<%if(syear.equals("3")) out.print("selected"); %> >3학년</option>
						</select>&nbsp;&nbsp;
					반 <select name="t_sclass">
							<option value="1" <%if(sclass.equals("1")) out.print("selected"); %> >1반</option>
							<option value="2" <%if(sclass.equals("2")) out.print("selected"); %> >2반</option>
							<option value="3" <%if(sclass.equals("3")) out.print("selected"); %> >3반</option>
							<option value="4" <%if(sclass.equals("4")) out.print("selected"); %> >4반</option>
							<option value="5" <%if(sclass.equals("5")) out.print("selected"); %> >5반</option>
						</select>
						
						구분 <select name="t_gubun">
							<option value="sno" <%if(gubun.equals("sno")) out.print("selected"); %> >번호</option>
							<option value="name" <%if(gubun.equals("name")) out.print("selected"); %> >성명</option>
						</select>&nbsp;&nbsp;				
						<input type="text" size="3" name="t_search" value="<%=search%>" >
						<input type="button" onclick="goSearch()" value="검 색">
						<input type="button" onclick="goALLStudent()" value="전체출력">
		
					</td>
				</tr>
			</table>
	</form>
		<% if(workGubun.equals("all")){ %>
			<p>[전체출력]</p>
		<% } %>
		<p>총 : <%=arr.size()%>명</p>
		<table border="1" width="500">
			<colgroup>
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="40%">
			</colgroup>
			<tr>
			<th>학년</th><th>반</th><th>번호</th><th>성명</th>
			</tr>	
			<% if(arr.size()==0) {%>
			<tr>
				<th colspan="4"> 정보없음 </th>
			</tr>
			<% } %>
			
			<% for(StudentDto dto : arr){ %>
			<tr>
				<td style="text-align: center"><%=dto.getSyear()%></td>		
				<td style="text-align: center"><%=dto.getSclass()%></td>		
				<td style="text-align: center"><%=dto.getSno()%></td>		
				<td style="text-align: center">
					<a href="student_view.jsp?t_syear=<%=dto.getSyear()%>&t_sclass=<%=dto.getSclass()%>&t_sno=<%=dto.getSno()%>"> <%=dto.getName() %> </a>
					<br>  
					<a href="javascript:goView('<%=dto.getSyear()%>','<%=dto.getSclass()%>','<%=dto.getSno()%>')"> <%=dto.getName() %> </a>
				 </td>		
			</tr>
			<%}%>
		</table>
		<table border="0" width="500">	
			<tr>
				<td style="text-align: right"> <input type="button" value="등록" > </td>
			</tr>
		</table>
</form>	

</body>
</html>
