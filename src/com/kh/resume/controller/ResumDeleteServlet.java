package com.kh.resume.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.resume.model.service.ResumeService;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class ResumDeleteServlet
 */
@WebServlet("/deleteResum.re")
public class ResumDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	int resume_no = Integer.parseInt(request.getParameter("resume_no"));
	
	int result = new ResumeService().deleteResume(resume_no);
	
	HttpSession session = request.getSession();
	//지원중인 지원서인지? 0이면 좋아요삭제,이력서삭제
	//				1이면 지원취소하고 삭제하라고 해
	// select * from volunteer where resume_no =? 값이 있으면 1, 없으면 0 
	// 1--> 알림창(현재 이력서가 지원중이니 삭제하시려면 지원취소하고 삭제해주세요)
	// 0--> LIKE_MEM에서 RESUME_NO=?인거 삭제하고 이력서도 삭제 
	//int result = new ResumeService().deleteResume(resume_no);
	
	if(result > 0) {
		session.setAttribute("alert", "이력서 삭제 성공");
		response.sendRedirect("list.re");
	} else { 
		System.out.println("이력서 삭제에 실패하였습니다.");
		// 이력서 삭제 실패하였을때 지원중인 이력서 인지 확인 
		session.setAttribute("alert", "현재이력서가 지원중이니 삭제하시려면 지원취소하고 삭제해주세요");
		//response.sendRedirect("list.re");
		int su_result = new ResumeService().supportResume(resume_no);
		
		if(su_result > 0){
			System.out.println("현재이력서가 지원중이니 삭제하시려면 지원취소하고 삭제해주세요");
			//msg("현재이력서가 지원중이니 삭제하시려면 지원취소하고 삭제해주세요");
			response.sendRedirect("list.re");
		}else{
			System.out.println("좋아요삭제하고 이력서삭제");
			// 좋아요삭제하고 
			//response.sendRedirect("deleteResum.re");
			response.sendRedirect("list.re");
		}
		//response.sendRedirect("list.re");
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
