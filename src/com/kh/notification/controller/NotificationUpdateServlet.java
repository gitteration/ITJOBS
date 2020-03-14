package com.kh.notification.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notification.model.service.NotificationService;
import com.kh.notification.model.vo.Notification;

/**
 * Servlet implementation class NotificationUpdateServlet
 */
@WebServlet("/edit.no")
public class NotificationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int noti_no=Integer.parseInt(request.getParameter("noti_no"));
		Notification noti=new NotificationService().getNotification(noti_no);
		
		request.setAttribute("noti", noti);
		request.getRequestDispatcher("views/mypage/notice/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		
		int noti_no=Integer.parseInt(request.getParameter("noti_no"));
		
		String title=request.getParameter("title");
		String end_date=request.getParameter("end_date");
		String jobs=request.getParameter("jobs");
		String[] language=request.getParameterValues("language");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String contents=request.getParameter("contents");
		String hope=request.getParameter("hope");
		String open=request.getParameter("open");
		
		Notification n=new Notification();
		n.setNoti_no(noti_no);
		n.setContents(contents);
		n.setEnd_date(end_date);
		n.setHope(hope);
		n.setJobs(jobs);
		n.setP_language(String.join(",",language));
		n.setSalary(salary);
		n.setTitle(title);
		n.setOpen(open);
		
		int result=new NotificationService().updateNotification(n);
		if(result>0) {
			//Notification newn=new NotificationService().getNotification(noti_no);
			
			//request.setAttribute("noti", newn);
			//request.getRequestDispatcher("views/mypage/notice/get.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/get.no?noti_no="+noti_no);
		}
	}

}
