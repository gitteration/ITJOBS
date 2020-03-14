package com.kh.notification.model.vo;

public class Notification {
   
   private int noti_no;
   private int co_no;
   private String title;
   private String end_date;
   private String enroll_date;
   private String p_language;
   private int salary;
   private String contents;
   private String jobs;
   private String hope;
   private String status;
   private int d_count;
   private String open;
   
   //resume
   private String v_date; //resume테이블의 v_date(지원날짜)
   
   //Member
   private String nickname;   //기업이름
   
   //Co_Info
   private String address;   //기업주소
   private String logofile; 
   
   public String getV_date() {
      return v_date;
   }
   public void setV_date(String v_date) {
      this.v_date = v_date;
   }
   public Notification() {
      super();
   }
   
   
 
public Notification(int noti_no, int co_no, String title, String end_date, String enroll_date, String p_language,
		int salary, String contents, String jobs, String hope, String status, int d_count, String open, String nickname,
		String logofile) {
	super();
	this.noti_no = noti_no;
	this.co_no = co_no;
	this.title = title;
	this.end_date = end_date;
	this.enroll_date = enroll_date;
	this.p_language = p_language;
	this.salary = salary;
	this.contents = contents;
	this.jobs = jobs;
	this.hope = hope;
	this.status = status;
	this.d_count = d_count;
	this.open = open;
	this.nickname = nickname;
	this.logofile = logofile;
}
public Notification(int noti_no, int co_no, String title, String end_date, String enroll_date, String p_language,
         int salary, String contents, String jobs, String hope, String status, int d_count) {
      super();
      this.noti_no = noti_no;
      this.co_no = co_no;
      this.title = title;
      this.end_date = end_date;
      this.enroll_date = enroll_date;
      this.p_language = p_language;
      this.salary = salary;
      this.contents = contents;
      this.jobs = jobs;
      this.hope = hope;
      this.status = status;
      this.d_count = d_count;
   }
   
   public Notification(int noti_no, int co_no, String title, String end_date, String enroll_date, String p_language,
         int salary, String contents, String jobs, String hope, String status, int d_count, String open) {
      super();
      this.noti_no = noti_no;
      this.co_no = co_no;
      this.title = title;
      this.end_date = end_date;
      this.enroll_date = enroll_date;
      this.p_language = p_language;
      this.salary = salary;
      this.contents = contents;
      this.jobs = jobs;
      this.hope = hope;
      this.status = status;
      this.d_count = d_count;
      this.open = open;
   }
   
   public Notification(int noti_no, int co_no, String title, String end_date, String enroll_date, String p_language,
         int salary, String contents, String jobs, String hope, String status, int d_count, String open,String logofile) {
      super();
      this.noti_no = noti_no;
      this.co_no = co_no;
      this.title = title;
      this.end_date = end_date;
      this.enroll_date = enroll_date;
      this.p_language = p_language;
      this.salary = salary;
      this.contents = contents;
      this.jobs = jobs;
      this.hope = hope;
      this.status = status;
      this.d_count = d_count;
      this.open = open;
      this.logofile=logofile;
   }
   

   
   public int getNoti_no() {
      return noti_no;
   }
   public void setNoti_no(int noti_no) {
      this.noti_no = noti_no;
   }
   public int getCo_no() {
      return co_no;
   }
   public void setCo_no(int co_no) {
      this.co_no = co_no;
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
   public String getEnroll_date() {
      return enroll_date;
   }
   public void setEnroll_date(String enroll_date) {
      this.enroll_date = enroll_date;
   }
   public String getP_language() {
      return p_language;
   }
   public void setP_language(String p_language) {
      this.p_language = p_language;
   }
   public int getSalary() {
      return salary;
   }
   public void setSalary(int salary) {
      this.salary = salary;
   }
   public String getContents() {
      return contents;
   }
   public void setContents(String contents) {
      this.contents = contents;
   }
   public String getJobs() {
      return jobs;
   }
   public void setJobs(String jobs) {
      this.jobs = jobs;
   }
   public String getHope() {
      return hope;
   }
   public void setHope(String hope) {
      this.hope = hope;
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
   
   public String getOpen() {
      return open;
   }
   public void setOpen(String open) {
      this.open = open;
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
   
   public String getLogoFile() {
      return logofile;
   }
   public void setLogoFile(String logofile) {
      this.logofile = logofile;
   }
   @Override
   public String toString() {
      return "Notification [noti_no=" + noti_no + ", co_no=" + co_no + ", title=" + title + ", end_date=" + end_date
            + ", enroll_date=" + enroll_date + ", p_language=" + p_language + ", salary=" + salary + ", contents="
            + contents + ", jobs=" + jobs + ", hope=" + hope + ", status=" + status + ", d_count=" + d_count
            + ", open=" + open + "]";
   }
   
}



