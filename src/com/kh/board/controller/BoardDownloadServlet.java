package com.kh.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardDownloadServlet
 */
@WebServlet("/download.bo")
public class BoardDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		Board b = new BoardService().selectDownCountBoard(bId);
		
		File downFile = new File(request.getSession().getServletContext().getRealPath("/resources")+"/fileupload_board/" + b.getEditFile());
		String oriName = new String(b.getFile().getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "attchment; filename=\"" + oriName + "\"");
		response.setContentLength((int)downFile.length());
		ServletOutputStream downOut = response.getOutputStream();
		BufferedInputStream buf = new BufferedInputStream(new FileInputStream(downFile));
		int readBytes = 0;
		while((readBytes = buf.read()) != -1) {	
			downOut.write(readBytes);
		}
		
		downOut.close();
		buf.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
