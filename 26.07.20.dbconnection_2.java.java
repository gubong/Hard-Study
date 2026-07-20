package o_database;

import java.sql.Connection;

public class ConnectionTest {

	public static void main(String[] args) {
		//sql을 실행할때는 db접속>sql하나실행>접속끊기. 의 과정을 반복해야함. 다중접속이누적되면 부하가 심해질수있기때문.
	  // DBConnection db = new DBConnection();
	   Connection con = DBConnection.getConnection(); //실행
	   System.out.println(con);
	   DBConnection.closeDB(con); //끊기
	   
	   
	   
	   
	
	
	
	
	
	
	}

}
