package o_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//자바베이직우클릭-빌드패스-콘피규어패스-라이브러리-모듈패스-에드 익스터널 자르- 어플라이,어플라이클로즈
	//DB접속해제
	public static void closeDB(Connection con ) {		//연결시에 id비번등이 틀리면 con이 null이 되버림
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	public static Connection getConnection(){
		Connection con = null;
		//1번째, 오라클 드라이버를 읽어옴.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//2번째,DB에 접속한다.
		
		String db_url ="jdbc:oracle:thin:@1.245.91.229:1521/xe"; //DB주소  //jsl505-001  //oracle기본포트번호 1521 // 
		String db_user ="ai_01"; //계정ID
		String db_password="1234";//비번
		
		
		
		try {
			con = DriverManager.getConnection(db_url, db_user, db_password);			//드라이버매니져는 스태틱메소드임
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return con;
	}

	
	
	
	
	
	
	
	


}


