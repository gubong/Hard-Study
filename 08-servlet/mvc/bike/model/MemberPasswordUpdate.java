package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;

public class MemberPasswordUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = MemberDao.getDao();
		String id = request.getParameter("t_id");
		String newPassword = request.getParameter("t_new_password");
		String passwordLength =  Integer.toString(newPassword.length());
		String update_date = CommonUtil.getTodayTime();
		try {
			newPassword = dao.encryptSHA256(newPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int result = dao.memberPasswordUpdate(id,newPassword,passwordLength,update_date);
		String msg="",gubun="";
		if(result==1) {
			msg="비밀번호변경되었습니다.다시로그인하세";
			HttpSession session = request.getSession();
			session.invalidate();
			gubun="login";
		}else {
			msg="실패";
			gubun="password_updateForm";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "member");
		request.setAttribute("t_gubun", gubun);
	}

}
