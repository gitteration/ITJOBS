package com.kh.resume.model.vo;

public class Resume {

	private int resume_no;
	private String photo;
	private String path;
	private String name;
	private String birth_date;
	private String phone;
	private String address;
	private String email;
	private String school;
	private String department;
	private String school_period;
	private String career;
	private String work_place;
	private String work_date;
	private String work;
	private String certification;
	private String cer_date;
	private String title;
	private String cover_letter;
	private String open; //public이 예약어라 못씀
	private String update_date;
	private String p_language;
	private String hope_salary;
	private int m_no;
	private String career_year;
	private String school_final;
	
	public Resume() {
		super();
	}
	public Resume(String name, String birth_date, String phone, String address, String email, String school,
			String department, String school_period, String career, String work_place, String work_date, String work,
			String certification, String cer_date, String title, String cover_letter, String open, String p_language,
			String hope_salary) {
		super();
		this.name = name;
		this.birth_date = birth_date;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.school = school;
		this.department = department;
		this.school_period = school_period;
		this.career = career;
		this.work_place = work_place;
		this.work_date = work_date;
		this.work = work;
		this.certification = certification;
		this.cer_date = cer_date;
		this.title = title;
		this.cover_letter = cover_letter;
		this.open = open;
		this.p_language = p_language;
		this.hope_salary = hope_salary;
	}

	public Resume(int resume_no, String photo, String path, String name, String birth_date, String phone, String address,
			String email, String school, String department, String school_period, String career, String work_place,
			String work_date, String work, String certification, String cer_date, String title, String cover_letter,
			String open, String update_date, String p_language, String hope_salary, int m_no) {
		super();
		this.resume_no = resume_no;
		this.photo = photo;
		this.path = path;
		this.name = name;
		this.birth_date = birth_date;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.school = school;
		this.department = department;
		this.school_period = school_period;
		this.career = career;
		this.work_place = work_place;
		this.work_date = work_date;
		this.work = work;
		this.certification = certification;
		this.cer_date = cer_date;
		this.title = title;
		this.cover_letter = cover_letter;
		this.open = open;
		this.update_date = update_date;
		this.p_language = p_language;
		this.hope_salary = hope_salary;
		this.m_no = m_no;
		
		
	}
	
	public Resume(int resume_no, String photo, String path, String name, String birth_date, String phone,
			String address, String email, String school, String department, String school_period, String career,
			String work_place, String work_date, String work, String certification, String cer_date, String title,
			String cover_letter, String open, String update_date, String p_language, String hope_salary, int m_no,
			String career_year, String school_final) {
		super();
		this.resume_no = resume_no;
		this.photo = photo;
		this.path = path;
		this.name = name;
		this.birth_date = birth_date;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.school = school;
		this.department = department;
		this.school_period = school_period;
		this.career = career;
		this.work_place = work_place;
		this.work_date = work_date;
		this.work = work;
		this.certification = certification;
		this.cer_date = cer_date;
		this.title = title;
		this.cover_letter = cover_letter;
		this.open = open;
		this.update_date = update_date;
		this.p_language = p_language;
		this.hope_salary = hope_salary;
		this.m_no = m_no;
		this.career_year = career_year;
		this.school_final = school_final;
	}
	public int getResume_no() {
		return resume_no;
	}
	public void setResume_no(int resume_no) {
		this.resume_no = resume_no;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSchool_period() {
		return school_period;
	}
	public void setSchool_period(String school_period) {
		this.school_period = school_period;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getWork_place() {
		return work_place;
	}
	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getCer_date() {
		return cer_date;
	}
	public void setCer_date(String cer_date) {
		this.cer_date = cer_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover_letter() {
		return cover_letter;
	}
	public void setCover_letter(String cover_letter) {
		this.cover_letter = cover_letter;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getP_language() {
		return p_language;
	}
	public void setP_language(String p_language) {
		this.p_language = p_language;
	}
	public String getHope_salary() {
		return hope_salary;
	}
	public void setHope_salary(String hope_salary) {
		this.hope_salary = hope_salary;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	public String getCareer_year() {
		return career_year;
	}
	public void setCareer_year(String career_year) {
		this.career_year = career_year;
	}
	public String getSchool_final() {
		return school_final;
	}
	public void setSchool_final(String school_final) {
		this.school_final = school_final;
	}
	@Override
	public String toString() {
		return "Resume [resume_no=" + resume_no + ", photo=" + photo + ", path=" + path + ", name=" + name
				+ ", birth_date=" + birth_date + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", school=" + school + ", department=" + department + ", school_period=" + school_period + ", career="
				+ career + ", work_place=" + work_place + ", work_date=" + work_date + ", work=" + work
				+ ", certification=" + certification + ", cer_date=" + cer_date + ", title=" + title + ", cover_letter="
				+ cover_letter + ", open=" + open + ", update_date=" + update_date + ", p_language=" + p_language
				+ ", hope_salary=" + hope_salary + ", m_no=" + m_no + ", career_year=" + career_year + ", school_final="
				+ school_final + "]";
	}

	
	
}
