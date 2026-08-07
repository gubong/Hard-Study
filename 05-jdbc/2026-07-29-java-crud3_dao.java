package o_student_권구봉;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import m_static.Dao;
import o_database_권구봉.SnackDto;

public class StuDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//학년반번호 중복인지 알아보기.
	public int getOK(String grade, String ban, String number) {
		int result = 0;
		String sql = "select name\r\n"
				+ "    from student_권구봉\r\n"
				+ "    where syear = '"+grade+"'\r\n"
				+ "    and sclass = '"+ban+"'\r\n"
				+ "    and sno = '"+number+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보 오류 \"select name\\r\\n\"\r\n"
					+ "				+ \"    from student_권구봉\\r\\n\"\r\n"
					+ "				+ \"    where syear = '\"+grade+\"'\\r\\n\"\r\n"
					+ "				+ \"    and sclass = '\"+ban+\"'\\r\\n\"\r\n"
					+ "				+ \"    and sno = '\"+number+\"'\"");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	
	//전부등록하는거
	public int getInsert(StuDto dto) {
		int result = 0;
		String sql = "insert into student_권구봉\r\n"
				+ "(syear,sclass,sno,name,kor,eng,mat)\r\n"
				+ "values\r\n"
				+ "('"+dto.getGrade()+"','"+dto.getBan()+"','"+dto.getNumber()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+")";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록메소드오류, \"insert into student_권구봉\\r\\n\"\r\n"
					+ "				+ \"(syear,sclass,sno,name,kor,eng,mat)\\r\\n\"\r\n"
					+ "				+ \"values\\r\\n\"\r\n"
					+ "				+ \"('\"+dto.getGrade()+\"','\"+dto.getBan()+\"','\"+dto.getNumber()+\"','\"+Dao.getName()+\"',\"+dto.getKor()+\",\"+dto.getEng()+\",\"+dto.getMat()+\")\"");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//하나보여주기
	public void getAllprint(String grade, String ban, String number) {
		String sql = "select syear,sclass,sno,name,kor,eng,mat\r\n"
				+ "from student_권구봉\r\n"
				+ "where syear = '"+grade+"'\r\n"
				+ "and sclass = '"+ban+"'\r\n"
				+ "and sno = '"+number+"'";
		 try {
			 con = DBConnection.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 System.out.print(rs.getString("syear")+"\t");
				 System.out.print(rs.getString("sclass")+"\t");
				 System.out.print(rs.getString("sno")+"\t");
				 System.out.print(rs.getString("name")+"\t");
				 System.out.print(rs.getInt("kor")+"\t");
				 System.out.print(rs.getInt("eng")+"\t");
				 System.out.println(rs.getInt("mat"));
			 }
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("보여주기메소드오류,\"select syear,sclass,sno,name,kor,eng,mat\\r\\n\"\r\n"
					+ "				+ \"from student_권구봉\\r\\n\"\r\n"
					+ "				+ \"where syear = '\"+grade+\"'\\r\\n\"\r\n"
					+ "				+ \"and sclass = '\"+ban+\"'\\r\\n\"\r\n"
					+ "				+ \"and sno = '\"+number+\"'\"");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
	}

	//다받아와서수정하는애.
	public int getSujong(StuDto dto) {
		int result = 0;
		String sql = "update student_권구봉\r\n"
				+ "set kor = "+dto.getKor()+",\r\n"
				+ "    eng = "+dto.getEng()+",\r\n"
				+ "    mat = "+dto.getMat()+"\r\n"
				+ "where syear = '"+dto.getGrade()+"'\r\n"
				+ "and sclass = '"+dto.getBan()+"'\r\n"
				+ "and sno = '"+dto.getNumber()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정메소드오류/ \"update student_권구봉\\r\\n\"\r\n"
					+ "				+ \"set kor = \"+dto.getKor()+\",\\r\\n\"\r\n"
					+ "				+ \"    eng = \"+dto.getEng()+\",\\r\\n\"\r\n"
					+ "				+ \"    mat = \"+dto.getMat()+\"\\r\\n\"\r\n"
					+ "				+ \"where syear = '\"+dto.getGrade()+\"'\\r\\n\"\r\n"
					+ "				+ \"and sclass = '\"+dto.getBan()+\"'\\r\\n\"\r\n"
					+ "				+ \"and sno = '\"+dto.getNumber()+\"'\"");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//전체조회
	public ArrayList<StuDto> realJo() {
		ArrayList<StuDto> arr = new ArrayList<>();
		
		String sql = "SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
				+ "from student_권구봉";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String a = rs.getString("syear");
				String a2 = rs.getString("sclass");
				String a3 = rs.getString("sno");
				String a4 = rs.getString("name");
				int b = rs.getInt("kor");
				int b2 = rs.getInt("eng");
				int b3 = rs.getInt("mat");
				StuDto dto = new StuDto(a,a2,a3,a4,b,b2,b3);
				arr.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
					+ "from student_권구봉");
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		
		return arr;
		
	}


	public void getPrint(ArrayList<StuDto> arr) {
		for(StuDto a : arr) {
			System.out.print("학년 :"+a.getGrade()+"\t");
			System.out.print("반 :"+a.getBan()+"\t");
			System.out.print("번호 :"+a.getNumber()+"\t");
			System.out.print("이름 :"+a.getName()+"\t");
			System.out.print("국 :"+a.getKor()+"\t");
			System.out.print("영 :"+a.getEng()+"\t");
			System.out.println("수 :"+a.getMat());
		}
		
	}


	public ArrayList<StuDto> nameJo(String searchname) {
		ArrayList<StuDto> arr = new ArrayList<>();
//		arr= null;
		String sql = "SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
				+ "from student_권구봉\r\n"
				+ "where name like '%"+searchname+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String a = rs.getString("syear");
				String a2 = rs.getString("sclass");
				String a3 = rs.getString("sno");
				String a4 = rs.getString("name");
				int b = rs.getInt("kor");
				int b2 = rs.getInt("eng");
				int b3 = rs.getInt("mat");
				StuDto dto = new StuDto(a,a2,a3,a4,b,b2,b3);
				arr.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
					+ "from student_권구봉");
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		
		return arr;
		
	}


	public ArrayList<StuDto> numbJo(String searchnumb) {
		ArrayList<StuDto> arr = new ArrayList<>();
		//arr=null;
		String sql = "SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
				+ "from student_권구봉\r\n"
				+ "where sno ='"+searchnumb+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String a = rs.getString("syear");
				String a2 = rs.getString("sclass");
				String a3 = rs.getString("sno");
				String a4 = rs.getString("name");
				int b = rs.getInt("kor");
				int b2 = rs.getInt("eng");
				int b3 = rs.getInt("mat");
				StuDto dto = new StuDto(a,a2,a3,a4,b,b2,b3);
				arr.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT syear,sclass,sno,name,kor,eng,mat\r\n"
					+ "from student_권구봉");
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		
		return arr;
		
	}


	public int getSak(String a, String b, String c) {
		int result = 0;
		String sql = "DELETE from student_권구봉\r\n"
				+ "where syear = '"+a+"'\r\n"
				+ "and sclass = '"+b+"'\r\n"
				+ "and sno = '"+c+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제메소드오류");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return result;
	}


	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
