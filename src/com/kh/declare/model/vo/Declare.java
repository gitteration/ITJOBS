package com.kh.declare.model.vo;

public class Declare {

	private int de_no;
	private int noti_no;
	private int b_no;
	private int re_no;
	private int m_no;
	private String contents;
	private String enroll_date;
	private String comp_date;
	private String status;
	public Declare() {
		super();
	}
	public Declare(int de_no, int noti_no, int b_no, int re_no, int m_no, String contents, String enroll_date,
			String comp_date, String status) {
		super();
		this.de_no = de_no;
		this.noti_no = noti_no;
		this.b_no = b_no;
		this.re_no = re_no;
		this.m_no = m_no;
		this.contents = contents;
		this.enroll_date = enroll_date;
		this.comp_date = comp_date;
		this.status = status;
	}
	public int getDe_no() {
		return de_no;
	}
	public void setDe_no(int de_no) {
		this.de_no = de_no;
	}
	public int getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getComp_date() {
		return comp_date;
	}
	public void setComp_date(String comp_date) {
		this.comp_date = comp_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Like [de_no=" + de_no + ", noti_no=" + noti_no + ", b_no=" + b_no + ", re_no=" + re_no + ", m_no="
				+ m_no + ", contents=" + contents + ", enroll_date=" + enroll_date + ", comp_date=" + comp_date
				+ ", status=" + status + "]";
	}
	
}
