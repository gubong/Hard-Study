package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.NoticeDto;

public class NoticeDao {
	private NoticeDao() {}
	private static NoticeDao dao = new NoticeDao();
	public static NoticeDao getDao() {
		return dao;
	}
	
	Connection con = null;
	ResultSet rs = null;
	LoggableStatement ps = null;
	
	//이전글,다음글 번호제목가져오기
	public List<NoticeDto> getPreNextInfo(String no){
		List<NoticeDto> arr = new ArrayList<>();
		String preSql= "select a.preNo, b.title\r\n"
				+ "from(\r\n"
				+ "    select max(no) as preNo \r\n"
				+ "    from jsl_권구봉_notice a\r\n"
				+ "    where no < ?\r\n"
				+ "    )a, jsl_권구봉_notice b\r\n"
				+ "where a.preNo = b.no";
		
		String nextSql="select a.nextNo, b.title\r\n"
				+ "from(\r\n"
				+ "    select min(no) as nextNo \r\n"
				+ "    from jsl_권구봉_notice a\r\n"
				+ "    where no > ?\r\n"
				+ "    )a, jsl_권구봉_notice b\r\n"
				+ "where a.nextNo = b.no";
		try {
			con=DBConnection.getConnection();
			//이전글
			LoggableStatement ps = new LoggableStatement(con, preSql);
			ps.setString(1, no);
			rs=ps.executeQuery();
			NoticeDto preDto = null;
			if(rs.next()) {
				String preNo = rs.getString("preno");
				String title = rs.getString("title");
				preDto = new NoticeDto(preNo, title);
			}
			arr.add(preDto);
			
			//다음글
			ps = new LoggableStatement(con, nextSql);
			ps.setString(1, no);
			rs=ps.executeQuery();
			NoticeDto nextDto = null;
			if(rs.next()) {
				String nextNo = rs.getString("nextno");
				String title = rs.getString("title");
				nextDto = new NoticeDto(nextNo, title);
			}
			arr.add(nextDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		String sql2="";
				
		return arr;
	}
	
	
	
	//힛트증가
	public int setHitCount(String no) {
		int result = 0;
		String sql = "update jsl_권구봉_notice\r\n"
				+ "set hit = hit +1\r\n"
				+ "where no = ?";
		
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, no);
			result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	
	
	
	
	public NoticeDto getNoticeView(String no) {
		NoticeDto dto = null;
		String sql = "select n.no,n.title,n.content,n.attach,\r\n"
				+ "        m.name as reg_name, n.hit, to_char(n.reg_date,'yyyy-MM-dd') as reg_date\r\n"
				+ "from jsl_권구봉_notice n, jsl_홍길동_member m\r\n"
				+ "where n.reg_id = m.id\r\n"
				+ "and n.no = ?";
		
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title	= rs.getString("title");
				String content = rs.getString("content");
				String attach	= rs.getString("attach");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String hit 		= rs.getString("hit");
				dto = new NoticeDto(no, title, content, attach, hit, "id", reg_name, reg_date);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	
	
	
	
	//목록 카운트
	public int getTotalCount(String select,String search) {
		int count = 0;
		String sql = "select count(*) as count\r\n"
				+ "from jsl_권구봉_notice\r\n"
				+ "where "+select+" like ?";
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, "%"+search+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	//목록전체조회
	public List<NoticeDto> getNoticeList(String select, String search, int start,
			int end){
		List<NoticeDto> arr = new ArrayList<>();
		String sql = "select * from(\r\n"
				+ "    select rownum as rnum, tbl.* \r\n"
				+ "    from (\r\n"
				+ "        select n.no,n.title,n.attach,m.name as reg_name,\r\n"
				+ "                to_char(n.reg_date,'yyyy-MM-dd') as reg_date,\r\n"
				+ "                n.hit\r\n"
				+ "        from jsl_권구봉_notice n,jsl_권구봉_member m\r\n"
				+ "        where n.reg_id = m.id\r\n"
				+ "        and "+select+" like ?\r\n"
				+ "        order by n.no desc\r\n"
				+ "    ) tbl)\r\n"
				+ "where rnum >=? and rnum<=?";
		
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, "%"+search+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no  		= rs.getString("no");
				String title	= rs.getString("title");
				String attach	= rs.getString("attach");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String hit 		= rs.getString("hit");
				NoticeDto dto = new NoticeDto(no, title, attach, hit, reg_name, reg_date);
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//저장
	public int noticeSave(NoticeDto dto) {
		int result =0;
		String sql = "insert into jsl_권구봉_notice\r\n"
				+ "(no,title,content,attach,reg_id,reg_date)\r\n"
				+ "values\r\n"
				+ "(?,?,?,?,?,?)";
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, dto.getNo());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getAttach());
			ps.setString(5, dto.getReg_id());
			ps.setString(6, dto.getReg_date());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : ");
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	

	//게시글번호생성
	public String getNoticeNo() {
		String no = "";
		String sql = "select max(no) as no\r\n"
				+ "from jsl_권구봉_notice";
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				no=rs.getString("no");	// N003;
				if(no==null) no = "N000"; 
				no = no.substring(1); // 003
				int num = Integer.parseInt(no)+1; //3+1
				DecimalFormat df = new DecimalFormat("N000");
				no = df.format(num);	//N004
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getnotice오류 : "+ps.toString());
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}







}
