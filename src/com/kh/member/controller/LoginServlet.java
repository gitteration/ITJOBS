package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Co_Info;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//ArrayList<Member> list=new AdminMemberService().getAllMemberList();
		
		
		//request.setAttribute("list", list);
		request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
	
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
//		String type=request.getParameter("type");
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		Member m=new Member();
		m.setEmail(email);
		m.setPw(pw);
//		m.setType(type);
		
		Member mem=new MemberService().login(m);
		Co_Info co=new MemberService().getCoInfo(mem);
		
		if(mem.getEmail()!=null && mem.getPw() != null && mem.getStatus().equals("Y")) {
			HttpSession session = request.getSession();
			session.setAttribute("mem", mem);
			session.setAttribute("co", co);
			//request.getRequestDispatcher("views/mypage/myInfo.jsp").forward(request, response);			
			response.sendRedirect(request.getContextPath());
//			System.out.println("로그인성공");
			
		}

	
		if(mem.getEmail()!=null && mem.getPw() != null && mem.getStatus().equals("N")) {
			request.setAttribute("error", "활동정지 회원 입니다. 문의사항은 고객센터에 전화주세요.");
			request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
//			System.out.println("활동정지");
		}
	
		if(mem.getEmail()!=null && mem.getPw() != null && mem.getType().equals("2") && mem.getStatus().equals("D")) {
			request.setAttribute("error", "아직 승인절차 진행중 입니다(1~2일정도 소요됩니다).");
			request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
//			System.out.println("승인절차");
		}
	
		if(mem.getEmail()==null && mem.getPw() == null) {
			request.setAttribute("error", "이메일과 비밀번호를 다시 확인해 주세요.");
			request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
//			System.out.println("이메일,비밀번호오류");
		}
	
	
	}

}
