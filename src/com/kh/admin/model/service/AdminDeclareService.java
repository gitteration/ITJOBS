package com.kh.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDeclareDao;
import com.kh.declare.model.vo.Declare;

import static com.kh.common.JDBCTemplate.*;

public class AdminDeclareService {

	public ArrayList<Declare> getBoardList() {
		Connection conn = getConnection();
		ArrayList<Declare> list=new AdminDeclareDao().getBoardList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Declare> getReplyList() {
		Connection conn = getConnection();
		ArrayList<Declare> list=new AdminDeclareDao().getReplyList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Declare> getNotificationList() {
		Connection conn = getConnection();
		ArrayList<Declare> list=new AdminDeclareDao().getNotificationList(conn);
		close(conn);
		return list;
	}

	public Declare getBoard(int de_no) {
		Connection conn = getConnection();
		Declare de=new AdminDeclareDao().getBoard(conn,de_no);
		close(conn);
		return de;
	}

	public Declare getNotification(int de_no) {
		Connection conn = getConnection();
		Declare de=new AdminDeclareDao().getNotification(conn,de_no);
		close(conn);
		return de;
	}

	public Declare getReply(int de_no) {
		Connection conn = getConnection();
		Declare de=new AdminDeclareDao().getReply(conn,de_no);
		close(conn);
		return de;
	}

	public int completeBoard(int de_no) {
		Connection conn = getConnection();
		int result=new AdminDeclareDao().completeBoard(conn,de_no);
		close(conn);
		return result;
	}

	public int completeNotification(int de_no) {
		Connection conn = getConnection();
		int result=new AdminDeclareDao().completeNotification(conn,de_no);
		close(conn);
		return result;
	}

	public int completeReply(int de_no) {
		Connection conn = getConnection();
		int result=new AdminDeclareDao().completeReply(conn,de_no);
		close(conn);
		return result;
	}

}
