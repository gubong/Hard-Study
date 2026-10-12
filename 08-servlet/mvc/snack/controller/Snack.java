package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.CMemberList;
import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackUpdateForm;
import command.snack.SnackView;
import command.snack.SnackWrite;
import common.CommonExecute;

/**
 * Servlet implementation class Snack
 */
@WebServlet("/Snack")
public class Snack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack() {
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
		if(gubun==null||gubun.equals("")) gubun="list";
		if(gubun.equals("list")) {
			CommonExecute snack = new SnackList();
			snack.execute(request);
			viewPage = "snack/snack_list.jsp";
		}else if(gubun.equals("write")){
			CommonExecute snack = new SnackWrite();
			snack.execute(request);
			viewPage = "snack/snack_write.jsp";
		}else if(gubun.equals("save")) {
			CommonExecute snack = new SnackSave();
			snack.execute(request);
			viewPage = "common_alert.jsp";
		}else if(gubun.equals("view")) {
			CommonExecute snack = new SnackView();
			snack.execute(request);
			viewPage = "snack/snack_view.jsp";
		}else if(gubun.equals("updateForm")) {
			CommonExecute snack = new SnackUpdateForm();
			snack.execute(request);
			viewPage = "snack/snack_update.jsp";
		}else if(gubun.equals("update")) {
			CommonExecute snack = new SnackUpdate();
			snack.execute(request);
			viewPage = "common_alert.jsp";
		}else if(gubun.equals("delete")) {
			CommonExecute snack = new SnackDelete();
			snack.execute(request);
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
