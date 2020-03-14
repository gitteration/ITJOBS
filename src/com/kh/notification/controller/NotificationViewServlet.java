package com.kh.notification.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.like.model.service.LikeService;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.service.NotificationService;
import com.kh.notification.model.vo.Notification;
import com.kh.resume.model.service.ResumeService;
import com.kh.resume.model.vo.Resume;
import com.kh.volunteer.model.service.VolunteerService;

/**
 * Servlet implementation class NotificationViewServlet
 */
@WebServlet("/get.no")
public class NotificationViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationViewServlet() {
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
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("mem");
		
		Notification noti=new NotificationService().getNotification(noti_no);
		request.setAttribute("noti", noti);
		
		if(m != null) { // 좋아요 한 맴버의 게시글번호 불러오기 위해 
			int memNo = ((Member)request.getSession().getAttribute("mem")).getM_no();
			
			String likeNoCheck = new LikeService().likeNoCheck(noti_no,memNo);
			request.setAttribute("likeNoCheck", likeNoCheck);
		}
		
		
	
		
		if(m!=null) {
			int isApply=new VolunteerService().isApply(m,noti);
			if(m.getType().equals("1") && isApply==0) {
				ArrayList<Resume> rlist=new ResumeService().getMyResumeListforApply(m);
				request.setAttribute("rlist", rlist);
			}
		}
		
		//random 2개 공고
		ArrayList<Notification> randomList=new ArrayList<>();
		ArrayList<Notification> tempList=new NotificationService().getOpenNotificationList();
		int tempListSize=tempList.size();
		int random1=(int)(Math.random()*tempListSize);
		int random2=-1;
	
		while(true) {
			random2=(int)(Math.random()*tempListSize);
			if(random1!=random2)break;
	
		}
		randomList.add(tempList.get(random1));
		randomList.add(tempList.get(random2));
		
		request.setAttribute("random", randomList);
		request.getRequestDispatcher("views/mypage/notice/get.jsp").forward(request, response);
		//response.sendRedirect("get.no?noti_no="+noti.getNoti_no());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
