package com.kh.volunteer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.volunteer.model.service.VolunteerService;
import com.kh.volunteer.model.vo.Volunteer;

/**
 * Servlet implementation class VolunteerFailServlet
 */
@WebServlet("/fail.vo")
public class VolunteerFailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerFailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int v_no=Integer.parseInt(request.getParameter("v_no"));
		Volunteer v=new VolunteerService().getVolunteer(v_no);
		
		int result=new VolunteerService().failResume(v_no);
		if(result>0) {
			response.sendRedirect("list.vo?noti_no="+v.getNoti_no());
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
