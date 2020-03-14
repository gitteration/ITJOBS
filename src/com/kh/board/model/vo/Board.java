package com.kh.board.model.vo;

public class Board {

	private int b_no;
	private int m_no;
	private String nickname;
	private String head;
	private String title;
	private String contents;
	private String enroll_date;
	private String update_date;
	private String file;
	private String time; //모집기간
	private int count;
	private String status;
	private int d_count;
	private String editFile;
	private String path;
	private int down_count;
	private int reply_count;
	private String video;
	
	
	public Board() {
		super();
	}
	
	public Board(int b_no, int m_no, String nickname, String head, String title, String contents, String enroll_date,
			String update_date, String file, String time, int count, String status, int d_count, String editFile,
			String path, int down_count, int reply_count) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.enroll_date = enroll_date;
		this.update_date = update_date;
		this.file = file;
		this.time = time;
		this.count = count;
		this.status = status;
		this.d_count = d_count;
		this.editFile = editFile;
		this.path = path;
		this.down_count = down_count;
		this.reply_count = reply_count;
	}
	
	
	public Board(int b_no, int m_no, String nickname, String head, String title, String contents, String enroll_date,
			String update_date, String file, String time, int count, String status, int d_count, String editFile,
			String path, int down_count) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.enroll_date = enroll_date;
		this.update_date = update_date;
		this.file = file;
		this.time = time;
		this.count = count;
		this.status = status;
		this.d_count = d_count;
		this.editFile = editFile;
		this.path = path;
		this.down_count = down_count;
	}


	public Board(int b_no, int m_no, String head, String title, String contents, String enroll_date, String update_date,
			String file, String time, int count, String status, int d_count, String editFile, String path) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.enroll_date = enroll_date;
		this.update_date = update_date;
		this.file = file;
		this.time = time;
		this.count = count;
		this.status = status;
		this.d_count = d_count;
		this.editFile = editFile;
		this.path = path;
	}
	
	public Board(int b_no, int m_no, String nickname, String head, String title, String contents, String update_date,
			String file, String time, int count, String editFile, String path, int down_count, int reply_count, String video) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.update_date = update_date;
		this.file = file;
		this.time = time;
		this.count = count;
		this.editFile = editFile;
		this.path = path;
		this.down_count = down_count;
		this.reply_count = reply_count;
		this.video = video;
	}
	public Board(int b_no, int m_no, String head, String title, String contents, String update_date, String time,
			int count) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.update_date = update_date;
		this.time = time;
		this.count = count;
	}
	
	public Board(int b_no, int m_no, String nickname, String head, String title, String contents, String update_date,
			String editFile, String time, int count, String video) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.update_date = update_date;
		this.editFile = editFile;
		this.time = time;
		this.count = count;
		this.video = video;
	}
	
	
	public Board(int b_no, int m_no, String nickname, String head, String title, String contents,
			String update_date, String file, String time, int count, String editFile,
			String path, int down_count) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.update_date = update_date;
		this.file = file;
		this.time = time;
		this.count = count;
		this.editFile = editFile;
		this.path = path;
		this.down_count = down_count;
	}
	
	

	public Board(int b_no, int m_no, String nickname, String head, String title, String contents, String update_date,
			String time, int count, String editFile, String path, int down_count) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.nickname = nickname;
		this.head = head;
		this.title = title;
		this.contents = contents;
		this.update_date = update_date;
		this.time = time;
		this.count = count;
		this.editFile = editFile;
		this.path = path;
		this.down_count = down_count;
	}

	public String getNickname() {
		return nickname;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
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
	public String getFile() {
		return file;
	}
	public int getDown_count() {
		return down_count;
	}

	public void setDown_count(int down_count) {
		this.down_count = down_count;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getEditFile() {
		return editFile;
	}
	public void setEditFile(String editFile) {
		this.editFile = editFile;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	@Override
	public String toString() {
		return "Board [b_no=" + b_no + ", m_no=" + m_no + ", nickname=" + nickname + ", head=" + head + ", title="
				+ title + ", contents=" + contents + ", enroll_date=" + enroll_date + ", update_date=" + update_date
				+ ", file=" + file + ", time=" + time + ", count=" + count + ", status=" + status + ", d_count="
				+ d_count + ", editFile=" + editFile + ", path=" + path + ", down_count=" + down_count
				+ ", reply_count=" + reply_count + ", video=" + video + "]";
	}
	
	
}