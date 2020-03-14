package com.kh.volunteer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.volunteer.model.service.VolunteerService;

/**
 * Servlet implementation class VolunteerApplyServlet
 */
@WebServlet("/apply.vo")
public class VolunteerApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerApplyServlet() {
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
		int resume_no=Integer.parseInt(request.getParameter("resume_no"));
		
		int result=new VolunteerService().apply(noti_no,resume_no);
		if(result>0) {
			//request.getRequestDispatcher("views/mypage/resume/resumeListView.jsp").forward(request, response);
			response.sendRedirect("myApplyList.vo");
		}else {
			
		}
		
		//모달창에서 post로 noti_no,resume_no도 받아서 넘어오자
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
