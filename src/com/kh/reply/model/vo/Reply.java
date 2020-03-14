package com.kh.reply.model.vo;

public class Reply {

	private int re_no;
	private int m_no;
	private int b_no;
	private String nickname;
	private String enroll_date;
	private String update_date;
	private String contents;
	private String status;
	private int d_count;
	public Reply() {
		super();
	}
	
	public Reply(int re_no, int m_no, int b_no, String enroll_date, String update_date, String contents, String status,
			int d_count) {
		super();
		this.re_no = re_no;
		this.m_no = m_no;
		this.b_no = b_no;
		this.enroll_date = enroll_date;
		this.update_date = update_date;
		this.contents = contents;
		this.status = status;
		this.d_count = d_count;
	}
	
	public Reply(int re_no, int m_no, int b_no, String nickname, String enroll_date, String update_date, String contents, String status,
			int d_count) {
		super();
		this.re_no = re_no;
		this.m_no = m_no;
		this.b_no = b_no;
		this.nickname = nickname;
		this.enroll_date = enroll_date;
		this.update_date = update_date;
		this.contents = contents;
		this.status = status;
		this.d_count = d_count;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getD_count() {
		return d_count;
	}
	public void setD_count(int d_count) {
		this.d_count = d_count;
	}
	@Override
	public String toString() {
		return "Reply [re_no=" + re_no + ", m_no=" + m_no + ", b_no=" + b_no + ", nickname=" + nickname
				+ ", enroll_date=" + enroll_date + ", update_date=" + update_date + ", contents=" + contents
				+ ", status=" + status + ", d_count=" + d_count + "]";
	}
	
}
