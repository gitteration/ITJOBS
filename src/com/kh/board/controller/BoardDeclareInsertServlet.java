package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardDeclareInsertServlet
 */
@WebServlet("/insert.de")
public class BoardDeclareInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeclareInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bId = Integer.parseInt(request.getParameter("bId"));
		String content = request.getParameter("declare_content");
		String head= request.getParameter("head");
		
		HttpSession session = request.getSession();
	    Member mem=(Member)session.getAttribute("mem");
	    int m_no = mem.getM_no();
	    
	    System.out.println("회원번호 : " + m_no);
	
	    int result = new BoardService().insertDeclareBoard(bId, m_no, content);
	    
	    System.out.println("result : " +result);
	    
	    response.getWriter().print(String.valueOf(result));
	
	    /*
	    if(result > 0) {
	    	response.sendRedirect("detail.bo?head="+head+"&bId="+bId);
	    }else {
	    	request.setAttribute("msg", "신고 실패");
	    	request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	    }
	    
	    */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
