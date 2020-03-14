package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.kh.board.model.service.BoardService;
import com.kh.reply.model.vo.Reply;

/**
 * Servlet implementation class BoardReplyListServlet
 */
@WebServlet("/brlist.bo")
public class BoardReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bId = Integer.parseInt(request.getParameter("bId"));
		
		ArrayList<Reply> list = new BoardService().selectRlist(bId);
		
		response.setContentType("application/json; charset=UTF-8");
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yy-MM-dd HH:mm:ss").create();
		
		gson.toJson(list,response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
