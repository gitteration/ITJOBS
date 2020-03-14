package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminBoardDao;
import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;

public class AdminBoardService {

	public int delete(int b_no) {
		Connection conn=getConnection();
		int result=new AdminBoardDao().delete(conn,b_no);
		close(conn);
		return result;
	}

	public ArrayList<Board> getAllList(PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Board> list=new AdminBoardDao().getAllList(conn,pi);
		return list;
	}

	public int deleteCancle(int b_no) {
		Connection conn=getConnection();
		int result=new AdminBoardDao().deleteCancle(conn,b_no);
		close(conn);
		return result;
	}
	
	public int getListCount() {
		Connection conn=getConnection();
		int result=new AdminBoardDao().getListCount(conn);
		close(conn);
		return result;
	}
	
	public Board selectBoard(int bId) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, bId);
		close(conn);
		return b;
	}
}
