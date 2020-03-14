package com.kh.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.resume.model.service.ResumeService;

/**
 * Servlet implementation class ResumeLikeServlet
 */
@WebServlet("/like.res")
public class ResumeLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int likeRes = Integer.parseInt(request.getParameter("resNo"));
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		int result = new ResumeService().ResLikeCheck(likeRes,memNo);

		
		PrintWriter out = response.getWriter();
		
		if(result==0) {
			out.print(0);
		}else {
			out.print(1);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
