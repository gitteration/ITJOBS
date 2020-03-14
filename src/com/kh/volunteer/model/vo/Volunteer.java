package com.kh.volunteer.model.vo;

public class Volunteer {

	private int v_no;
	private int noti_no;
	private int resume_no;
	private String v_date;
	private String status;
	
	//Resume
	private int m_no;
	
	//Notification
	private String title;
	private String end_date;
	private String p_language;
	
	//Member
	private String nickname;	//기업명
	
	//CoInfo
	private String logofile;
	
	private int sum;//총지원자수
	
	public Volunteer() {
		super();
	}
	public Volunteer(int v_no, int noti_no, int resume_no, String v_date, String status) {
		super();
		this.v_no = v_no;
		this.noti_no = noti_no;
		this.resume_no = resume_no;
		this.v_date = v_date;
		this.status = status;
	}
	public int getV_no() {
		return v_no;
	}
	public void setV_no(int v_no) {
		this.v_no = v_no;
	}
	public int getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
	public int getResume_no() {
		return resume_no;
	}
	public void setResume_no(int resume_no) {
		this.resume_no = resume_no;
	}
	public String getV_date() {
		return v_date;
	}
	public void setV_date(String v_date) {
		this.v_date = v_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getP_language() {
		return p_language;
	}
	public void setP_language(String p_language) {
		this.p_language = p_language;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getLogofile() {
		return logofile;
	}
	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}
	@Override
	public String toString() {
		return "Volunteer [v_no=" + v_no + ", noti_no=" + noti_no + ", resume_no=" + resume_no + ", v_date=" + v_date
				+ ", status=" + status + "]";
	}
	
	
}
