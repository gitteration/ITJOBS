package com.kh.member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.sendEmail;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class findPwd
 */
@WebServlet(name="findPwdServlet", urlPatterns="/findpwd.me")

public class findPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		String email = request.getParameter("email"); 
		
		Member mem = new MemberService().findPwd(email); //유저의 이메일을 조회해오고
		
		if(mem != null) {	// 존재하면
			
			String userPwd = mem.getPw(); // 유저 비밀번호를 받고
			
			int pwRandom = (int)(Math.random()*100000+1); // 임시로 난수를 발생시킨 숫자를 변수에 담아
			
			
			userPwd =  Integer.toString(pwRandom); // 유저의 비밀번호에 난수의 숫자를 담고
			
			
			// 이메일에 보내기전 pwRandom 에 난수를 encPwd로 받아 암호화 하고  
			String encPwd = "";
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-512");

				byte[] bytes=userPwd.getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				encPwd=Base64.getEncoder().encodeToString(md.digest());
				
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int result = new MemberService().randomPwd(encPwd,email); //  디비에 암호화된 비밀번호와 이메일을 저장한다
			
			if(result>0) {	// 정상적으로 비밀번호 변경 이메일에 임시 비밀번호 전송
				
				new sendEmail().sendPwd(email,userPwd); // 암호화 하기전 발생시킨 난수는 상대방 이메일로 전송 
				
				request.setAttribute("findResult", "임시 비밀번호를 발송하였습니다. 로그인을 진행해 주세요");
				request.setAttribute("MemEmail", email);
				request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
			}else {
				//이메일 발송 실패
			}
			
			
			
		}else {
			// 존재하지 않는 회원
			request.setAttribute("findResult", "존재하지 않는 회원입니다.");
			request.getRequestDispatcher("views/login/find.jsp").forward(request, response);
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
