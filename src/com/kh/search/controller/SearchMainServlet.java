package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.PageInfo;
import com.kh.notification.model.service.NotificationService;
import com.kh.notification.model.vo.Notification;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SearchMainServlet
 */
@WebServlet("/main.se")
public class SearchMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");

		int listCount =  new NotificationService().getListCount();
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		PageInfo pi = new PageInfo(currentPage, listCount, 10, 10);
		
		String sText=request.getParameter("sText");
		
		ArrayList<Notification> list=new SearchService().getSuperSearchNotification(sText,pi);
		if(list!=null) {
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("sText", sText);
			request.getRequestDispatcher("views/search/notification.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
