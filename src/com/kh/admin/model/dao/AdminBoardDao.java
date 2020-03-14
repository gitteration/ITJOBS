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
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;

public class AdminBoardDao {

private Properties prop = new Properties();
	
	public AdminBoardDao() {
		
		String fileName = BoardDao.class.getResource("/com/kh/sql/admin-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(Connection conn, int b_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("delete");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	public ArrayList<Board> getAllList(Connection conn, PageInfo pi) {
		ArrayList<Board> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pi.getEndRow());
			ps.setInt(2, pi.getStartRow());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Board b=new Board(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getString(13),
						rs.getString(14));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}
	
	public int deleteCancle(Connection conn, int b_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteCancle");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	public int getListCount(Connection conn) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getListCount");
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
