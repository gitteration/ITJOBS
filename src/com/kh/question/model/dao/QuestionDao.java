package com.kh.question.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.question.model.vo.Question;

public class QuestionDao {

	private Properties prop = new Properties();
	
	public QuestionDao() {
		
		String fileName = QuestionDao.class.getResource("/com/kh/sql/question-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Question> getQuestionList(Connection conn) {
		ArrayList<Question> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getQuestionList");
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Question(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getDate(6)+" "+rs.getTime(6),
					rs.getDate(7)+" "+rs.getTime(7),
					rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return list;
	}

	public Question getQuestion(Connection conn, int q_no) {
		Question q=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getQuestion");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, q_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				q=new Question(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getDate(6)+" "+rs.getTime(6),
					rs.getDate(7)+" "+rs.getTime(7),
					rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return q;
	}

	public int insertQuestion(Connection conn, Question q) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("insertQuestion");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, q.getM_no());
			ps.setString(2, q.getTitle());
			ps.setString(3, q.getContents());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	public ArrayList<Question> getMyQuestionList(Connection conn, int m_no) {
		ArrayList<Question> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=prop.getProperty("getMyQuestionList");
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Question(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getDate(6)+" "+rs.getTime(6),
					rs.getDate(7)+" "+rs.getTime(7),
					rs.getString(8),
					rs.getString(9)));
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
