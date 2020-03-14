package com.kh.resume.model.dao;

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
import com.kh.member.model.vo.Member;
import com.kh.resume.model.vo.Resume;

 
public class ResumeDao {

	private Properties prop = new Properties();
	
	public ResumeDao() {
		
		String fileName = ResumeDao.class.getResource("/com/kh/sql/resume-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Resume> getOpenResumeList(Connection conn, PageInfo pi) {
		ArrayList<Resume> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getOpenResumeList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pi.getStartRow());
			ps.setInt(2, pi.getEndRow());
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
						rs.getString(17),
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

	/**
	 * 1. 이력서 추가 
	 * @param conn
	 * @param re
	 * @return
	 */
	public int insertResum(Connection conn,Resume re){
		   
		   int result = 0;
		   PreparedStatement pstmt = null;
		   
		   String sql = prop.getProperty("insertResum");
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re.getPhoto());
			pstmt.setString(2, re.getPath());
			pstmt.setString(3, re.getName());
			pstmt.setString(4, re.getBirth_date());
			
			pstmt.setString(5, re.getPhone());
			pstmt.setString(6, re.getAddress());
			pstmt.setString(7, re.getEmail());
			
			pstmt.setString(8, re.getSchool());
			pstmt.setString(9, re.getDepartment());
			pstmt.setString(10,re.getSchool_period());
			
			pstmt.setString(11, re.getCareer());
			pstmt.setString(12, re.getWork_place());
			pstmt.setString(13, re.getWork_date());
			pstmt.setString(14, re.getWork());
			
			pstmt.setString(15, re.getCertification());
			pstmt.setString(16, re.getCer_date());
			
			pstmt.setString(17, re.getTitle());
			pstmt.setString(18, re.getCover_letter());
			pstmt.setString(19, re.getOpen());
			pstmt.setString(20, re.getP_language());
			pstmt.setString(21, re.getHope_salary());
			pstmt.setInt(22, re.getM_no());
			pstmt.setString(23, re.getCareer_year());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		   return result;
	   }
	   
