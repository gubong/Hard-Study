package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.notice.NoticeSave;
import common.CommonExecute;
import common.CommonUtil;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun==null||gubun.equals("")) gubun = "list";
		String viewPage = "";
		HttpSession session = request.getSession();
		String sessionLevel = (String)session.getAttribute("sessionLevel");
		if(sessionLevel == null) sessionLevel = "";

		
		if(gubun.equals("list")) {
			viewPage = "notice/notice_list.jsp";
		}else if(gubun.equals("writeForm")) {
			
			if(sessionLevel.equals("top")) {
				request.setAttribute("today", CommonUtil.getToday());
				viewPage = "notice/notice_write.jsp";
			}else {
				request.setAttribute("t_msg", "관리자 메뉴입니다.");
				request.setAttribute("t_url", "Notice");
				viewPage = "common_alert.jsp";
			}
		
		}else if(gubun.equals("save")) {
			CommonExecute noti = new NoticeSave();
			noti.execute(request);
			viewPage = "common_alert.jsp";
		}
		
		request.setAttribute("apple_gubun","Notice");
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
