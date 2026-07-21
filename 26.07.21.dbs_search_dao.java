package o_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
/*	
	
	//상세조회
	public MemberDto getMemberInfo(String searchId) {
		// 목표 : MemberDto dto = new MemberDto("101", "홍길동", "대전", 25);

		MemberDto dto = null;		//가장먼저 리턴타입부터 생성.  //반드시 sql에서 복사해서오셈. 세미콜론은 복사 ㄴㄴ
		String sql = "select id,name,area,age\r\n"			
					+ "from member_홍길동\r\n"
					+ "where id = '"+searchId+"'";

		try {
			con = DBConnection.getConnection();		//접속완료.
			ps = con.prepareStatement(sql);		//sql문을 실행시킬준비를시킨다.
			rs = ps.executeQuery();		//실행된sql의 결과값을 rs에 저장한다.
			if(rs.next()) {						//re.next >>sql의 결과값이 존재하면 true를 리턴해줌
				String id = rs.getString("id");	//겟스트링(컬럼라벨). 열 제목을 의미함.
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				dto = new MemberDto(id, name, area, age);
			}
			
		} catch (SQLException e) {
			System.out.println("getMemberInfo() 메소드 오류"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con,ps,rs);
		}
				
		
		
		return dto;
	}

	
	
	
	
	public String getMemberName(String id) {
		String name = "";
		String sql = "select name\r\n"
				+ "from member_홍길동\r\n"
				+ "where id  = '"+id+"'";
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
				
			}
			
		} catch (Exception e) {
			System.out.println("멤버네임메도스 오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con,ps,rs);
		}
		return name;
	}

*/



	public String getAreaName(String id) {
		String area = "";
		String sql = "\r\n"
				+ "select area\r\n"
				+ "from member_홍길동\r\n"
				+ "where id  = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
			area = rs.getString("area");
			}
		} catch (SQLException e) {
			System.out.println("정보오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return area;
	}



	public int getAge(String id) {
		int age = 0;
		String sql = "\r\n"
				+ "select age\r\n"
				+ "from member_홍길동\r\n"
				+ "where id = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				age = rs.getInt("age");
			}
		} catch (SQLException e) {
			System.out.println("메소드오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return age;
	}


	//회원목록
	public ArrayList<MemberDto> getMemberList(String searchname) {
		ArrayList<MemberDto> arr = new ArrayList<>();
		String sql = "select id,name,area,age\r\n"
				+ "from member_홍길동\r\n"
				+ "where name like '%"+searchname+"%'";
		
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {									//1행or0개>if,  2행이상>while
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				MemberDto dto = new MemberDto(id, name, area, age);
				arr.add(dto);
				
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("멤버리스트 메소드 오류");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		
		
		return arr;
	
	}

	
	
	
	
	
}
