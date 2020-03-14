package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberChangePwServlet
 */
@WebServlet("/changePw.me")

public class MemberChangePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/mypage/myinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pw=request.getParameter("pw");
		String newPw=request.getParameter("newPw");
		
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("mem");
		
		Member newm=null;
		if(pw.equals(m.getPw())) {
			newm=new MemberService().changePw(m,newPw);
		}
		if(newm!=null) {
			session.setAttribute("mem", newm);
			session.setAttribute("pwChange", "정상적으로 수정 되었습니다");
			response.sendRedirect(request.getContextPath()+"/myInfo.me");
		
		}else {
			session.setAttribute("pwChange", "비밀번호를 다시 확인해 주세요");
			//실패메시지 어떻게 보내지?
			response.sendRedirect(request.getContextPath()+"/myInfo.me");
		}
	}

}
