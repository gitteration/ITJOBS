package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Co_Info;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		int result=0;
		
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("mem");
		
		if(m.getType().equals("1")) {
			String nickname=request.getParameter("nickname");
			m.setNickname(nickname);
			result=new MemberService().update(m);
		} else if(m.getType().equals("2")) {
			if(ServletFileUpload.isMultipartContent(request)) {
				int maxSize=10*1024*1024;
				String root = request.getSession().getServletContext().getRealPath("/resources");
				String savePath = root + "/cofileupload/";
		
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
				String[] changeName = new String[2];
				String[] pathName=new String[2];
				changeName[0]=multiRequest.getParameter("file1_file");
				pathName[0]=multiRequest.getParameter("path1_path");
				changeName[1]=multiRequest.getParameter("file2_file");
				pathName[1]=multiRequest.getParameter("path2_path");
				
				//Enumeration<String> files = multiRequest.getFileNames();
				
				if(multiRequest.getFilesystemName("file1") != null) {
					changeName[0]=multiRequest.getFilesystemName("file1");
				}
				if(multiRequest.getFilesystemName("file2") != null) {
					changeName[1]=multiRequest.getFilesystemName("file2");
				}
				
				//닉네임부터 수정
				String nickname=multiRequest.getParameter("nickname");
				m.setNickname(nickname+"(기업)");
				//result=new MemberService().update(m);
				
				//나머지 수정
				String regNum=multiRequest.getParameter("regnum");
				String ceo=multiRequest.getParameter("ceo");
				String name=multiRequest.getParameter("name");
				String phone=multiRequest.getParameter("phone");
				String descript=multiRequest.getParameter("descript");
				String co_phone=multiRequest.getParameter("co_phone");
				String birth_date=multiRequest.getParameter("birth_date");
				int memsum=Integer.parseInt(multiRequest.getParameter("memsum"));
				int revenue=Integer.parseInt(multiRequest.getParameter("revenue"));
				
				String postcode=multiRequest.getParameter("sample3_postcode");
				String address_=multiRequest.getParameter("sample3_address");
				String detailAddress=multiRequest.getParameter("sample3_detailAddress");
				String address=postcode+"+"+address_+"+"+detailAddress;
				
				String history=multiRequest.getParameter("history");
				String welfare=multiRequest.getParameter("welfare");
				
				Co_Info co=new Co_Info();
				co.setM_no(m.getM_no());
				co.setRegNum(regNum);
				co.setFile(changeName[0]);
				co.setPath(savePath);
				co.setName(name);
				co.setPhone(phone);
				co.setDescript(descript);
				co.setAddress(address);
				co.setBirth_date(birth_date);
				co.setCeo(ceo);
				co.setCo_phone(co_phone);
				co.setMemsum(memsum);
				co.setRevenue(revenue);
				co.setAddress(address);
				co.setHistory(history);
				co.setWelfare(welfare);
				co.setLogofile(changeName[1]);
				co.setLogopath(savePath);
				System.out.println(co);
				result=new MemberService().update(m,co);
			}
		}
		
		if(result>0) {
			Member newm=new MemberService().getMemberByEmail(m.getEmail());
			session.setAttribute("mem", newm);
			Co_Info co=new MemberService().getCoInfo(newm);
			session.setAttribute("co", co);
			session.setAttribute("nickChange", "정상적으로 수정 되었습니다");
			response.sendRedirect(request.getContextPath()+"/myInfo.me");
		}else{
			session.setAttribute("nickChange", "다시 수정 부탁드립니다.");
			response.sendRedirect(request.getContextPath()+"/myInfo.me");
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
