package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminMemberDao;
import com.kh.board.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public class AdminMemberService {

	public ArrayList<Member> getAllMemberList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminMemberDao().getAllMemberList(conn,pi);
		close(conn);
		return list;
	}
	
	public int vanishMember(int mno) {
		Connection conn = getConnection();
		int result = new AdminMemberDao().vanishMember(conn, mno);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int vanishCancleMember(int mno) {
		Connection conn = getConnection();
		int result = new AdminMemberDao().vanishCancleMember(conn, mno);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getMemberListCount() {
		Connection conn = getConnection();
		int result = new AdminMemberDao().getMemberListCount(conn);
		close(conn);
		return result;
	}

}
