package com.kh.resume.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.resume.model.dao.ResumeDao;
import com.kh.resume.model.vo.Resume;
 

public class ResumeService {

	public ArrayList<Resume> getOpenResumeList(PageInfo pi) {
		Connection conn=getConnection();
		ArrayList<Resume> list=new ResumeDao().getOpenResumeList(conn,pi);
		close(conn);
		return list;
	}

	
public int insertResum(Resume re){
		
		Connection conn = getConnection();
		
		int result = new ResumeDao().insertResum(conn,re);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	/*public Resum resumDetail(int mno){
		
		int result =0;
		Connection conn = getConnection();
		
		Resum re = null;
		if(result > 0) {
			commit(conn);
			re = new ResumDao().selectResumDetail(conn, mno);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return re;
		
	}*/
	
	/**
	 * 3_1.이력서 총 갯수 조회용 서비스 
	 * @return
	 */
	public int getListCount(int mno) {
		Connection conn = getConnection();
		
		int listCount = new ResumeDao().getListCount(conn,mno);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 3_2. 이력서 리스트 조회용 서비스
	 * @param pi
	 * @return
	 */
	public ArrayList<Resume> selectResume(PageInfo pi,int mno){
		Connection conn = getConnection();
		
		ArrayList<Resume> list = new ResumeDao().selectResume(conn, pi,mno);
		close(conn);
		
		return list;
		
	}
	
	/**
	 * 4.이력서 상세보기용 서비스
	 * @param mno
	 * @return
	 */
	public Resume selectResumDetail(int resume_no){
	
	 Connection conn = getConnection();
		
	 Resume re = new ResumeDao().selectResumDetail(conn, resume_no);
	 
	 if(re != null){ 
		 commit(conn);
	 }else{
		 rollback(conn);
	 }
	  close(conn);
		
	
		
		
		
		
		return re;
		
	}
	
	/**
	 * 5. 이력서 수정 폼용 서비스 
	 * @param resume_no
	 * @return
	 */
	public Resume selectUpdateResum(int resume_no){
		Connection conn = getConnection();
		
		Resume re = new ResumeDao().selectUpdateResum(conn,resume_no);
		
		if(re != null){ 
			 commit(conn);
		 }else{
			 rollback(conn);
		 }
		  close(conn);
		  return re;
	}


	public ArrayList<Resume> getMyResumeList(Member m) {
		Connection conn = getConnection();
		
		ArrayList<Resume> list = new ResumeDao().getMyResumeList(conn, m);
		
		close(conn);
		
		return list;
	}
	
	public int deleteResume(int resume_no){
		
		Connection conn = getConnection();
		
		int result = new ResumeDao().deleteResume(conn,resume_no);
		// result = 0이면 이력서 삭제 실패 --> 지원중인지 확인 
		//			1이면 이력서 삭제 성공 
		
		if(result > 0){
			commit(conn);
			
		}else{
			rollback(conn);
			
		}
		close(conn);
		
		return result;
		
	}
	
	public int supportResume(int resume_no){
		
		Connection conn = getConnection();
		
		int su_result = new ResumeDao().supportResume(conn,resume_no);
		
		if(su_result > 0){
			commit(conn);
			
		}else{
			rollback(conn);
			
		}
		close(conn);
		
		return su_result;
		
	}
		


	public int updateResume(Resume re){
		
		Connection conn = getConnection();
		
		int result = new ResumeDao().updateResume(conn,re);
		
		if(result >0 ){
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int ResLikeCheck(int likeRes, int memNo) {
		
		
	 	
		Connection conn = getConnection();
		//좋아요 중복체크하기 위해서
		int result = new ResumeDao().ResLikeCheck(conn,likeRes,memNo);
		
		if(result>0) { // 중복으로 좋아요 한 기업이 있으면 
		  int result1 = new ResumeDao().deleteLike(conn,likeRes,memNo);
		  	if(result1>0) {
		  		commit(conn);
		  	}else {
		  		rollback(conn);
		  	}
		  
		
		}else { // 좋아요가 없으면
		   int result2 = new ResumeDao().insertLike(conn,likeRes,memNo);
		   	if(result2>0) {
		   		commit(conn);
		   	}else {
		   		rollback(conn);
		   	}
		   
		}
		close(conn);
	
		return result;
	}


	public int getOpenResumeListCount() {
		Connection conn = getConnection();
		int result = new ResumeDao().getOpenResumeListCount(conn);
		close(conn);
		return result;
	}


	public ArrayList<Resume> getMyResumeListforApply(Member m) {
		Connection conn = getConnection();
		ArrayList<Resume> list = new ResumeDao().getMyResumeListforApply(conn, m);
		close(conn);
		return list;
	}
	
	
	
	
}
