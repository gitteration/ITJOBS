package com.kh.like.model.vo;

public class Like {

	private int like_no;
	private int m_no;
	private int co_no;
	private int noti_co;
	
	//likeCompany
	private String nickname;
	private String address;
	
	
	public Like() {
		super();
	}
	public Like(int like_no, int m_no, int co_no, int noti_co) {
		super();
		this.like_no = like_no;
		this.m_no = m_no;
		this.co_no = co_no;
		this.noti_co = noti_co;
	}
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getCo_no() {
		return co_no;
	}
	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}
	public int getNoti_co() {
		return noti_co;
	}
	public void setNoti_co(int noti_co) {
		this.noti_co = noti_co;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Like [like_no=" + like_no + ", m_no=" + m_no + ", co_no=" + co_no + ", noti_co=" + noti_co + "]";
	}
	
}
