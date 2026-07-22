package o_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SnackDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//상세조회
	public SnackDto getSnackInfo(String code) {
		SnackDto dto = null;
		String sql = "select pcode, pname, company, price,  \r\n"
				+ "    to_char(makedate,'yyyy-MM-dd') as makedate\r\n"
				+ "from snack_권구봉\r\n"
				+ "where pcode = '"+code+"'";
		
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String company = rs.getString("company");
				String makedate = rs.getString("makedate");
				int price = rs.getInt("price");
				dto = new SnackDto(pcode, pname, company, makedate, price);
				
			}
		} catch (SQLException e) {
			System.out.println(sql);
			System.out.println("메소드오류");
			e.printStackTrace();
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}


	public void snackPrint(SnackDto dto) {
		System.out.println("=======================================");
		System.out.println("코드\t제품명\t제조사\t가격\t제조일");
		System.out.println("---------------------------------------");
		System.out.print(dto.getPcode()+"\t");
		System.out.print(dto.getPname()+"\t");
		System.out.print(dto.getCompany()+"\t");
		System.out.print(dto.getPrice()+"\t");
		System.out.print(dto.getMakedate()+"\n");
		System.out.println("-------------------------------------");
		
	}

//제품명>전부출력
	public ArrayList<SnackDto> getSnackList(String searchName) {
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		String sql = "select pcode, pname, company, price,  \r\n"
				+ "    to_char(makedate,'yyyy-MM-dd') as makedate\r\n"
				+ "from snack_박상아\r\n"
				+ "where pname like '%"+searchName+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String company = rs.getString("company");
				String makedate = rs.getString("makedate");
				int price = rs.getInt("price");
				
				SnackDto dto = new SnackDto(pcode, pname, company, makedate, price);
				arr.add(dto);
			}
			
		}catch(Exception e){
			System.out.println("메소드 오류");
			System.out.println("select pcode, pname, company, price,  \\r\\n\"\r\n"
					+ "				+ \"    to_char(makedate,'yyyy-MM-dd') as makedate\\r\\n\"\r\n"
					+ "				+ \"from snack_권구봉\\r\\n\"\r\n"
					+ "				+ \"where pname like '%\"+searchName+\"%'");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		};
		
		
		
		
		
		return arr;
	}

//배열출력
	public void snackPtintAll(ArrayList<SnackDto> arr) {
		
		System.out.println("=======================================");
		System.out.println("코드\t제품명\t제조사\t가격\t제조일");
		System.out.println("---------------------------------------");
	for(SnackDto dto : arr) {
		System.out.print(dto.getPcode()+"\t");
		System.out.print(dto.getPname()+"\t");
		System.out.print(dto.getCompany()+"\t");
		System.out.print(dto.getPrice()+"\t");
		System.out.print(dto.getMakedate()+"\n");
	}

		
	}


	public ArrayList<SnackDto> getSnackCompany(String searchCompany) {
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		
		if(searchCompany.equals("1")) {
			searchCompany = "농심";
		}
		else if(searchCompany.equals("2")) {
			searchCompany = "롯데";
		}
		else if(searchCompany.equals("3")) {
			searchCompany = "해태";
		}
		else if(searchCompany.equals("4")) {
			searchCompany = "오리온";
		}else {
			searchCompany = null;
		}
		
		String sql = "select pcode, pname, company, price,  \r\n"
				+ "    to_char(makedate,'yyyy-MM-dd') as makedate\r\n"
				+ "from snack_홍길동\r\n"
				+ "where company ='"+searchCompany+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String company = rs.getString("company");
				String makedate = rs.getString("makedate");
				int price = rs.getInt("price");
				
				SnackDto dto = new SnackDto(pcode, pname, company, makedate, price);
				arr.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println(sql);
			System.out.println("메소드오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	

}
