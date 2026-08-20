package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.StudentDto;

public class StudentDao {
	private StudentDao() {}
	private static StudentDao dao = new StudentDao();
	public static StudentDao getDao() {
		return dao;
	}
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//전체조회
	public List<StudentDto> getStudentList(){
		List<StudentDto> arr = new ArrayList<>();
		String sql = "select syear,sclass,sno,name \r\n"
				+ "from student_권구봉\r\n"
				+ "order by syear,sclass,sno";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String syear = rs.getString("syear");
				String sclass = rs.getString("sclass");
				String sno = rs.getString("sno");
				String name = rs.getString("name");
				StudentDto dto = new StudentDto(syear, sclass, sno, name);
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	
	//등록
	public int studentSave(StudentDto dto) {
		int result = 0;
		String sql = "insert into student_권구봉\r\n"
				+ "(syear,sclass,sno,name,kor,eng,mat)\r\n"
				+ "values\r\n"
				+ "('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+")";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
		//학년반번호 중복검사
	public int checkStudent(StudentDto dto) {
		int count = 0;
		String sql = "select count(*) as count\r\n"
				+ "from student_권구봉\r\n"
				+ "where syear = '"+dto.getSyear()+"'\r\n"
				+ "and sclass = '"+dto.getSclass()+"'\r\n"
				+ "and sno = '"+dto.getSno()+"'";
System.out.println(sql);
		
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return count;
	}
	
	
	
	
	
}
