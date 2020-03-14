package com.kh.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.question.model.dao.QuestionDao;
import com.kh.reply.model.vo.Reply;

public class AdminReplyDao {

	private Properties prop = new Properties();
	
	public AdminReplyDao() {
		
		String fileName = QuestionDao.class.getResource("/com/kh/sql/reply-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reply> getAllReplyList(Connection conn) {
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllReplyList");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Reply d=new Reply();
				d.setRe_no(rs.getInt(1));
				d.setM_no(rs.getInt(2));
				d.setB_no(rs.getInt(3));
				d.setEnroll_date(rs.getDate(4)+" "+rs.getTime(4));
				d.setUpdate_date(rs.getDate(5)+" "+rs.getTime(5));
				d.setContents(rs.getString(6));
				d.setStatus(rs.getString(7));
				d.setD_count(rs.getInt(8));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	public int delete(Connection conn, int r_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("delete");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int deleteCancle(Connection conn, int r_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteCancle");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	
}
