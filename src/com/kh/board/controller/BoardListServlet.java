package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String head = request.getParameter("head");
		
		int listCount = 0;
		
		if(head.equals("main")||head.equals("전체보기")) {
			listCount = new BoardService().getMainListCount();
		}else {
			switch(head) {
			case "free" : head="자유"; break;
			case "study" : head="스터디"; break;
			case "project" : head="프로젝트"; break;
			case "qu" : head="공지사항"; break;
			case "form" : head="서식"; break;
			default: break;
			}
			listCount =  new BoardService().getEtcListCount(head);
		}
		
		// 페이징처리
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
		
		ArrayList<Board> list = new ArrayList<>();
		if(head.equals("main")||head.equals("전체보기")) {
			list = new BoardService().selectMainList(pi);
			
		}else {
			list = new BoardService().selectEtcList(head, pi);
		}
	
		request.setAttribute("pi",pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}