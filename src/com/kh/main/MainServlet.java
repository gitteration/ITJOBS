package com.kh.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.notification.model.vo.Notification;

/**
 * Servlet implementation class Main
 */
@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Notification> nlist=new MainService().select5Notification();
		ArrayList<Notification> endlist=new MainService().select5NotificationEnd();
		ArrayList<Board> plist=new MainService().select5Project();
		ArrayList<Board> slist=new MainService().select5Study();
		ArrayList<Board> nolist=new MainService().select5Notice();
		ArrayList<Board> freelist=new MainService().select5Free();
		
		request.setAttribute("nlist", nlist);
		request.setAttribute("endlist", endlist);
		request.setAttribute("plist", plist);
		request.setAttribute("slist", slist);
		request.setAttribute("nolist", nolist);
		request.setAttribute("freelist", freelist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
