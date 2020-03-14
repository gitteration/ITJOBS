package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.PageInfo;
import com.kh.like.model.service.LikeService;
import com.kh.like.model.vo.Like;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.service.NotificationService;
import com.kh.notification.model.vo.Notification;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SearchNotificationListServlet
 */
@WebServlet("/notificationList.se")
public class SearchNotificationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNotificationListServlet() {
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
		
		HttpSession session = request.getSession();
		Member mem=(Member)session.getAttribute("mem");
		
		
		
		if(mem != null) { // 좋아요 한 맴버의 게시글번호 불러오기 위해 
			int memNo = ((Member)request.getSession().getAttribute("mem")).getM_no();
			
			ArrayList<String> likeMem = new LikeService().LikeBoList(memNo);
		
		
		request.setAttribute("likeMem", likeMem);
		}
		
		/*
		 * int likeSum = new LikeSerivce().LikeSum()
		 */
		//System.out.println(likeBoList);
		
		int listCount = 0;
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		PageInfo pi = null;
		
		String sKey=request.getParameter("sKey");
		String sText=request.getParameter("sText");
		
		ArrayList<Notification> list=null;
		if(sKey!=null && (sText!=null && !sText.equals("null"))) {
			//list=new SearchService().searchNotificationList(sKey,sText);
		}else if(sText!=null && !sText.equals("null")){
			listCount=new NotificationService().getSuperSearchNotificationListCount(sText);
			pi = new PageInfo(currentPage, listCount, 10, 10);
			list=new SearchService().getSuperSearchNotification(sText,pi);
		}else {
			listCount=new NotificationService().getListCount();
			pi = new PageInfo(currentPage, listCount, 10, 10);
			list=new NotificationService().getAllNotificationList(pi);
		}
		
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("sText", sText);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("views/search/notification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
