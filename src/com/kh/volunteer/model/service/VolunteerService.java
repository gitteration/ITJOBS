package com.kh.volunteer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.notification.model.vo.Notification;
import com.kh.volunteer.model.dao.VolunteerDao;
import com.kh.volunteer.model.vo.Volunteer;

public class VolunteerService {

	public ArrayList<Volunteer> getList(int noti_no, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Volunteer> list=new VolunteerDao().getList(conn,noti_no,pi);
		close(conn);
		return list;
	}

	public ArrayList<Volunteer> getMyApplyList(int m_no, PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Volunteer> list=new VolunteerDao().getMyApplyList(conn,m_no,pi);
		close(conn);
		return list;
	}

	public int apply(int noti_no, int resume_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().apply(conn,noti_no,resume_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int applyCancle(int v_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().applyCancle(conn,v_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getListCount(int noti_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().getListCount(conn,noti_no);
		close(conn);
		return result;
	}

	public Volunteer getVolunteer(int v_no) {
		Connection conn=getConnection();
		Volunteer v=new VolunteerDao().getVolunteer(conn,v_no);
		close(conn);
		return v;
	}

	public int readResume(int v_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().readResume(conn,v_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getMyApplyListCount(Member mem) {
		Connection conn=getConnection();
		int result=new VolunteerDao().getMyApplyListCount(conn,mem);
		close(conn);
		return result;
	}

	public int passResume(int v_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().passResume(conn,v_no);
		System.out.println("서비스"+result);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int failResume(int v_no) {
		Connection conn=getConnection();
		int result=new VolunteerDao().failResume(conn,v_no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int isApply(Member m, Notification noti) {
		Connection conn=getConnection();
		int result=new VolunteerDao().isApply(conn,m,noti);
		close(conn);
		return result;
	}

	public ArrayList<Volunteer> getListWithoutPage(int noti_no) {
		Connection conn=getConnection();
		ArrayList<Volunteer> list=new VolunteerDao().getListWithoutPage(conn,noti_no);
		close(conn);
		return list;
	}

}
