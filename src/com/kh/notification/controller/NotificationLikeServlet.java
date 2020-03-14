package com.kh.notification.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notification.model.service.NotificationService;

/**
 * Servlet implementation class NotificationLikeServlet
 */
@WebServlet("/like.no")
public class NotificationLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int likeNo = Integer.parseInt(request.getParameter("noNo"));
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
//		System.out.println(likeNo);
//		System.out.println(memNo);
		
		int result = new NotificationService().NotiLikeCheck(likeNo,memNo);
		
//		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		
		if(result==0) {
			out.print(0);
		}else {
			out.print(1);
		}
		
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
