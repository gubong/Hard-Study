package o_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	
	
	//상세조회
	public MemberDto getMemberInfo(String searchId) {
		// 목표 : MemberDto dto = new MemberDto("101", "홍길동", "대전", 25);
		MemberDto dto = null;		//가장먼저 리턴타입부터 생성.
		String sql = "select id,name,area,age\r\n"			//반드시 sql에서 복사해서오셈. 세미콜론은 복사 ㄴㄴ
					+ "from member_홍길동\r\n"
					+ "where id = '101'";
		Connection con = DBConnection.getConnection();		//접속완료.
		try {
			PreparedStatement ps = con.prepareStatement(sql);		//sql문을 실행시킬준비를시킨다.
			ResultSet rs = ps.executeQuery();		//실행된sql의 결과값을 rs에 저장한다.
			if(rs.next()) {						//re.next >>sql의 결과값이 존재하면 true를 리턴해줌
				String id = rs.getString("id");	//겟스트링(컬럼라벨). 열 제목을 의미함.
				String name = rs.getString("name");
				String area = rs.getString("area");
				String age = rs.getString("age");	
				dto = new MemberDto(id, name, area, Integer.parseInt(age));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		
		return dto;
	}

	
	
	
	
}
