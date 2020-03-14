package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public class AdminMemberDao {

private Properties prop = new Properties();
	
	public AdminMemberDao() {
		
		String fileName = BoardDao.class.getResource("/com/kh/sql/admin-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> getAllMemberList(Connection conn,PageInfo pi) {
		ArrayList<Member> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null; 
		
		String sql=prop.getProperty("getAllMemberList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pi.getStartRow());
			ps.setInt(2, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}
	
	public int vanishMember(Connection conn, int mno) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("vanishMember");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int vanishCancleMember(Connection conn, int mno) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("vanishCancleMember");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int getMemberListCount(Connection conn) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMemberListCount");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
}
