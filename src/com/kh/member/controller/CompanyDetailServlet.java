package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.like.model.service.LikeService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Co_Info;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class CompanyDetailServlet
 */
@WebServlet("/detail.co")
public class CompanyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int co_no=Integer.parseInt(request.getParameter("co_no"));
		
		Member co=new MemberService().getMemberByM_no(co_no);
		Co_Info co_Info=new MemberService().getCoInfo(co);
		
		HttpSession session = request.getSession();
		Member mem=(Member)session.getAttribute("mem");

/*		if(mem != null) { // 좋아요 한 맴버의 게시글번호 불러오기 위해 
			int memNo = ((Member)request.getSession().getAttribute("mem")).getM_no();
			
			ArrayList<String> likeCo = new LikeService().LikeCoList(memNo);
		
		
		
		request.setAttribute("likeCo", likeCo);
		}*/
		
		
		
		
		request.setAttribute("co", co);
		request.setAttribute("co_Info", co_Info);
		
		request.getRequestDispatcher("views/mypage/companyDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
