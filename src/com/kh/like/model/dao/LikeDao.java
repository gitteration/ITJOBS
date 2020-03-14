package com.kh.like.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.board.model.vo.PageInfo;
import com.kh.like.model.vo.Like;
import com.kh.notification.model.vo.Notification;
import com.kh.question.model.dao.QuestionDao;
import com.kh.resume.model.vo.Resume;

public class LikeDao {

	private Properties prop = new Properties();
	
	public LikeDao() {
		
		String fileName = QuestionDao.class.getResource("/com/kh/sql/like-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Like> myCompanyList(Connection conn, int m_no, PageInfo pi) {
		ArrayList<Like> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyCompanyList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Like like=new Like();
				like.setLike_no(rs.getInt("like_co_no"));
				like.setM_no(rs.getInt("m_no"));
				like.setCo_no(rs.getInt("co_no"));
				like.setNickname(rs.getString("nickname"));
				like.setAddress(rs.getString("address"));
				//m.setNumberOfNotification(rs.getInt("t"));
				list.add(like);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return list;
	}

	public ArrayList<Notification> myNotificationList(Connection conn, int m_no, PageInfo pi) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyNotificationList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Notification n=new Notification();
				n.setNoti_no(rs.getInt("noti_no"));
				n.setTitle(rs.getString("title"));
				n.setEnd_date(rs.getDate("end_date")+" "+rs.getTime("end_date"));
				n.setNickname(rs.getString("nickname"));
				n.setAddress(rs.getString("address"));
				n.setLogoFile(rs.getString("logo_file"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return list;
	}

	public ArrayList<Resume> myResumeList(Connection conn, int m_no, PageInfo pi) {
		ArrayList<Resume> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyResumeList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Resume r=new Resume();
				r.setResume_no(rs.getInt("resume_no"));
				r.setP_language(rs.getString("p_language"));
				r.setTitle(rs.getString("title"));
				r.setDepartment(rs.getString("department"));
				r.setCareer(rs.getString("career"));
				r.setPhoto(rs.getString("photo"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int deleteCompany(Connection conn, int co_no, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteCompany");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, co_no);
			ps.setInt(2, m_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteNotification(Connection conn, int noti_no, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			ps.setInt(2, m_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteResume(Connection conn, int resume_no, int co_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteResume");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, resume_no);
			ps.setInt(2, co_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<String> likeBoList(Connection conn, int memNo) {
	
		ArrayList<String> likeBoList = new ArrayList<>();
		
		
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("likeBoList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, memNo);
			rs=ps.executeQuery();
			
			/*
			while(true) {
			if(rs.next()) {
				likeBoList.add(rs.getString(1));
				}
			}*/
			while(rs.next()) {
				likeBoList.add(rs.getString(1));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		
		return likeBoList;
		
		
	}
	

	public ArrayList<String> likeResList(Connection conn, int CoNo) {
	
		ArrayList<String> likeBoList = new ArrayList<>();
		
		
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("likeResList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, CoNo);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				likeBoList.add(rs.getString(1));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		
		return likeBoList;
		
		
	}

	public int likeCoList1(Connection conn, int coNo, int memNo) {

		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
	
		System.out.println(coNo + "+" + memNo);
		
		String sql = prop.getProperty("likeCoList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, coNo);
			ps.setInt(2, memNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			result = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		System.out.println(result);
		return result;
		
		
	}
	
	
		
		
	
	
	public String likeCoCheck(Connection conn, int coNo, int memNo) {

		String result = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
	
		System.out.println(coNo + "+" + memNo);
		
		String sql = prop.getProperty("likeCoList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, coNo);
			ps.setInt(2, memNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			result = rs.getString(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		System.out.println(result);
		return result;
		
		
	}
	
	public int likeNoList1(Connection conn, int noNo, int memNo) {

		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
	
		System.out.println(noNo + "+" + memNo);
		
		String sql = prop.getProperty("likeNoList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noNo);
			ps.setInt(2, memNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			result = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		System.out.println(result);
		return result;
		
		
	}
	
	public String likeNoCheck(Connection conn, int noNo, int memNo) {

		String result = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
	
		System.out.println(noNo + "+" + memNo);
		
		String sql = prop.getProperty("likeNoList");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noNo);
			ps.setInt(2, memNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			result = rs.getString(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		System.out.println(result);
		return result;
		
		
	}
	
	public int deleteCoLike(Connection conn, int coNo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteCoLike");
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, coNo);
			ps.setInt(2, memNo);
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}
	
	public int insertCoLike(Connection conn, int coNo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertCoLike");
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, memNo);
			ps.setInt(2, coNo);
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
			return result;
		}
	
	
	public int myCompanyListCount(Connection conn, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyCompanyListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public int myNotificationListCount(Connection conn, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("myNotificationListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public int myResumeListCount(Connection conn, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("myResumeListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return result;
	}
	

}
