package o_database;

public class Member {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		String id = "101";
		MemberDto dto = dao.getMemberInfo(id);
		System.out.println(dto.getName());
		System.out.println(dto.getArea());
		System.out.println(dto.getAge());
		
		
		
		
		
		
		
	}

}
