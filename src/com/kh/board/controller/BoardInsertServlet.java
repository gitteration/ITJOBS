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
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/insert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

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
		
			HttpSession session = request.getSession();
		    Member mem=(Member)session.getAttribute("mem");
		    int m_no = mem.getM_no();
			
			String head = multiRequest.getParameter("writehead");
			String title = multiRequest.getParameter("title");
			String contents = multiRequest.getParameter("content");
			String time1 = multiRequest.getParameter("time1");
			String time2 = multiRequest.getParameter("time2");
			String clickHead = multiRequest.getParameter("clickHead");	// 메뉴바에서 클릭한 헤드(인설트 후 리스트 재조회 시 필요)
			String video = multiRequest.getParameter("video");
			
			switch(clickHead) {
			case "전체보기" : clickHead="main"; break;
			case "자유" : clickHead="free"; break;
			case "스터디" : clickHead="study"; break;
			case "프로젝트" : clickHead="project"; break;
			case "공지사항" : clickHead="qu"; break;
			case "서식" : clickHead="form"; break;
			default: break;
			}
			
			String time = "";
	         if(head.equals("스터디") || head.equals("프로젝트")) {
	            time = time1 + "~" + time2;
	         }
			
			Board b = new Board();
			b.setM_no(m_no);
			b.setHead(head);
			b.setTitle(title);
			b.setContents(contents);
			b.setTime(time);
			b.setFile(originName);
			b.setEditFile(changeName);
			b.setPath(savePath);
			b.setVideo(video);
			
			int result = new BoardService().insertBoard(b);
			
			if(result > 0) {
				response.sendRedirect("list.bo?head="+ clickHead);
				/*request.setAttribute("head", clickHead);
				request.getRequestDispatcher("list.bo").forward(request, response);*/
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
