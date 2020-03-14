package com.kh.resume.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.resume.model.service.ResumeService;
import com.kh.resume.model.vo.Resume;
 
/**
 * Servlet implementation class ResumUpdateServlet
 */
@WebServlet("/updateForm.re")
public class ResumUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int resume_no = Integer.parseInt(request.getParameter("resume_no"));
		
		Resume re = new ResumeService().selectUpdateResum(resume_no);
		
		if(re != null) {
			request.setAttribute("re", re);
			request.getRequestDispatcher("views/mypage/resume/resumeUpdateView.jsp").forward(request, response);
			
		}else {
			System.out.print("수정실패");
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
