package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.student.CStudentList;
import command.student.CStudentUpdate;
import command.student.CStudentview;
import command.student.DBdelete;
import command.student.DBsave;
import command.student.DBupdate;
import common.CommonExecute;

/**
 * Servlet implementation class student
 */
@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		String viewPage = "";
		//목록
		if(key==null) key="";
		if(key.equals("")) {
			CStudentList mem = new CStudentList();
			mem.execute(request);
			viewPage = "student/student_list.jsp";
		//상세
		}else if(key.equals("view")) {
			CommonExecute mem = new CStudentview();
			mem.execute(request);
			viewPage = "student/student_view.jsp";
		}else if(key.equals("update")) {
			CommonExecute mem = new CStudentUpdate();
			mem.execute(request);
			viewPage = "student/student_update.jsp";
		}else if(key.equals("DBupdate")) {
			CommonExecute mem = new DBupdate();
			mem.execute(request);
			viewPage = "common_alert.jsp";
		}else if(key.equals("DBdelete")) {
			CommonExecute mem = new DBdelete();
			mem.execute(request);
			viewPage = "common_alert.jsp";
		}else if(key.equals("write")) {
			viewPage = "student/student_write.jsp";
		}else if(key.equals("DBsave")) {
			CommonExecute mem = new DBsave();
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
