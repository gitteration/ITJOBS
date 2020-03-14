package com.kh.like.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.like.model.service.LikeService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LikeMyResumeDeleteServlet
 */
@WebServlet("/delResume.like")
public class LikeMyResumeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeMyResumeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int resume_no=Integer.parseInt(request.getParameter("resume_no"));
		
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("mem");
		int co_no=m.getM_no();
		
		int result=new LikeService().deleteResume(resume_no,co_no);
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/myResumeList.like");
		}else {
			
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
