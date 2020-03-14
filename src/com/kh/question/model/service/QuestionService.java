package com.kh.question.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.question.model.dao.QuestionDao;
import com.kh.question.model.vo.Question;

public class QuestionService {

	public ArrayList<Question> getQuestionList() {
		Connection conn=getConnection();
		ArrayList<Question> list=new QuestionDao().getQuestionList(conn);
		close(conn);
		return list;
	}

	public int insertQuestion(Question q) {
		Connection conn=getConnection();
		int result=new QuestionDao().insertQuestion(conn,q);
		close(conn);
		return result;
	}
	
	public Question getQuestion(int q_no) {
		Connection conn=getConnection();
		Question q=new QuestionDao().getQuestion(conn,q_no);
		close(conn);
		return q;
	}
	
	public ArrayList<Question> getMyQuestionList(int m_no){
		Connection conn=getConnection();
		ArrayList<Question> list=new QuestionDao().getMyQuestionList(conn,m_no);
		close(conn);
		return list;
	}
	
}