	/**
	 * 2. 이력서 상세보기 
	 * @param conn
	 * @param mno
	 * @return
	 */
	public Resume selectResumDetail(Connection conn,int resume_no){
	 
			Resume re = null;
			PreparedStatement pstmt =null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectResumDetail");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resume_no);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					re = new Resume(rset.getInt("RESUME_NO"),
							   rset.getString("PHOTO"),
							   rset.getString("PATH"),
							   rset.getString("NAME"),
							   rset.getDate("BIRTH_DATE")+"",
							   rset.getString("PHONE"),
							   rset.getString("ADDRESS"),
							   rset.getString("EMAIL"),
							   rset.getString("SCHOOL"),
							   rset.getString("DEPARTMENT"),
							   rset.getString("SCHOOL_PERIOD"),
							   rset.getString("CAREER"),
							   rset.getString("WORK_PLACE"),
							   rset.getString("WORK_DATE"),
							   rset.getString("WORK"),
							   rset.getString("CERTIFICATE"),
							   rset.getString("CER_DATE"),
							   rset.getString("TITLE"),
							   rset.getString("COVER_LETTER"),
							   rset.getString("open"),
							   rset.getString("UPDATE_DATE"),
							   rset.getString("P_LANGUAGE"),
							   rset.getString("HOPE_SALARY"),
							   rset.getInt("M_NO"),
							   rset.getString("CAREER_YEAR"),
							   rset.getString("SCHOOL_FINAL")
							   );
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return re;
	 }
	
		/**
		 * 3. 이력서 리스트용 갯수 
		 * @param conn
		 * @param mno
		 * @return
		 */
		public int getListCount(Connection conn,int mno) {
			int listCount = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("getListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mno);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		
		}
		
		/**
		 * 4. 이력서 리스트 
		 * @param conn
		 * @param pi
		 * @param mno
		 * @return
		 */
		public ArrayList<Resume> selectResume(Connection conn,PageInfo pi,int mno) {

		ArrayList<Resume> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);*/
			
			pstmt.setInt(1,mno);
			pstmt.setInt(2, pi.getStartRow());
			pstmt.setInt(3, pi.getEndRow());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Resume(rset.getInt("RESUME_NO"),
								   rset.getString("PHOTO"),
								   rset.getString("PATH"),
								   rset.getString("NAME"),
								   rset.getString("BIRTH_DATE"),
								   rset.getString("PHONE"),
								   rset.getString("ADDRESS"),
								   rset.getString("EMAIL"),
								   rset.getString("SCHOOL"),
								   rset.getString("DEPARTMENT"),
								   rset.getString("SCHOOL_PERIOD"),
								   rset.getString("CAREER"),
								   rset.getString("WORK_PLACE"),
								   rset.getString("WORK_DATE"),
								   rset.getString("WORK"),
								   rset.getString("CERTIFICATE"),
								   rset.getString("CER_DATE"),
								   rset.getString("TITLE"),
								   rset.getString("COVER_LETTER"),
								   rset.getString("open"),//open으로 바꾸기로 했구
								   rset.getString("UPDATE_DATE"),
								   rset.getString("P_LANGUAGE"),
								   rset.getString("HOPE_SALARY"),
								   rset.getInt("M_NO"),
								   rset.getString("CAREER_YEAR"),
								   rset.getString("SCHOOL_FINAL")
								   
								   ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		} 
		return list;
	}	
		
	/**
	 * 5. 이력서 수정용
	 * @param conn
	 * @param resume_no
	 * @return
	 */
	public Resume selectUpdateResum(Connection conn,int resume_no){
		
		Resume re = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectupdateForm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resume_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				re = new Resume(rset.getInt("RESUME_NO"),
						   rset.getString("PHOTO"),
						   rset.getString("PATH"),
						   rset.getString("NAME"),
						   rset.getDate("BIRTH_DATE")+"",
						   rset.getString("PHONE"),
						   rset.getString("ADDRESS"),
						   rset.getString("EMAIL"),
						   rset.getString("SCHOOL"),
						   rset.getString("DEPARTMENT"),
						   rset.getString("SCHOOL_PERIOD"),
						   rset.getString("CAREER"),
						   rset.getString("WORK_PLACE"),
						   rset.getString("WORK_DATE"),
						   rset.getString("WORK"),
						   rset.getString("CERTIFICATE"),
						   rset.getString("CER_DATE"),
						   rset.getString("TITLE"),
						   rset.getString("COVER_LETTER"),
						   rset.getString("open"),
						   rset.getString("UPDATE_DATE"),
						   rset.getString("P_LANGUAGE"),
						   rset.getString("HOPE_SALARY"),
						   rset.getInt("M_NO"),
						   rset.getString("CAREER_YEAR"),
						   rset.getString("SCHOOL_FINAL")
						   );
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
		
	}
	
	public int deleteResume(Connection conn, int resume_no){
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteResum1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resume_no);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}   
	
	
	
	
	


	public ArrayList<Resume> getMyResumeList(Connection conn, Member m) {
		
		ArrayList<Resume> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,m.getM_no());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Resume(rset.getInt("RESUME_NO"),
								   rset.getString("PHOTO"),
								   rset.getString("PATH"),
								   rset.getString("NAME"),
								   rset.getString("BIRTH_DATE"),
								   rset.getString("PHONE"),
								   rset.getString("ADDRESS"),
								   rset.getString("EMAIL"),
								   rset.getString("SCHOOL"),
								   rset.getString("DEPARTMENT"),
								   rset.getString("SCHOOL_PERIOD"),
								   rset.getString("CAREER"),
								   rset.getString("WORK_PLACE"),
								   rset.getString("WORK_DATE"),
								   rset.getString("WORK"),
								   rset.getString("CERTIFICATE"),
								   rset.getString("CER_DATE"),
								   rset.getString("TITLE"),
								   rset.getString("COVER_LETTER"),
								   rset.getString("open"),
								   rset.getString("UPDATE_DATE"),
								   rset.getString("P_LANGUAGE"),
								   rset.getString("HOPE_SALARY"),
								   rset.getInt("M_NO"),
								   rset.getString("CAREER_YEAR"),
								   rset.getString("SCHOOL_FINAL")
								   
								   ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		} 
		return list;
	}
	
	public int updateResume(Connection conn, Resume re){
		 int result = 0;
		 PreparedStatement pstmt = null;
		 
		 String sql = prop.getProperty("updateResum");
		   try {
			pstmt = conn.prepareStatement(sql);
			//PHOTO=?,PATH=?,NAME=?,BIRTH_DATE=to_date(?,'yyyy-mm-dd'),
			//PHONE=?,ADDRESS=?,EMAIL=?,
			//SCHOOL=?,DEPARTMENT=?,SCHOOL_PERIOD=?,CAREER=?,WORK_PLACE=?,
			//WORK_DATE=?,WORK=?,CERTIFICATE=?,CER_DATE=?,TITLE=?,
			//COVER_LETTER=?,OPEN=?,UPDATE_DATE=SYSDATE,P_LANGUAGE=?,
			//HOPE_SALARY=? WHERE RESUME_NO=?
			pstmt.setString(1, re.getPhoto());
			pstmt.setString(2, re.getPath());
			pstmt.setString(3, re.getName());
			pstmt.setString(4, re.getBirth_date());
			
			pstmt.setString(5, re.getPhone());
			pstmt.setString(6, re.getAddress());
			pstmt.setString(7, re.getEmail());
			
			pstmt.setString(8, re.getSchool());
			pstmt.setString(9, re.getDepartment());
			pstmt.setString(10,re.getSchool_period());
			
			pstmt.setString(11, re.getCareer());
			pstmt.setString(12, re.getWork_place());
			pstmt.setString(13, re.getWork_date());
			pstmt.setString(14, re.getWork());
			
			pstmt.setString(15, re.getCertification());
			pstmt.setString(16, re.getCer_date());
			
			pstmt.setString(17, re.getTitle());
			pstmt.setString(18, re.getCover_letter());
			pstmt.setString(19, re.getOpen());
			pstmt.setString(20, re.getP_language());
			pstmt.setString(21, re.getHope_salary());
			pstmt.setString(22, re.getCareer_year());
			pstmt.setInt(23, re.getResume_no());
			result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close(pstmt);
			}
			   return result;
		   }
	
	public int supportResume(Connection conn, int resume_no){
		
		 ResultSet rset = null;
		 int su_result = 0;
		 PreparedStatement pstmt = null;
		 
		 String sql = prop.getProperty("supportResum");
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resume_no);
			rset = pstmt.executeQuery();
			while(rset.next()){
				su_result = rset.getInt(1);
			}
			
			
		   } catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				close(pstmt);
			}
			   return su_result;
		   }
	
	public int ResLikeCheck(Connection conn, int likeRes, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("likeCheck");
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, likeRes);
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
	
	public int deleteLike(Connection conn, int likeRes, int memNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteLike");
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, likeRes);
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
	
	public int insertLike(Connection conn, int likeRes, int memNo) {
		
	int result = 0;
	
	PreparedStatement ps = null;
	
	String sql = prop.getProperty("insertLike");
	
	try {
		ps = conn.prepareStatement(sql);
	
		ps.setInt(1, likeRes);
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

	public int getOpenResumeListCount(Connection conn) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("getOpenResumeListCount");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public ArrayList<Resume> getMyResumeListforApply(Connection conn, Member m) {
		ArrayList<Resume> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getMyResumeListforApply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,m.getM_no());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Resume(rset.getInt("RESUME_NO"),
								   rset.getString("PHOTO"),
								   rset.getString("PATH"),
								   rset.getString("NAME"),
								   rset.getString("BIRTH_DATE"),
								   rset.getString("PHONE"),
								   rset.getString("ADDRESS"),
								   rset.getString("EMAIL"),
								   rset.getString("SCHOOL"),
								   rset.getString("DEPARTMENT"),
								   rset.getString("SCHOOL_PERIOD"),
								   rset.getString("CAREER"),
								   rset.getString("WORK_PLACE"),
								   rset.getString("WORK_DATE"),
								   rset.getString("WORK"),
								   rset.getString("CERTIFICATE"),
								   rset.getString("CER_DATE"),
								   rset.getString("TITLE"),
								   rset.getString("COVER_LETTER"),
								   rset.getString("open"),
								   rset.getString("UPDATE_DATE"),
								   rset.getString("P_LANGUAGE"),
								   rset.getString("HOPE_SALARY"),
								   rset.getInt("M_NO"),
								   rset.getString("CAREER_YEAR"),
								   rset.getString("SCHOOL_FINAL")
								   ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		} 
		return list;
	}
	
	
	
}