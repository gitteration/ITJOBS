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
import com.kh.declare.model.vo.Declare;
import com.kh.question.model.dao.QuestionDao;

public class AdminDeclareDao {

	private Properties prop = new Properties();
	
	public AdminDeclareDao() {
		
		String fileName = QuestionDao.class.getResource("/com/kh/sql/declare-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Declare> getBoardList(Connection conn) {
		ArrayList<Declare> list = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllBoardList");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Declare d=new Declare();
				d.setDe_no(rs.getInt(1));
				d.setB_no(rs.getInt(2));
				d.setM_no(rs.getInt(3));
				d.setContents(rs.getString(4));
				d.setEnroll_date(rs.getDate(5)+" "+rs.getTime(5));
				d.setComp_date(rs.getDate(6)+" "+rs.getTime(6));
				d.setStatus(rs.getString(7));
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

	public ArrayList<Declare> getReplyList(Connection conn) {
		ArrayList<Declare> list = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllReplyList");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Declare d=new Declare();
				d.setDe_no(rs.getInt(1));
				d.setRe_no(rs.getInt(2));
				d.setM_no(rs.getInt(3));
				d.setContents(rs.getString(4));
				d.setEnroll_date(rs.getDate(5)+" "+rs.getTime(5));
				d.setComp_date(rs.getDate(6)+" "+rs.getTime(6));
				d.setStatus(rs.getString(7));
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

	public ArrayList<Declare> getNotificationList(Connection conn) {
		ArrayList<Declare> list = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllNotificationList");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Declare d=new Declare();
				d.setDe_no(rs.getInt(1));
				d.setNoti_no(rs.getInt(2));
				d.setM_no(rs.getInt(3));
				d.setContents(rs.getString(4));
				d.setEnroll_date(rs.getDate(5)+" "+rs.getTime(5));
				d.setComp_date(rs.getDate(6)+" "+rs.getTime(6));
				d.setStatus(rs.getString(7));
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

	public Declare getBoard(Connection conn, int de_no) {
		Declare de = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getBoard");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				de=new Declare();
				de.setDe_no(rs.getInt("b_d_no"));
				de.setB_no(rs.getInt("b_no"));
				de.setM_no(rs.getInt("m_no"));
				de.setContents(rs.getString("contents"));
				de.setEnroll_date(rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"));
				de.setComp_date(rs.getDate("comp_date")+" "+rs.getTime("comp_date"));
				de.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return de;
	}

	public Declare getNotification(Connection conn, int de_no) {
		Declare de = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				de=new Declare();
				de.setDe_no(rs.getInt("n_d_no"));
				de.setNoti_no(rs.getInt("noti_no"));
				de.setM_no(rs.getInt("m_no"));
				de.setContents(rs.getString("contents"));
				de.setEnroll_date(rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"));
				de.setComp_date(rs.getDate("comp_date")+" "+rs.getTime("comp_date"));
				de.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return de;
	}

	public Declare getReply(Connection conn, int de_no) {
		Declare de = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getReply");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				de=new Declare();
				de.setDe_no(rs.getInt("r_d_no"));
				de.setRe_no(rs.getInt("re_no"));
				de.setM_no(rs.getInt("m_no"));
				de.setContents(rs.getString("contents"));
				de.setEnroll_date(rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"));
				de.setComp_date(rs.getDate("comp_date")+" "+rs.getTime("comp_date"));
				de.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return de;
	}

	public int completeBoard(Connection conn, int de_no) {
		int result = 0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("completeBoard");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int completeNotification(Connection conn, int de_no) {
		int result = 0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("completeNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int completeReply(Connection conn, int de_no) {
		int result = 0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("completeReply");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, de_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
}
