package com.kh.volunteer.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.vo.Notification;
import com.kh.resume.model.dao.ResumeDao;
import com.kh.volunteer.model.vo.Volunteer;

public class VolunteerDao {

private Properties prop = new Properties();
	
	public VolunteerDao() {
		
		String fileName = ResumeDao.class.getResource("/com/kh/sql/volunteer-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Volunteer> getList(Connection conn, int noti_no, PageInfo pi) {
		ArrayList<Volunteer> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Volunteer v=new Volunteer(
						rs.getInt("v_no"),
						rs.getInt("noti_no"),
						rs.getInt("resume_no"),
						rs.getDate("v_Date")+" "+rs.getTime("v_Date"),
						rs.getString("status"));
				//v.setP_language(rs.getString("p_language"));
				//v.setSum(rs.getInt("sum"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Volunteer> getMyApplyList(Connection conn, int m_no, PageInfo pi) {
		ArrayList<Volunteer> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyApplyList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Volunteer v=new Volunteer(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4)+" "+rs.getTime(4),
						rs.getString(5));
				v.setM_no(rs.getInt("m_no"));
				v.setTitle(rs.getString("title"));
				v.setEnd_date(rs.getString("end_date"));
				v.setP_language(rs.getString("p_language"));
				v.setNickname(rs.getString("nickname"));
				v.setLogofile(rs.getString("logo_file"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int apply(Connection conn, int noti_no, int resume_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("apply");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			ps.setInt(2, resume_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int applyCancle(Connection conn, int v_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("applyCancle");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, v_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getListCount(Connection conn, int noti_no) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Volunteer getVolunteer(Connection conn, int v_no) {
		Volunteer v=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getVolunteer");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, v_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				v=new Volunteer(
						rs.getInt("v_no"),
						rs.getInt("noti_no"),
						rs.getInt("resume_no"),
						rs.getDate("v_Date")+" "+rs.getTime("v_Date"),
						rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public int readResume(Connection conn, int v_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("readResume");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, v_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getMyApplyListCount(Connection conn, Member mem) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyApplyListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mem.getM_no());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int passResume(Connection conn, int v_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("passResume");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, v_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int failResume(Connection conn, int v_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("failResume");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, v_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int isApply(Connection conn, Member m, Notification noti) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("isApply");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti.getNoti_no());
			ps.setInt(2, m.getM_no());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Volunteer> getListWithoutPage(Connection conn, int noti_no) {
		ArrayList<Volunteer> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getListWithoutPage");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			rs=ps.executeQuery();
			while(rs.next()) {
				Volunteer v=new Volunteer(
						rs.getInt("v_no"),
						rs.getInt("noti_no"),
						rs.getInt("resume_no"),
						rs.getDate("v_Date")+" "+rs.getTime("v_Date"),
						rs.getString("status"));
				v.setP_language(rs.getString("p_language"));
				//v.setSum(rs.getInt("sum"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
