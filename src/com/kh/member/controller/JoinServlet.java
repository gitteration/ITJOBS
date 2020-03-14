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
 * Servlet implementation class JoinServlet
 */
@WebServlet(name="JoinServlet", urlPatterns="/join.me")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	
	
	
	
	
	public JoinServlet() {
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
		
		System.out.println("join.me 서블릿에 접속하는지");
		
		String type=request.getParameter("type");
		
		String email=request.getParameter("email");			
		String pw=request.getParameter("pw");
		String nickname=request.getParameter("nickName");
			
		
		
		if(type.equals("2")) {
			nickname = request.getParameter("nickName")+"(기업)";
		}
		
		
		Member m=new Member();
		m.setType(type);
		m.setEmail(email);
		m.setPw(pw);
		m.setNickname(nickname);
		
		System.out.println(m);
		
		
		if(type.equals("1")) {
			
			int result=new MemberService().insertMember(m);
			
			if(result>0) {
//			System.out.println(type);
				HttpSession session = request.getSession();
				
				session.setAttribute("alert", "회원가입을 환영합니다.로그인을 진행해 주세요");
				request.setAttribute("nickname", nickname);
				
				request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
			
				
			}else {
				
				HttpSession session = request.getSession();
				
				response.sendRedirect(request.getContextPath());
				session.setAttribute("alert", "동시 가입자가 많아 잠시 후 다시 시도해 주시길 바랍니다.");
				
			
				}
			}
			
			if(type.equals("2")) {
				
				request.setAttribute("m", m);
				request.getRequestDispatcher("views/login/join_co_info.jsp").forward(request, response);
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
