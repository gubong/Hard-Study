<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*, java.util.*" %>
<%
	SnackDao dao = new SnackDao();
	List<CompanyDto> arr = dao.getCompanyList();
	String pcode = dao.getPcode();
	
	/*int a =4; //1,250
	
	DecimalFormat df = new DecimalFormat("####,000.00");  //3을 003으로 바꿔주는애이용할건데 0아니면#을 넣으면 콤마찍어줌
	DecimalFormat df = new DecimalFormat("P000");  
	String no = df.format(a);	//1234
	out.print(no); 
	
	*/	
	
	
	//placeholder="a"  인풋 칸에 a 흰색글씨써놓음
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권구봉 SNACK</title>
							<!--		/jsp_scnak/js/common.js  절대경로,아랫거는 상대경로  -->
<script type="text/javascript" src="../js/common.js"> </script>
<script type="text/javascript">


	function goSave(){
		if(isEmpty((snack.t_pcode),"제품코드 입력!")) return;
		if(isEmpty((snack.t_pname),"제품명 입력!")) return;
		if(isEmpty((snack.t_price),"가격 입력!")) return;
		if(isEmpty((snack.t_makedate),"제조일 입력!")) return;
/*	
		if(snack.t_pname.value==""){
			alert("제품코드 입력!");
			snack.t_pname.focus();
			return;
		}
*/	
		snack.method="post";
		snack.action="db_snack_save.jsp";
		snack.submit();
		

	}



</script>



</head>
<body>
	<h2>권구봉 SNACK write</h2>
	
<form name = "snack">	
		<table border="1" width="400">
		<colgroup>
			<col width="30%">
			<col width="*">
		</colgroup>
		<tr>
			<th>제품코드</th>
			<td><input type="text" name="t_pcode" value="<%=pcode%>" readonly  size="3"></td>
		</tr>
		<tr>
			<th>제품명</th>
			<td><input type="text" name="t_pname" size="8"></td>
		</tr>
		<tr>
			<th>제조사</th>
			<td>
				<select name="t_company">
				<% for(CompanyDto dto : arr){ %>
					<option value="<%= dto.getCompany_code() %>"> <%= dto.getCompany_name() %>  </option>
					
				<% } %>
				</select>
			</td>
		</tr>	
		<tr>
			<th>가격</th>
			<td><input type="text" name="t_price" style="text-align: right" size="8"></td>
		</tr>
		<tr>
			<th>제조일자</th>
			<td><input type="date" name="t_makedate" ></td>
		</tr>
	</table>
</form>
<table border="0" width="400">
	<tr>
		<td style="text-align: center">
			<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
			<input type="button" onclick="goSave()" value="등록">
		</td>
	</tr>
</table>

</body>
</html>