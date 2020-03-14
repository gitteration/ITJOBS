package com.kh.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.question.model.service.QuestionService;
import com.kh.member.model.vo.Member;
import com.kh.question.model.vo.Question;
import com.oracle.jrockit.jfr.RequestableEvent;

/**
 * Servlet implementation class QuestionInsertServlet
 */
@WebServlet("/insert.qu")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		Member m=(Member)session.getAttribute("mem");
		int m_no=m.getM_no();
		String title = request.getParameter("title");
		String contents=request.getParameter("contents");
		
		
		Question q=new Question();
		q.setM_no(m_no);
		q.setTitle(title);
		q.setContents(contents);
		System.out.println(q);
		
		int result=new QuestionService().insertQuestion(q);
		response.sendRedirect(request.getContextPath()+"/mylist.qu");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
