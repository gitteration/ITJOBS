package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;
import com.kh.reply.model.vo.Reply;

import oracle.jdbc.proxy.annotation.Pre;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		
		String fileName = BoardDao.class.getResource("/com/kh/sql/board-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getMainListCount(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getMainListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int getEtcListCount(Connection conn, String head) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getEtcListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, head);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Board> selectMainList(Connection conn, PageInfo pi){
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMainList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pi.getStartRow());
			pstmt.setInt(2, pi.getEndRow());
			
			rset = pstmt.executeQuery(); 
			
			while(rset.next()) {
				Board b = new Board(rset.getInt("b_no"),
						rset.getInt("m_no"),
						rset.getString("nickname"), 
						rset.getString("head"),
						rset.getString("title"),
						rset.getString("contents"),
						rset.getString("update_date"),
						rset.getString("editfile"),
						rset.getString("time"),
						rset.getInt("count"),
						rset.getString("video"));
						b.setDown_count(rset.getInt("down_count"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Board> selectEtcList(Connection conn, String head, PageInfo pi){
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEtcList");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, head);
			pstmt.setInt(2, pi.getStartRow());
			pstmt.setInt(3, pi.getEndRow());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board(rset.getInt("b_no"),
						rset.getInt("m_no"),
						rset.getString("nickname"), 
						rset.getString("head"),
						rset.getString("title"),
						rset.getString("contents"),
						rset.getString("update_date"),
						rset.getString("editfile"),
						rset.getString("time"),
						rset.getInt("count"),
						rset.getString("video"));
						b.setDown_count(rset.getInt("down_count"));
				list.add(b);
				
								
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	public int countBoard(Connection conn, int bId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("countBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;		
	}
	
	
	public Board selectBoard(Connection conn, int bId) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			pstmt.setInt(2, bId);
			rset = pstmt.executeQuery();
		
			if(rset.next()) {
				b = new Board(rset.getInt("b_no"),
								rset.getInt("m_no"),
								rset.getString("nickname"),
								rset.getString("head"),
								rset.getString("title"),
								rset.getString("contents"),
								rset.getString("update_date"),
								rset.getString("file_oriname"),
								rset.getString("time"),
								rset.getInt("count"),
								rset.getString("editfile"),
								rset.getString("path"),
								rset.getInt("down_count"),
								rset.getInt("reply_count"),
								rset.getString("video"));	
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public int deleteBoard(Connection conn, int bId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Board prevEtcBoard(Connection conn, int bId, String head) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("prevEtcBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, head);
			pstmt.setInt(2, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setTitle(rset.getString("title"));
				b.setB_no(rset.getInt("b_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}


	public Board nextEtcBoard(Connection conn, int bId, String head) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nextEtcBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, head);
			pstmt.setInt(2, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setTitle(rset.getString("title"));
				b.setB_no(rset.getInt("b_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public Board prevMainBoard(Connection conn, int bId) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("prevMainBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setTitle(rset.getString("title"));
				b.setB_no(rset.getInt("b_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	
	public Board nextMainBoard(Connection conn, int bId) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nextMainBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setTitle(rset.getString("title"));
				b.setB_no(rset.getInt("b_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}
	
	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,b.getM_no());
			pstmt.setString(2, b.getHead());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContents());
			pstmt.setString(5, b.getFile());
			pstmt.setString(6, b.getTime());
			pstmt.setString(7, b.getEditFile());
			pstmt.setString(8, b.getPath());
			pstmt.setString(9, b.getVideo());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public Board selectUpdateBoard(Connection conn, int bId) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUpdateBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("b_no"),
								rset.getInt("m_no"),
								rset.getString("nickname"),
								rset.getString("head"),
								rset.getString("title"),
								rset.getString("contents"),
								rset.getString("update_date"),
								rset.getString("file_oriname"),
								rset.getString("time"),
								rset.getInt("count"),
								rset.getString("editfile"),
								rset.getString("path"),
								rset.getInt("down_count"));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getHead());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContents());
			pstmt.setString(4, b.getFile());
			pstmt.setString(5, b.getTime());
			pstmt.setString(6, b.getEditFile());
			pstmt.setString(7, b.getPath());
			pstmt.setInt(8, b.getB_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public String[] selectHead(Connection conn, int b_no) {
		String[] head = new String[2];
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectHead");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				head[0] = String.valueOf(rset.getString("head"));
				head[1] = String.valueOf(rset.getInt("m_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return head;
	}
	
	
	public int insertDeclareBoard(Connection conn, int bId, int m_no, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertDeclare");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);
			pstmt.setInt(2, m_no);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public int downCountUpBoard(Connection conn, int bId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("downCountUpBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
		
	public Board selectDownCountBoard(Connection conn, int bId) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDownCountBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("b_no"),
								rset.getInt("m_no"),
								rset.getString("nickname"),
								rset.getString("head"),
								rset.getString("title"),
								rset.getString("contents"),
								rset.getString("update_date"),
								rset.getString("file_oriname"),
								rset.getString("time"),
								rset.getInt("count"),
								rset.getString("editfile"),
								rset.getString("path"),
								rset.getInt("down_count"));	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public ArrayList<Reply> selectRlist(Connection conn, int bId){
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRlist");
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("re_no"),
									rset.getInt("m_no"),
									rset.getInt("b_no"),
									rset.getString("nickname"),
									rset.getString("enroll_date"),
									rset.getString("update_date"),
									rset.getString("contents"),
									rset.getString("status"),
									rset.getInt("d_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertReplyBoard(Connection conn, int bId, int m_no, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReplyBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m_no);
			pstmt.setInt(2, bId);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteReply(Connection conn, int re_no){
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, re_no);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Board> esearchBoard(Connection conn, String head, String select, String search, PageInfo pi){
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(select.equals("title")) {
			sql=prop.getProperty("esearchTitle");
		}else if(select.equals("contents")) {
			sql=prop.getProperty("esearchContents");
		}else if(select.equals("nickname")) {
			sql=prop.getProperty("esearchNickname");
		}
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			String search1 = "%"+search+"%";
			pstmt.setString(1, search1);
			pstmt.setString(2, head);
			pstmt.setInt(3, pi.getStartRow());
			pstmt.setInt(4, pi.getEndRow());
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("b_no"),
									rset.getInt("m_no"),
									rset.getString("nickname"),
									rset.getString("head"), 
									rset.getString("title"),
									rset.getString("contents"),
									rset.getString("update_date"),
									rset.getString("time"),
									rset.getInt("count"),
									rset.getString("editfile"),
									rset.getString("path"),
									rset.getInt("down_count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public ArrayList<Board> msearchBoard(Connection conn, String select, String search, PageInfo pi){
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(select.equals("title")) {
			sql=prop.getProperty("msearchTitle");
		}else if(select.equals("contents")) {
			sql=prop.getProperty("msearchContents");
		}else if(select.equals("nickname")) {
			sql=prop.getProperty("msearchNickname");
		}
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			String search1 = "%"+search+"%";
			pstmt.setString(1, search1);
			pstmt.setInt(2, pi.getStartRow());
			pstmt.setInt(3, pi.getEndRow());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("b_no"),
									rset.getInt("m_no"),
									rset.getString("nickname"),
									rset.getString("head"), 
									rset.getString("title"),
									rset.getString("contents"),
									rset.getString("update_date"),
									rset.getString("time"),
									rset.getInt("count"),
									rset.getString("editfile"),
									rset.getString("path"),
									rset.getInt("down_count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public int getMainSearchListCount(Connection conn, String search, String select) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		
		if(select.equals("title")) {
			sql = prop.getProperty("msearchTitleCount");
		}else if(select.equals("contents")) {
			sql = prop.getProperty("msearchContentsCount");
		}else if(select.equals("nickname")) {
			sql = prop.getProperty("msearchNicknameCount");
		}
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			String search1 = "%"+search+"%";
			
			pstmt.setString(1, search1);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	public int getEtcSearchListCount(Connection conn, String head, String search, String select) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		
		if(select.equals("title")) {
			sql = prop.getProperty("eserarchTitleCount");
		}else if(select.equals("contents")) {
			sql = prop.getProperty("eserarchContentsCount");
		}else if(select.equals("nickname")) {
			sql = prop.getProperty("eserarchNicknameCount");
		}
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			String search1 = "%"+search+"%";
			
			pstmt.setString(1, search1);
			pstmt.setString(2, head);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
}
