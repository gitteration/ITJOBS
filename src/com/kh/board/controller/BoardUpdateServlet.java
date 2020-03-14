package com.kh.board.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/update.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String root = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = root + "/fileupload_board/"; 
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String originName  = new String();
			String changeName = new String();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				if(multiRequest.getFilesystemName(name) != null) {
					originName = multiRequest.getOriginalFileName(name);
					changeName = multiRequest.getFilesystemName(name);

				}
			}
			
			int b_no = Integer.parseInt(multiRequest.getParameter("b_no"));
			
			HttpSession session = request.getSession();
		    Member mem=(Member)session.getAttribute("mem");
		    int m_no = mem.getM_no();
		    
			String strB_no = multiRequest.getParameter("b_no");
			
			String head = multiRequest.getParameter("writehead");
			String title = multiRequest.getParameter("title");
			String contents = multiRequest.getParameter("content");
			String time1 = multiRequest.getParameter("time1");
			String time2 = multiRequest.getParameter("time2");
			
		
			String time = "";
	         if(time1 != null && time2 != null) {
	            time = time1 + "~" + time2;
	         }
	         
			Board b = new Board();
			b.setB_no(b_no);
			b.setM_no(m_no);
			b.setHead(head);
			b.setTitle(title);
			b.setContents(contents);
			b.setTime(time);
			b.setFile(originName);
			b.setEditFile(changeName);
			b.setPath(savePath);
			
		
			int result = new BoardService().updateBoard(b);
			
			if(result > 0) {
				String[] afterHeadAry = new BoardService().selectHead(b_no);
				String afterHead = afterHeadAry[0];		// M_no받아오는 디테일 서블릿이랑 sql구문 같이쓰려고 배열로 받음 [0]은 해당 게시글 head, [1]은 해당게시글 m_no
				System.out.println("업데이트 서블릿  스위치 전  " + afterHead);
				
	
				switch(afterHead) {
				case "자유" :  afterHead="free"; break;
				case "스터디" :  afterHead="study"; break;
				case "프로젝트" :  afterHead="project"; break;
				case "공지사항" :  afterHead="qu"; break;
				case "서식" :  afterHead="form"; break;
				default: break;
				}
				
				System.out.println("업데이트 서블릿  스위치 후  " + afterHead);
				
				response.sendRedirect("detail.bo?head="+afterHead+"&bId=" + strB_no);
			}else {
				request.setAttribute("msg", "게시글 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		
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
