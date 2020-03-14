package com.kh.like.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.PageInfo;
import com.kh.like.model.dao.LikeDao;
import com.kh.like.model.vo.Like;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.dao.NotificationDao;
import com.kh.notification.model.vo.Notification;
import com.kh.resume.model.vo.Resume;

import static com.kh.common.JDBCTemplate.*;

public class LikeService {

	public ArrayList<Like> myCompanyList(int m_no, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Like> list=new LikeDao().myCompanyList(conn,m_no,pi);
		close(conn);
		return list;
	}

	public ArrayList<Notification> myNotificationList(int m_no, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Notification> list=new LikeDao().myNotificationList(conn,m_no,pi);
		close(conn);
		return list;
	}

	public ArrayList<Resume> myResumeList(int m_no, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Resume> list=new LikeDao().myResumeList(conn,m_no,pi);
		close(conn);
		return list;
	}

	public int deleteCompany(int co_no, int m_no) {
		Connection conn=getConnection();
		int result=new LikeDao().deleteCompany(conn,co_no,m_no);
		close(conn);
		return result;
	}

	public int deleteNotification(int noti_no, int m_no) {
		Connection conn=getConnection();
		int result=new LikeDao().deleteNotification(conn,noti_no,m_no);
		close(conn);
		return result;
	}

	public int deleteResume(int resume_no, int co_no) {
		Connection conn=getConnection();
		int result=new LikeDao().deleteResume(conn,resume_no,co_no);
		close(conn);
		return result;
	}

	
	public ArrayList<String> LikeBoList(int memNo) {
		
		Connection conn = getConnection();
		
		ArrayList<String> likeBoList = new LikeDao().likeBoList(conn,memNo);
		close(conn);
		return likeBoList;
	
	}
		
	public ArrayList<String> LikeResList(int CoNo) {
		
		Connection conn = getConnection();
		
		ArrayList<String> likeBoList = new LikeDao().likeResList(conn,CoNo);
		close(conn);
		return likeBoList;
	
	}
	
	public int LikeCoList1(int coNo, int memNo) {
		
		Connection conn = getConnection();
		
		int result = new LikeDao().likeCoList1(conn,coNo,memNo);
		

		if(result>0) { // 중복으로 좋아요 한 기업이 있으면 
		  int result1 = new LikeDao().deleteCoLike(conn,coNo,memNo);
		  	if(result1>0) {
		  		commit(conn);
		  	}else {
		  		rollback(conn);
		  	}
		  close(conn);
		
		}else { // 좋아요가 없으면
		   int result2 = new LikeDao().insertCoLike(conn,coNo,memNo);
		   	
		   if(result2>0) {		
		   		commit(conn);
		   	}else {
		   		rollback(conn);
		   	}
		   	close(conn);
		   
		}
		
		
		
		return result;
	
	}
	
	
	public String likeCoCheck(int co_no, int memNo) {
		
		Connection conn = getConnection();
		
		String result = new LikeDao().likeCoCheck(conn,co_no,memNo);
		
		close(conn);
		
		return result;
		
	}
	

	public String likeNoCheck(int noNo, int memNo) {
		
		Connection conn = getConnection();
		
		String result = new LikeDao().likeNoCheck(conn,noNo,memNo);
		
		close(conn);
		
		return result;
		
	}

	public int myCompanyListCount(int m_no) {
		Connection conn=getConnection();
		int result=new LikeDao().myCompanyListCount(conn,m_no);
		close(conn);
		return result;
	}

	public int myNotificationListCount(int m_no) {
		Connection conn=getConnection();
		int result=new LikeDao().myNotificationListCount(conn,m_no);
		close(conn);
		return result;
	}

	public int myResumeListCount(int m_no) {
		Connection conn=getConnection();
		int result=new LikeDao().myResumeListCount(conn,m_no);
		close(conn);
		return result;
	}
}
