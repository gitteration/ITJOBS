package com.kh.question.model.vo;

public class Question {

	private int q_no;
	private int m_no;
	private String title;
	private String contents;
	private String answer;
	private String enroll_date;
	private String end_date;
	private String status;
	private String nickname;
	
	
	public Question() {
		super();
	}
	public Question(int q_no, int m_no,String title, String contents, String answer, String enroll_date, String end_date,
			String status) {
		super();
		this.q_no = q_no;
		this.m_no = m_no;
		this.title=title;
		this.contents = contents;
		this.answer = answer;
		this.enroll_date = enroll_date;
		this.end_date = end_date;
		this.status = status;
		
	}
	public Question(int q_no, int m_no,String title, String contents, String answer, String enroll_date, String end_date,
			String status,String nickname) {
		super();
		this.q_no = q_no;
		this.m_no = m_no;
		this.title=title;
		this.contents = contents;
		this.answer = answer;
		this.enroll_date = enroll_date;
		this.end_date = end_date;
		this.status = status;
		this.nickname=nickname;
		
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	@Override
	public String toString() {
		return "Question [q_no=" + q_no + ", m_no=" + m_no + ", contents=" + contents + ", answer=" + answer
				+ ", enroll_date=" + enroll_date + ", end_date=" + end_date + ", status=" + status + ", title=" + title
				+ "]";
	}
	
	
}
