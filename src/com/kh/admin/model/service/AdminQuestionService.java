package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.admin.model.dao.AdminQuestionDao;
import com.kh.question.model.vo.Question;

public class AdminQuestionService {

	public int answerQuestion(Question q) {
		Connection conn=getConnection();
		int result=new AdminQuestionDao().answerQuestion(conn,q);
		close(conn);
		return result;
	}
	

}
