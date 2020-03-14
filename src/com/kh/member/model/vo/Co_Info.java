package com.kh.member.model.vo;

public class Co_Info {

	private int m_no;
	private String regnum;
	private String file;
	private String path;
	private String name;	//담당자이름
	private String phone;	//담당자번호
	private String address;
	private String ceo;
	private String co_phone;
	private String descript;
	private String birth_date;
	private int memsum;
	private int revenue;
	private String history;
	private String welfare;
	private String logofile;
	private String logopath;
	public Co_Info() {
		super();
	}
	public Co_Info(int m_no, String regnum, String file, String path, String name, String phone, String address,
			String ceo, String co_phone, String descript, String birth_date, int memsum, int revenue, String history,
			String welfare) {
		super();
		this.m_no = m_no;
		this.regnum = regnum;
		this.file = file;
		this.path = path;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ceo = ceo;
		this.co_phone = co_phone;
		this.descript = descript;
		this.birth_date = birth_date;
		this.memsum = memsum;
		this.revenue = revenue;
		this.history = history;
		this.welfare = welfare;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getCo_phone() {
		return co_phone;
	}
	public void setCo_phone(String co_phone) {
		this.co_phone = co_phone;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public int getMemsum() {
		return memsum;
	}
	public void setMemsum(int memsum) {
		this.memsum = memsum;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public String getRegNum() {
		return regnum;
	}
	public void setRegNum(String regnum) {
		this.regnum = regnum;
	}
	public String getLogofile() {
		return logofile;
	}
	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}
	public String getLogopath() {
		return logopath;
	}
	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}
	@Override
	public String toString() {
		return "Co_Info [m_no=" + m_no + ", regnum=" + regnum + ", file=" + file + ", path=" + path + ", name=" + name
				+ ", phone=" + phone + ", address=" + address + ", ceo=" + ceo + ", co_phone=" + co_phone
				+ ", descript=" + descript + ", birth_date=" + birth_date + ", memsum=" + memsum + ", revenue="
				+ revenue + ", history=" + history + ", welfare=" + welfare + ", logofile=" + logofile + ", logopath="
				+ logopath + "]";
	}
	
}
