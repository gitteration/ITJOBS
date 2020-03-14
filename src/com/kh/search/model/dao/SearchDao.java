package com.kh.search.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.PageInfo;
import com.kh.notification.model.vo.Notification;
import com.kh.resume.model.dao.ResumeDao;
import com.kh.resume.model.vo.Resume;

public class SearchDao {

	private Properties prop = new Properties();
	
	public SearchDao() {
		
		String fileName = ResumeDao.class.getResource("/com/kh/sql/search-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Resume> searchResumeList(Connection conn, String sKey, String sText) {
		ArrayList<Resume> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("searchResumeList");
		if(sKey!=null) {
			if(sText.equals("")) {
				sql+=" and "+sKey+" like '%'";

			}else {
				sql+=" and "+sKey+" like '%"+sText+"%'";
			}
		}
		System.out.println(sql);
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Resume(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5)+" "+rs.getTime(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),
						rs.getString(15),
						rs.getString(16),
						rs.getDate(17)+" "+rs.getTime(17),
						rs.getString(18),
						rs.getString(19),
						rs.getString(20),
						rs.getDate(21)+" "+rs.getTime(21),
						rs.getString(22),
						rs.getString(23),
						rs.getInt(24)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public ArrayList<Resume> getSuperSearchResume(Connection conn, String sText) {
		ArrayList<Resume> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getSuperSearchResume");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, sText.replace(" ", "|"));
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Resume(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5)+" "+rs.getTime(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),
						rs.getString(15),
						rs.getString(16),
						rs.getDate(17)+" "+rs.getTime(17),
						rs.getString(18),
						rs.getString(19),
						rs.getString(20),
						rs.getDate(21)+" "+rs.getTime(21),
						rs.getString(22),
						rs.getString(23),
						rs.getInt(24)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Notification> getSuperSearchNotification(Connection conn, String sText, PageInfo pi) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getSuperSearchNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, sText.replace(" ", "|"));
			ps.setInt(2, pi.getStartRow());
			ps.setInt(3, pi.getEndRow());
			rs=ps.executeQuery();
			while(rs.next()) {
				Notification n=new Notification(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getDate(4)+" "+rs.getTime(4),
						rs.getDate(5)+" "+rs.getTime(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12));
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
}
