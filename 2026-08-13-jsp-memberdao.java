package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	Connection 			con = null;
	PreparedStatement 	ps 	= null;
	ResultSet 			rs  = null;

	
	//상세조회
	public MemberDto getMemberView(String searchId){
		MemberDto dto = null;
		String sql = "select id, name, area, age\r\n"
					+ "from member_홍길동\r\n"
					+ "where id ='"+searchId+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();		
			if(rs.next()) {
				String id   = rs.getString("id");
				String name = rs.getString("name");				
				String area = rs.getString("area");
				int age = rs.getInt("age");
				dto = new MemberDto(id, name, area, age);
			}	
		} catch (SQLException e) {
			System.out.println("getMemberView() 오류 :"+sql);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	
	//목록조회 member_list.jsp
	public ArrayList<MemberDto> getMemberList(String select,String search){
		ArrayList<MemberDto> arr = new ArrayList<>();
		String sql ="select id,name\r\n"
				+ "from member_홍길동\r\n"
				+ "where "+select+" like '%"+search+"%'\r\n"
				+ "order by id";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();		
			while(rs.next()){
				String id   = rs.getString("id");
				String name = rs.getString("name");
				MemberDto dto = new MemberDto(id, name);
				arr.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getMemberList() 오류 :"+sql);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return arr;
	}
	
}

	


