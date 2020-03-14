package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminReplyDao;
import com.kh.reply.model.vo.Reply;

public class AdminReplyService {

	public ArrayList<Reply> getAllReplyList() {
		Connection conn = getConnection();
		ArrayList<Reply> list=new AdminReplyDao().getAllReplyList(conn);
		close(conn);
		return list;
	}

	public int delete(int r_no) {
		Connection conn=getConnection();
		int result=new AdminReplyDao().delete(conn,r_no);
		close(conn);
		return result;
	}

	public int deleteCancle(int r_no) {
		Connection conn=getConnection();
		int result=new AdminReplyDao().deleteCancle(conn,r_no);
		close(conn);
		return result;
	}

}
