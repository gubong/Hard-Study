<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dto.*, java.util.*" %>
    
<%
	
	String name = "이상민";
	int age = 25;
	MemberDto dto1 = new MemberDto("101","김길동","대전",15);
	MemberDto dto2 = new MemberDto("201","귀길동","머전",45);
	MemberDto dto3 = new MemberDto("301","힁길동","퍼전",95);
	ArrayList<MemberDto> arr = new ArrayList<>();
	arr.add(dto1);
	arr.add(dto2);
	arr.add(dto3);
	
	System.out.print("콘솔~출력");
	int kor = Integer.parseInt("85");
	//jsp에서는 java.lang 패키지는 그냥쓰게해줌. (안보이지만 java.lang.* 임포트해준상태)
	
	
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	<%="id : "+dto1.getId()+"<br>"%>
	<%="namae : "+dto1.getName()%><br>
	<%="area : "+dto1.getArea()+"<br>"%>
	<%="age : "+dto1.getAge()+"<br>"%>
</p>



<p>
	성명 : <%out.print(name);
//jsp파일을 생성하면 jsp write 라는 클래스를 자동으로 생성해준다. 사용할때는 out. 으로 사용가능.
//추가로 네다섯개정도 더 만들어줌 %>
</p>

<p>
	나이 : <%=age%>
</p>

<%
	for(MemberDto dto : arr){
		out.println(dto.getId()+"<br>");
		out.println(dto.getName()+"<br>");
		out.print(dto.getArea()+"<br>");
		out.print(dto.getAge()+"<br>");
	}
%>
<hr>

<table border="1">
	<tr>
		<th>id</th>
		<th>성명</th>
		<th>지역</th>
		<th>나이</th>
	</tr>
<%
	for(MemberDto dto : arr){
%>
	<tr>
		<td><%=dto.getId()%><br></td>
		<td><%=dto.getName()%><br></td>
		<td><%=dto.getArea()%><br></td>
		<td><%=dto.getAge()%><br></td>
	</tr>

<% 
	}
%>



</table>


</body>
</html>