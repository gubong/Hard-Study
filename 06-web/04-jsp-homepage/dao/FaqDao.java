package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
