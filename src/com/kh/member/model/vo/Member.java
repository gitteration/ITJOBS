package com.kh.member.model.vo;

public class Member {

	private int m_no;
	private String type;
	private String email;
	private String pw;
	private String nickname;
	private String update_date;
	private String enroll_date;
	private String status;
	private int d_count;
	
	private String address;	//기업주소
	private int NumberOfNotification;
	
	
	public Member() {}
	
	public Member(int m_no) {
		super();
		this.m_no = m_no;
	}
	public Member(String pw) {
		super();
		this.pw = pw;
	}
	public Member(int m_no, String type, String email, String pw, String nickname, String update_date,
			String enroll_date, String status, int d_count) {
		super();
		this.m_no = m_no;
		this.type = type;
		this.email = email;
		this.pw = pw;
		this.nickname = nickname;
		this.update_date = update_date;
		this.enroll_date = enroll_date;
		this.status = status;
		this.d_count = d_count;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfNotification() {
		return NumberOfNotification;
	}

	public void setNumberOfNotification(int numberOfNotification) {
		NumberOfNotification = numberOfNotification;
	}

	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", type=" + type + ", email=" + email + ", pw=" + pw + ", nickname=" + nickname
				+ ", update_date=" + update_date + ", enroll_date=" + enroll_date + ", status=" + status + ", d_count="
				+ d_count + "]";
	}
	
	
	
}
