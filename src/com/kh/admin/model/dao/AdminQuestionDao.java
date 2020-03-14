package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.question.model.vo.Question;

public class AdminQuestionDao {

	private Properties prop = new Properties();
	
	public AdminQuestionDao() {
		
		String fileName = AdminQuestionDao.class.getResource("/com/kh/sql/admin-query.properties").getPath();
		fileName=fileName.replace("WEB-INF/classes/", "");
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int answerQuestion(Connection conn, Question q) {
		int result=0;
		PreparedStatement ps=null;
		
		String sql=prop.getProperty("answerQuestion");
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, q.getAnswer());
			ps.setInt(2, q.getQ_no());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
}
