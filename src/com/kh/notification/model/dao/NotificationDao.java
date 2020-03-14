package com.kh.notification.model.dao;

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
import com.kh.like.model.vo.Like;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.vo.Notification;

public class NotificationDao {

	private Properties prop = new Properties();
	
	public NotificationDao() {
		
		String fileName = MemberDao.class.getResource("/com/kh/sql/notification-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Notification> getAllNotificationList(Connection conn, PageInfo pi) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAllNotificationList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pi.getStartRow());
			ps.setInt(2, pi.getEndRow());
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
	
	public ArrayList<Notification> getAdminAllNotificationList(Connection conn, PageInfo pi) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getAdminAllNotificationList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pi.getStartRow());
			ps.setInt(2, pi.getEndRow());
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

	public int delete(Connection conn, int noti_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("delete");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int deleteCancle(Connection conn, int noti_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("deleteCancle");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public ArrayList<Notification> getOpenNotificationList(Connection conn) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getOpenNotificationList");
		try {
			ps=conn.prepareStatement(sql);
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

	public ArrayList<Notification> getMyNotificationList(Connection conn, Member mem, PageInfo pi) {
		ArrayList<Notification> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyNotificationList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mem.getM_no());
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
				n.setOpen(rs.getString("open"));
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

	public Notification getNotification(Connection conn, int noti_no) {
		Notification noti=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				noti=new Notification(
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
				noti.setOpen(rs.getString("open"));
				noti.setNickname(rs.getString("nickname"));
				noti.setAddress(rs.getString("address"));
				noti.setLogoFile(rs.getString("logo_file"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return noti;
	}

	public int insertNotification(Connection conn, Notification n) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("insertNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, n.getCo_no());
			ps.setString(2, n.getTitle());
			ps.setString(3, n.getEnd_date());
			ps.setString(4, n.getP_language());
			ps.setInt(5, n.getSalary());
			ps.setString(6, n.getContents());
			ps.setString(7, n.getJobs());
			ps.setString(8, n.getHope());
			ps.setString(9, n.getOpen());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Notification getLastestNotification(Connection conn) {
		Notification noti=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getLastestNotification");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				noti=new Notification(
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return noti;
	}

	public int updateNotification(Connection conn, Notification n) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("updateNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getEnd_date());
			ps.setString(3, n.getP_language());
			ps.setInt(4, n.getSalary());
			ps.setString(5, n.getContents());
			ps.setString(6, n.getJobs());
			ps.setString(7, n.getHope());
			ps.setString(8, n.getOpen());
			ps.setInt(9, n.getNoti_no());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int openNotification(Connection conn, int noti_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("openNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public int openCancleNotification(Connection conn, int noti_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("openCancleNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noti_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	public int notiLikeCheck(Connection conn, int likeNo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("likeCheck");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,likeNo);
			ps.setInt(2, memNo);
		
			rs=ps.executeQuery();
			
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
		
		//System.out.println(result);
		
		return result;
		
		
	}
	
	public int deleteLike(Connection conn, int likeNo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteLike");
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, likeNo);
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
	
	public int insertLike(Connection conn, int likeNo, int memNo) {
		
	int result = 0;
	
	PreparedStatement ps = null;
	
	String sql = prop.getProperty("insertLike");
	
	try {
		ps = conn.prepareStatement(sql);
	
		ps.setInt(1, likeNo);
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

	public int getSuperSearchNotificationListCount(Connection conn, String sText) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getSuperSearchNotification");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, sText);
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

	public int getMyNotificationListCount(Connection conn, Member mem) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyNotificationListCount");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mem.getM_no());
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
