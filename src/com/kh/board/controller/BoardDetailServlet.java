package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/detail.bo")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		String head = request.getParameter("head");
		
		HttpSession session = request.getSession();
	    Member mem=(Member)session.getAttribute("mem");
		int m_no = 0;
		String type="3";
		
		if(mem != null) {	// 로그인 했을 때만 실행되게
			 m_no = mem.getM_no();
			 type = mem.getType();
		}
		
		Board prev = new Board();
		Board next = new Board();
		
		switch(head) {
		case "free" : head="자유"; break;
		case "study" : head="스터디"; break;
		case "project" : head="프로젝트"; break;
		case "qna" : head="공지사항"; break;
		case "form" : head="서식"; break;
		default : break;
		}

		Board b = new BoardService().selectBoard(bId, m_no, type);

		System.out.println(b);

		if(b == null) {
			request.setAttribute("msg", "조회실패");
		}else {
			
			if(head.equals("전체보기")) {
				prev = new BoardService().prevMainBoard(bId);
				next = new BoardService().nextMainBoard(bId);
			}else {
				prev = new BoardService().prevEtcBoard(bId, head);
				next = new BoardService().nextEtcBoard(bId, head);
			}
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("b", b);
		request.getRequestDispatcher("views/board/detail.jsp").forward(request, response);
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
