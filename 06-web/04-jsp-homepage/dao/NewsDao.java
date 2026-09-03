package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.NewsDto;

public class NewsDao {
	private NewsDao() {}
	private static NewsDao dao = new NewsDao();
	public static NewsDao getDao() {
		return dao;
	}

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//상세조회
	public NewsDto getNewsView(String no) {
		NewsDto dto = null;
		String sql = "";
		
		return  dto;
	}
	
	
	//페이지 count
	public int getTotalCount(String select,String search) {
		int count = 0;
		String sql = "select COUNT(*) as count\r\n"
				+ "from jsl_권구봉_news\r\n"
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
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	
	
	//게시판목록
	public List<NewsDto> getNewsList(String select, String search, int start, int end){
		List<NewsDto> arr = new ArrayList<>();
		String sql = "select * from(\r\n"
				+ "    select rownum as rnum, tbl.* \r\n"
				+ "    from (\r\n"
				+ "        select n.no,n.title,m.name, to_char(n.reg_date,'yy/MM/dd') as reg_date, n.hit\r\n"
				+ "        from jsl_권구봉_news n,jsl_권구봉_member m\r\n"
				+ "        where n.reg_id = m.id\r\n"
				+ "        and n."+select+" like ?\r\n"
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
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String hit 		= rs.getString("hit");
				NewsDto dto = new NewsDto(no, title, "content", hit, "reg_id", reg_name, reg_date);
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	
	
	//게시판등록
	public int newsSave(NewsDto dto) {
		int result = 0;
		String sql = "insert into jsl_권구봉_news\r\n"
				+ "(no,title,content,reg_id,reg_date)\r\n"
				+ "values\r\n"
				+ "(?,?,?,?,?)";
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, dto.getNo());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getReg_id());
			ps.setString(5, dto.getReg_date());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//게시글번호생성
	public String getNewsNo() {
		String no = "";
		String sql = "select max(no) as no\r\n"
				+ "from jsl_권구봉_news";
		
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
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
	
	
	
}
