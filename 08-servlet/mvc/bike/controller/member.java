package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberInfo;
import command.member.MemberLogin;
import command.member.MemberLogout;
import command.member.MemberPasswordUpdate;
import command.member.MemberSave;
import command.member.MemberSendPassword;
import command.member.MemberUpdate;
import common.CommonExecute;
import dao.MemberDao;

/**
 * Servlet implementation class member
 */
@WebServlet("/member")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null || gubun.equals("")) gubun="login";
		
		request.setAttribute("apple_gubun", gubun);
		
		
		String viewPage ="";
		
		if(gubun.equals("login")) {
			viewPage ="member/member_login.jsp";
			
		} else if(gubun.equals("join")){
			viewPage ="member/member_join.jsp";
			
		//회원가입	
		} else if(gubun.equals("memberSave")) {	
			CommonExecute mem = new MemberSave();
			mem.execute(request);
			viewPage="common_alert.jsp";
		//로그인
		} else if(gubun.equals("memberLogin")) {
			CommonExecute mem = new MemberLogin();
			mem.execute(request);
			viewPage="common_alert.jsp";
		//로그아웃	
		} else if(gubun.equals("logout")) {
			CommonExecute mem = new MemberLogout();
			mem.execute(request);
			viewPage="common_alert.jsp";
		//내정보
		}else if(gubun.equals("myinfo")) {
			//HttpSession session = request.getSession();
			String id =(String)request.getSession().getAttribute("sessionId"); //위에거 한줄로 하는 방법
			if(id==null) {
				request.setAttribute("t_msg", "로그인 정보가 만료되었습니다.");
				request.setAttribute("t_url", "Member");
				viewPage="common_alert.jsp";
			} else {
				CommonExecute mem = new MemberInfo();
				mem.execute(request);
				viewPage ="member/member_myinfo.jsp";
			}
		//내정보 수정 폼	
		}else if(gubun.equals("updateForm")){
			String id =(String)request.getSession().getAttribute("sessionId"); 
			if(id==null) {
				request.setAttribute("t_msg", "로그인 정보가 만료되었습니다.");
				request.setAttribute("t_url", "Member");
				viewPage="common_alert.jsp";
			} else {
				CommonExecute mem = new MemberInfo();
				mem.execute(request);
				viewPage ="member/member_update.jsp";
			}
			
		}else if(gubun.equals("memberUpdate")) {
			CommonExecute mem = new MemberUpdate();
			mem.execute(request);
			viewPage="common_alert.jsp";
			
		}else if(gubun.equals("password_updateForm")) {
			viewPage="member/member_password_update.jsp";
		}else if(gubun.equals("passwordUpdate")) {
			CommonExecute mem = new MemberPasswordUpdate();
			mem.execute(request);
			viewPage="common_alert.jsp";
		//비밀번호 찾기
		}else if(gubun.equals("findPassword")) {
			viewPage="member/member_findPassword.jsp";
		//새로운 비밀번호 메일 발송
		}else if(gubun.equals("sendPassword")) {
			CommonExecute mem = new MemberSendPassword();
			mem.execute(request);
			viewPage="common_alert.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
