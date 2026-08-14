package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.CompanyDto;
import dto.SnackDto;

public class SnackDao {
	Connection con =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	//코드로 1인분 상세조회하기
	public SnackDto getSnackView(String pcode) {
		SnackDto dto = null;
		String sql = "select s.pcode,s.pname,s.company,c.company_name,to_char(s.makedate,'yyyy-MM-dd') as makedate,s.price\r\n"
				+ "from snack_권구봉 s, snack_company c\r\n"
				+ "where s.company = c.company_code\r\n"
				+ "and s.pcode = '"+pcode+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("pname");
				String company = rs.getString("company");
				String company_name = rs.getString("company_name");				
				String makedate = rs.getString("makedate");
				int price = rs.getShort("price");
				dto = new SnackDto(pcode, name, company, company_name, makedate, price);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select *\r\n"
					+ "from snack_company\r\n"
					+ "order by company_code");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return dto;
	}
	
	
	
	
	
	
	//전체조회해서 리스트에 출력
	public List<SnackDto> allJo(String select, String search){
		List<SnackDto> arr = new ArrayList<>(); //어레이리스트가 list를 임플먼츠하고있어서 부모타입으로 생성한거
		String sql="select pcode,pname\r\n"
				+ "from snack_권구봉\r\n";
				
				if(select.equals("all")) {
					sql += "where pname like '%"+search+"%' \r\n";
				}else {
					sql += "where company ='"+select+"'\r\n"
						+ "and pname like '%"+search+"%'\r\n";
				}
				sql += "order by pcode desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("pcode");
				String name = rs.getString("pname");
				SnackDto dto = new SnackDto(code, name);
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select *\r\n"
					+ "from snack_company\r\n"
					+ "order by company_code");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	 }
	
	
	
	
	
	//제조사목록
	public List<CompanyDto> getCompanyList(){
		List<CompanyDto> arr = new ArrayList<>(); //어레이리스트가 list를 임플먼츠하고있어서 부모타입으로 생성한거
		String sql="select *\r\n"
				+ "from snack_company\r\n"
				+ "order by company_code";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("company_code");
				String name = rs.getString("company_name");
				CompanyDto dto = new CompanyDto(code, name);
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select *\r\n"
					+ "from snack_company\r\n"
					+ "order by company_code");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	 }
	
	//저장
	public int snackSave(SnackDto dto) {
		int result=0;
		String sql="insert into snack_권구봉\r\n"
				+ "(pcode,pname,company,makedate,price)\r\n"
				+ "values\r\n"
				+ "('"+dto.getPcode()+"','"+dto.getPname()+"','"+dto.getCompany()+"','"+dto.getMakedate()+"',"+dto.getPrice()+")";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//새로운제품번호
	public String getPcode() {
		String no = "";
		String sql = "select max(pcode) as pcode\r\n"
				+ "from snack_권구봉";
		
		try {
			con=DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String code = rs.getString("pcode");	//p003
				if(code==null) {
					no = "P001";
				}else {
					code = code.substring(1);	//003
					int n = Integer.parseInt(code)+1;	//3+1
					DecimalFormat df = new DecimalFormat("P000");  //P004
					no = df.format(n);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return no;
	}
	
	
	
}
