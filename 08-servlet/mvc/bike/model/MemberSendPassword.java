package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import mail.SendMail;

public class MemberSendPassword implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		String msg = "";
		
		MemberDao dao = MemberDao.getDao();
		String id = request.getParameter("t_id");
		String fromUserEmail = "fkqtmxk789@gmail.com";
		String fromUserPassword = "vahn yftk kxfm ibxp";
		int pwLength = 4;
		String newPassword = dao.getNewPassword(pwLength);
		
		SendMail sm = new SendMail(fromUserEmail, fromUserPassword);
		String toUserEmail =request.getParameter("t_toMemberEmail");
		String mailTitle ="임시 비밀번호를 발송합니다.";
		String mailContent ="임시 비밀번호는 "+newPassword+" 입니다.";
		
		boolean tf = sm.sendPassword(toUserEmail, mailTitle, mailContent);
		if(tf) {
			try {
				newPassword = dao.encryptSHA256(newPassword);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			int result = dao.memberPasswordEmail(id, newPassword, Integer.toString(pwLength));
			if(result==1) msg="새로운 비밀번호를 발송했습니다.";
			else msg="비밀번호 변경 실패!";
		}else {
			msg = "메일 발송 실패! 관리자에게 문의 바랍니다.";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "member");
	}

}
