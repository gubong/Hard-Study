package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.cloud.CloudMembershipService;

import command.member.CMemberSave;
import command.member.CMemberUpdate;
import command.member.CMemberDelete;
import command.member.CMemberList;
import command.member.CMemberView;
import common.CommonExecute;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		String viewPage = "";
		
		
		//목록
		if(gubun==null) gubun="list";
		if(gubun.equals("list")) {
			CMemberList mem = new CMemberList();
			mem.excute(request);
			viewPage = "member/member_list.jsp";
			
		//조회페이지
		}else if(gubun.equals("view")) {
			CommonExecute mem = new CMemberView();
			mem.execute(request);
			viewPage = "member/member_view.jsp";
			
		//글쓰기페이지
		}else if(gubun.equals("writeForm")) {
			viewPage = "member/member_write.jsp";
			
		//저장
		}else if(gubun.equals("save")) {
			CommonExecute mem = new CMemberSave();
			mem.execute(request);
			viewPage = "common_alert.jsp";
			
		//수정페이지
		}else if(gubun.equals("updateForm")) {
			CommonExecute mem = new CMemberView();
			mem.execute(request);
			viewPage = "member/member_update.jsp";
		
		//수정
		}else if(gubun.equals("update")){
			CommonExecute mem = new CMemberUpdate();
			mem.execute(request);
			viewPage = "common_alert.jsp";
		
		//삭제
		}else if(gubun.equals("delete")) {
			CommonExecute mem = new CMemberDelete();
			mem.execute(request);
			viewPage = "common_alert.jsp";
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
