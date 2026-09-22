	package dao;

	import java.sql.Connection;
	import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	import common.DBConnection;
	import dto.FaqDto;

	public class FaqDao {
		
		static private FaqDao dao = new FaqDao();
		static public FaqDao getDao() {
			return dao;
		}
		
		Connection con = null;
		LoggableStatement ps = null;
		ResultSet rs = null;
		
		//번호로 몇개줏어오기
		public FaqDto getNoList(String no) {
			FaqDto dto = null;
			String sql = "select question,answer\r\n"
					+ "from jsl_권구봉_faq\r\n"
					+ "where no = ?";
			try {
				con = DBConnection.getConnection();
				LoggableStatement ps = new LoggableStatement(con, sql);
				ps.setString(1, no);
				rs = ps.executeQuery();
				if(rs.next()) {
					String question = rs.getString("question");
					String answer = rs.getString("answer");
					dto = new FaqDto(question, answer);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("FAQ목록오류");
			} finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return dto;
	 	}
		
		
		
		//삭제
		public int getDelete(String no) {
			int result = 0;
			String sql = "delete from jsl_권구봉_faq\r\n"
					+ "where no = ?";
			try {
				con =DBConnection.getConnection();
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
		
		
		//수정
		public int getUpdate(FaqDto dto) {
			int result = 0;
			String sql = "update jsl_권구봉_faq\r\n"
					+ "set question = ?,\r\n"
					+ "    answer= ?,\r\n"
					+ "    reg_date = ?\r\n"
					+ "where no = ?";
			try {
				con =DBConnection.getConnection();
				LoggableStatement ps = new LoggableStatement(con, sql);
				ps.setString(1, dto.getQuestion());
				ps.setString(2, dto.getAnswer());
				ps.setString(3, dto.getReg_date());
				ps.setString(4, dto.getNo());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getnotice오류 : ");
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
		
		
		
		
		// 출력할화면말불러오기
		public List<FaqDto> getNoticeList(String select,String search,int start,int end){
			List<FaqDto> arr = new ArrayList<FaqDto>();
			String sql = "select *\r\n"
					+ "from(\r\n"
					+ "    select rownum as rnum, a.*\r\n"
					+ "    from(\r\n"
					+ "        select no,question,answer,reg_id,to_char(reg_date,'yyyy-MM-dd') as reg_date\r\n"
					+ "        from jsl_권구봉_faq\r\n"
					+ "        where "+select+" like ?\r\n"
					+ " 		order by no desc \r\n"		
					+ "    )a\r\n"
					+ ")\r\n"
					+ "where rnum>=? and rnum<=?";
			
		try {
			con=DBConnection.getConnection();
			LoggableStatement ps = new LoggableStatement(con, sql);
			ps.setString(1, "%"+search+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs=ps.executeQuery();	
			while(rs.next()) {
				String no = rs.getString("no");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String reg_id = rs.getString("reg_id");
				String reg_date = rs.getString("reg_date");
				FaqDto dto = new FaqDto(no, question, answer, reg_id, reg_date);
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
			return arr;
		}
		
		
		
		//전체글수
		public int getTotalCount(String select,String search) {
			int result = 0;
			String sql = "select count(*) as count\r\n"
					+ "from jsl_권구봉_faq\r\n"
					+ "where "+select+" like ?";
			try {
				con = DBConnection.getConnection();
				LoggableStatement ps = new LoggableStatement(con, sql);
				ps.setString(1, "%"+search+"%");
				rs = ps.executeQuery();
				if(rs.next()) {
					result = rs.getInt("count");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("FAQ목록오류");
			} finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
		
		//저장
		public int getSave(FaqDto dto) {
			int result = 0 ;
			String sql = "insert into jsl_권구봉_faq\r\n"
					+ "(no,question,answer,reg_id,reg_date)\r\n"
					+ "values\r\n"
					+ "(?,?,?,?,?)";
			try {
				con=DBConnection.getConnection();
				LoggableStatement ps = new LoggableStatement(con, sql);
				ps.setString(1, dto.getNo());
				ps.setString(2, dto.getQuestion());
				ps.setString(3, dto.getAnswer());
				ps.setString(4, dto.getReg_id());
				ps.setString(5, dto.getReg_date());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getnotice오류 : ");
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
		
		
		
		//새롭게 넣을 번호 알아오기
		public String getNewNo() {
			String no = "";
			String sql = "select max(no) as no\r\n"
					+ "from jsl_권구봉_faq";
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
				System.out.println("getnotice오류 : ");
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return no;
		}
		
		
		//제목,내용으로 조회
		public List<FaqDto> getList(String select, String search){
			List<FaqDto> arr = new ArrayList<>();
			String sql = "select no,question,answer,reg_id,to_char(reg_date,'yyyy-MM-dd') as reg_date\r\n"
					+ "from jsl_권구봉_faq\r\n"
					+ "where "+select+" like ?";
			try {
				con = DBConnection.getConnection();
				LoggableStatement ps = new LoggableStatement(con, sql);
				ps.setString(1, "%"+search+"%");
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String no = rs.getString("no");
					String question = rs.getString("question");
					String answer = rs.getString("answer");
					String reg_id = rs.getString("reg_id");
					String reg_date = rs.getString("reg_date");
					FaqDto dto = new FaqDto(no, question, answer, reg_id, reg_date);
					arr.add(dto);
				}
				System.out.println(arr);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("FAQ목록오류");
			} finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return arr;
	 	}
		
		
	}
