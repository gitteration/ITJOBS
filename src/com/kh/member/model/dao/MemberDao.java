package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Co_Info;
import com.kh.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/com/kh/sql/member-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public Member login(Connection conn,  Member m) {
		Member mem=new Member();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("login");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getEmail());
			ps.setString(2, m.getPw());
			rs=ps.executeQuery();
			if(rs.next()) {
				mem=new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return mem;
	}
	public Member getMemberByEmail(Connection conn, String email) {
		Member mem=new Member();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("selectMemberByEmail");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				mem=new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return mem;
	}
	public int joinMember(Connection conn, Member m) {
		int result=0;
		PreparedStatement ps=null;
		
		System.out.println(m);
		
		try {
			
			if(m.getType().equals("1")) {
				String sql1=prop.getProperty("joinMember");
				ps=conn.prepareStatement(sql1);
				ps.setString(1, m.getType());
				ps.setString(2, m.getEmail());
				ps.setString(3, m.getPw());
				ps.setString(4, m.getNickname());
				result=ps.executeUpdate();
				}else {
				String sql2=prop.getProperty("joinCo");
				sql2=prop.getProperty("joinCo");
				ps=conn.prepareStatement(sql2);
				ps.setString(1, m.getType());
				ps.setString(2, m.getEmail());
				ps.setString(3, m.getPw());
				ps.setString(4, m.getNickname());
				result=ps.executeUpdate();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}		
		return result;
		
	
	}
	
	

	public void emailCheck(String email) {
		
		Member m = new Member();
		
		Connection conn = getConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("checkemail");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
			m=new Member(rs.getInt(1));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}
		
	
		
	}
	
	
	public int JoinCoInfo(Connection conn, String email, Co_Info cf) {
		int result=0;
		
		Member m = new Member();
		
		PreparedStatement ps=null;
				
		ResultSet rs = null;
		 
		String sql = prop.getProperty("joinCompany"); // 기업회원가입1에서 저장된 Member의 m_no을 가져오기 위한 과정
		try {
			
			ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			rs=ps.executeQuery();
//			if(rs.next()) {
//			m=new Member(rs.getInt(1));
//			}
			
//			sql=prop.getProperty("joinCompany");
						
			ps=conn.prepareStatement(sql);
			//ps.setInt(1, m.getM_no());
			ps.setString(1, cf.getRegNum());
			ps.setString(2, cf.getFile());
			ps.setString(3, cf.getPath());
			ps.setString(4, cf.getName());
			ps.setString(5, cf.getPhone());
			ps.setString(6, cf.getAddress());
			ps.setString(7, cf.getCeo());
			ps.setString(8, cf.getCo_phone());
			ps.setString(9, cf.getDescript());
			ps.setString(10, cf.getBirth_date());
			ps.setInt(11, cf.getMemsum());
			ps.setInt(12, cf.getRevenue());
			ps.setString(13, cf.getHistory());
			ps.setString(14, cf.getWelfare());
			ps.setString(15, cf.getLogofile());
			ps.setString(16, cf.getLogopath());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public Co_Info getCoInfo(Connection conn, Member m) {
		Co_Info co=new Co_Info();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("selectCoInfo");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getM_no());
			rs=ps.executeQuery();
			if(rs.next()) {
				co=new Co_Info(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getDate(11)+" "+rs.getTime(11),
						rs.getInt(12),
						rs.getInt(13),
						rs.getString(14),
						rs.getString(15));
				co.setLogofile(rs.getString("logo_file"));
				co.setLogopath(rs.getString("logo_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return co;
	}
	public int update(Connection conn, Member m) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("updateMember");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getNickname());
			ps.setInt(2, m.getM_no());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	public int update(Connection conn, Co_Info co) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("updateCoInfo");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, co.getRegNum());
			ps.setString(2, co.getFile());//나중에 수정
			ps.setString(3, co.getPath());//나중에 수정
			ps.setString(4, co.getName());
			ps.setString(5, co.getPhone());
			ps.setString(6, co.getAddress());
			ps.setString(7, co.getCeo());
			ps.setString(8, co.getCo_phone());
			ps.setString(9, co.getDescript());
			ps.setString(10, co.getBirth_date().split(" ")[0]);
			ps.setInt(11, co.getMemsum());
			ps.setInt(12, co.getRevenue());
			ps.setString(13, co.getHistory());
			ps.setString(14, co.getWelfare());
			ps.setString(15, co.getLogofile());
			ps.setString(16, co.getLogopath());
			ps.setInt(17, co.getM_no());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	public int changePw(Connection conn, Member m, String newPw) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("updatePw");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, newPw);
			ps.setInt(2, m.getM_no());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

	public Member findPwd(Connection conn, String email) {
		
		Member m = new Member();
		
		m = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("findpwd");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next()) {
			m = new Member(rs.getString(1));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return m;
	}
	
	public int randomPwd(Connection conn, String userPwd, String email) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("randomPwd");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPwd);
			ps.setString(2, email);
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
		
	}
	public Member getMemberByM_no(Connection conn, int co_no) {
		Member mem=new Member();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("selectMemberByM_no");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, co_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				mem=new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return mem;
	}
	
	public int CoLikeCheck(Connection conn, int likeCo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("likeCheck");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,memNo);
			ps.setInt(2, likeCo);
		
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
	
	
	
	
	
	
	public int deleteLike(Connection conn, int likeCo, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteLike");
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, memNo);
			ps.setInt(2, likeCo);
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}
	
	public int insertLike(Connection conn, int likeCo, int memNo) {
		
	int result = 0;
	
	PreparedStatement ps = null;
	
	String sql = prop.getProperty("insertLike");
	
	try {
		ps = conn.prepareStatement(sql);
	
		ps.setInt(1, memNo);
		ps.setInt(2, likeCo);
	
		result = ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(ps);
	}
		return result;
	}
	
	public int certifyMem(Connection conn, String email, String cer_no) {
		
		int result =0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("certifyMem");
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,email);
			ps.setString(2, cer_no);
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
		
	}
	
	public int EmailCheck(Connection conn, String email) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("emailOverCheck");
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, email);
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		
		return result;
		
	}
	
	public int NickCheck(Connection conn, String nickName) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("nickOverCheck");
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, nickName);
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
	
		return result;
		
	}
	
	public int leaveMember(Connection conn, int m_no) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("leaveMember");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	public Member GoogleMem(Connection conn, String googleEm) {
		
		Member mem=new Member();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("googleLogin");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, googleEm);
			rs=ps.executeQuery();
			if(rs.next()) {
				mem=new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return mem;
		
		
		
		
	}
	
public Member NaverMem(Connection conn, String naverEm) {
		
		Member mem=new Member();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("naverLogin");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, naverEm);
			rs=ps.executeQuery();
			if(rs.next()) {
				mem=new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6)+" "+rs.getTime(6),
						rs.getDate(7)+" "+rs.getTime(7),
						rs.getString(8),
						rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return mem;
		
		
		
		
	}
	
	
}
