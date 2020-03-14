package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.PageInfo;
import com.kh.like.model.service.LikeService;
import com.kh.member.model.vo.Member;
import com.kh.resume.model.service.ResumeService;
import com.kh.resume.model.vo.Resume;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SearchResumeListServlet
 */
@WebServlet("/resumeList.se")
public class SearchResumeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResumeListServlet() {
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
		Member mem=(Member)session.getAttribute("mem");
		
		if(mem != null) { // 좋아요 한 맴버의 게시글번호 불러오기 위해 
			int CoNo = ((Member)request.getSession().getAttribute("mem")).getM_no();
			
			ArrayList<String> likeRes = new LikeService().LikeResList(CoNo);
		
		request.setAttribute("likeRes", likeRes);
		}

		int listCount = 0;
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		PageInfo pi = null;
		
		
		String sKey=request.getParameter("sKey");
		String sText=request.getParameter("sText");
		
		ArrayList<Resume> list=null;
		if(sKey!=null && sText!=null) {
			list=new SearchService().searchResumeList(sKey,sText);
		}else if(sText!=null){
			list=new SearchService().getSuperSearchResume(sText);
		}else {
			listCount=new ResumeService().getOpenResumeListCount();
			pi = new PageInfo(currentPage, listCount, 10, 10);
			list=new ResumeService().getOpenResumeList(pi);
		}
			
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/search/resume.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
