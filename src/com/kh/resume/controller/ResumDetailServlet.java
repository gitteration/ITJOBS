package com.kh.resume.controller;

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
import com.kh.resume.model.service.ResumeService;
import com.kh.resume.model.vo.Resume;
import com.kh.volunteer.model.service.VolunteerService;
import com.kh.volunteer.model.vo.Volunteer;

/**
 * Servlet implementation class resumDetailServlet
 */ 
@WebServlet("/detail.re")
public class ResumDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /*  
     * @see HttpServlet#HttpServlet()
     */
    public ResumDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*int mno = Integer.parseInt(request.getParameter("mno"));*/
		//int mno = 1;
		//여기서도 session에서 가져오는걸로.
		HttpSession session = request.getSession();
		Member mem=(Member)session.getAttribute("mem");
		
		if(request.getParameter("v_no")!=null) {
			int v_no=Integer.parseInt(request.getParameter("v_no"));
			Volunteer v=new VolunteerService().getVolunteer(v_no);
			Notification n=new NotificationService().getNotification(v.getNoti_no());
			
			request.setAttribute("v", v);
			request.setAttribute("n", n);
			
			//기업이 이력서를 읽었으면 읽음으로 수정
			if(mem!=null && mem.getType().equals("2") && mem.getM_no()==n.getCo_no()) {
				int result=new VolunteerService().readResume(v_no);
			
			}
		}

		int resume_no = Integer.parseInt(request.getParameter("resume_no"));
		Resume re= new ResumeService().selectResumDetail(resume_no);
		
		request.setAttribute("re", re);
		request.getRequestDispatcher("views/mypage/resume/resumeDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
