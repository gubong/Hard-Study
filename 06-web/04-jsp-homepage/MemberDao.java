package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	private MemberDao() {
		
	}
	private static MemberDao dao = new MemberDao();

	public static MemberDao getDao() {
		return dao;
	}
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//비밀번호 변경
	public int memberPasswordUpdate(String id,String new_password) {
		int result = 0;
		String sql = "update jsl_권구봉_member\r\n"
				+ "set password = ?\r\n"
				+ "where id = ?";
		
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, new_password);
			ps.setString(2, id);
			result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	//탈퇴
	public int memberExit(String sessionId, String exit_date) {
		int result = 0;
		String sql = "update jsl_권구봉_member\r\n"
				+ "    set  exit_date = to_date(?, 'yyyy-MM-dd hh24:mi:ss')\r\n"
				+ "where id = ?";
				
		try {
			con = DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, exit_date);
			ps.setString(2, sessionId);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//회원정보 수정
	public int memberUpdate(MemberDto dto) {
		int result = 0;
		String sql = "update jsl_권구봉_member\r\n"
				+ "set name = ?,\r\n"
				+ "    job = ?,\r\n"
				+ "    tell_1 = ?,\r\n"
				+ "    tell_2 = ?,\r\n"
				+ "    tell_3 = ?,\r\n"
				+ "    mobile_1 = ?,\r\n"
				+ "    mobile_2 = ?,\r\n"
				+ "    mobile_3 = ?,\r\n"
				+ "    email_1 = ?,\r\n"
				+ "    email_2 = ?,\r\n"
				+ "    update_date = to_date(?,'yyyy-MM-dd hh24:mi:ss')\r\n"
				+ "where id = ?";
		
		try {
			con = DBConnection.getConnection();
			//ps=con.prepareStatement(sql);
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getJob());
			ps.setString(3, dto.getTell_1());
			ps.setString(4, dto.getTell_2());
			ps.setString(5, dto.getTell_3());
			ps.setString(6, dto.getMobile_1());
			ps.setString(7, dto.getMobile_2());
			ps.setString(8, dto.getMobile_3());
			ps.setString(9, dto.getEmail_1());
			ps.setString(10, dto.getEmail_2());
			ps.setString(11, dto.getUpdate_date());
			ps.setString(12, dto.getId());

			result = ps.executeUpdate();
			
			System.out.println("sql : "+ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//내정보조회
	public MemberDto getMemberInfo(String sessionId) {
		MemberDto dto = null;
		String sql = "select id,name,password,job,tell_1,tell_2,tell_3,\r\n"
				+ "		mobile_1,mobile_2,mobile_3,\r\n"
				+ "		email_1,email_2,\r\n"
				+ "		reg_date,update_date,exit_date\r\n"
				+ "from jsl_권구봉_member\r\n"
				+ "where id  = ?";
		
		
		try {
			con = DBConnection.getConnection();
			LogPreparedStatement ps = new LogPreparedStatement(con, sql);
			ps.setString(1, sessionId);
			rs = ps.executeQuery();
		System.out.println(ps.toString());	
			if(rs.next()) {
				String name = rs.getString("name");
				String job = rs.getString("job");
				String tell_1 = CommonUtil.getCheckNull(rs.getString("tell_1"));
				String tell_2 = CommonUtil.getCheckNull(rs.getString("tell_2"));
				String tell_3 = CommonUtil.getCheckNull(rs.getString("tell_3"));
				String mobile_1 = rs.getString("mobile_1");
				String mobile_2 = rs.getString("mobile_2");
				String mobile_3 = rs.getString("mobile_3");
				String email_1 = rs.getString("email_1");
				String email_2 = rs.getString("email_2");
				String reg_date = rs.getString("reg_date");	
				String update_date = CommonUtil.getCheckNull(rs.getString("update_date"));			
				String exit_date = CommonUtil.getCheckNull(rs.getString("exit_date"));			
				
				dto = new MemberDto(sessionId, name, name, job, tell_1, tell_2, tell_3, mobile_1, mobile_2, mobile_3, email_1, email_2, reg_date, update_date, exit_date);
			}
			
		} catch (Exception e) {
			System.out.println("getMemberInfo오류 : "+ps.toString());
			e.printStackTrace();
			
		} finally{
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return dto;
	}
	
	
	
	
	
	
	//중복검사
	public int checkId(String id) {
		int count = 0;
		String sql = "select count(*) as count\r\n"
				+ "from jsl_권구봉_member\r\n"
				+ "where id = ?";
		try {
			con = DBConnection.getConnection();
			LogPreparedStatement ps = new  LogPreparedStatement(con, sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			System.out.println("sql : "+ps.toString());
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	//로그인,  아이디비번으로 성명조회
	public String getLoginInfo(String id,String password) {
		String result = "";
		String sql = "select name\r\n"
				+ "from jsl_권구봉_member\r\n"
				+ "where id = ?\r\n"
				+ "and password = ? \r\n"
				+ "and exit_date is null";
		try {
			con = DBConnection.getConnection();
			//ps=con.prepareStatement(sql);
			LogPreparedStatement ps = new LogPreparedStatement(con, sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			System.out.println("sql : "+ps.toString());
			
			if(rs.next()) {
			result = rs.getString("name");
			}
			
		} catch (Exception e) {
			System.out.println("sql : "+ps.toString());
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
	
	
	
	//회원등록
	public int memberSave(MemberDto dto) {
		int result = 0;
/*
		String sql = "insert INTO jsl_권구봉_MEMBER\r\n"
				+ "(id,name,password,job,tell_1,tell_2,tell_3,\r\n"
				+ "		mobile_1,mobile_2,mobile_3,\r\n"
				+ "		email_1,email_2,\r\n"
				+ "		reg_date)\r\n"
				+ "VALUES\r\n"
				+ "('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPassword()+"','"+dto.getJob()+"','"+dto.getTell_1()+
				"','"+dto.getTell_2()+"','"+dto.getTell_3()+"','"+dto.getMobile_1()+"','"+dto.getMobile_2()+"','"+dto.getMobile_3()+"','"+dto.getEmail_1()+"','"+dto.getEmail_2()+"',to_date('"+dto.getRe_date()+"','yyyy-MM-dd hh24:mi:ss'))";
*/
		String sql = "insert INTO jsl_권구봉_MEMBER\r\n"
				+ "(id,name,password,job,tell_1,tell_2,tell_3,\r\n"
				+ "		mobile_1,mobile_2,mobile_3,\r\n"
				+ "		email_1,email_2,\r\n"
				+ "		reg_date)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			//ps=con.prepareStatement(sql);
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getJob());
			ps.setString(5, dto.getTell_1());
			ps.setString(6, dto.getTell_2());
			ps.setString(7, dto.getTell_3());
			ps.setString(8, dto.getMobile_1());
			ps.setString(9, dto.getMobile_2());
			ps.setString(10, dto.getMobile_3());
			ps.setString(11, dto.getEmail_1());
			ps.setString(12, dto.getEmail_2());
			ps.setString(13, dto.getReg_date());
			result = ps.executeUpdate();
			System.out.println(((LoggableStatement)ps).getQueryString());
				//?에 값을 다 넣어서 sql문 만들어서 출력
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return result;
	}
	
	
	
	//비밀번호 암호화
    public String encryptSHA256(String value) throws NoSuchAlgorithmException{
		String encryptData ="";
		
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(value.getBytes());
		
		byte[] digest = sha.digest();
		for (int i=0; i<digest.length; i++) {
		   encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
		}
		return encryptData;
    }
}
