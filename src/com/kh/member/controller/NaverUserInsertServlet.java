package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;


/**
 * Servlet implementation class NaverUserInsertServlet
 */
@WebServlet("/naverinsert.me")
public class NaverUserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverUserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String naverEm = request.getParameter("naverEm");
		
		
		
		if(naverEm != null) {
			
			int result = new MemberService().EmailCheck(naverEm); // 회원이 존재하는지
			
			if(result == 0) {	//없으면 디비에 저장시키고(신규)
				
				String type = "1";
				String email = naverEm;
				String pw = Integer.toString((int)(Math.random()*10000+1));
				
				String encPwd = "";
				MessageDigest md;
				
					try {
						md = MessageDigest.getInstance("SHA-512");
						byte[] bytes=pw.getBytes(Charset.forName("UTF-8"));
						md.update(bytes);
						encPwd=Base64.getEncoder().encodeToString(md.digest());
					
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				
				int index = naverEm.indexOf("@");
				
				String nickname=naverEm.substring(0,index);
				
				Member m = new Member();
				m.setType(type);
				m.setEmail(email); 
				m.setPw(encPwd);
				m.setNickname(nickname);
				
				
				int result1 = new MemberService().insertMember(m);
				
					if(result1>0) {	// 디비저장 성공
						//HttpSession session = request.getSession();
						//session.setAttribute("alert", "회원가입을 환영합니다.로그인을 진행해 주세요");
						//request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
						
						PrintWriter out= response.getWriter();
						
						out.print("1");
						
						
						
					}else {		// 실패
					/*
					 * HttpSession session = request.getSession();
					 * 
					 * response.sendRedirect(request.getContextPath());
					 * session.setAttribute("alert", "동시 가입자가 많아 잠시 후 다시 시도해 주시길 바랍니다.");
					 */
					
						// 이쪽은 잘 모르겠다 오류날 이유가 없는거 같아서.
						
						
						
					}
				
				
				
			}else { // 있으면 로그인으로 보내고
				
				Member naverMem = new MemberService().NaverMem(naverEm);
				
				HttpSession session = request.getSession();
				session.setAttribute("mem", naverMem);
				response.sendRedirect(request.getContextPath());
				PrintWriter out= response.getWriter();
				out.print("1");
				
				
				
				//response.sendRedirect(request.getContextPath());
				
				
			
			}
		
		
		
		}else {
			// 여기도 구지 모르겠음..
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
