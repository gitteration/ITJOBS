package com.kh.notification.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.PageInfo;
import com.kh.like.model.vo.Like;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.dao.NotificationDao;
import com.kh.notification.model.vo.Notification;

public class NotificationService {

	public ArrayList<Notification> getAllNotificationList(PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Notification> list=new NotificationDao().getAllNotificationList(conn, pi);
		System.out.println(list);
		return list;
	}
	
	public ArrayList<Notification> getAdminAllNotificationList(PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Notification> list=new NotificationDao().getAdminAllNotificationList(conn, pi);
		return list;
	}

	public int delete(int noti_no) {
		Connection conn=getConnection();
		int result=new NotificationDao().delete(conn,noti_no);
		close(conn);
		return result;
	}

	public int deleteCancle(int noti_no) {
		Connection conn=getConnection();
		int result=new NotificationDao().deleteCancle(conn,noti_no);
		close(conn);
		return result;
	}

	public ArrayList<Notification> getOpenNotificationList() {
		Connection conn=getConnection();
		ArrayList<Notification> list=new NotificationDao().getOpenNotificationList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Notification> getMyNotificationList(Member mem, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Notification> list=new NotificationDao().getMyNotificationList(conn,mem,pi);
		close(conn);
		return list;
	}

	public Notification getNotification(int noti_no) {
		Connection conn=getConnection();
		Notification noti=new NotificationDao().getNotification(conn,noti_no);
		close(conn);
		return noti;
	}

	public int insertNotification(Notification n) {
		Connection conn=getConnection();
		int result=new NotificationDao().insertNotification(conn,n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Notification getLastestNotification() {
		Connection conn=getConnection();
		Notification noti=new NotificationDao().getLastestNotification(conn);
		close(conn);
		return noti;
	}

	public int updateNotification(Notification n) {
		Connection conn=getConnection();
		int result=new NotificationDao().updateNotification(conn,n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int openNotification(int noti_no) {
		Connection conn=getConnection();
		int result=new NotificationDao().openNotification(conn,noti_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int openCancleNotification(int noti_no) {
		Connection conn=getConnection();
		int result=new NotificationDao().openCancleNotification(conn,noti_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int NotiLikeCheck(int likeNo, int memNo) {
		
		
	 	
		Connection conn = getConnection();
		//좋아요 중복체크하기 위해서
		int result = new NotificationDao().notiLikeCheck(conn,likeNo,memNo);
		
		if(result>0) { // 중복으로 좋아요 한 기업이 있으면 
		  int result1 = new NotificationDao().deleteLike(conn,likeNo,memNo);
		  	if(result1>0) {
		  		commit(conn);
		  	}else {
		  		rollback(conn);
		  	}
		  
		
		}else { // 좋아요가 없으면
		   int result2 = new NotificationDao().insertLike(conn,likeNo,memNo);
		   	if(result2>0) {
		   		commit(conn);
		   	}else {
		   		rollback(conn);
		   	}
		   
		}
		close(conn);
	
		return result;
	}

	public int getListCount() {
		Connection conn=getConnection();
		int result=new NotificationDao().getListCount(conn);
		close(conn);
		return result;
	}

	public int getSuperSearchNotificationListCount(String sText) {
		Connection conn=getConnection();
		int result=new NotificationDao().getSuperSearchNotificationListCount(conn,sText);
		close(conn);
		return result;
	}

	public int getMyNotificationListCount(Member mem) {
		Connection conn=getConnection();
		int result=new NotificationDao().getMyNotificationListCount(conn,mem);
		close(conn);
		return result;
	}
	
	
	
	
	
}
