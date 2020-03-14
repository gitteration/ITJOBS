package com.kh.notification.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notification.model.service.NotificationService;
import com.kh.notification.model.vo.Notification;

/**
 * Servlet implementation class NotificationWriteServlet
 */
@WebServlet("/write.no")
public class NotificationWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/mypage/notice/write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Member co=(Member)session.getAttribute("mem");
		
		String title=request.getParameter("title");
		String end_date=request.getParameter("end_date");
		String end_time=request.getParameter("end_time");
		String jobs=request.getParameter("jobs");
		String[] language=request.getParameterValues("language");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String contents=request.getParameter("contents");
		String hope=request.getParameter("hope");
		String open=request.getParameter("open");
		
		Notification n=new Notification();
		n.setCo_no(co.getM_no());
		n.setContents(contents);
		n.setEnd_date(end_date+" "+end_time);
		n.setHope(hope);
		n.setJobs(jobs);
		n.setP_language(String.join(",",language));
		n.setSalary(salary);
		n.setTitle(title);
		n.setOpen(open);
		System.out.println(n);
		
		int result=new NotificationService().insertNotification(n);
		if(result>0) {
			Notification newn=new NotificationService().getLastestNotification();
			
			request.setAttribute("noti", newn);
			//request.getRequestDispatcher("views/mypage/notice/get.jsp").forward(request, response);
			response.sendRedirect("get.no?noti_no="+newn.getNoti_no());
		}
	}

}
