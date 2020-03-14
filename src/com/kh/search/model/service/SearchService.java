package com.kh.search.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.PageInfo;
import com.kh.notification.model.vo.Notification;
import com.kh.resume.model.vo.Resume;
import com.kh.search.model.dao.SearchDao;

public class SearchService {

	public ArrayList<Resume> searchResumeList(String sKey, String sText) {
		Connection conn=getConnection();
		ArrayList<Resume> list=new SearchDao().searchResumeList(conn,sKey,sText);
		close(conn);
		return list;
	}
	
	public ArrayList<Resume> getSuperSearchResume(String sText) {
		Connection conn=getConnection();
		ArrayList<Resume> list=new SearchDao().getSuperSearchResume(conn,sText);
		close(conn);
		return list;
	}

	public ArrayList<Notification> getSuperSearchNotification(String sText, PageInfo pi) {
		
		Connection conn=getConnection();
		ArrayList<Notification> list=new SearchDao().getSuperSearchNotification(conn,sText,pi);
		close(conn);
		return list;
	}
}
