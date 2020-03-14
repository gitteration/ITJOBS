package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Co_Info;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.dao.NotificationDao;

public class MemberService {

	public Member login(Member m) {
		Connection conn = getConnection();
		Member mem = new MemberDao().login(conn, m);
		close(conn);
		return mem;
	}

	public Member getMemberByEmail(String email) {
		Connection conn = getConnection();
		Member m = new MemberDao().getMemberByEmail(conn, email);
		close(conn);
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().joinMember(conn, m);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Co_Info getCoInfo(Member m) {
		Connection conn = getConnection();
		Co_Info mem = new MemberDao().getCoInfo(conn, m);
		close(conn);
		return mem;
	}

	public int update(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().update(conn, m);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int update(Member m, Co_Info co) {
		Connection conn = getConnection();
		int result1 = new MemberDao().update(conn, m);
		int result2 = new MemberDao().update(conn, co);

		int result = 0;
		if (result1 > 0 && result2 > 0) {
			result = 1;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member changePw(Member m, String newPw) {
		Connection conn = getConnection();
		Member mem = null;

		int result = new MemberDao().changePw(conn, m, newPw);
		if (result > 0) {
			commit(conn);
			mem = new MemberDao().getMemberByEmail(conn, m.getEmail());
		} else {
			rollback(conn);
		}
		close(conn);
		return mem;
	}

	public int JoinCoInfo(Co_Info cf, String email, Member m) {

		Connection conn = getConnection();

		int result2 = 0;
		
		int result1 = new MemberDao().joinMember(conn, m);
		
		if(result1>0) {  // 기업정보1단계가 정상적으로 저장이되면
		
			 result2 = new MemberDao().JoinCoInfo(conn, email ,cf); 
		
			 if (result2 > 0 ) {  // 기업정보2단계도 정상적으로 저장되면 
			
				 commit(conn);  // 최종적으로 1단계 , 2단계 정상적으로 commit
				
			 } else {  
				
				 rollback(conn);
			 }
			 
		}else{
			
		}
		
		return result2;

	}

	public Member findPwd(String email) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().findPwd(conn,email);
		
		return m;
		
	}
	
	public int randomPwd(String userPwd,String email) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().randomPwd(conn,userPwd,email);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result ;
		
	}

	public Member getMemberByM_no(int co_no) {
		Connection conn = getConnection();
		Member m = new MemberDao().getMemberByM_no(conn, co_no);
		close(conn);
		return m;
	}
	
	// 기업 좋아요
	
	public int CoLikeCheck(int likeCo, int memNo) {
		
		
	 	
		Connection conn = getConnection();
		//좋아요 중복체크하기 위해서
		int result = new MemberDao().CoLikeCheck(conn,likeCo,memNo);
		
		if(result>0) { // 중복으로 좋아요 한 기업이 있으면 
		  int result1 = new MemberDao().deleteLike(conn,likeCo,memNo);
		  	if(result1>0) {
		  		commit(conn);
		  	}else {
		  		rollback(conn);
		  	}
		  
		
		}else { // 좋아요가 없으면
		   int result2 = new MemberDao().insertLike(conn,likeCo,memNo);
		   	if(result2>0) {
		   		commit(conn);
		   	}else {
		   		rollback(conn);
		   	}
		   
		}
		close(conn);
	
		return result;
	}
	
	public void certifyMem(String email, String cer_no) {
		
		
		Connection conn = getConnection();
		
		int result = new MemberDao().certifyMem(conn,email,cer_no);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
	}
	
	public int EmailCheck(String email) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().EmailCheck(conn,email);
		
		close(conn);
		
//		System.out.println(result);
		
		return result;	
		
	}

	public int NickCheck(String nickName) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().NickCheck(conn,nickName);
		
		close(conn);
		
//		System.out.println(result);
		
		return result;
	}
	
	public int leaveMember(int m_no) {
		Connection conn = getConnection();
		int result = new MemberDao().leaveMember(conn, m_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Member GoogleMem(String googleEm) {
		Connection conn = getConnection();
		
		Member googleMem = new MemberDao().GoogleMem(conn,googleEm);
		
		
		return googleMem;
		
		
		
	}
	
	public Member NaverMem(String naverEm) {
		Connection conn = getConnection();
		
		Member naverMem = new MemberDao().NaverMem(conn,naverEm);
		
		
		return naverMem;
		
		
		
	}
	
	
	
}
