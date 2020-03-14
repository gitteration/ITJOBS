<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	System.out.println("세션null확인?");
	if(mem==null){
		session.setAttribute("alert", "로그아웃되었습니다. 다시 로그인해주세요.");
		response.sendRedirect("login.me");
	}%>
    <script src="resources/jobx/assets/js/jquery-min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<div class="col-lg-4 col-md-12 col-xs-12">
	<div class="right-sideabr">
		<h4>Manage Account</h4>
		<ul class="list-item">
			<%	if(mem!=null && mem.getType().equals("1")){ %>
			<li><a href="<%=request.getContextPath()%>/list.re">이력서 관리</a></li>
			<li><a href="<%=request.getContextPath()%>/myApplyList.vo">내가 지원한 기업</a></li>
			<li><a href="<%=request.getContextPath()%>/myNotificationList.like">관심공고</a></li>
			<%	}else if(mem!=null){ %>
			<li><a href="<%=request.getContextPath()%>/myNotification.me">공고 관리</a></li>
			<li><a href="<%=request.getContextPath()%>/myResumeList.like">관심인재</a></li>
			<%	} %>
			<li><a href="<%=request.getContextPath()%>/changePw.me">정보 변경</a></li>
			<li><a href="<%=request.getContextPath()%>/mylist.qu">나의 문의</a></li>
			<li><a href="#" id="modal_open" data-target="#exampleModal" data-toggle="modal">탈퇴</a></li>
		</ul>
	</div>
</div>

<script>
	$("#modal_open").click(function () {
		if(confirm("정말 탈퇴하시겠습니까?")){
			
			$("#exampleModal").modal('show');
		}
		return false;
	})
</script>

<div class="modal" tabindex="-1" role="dialog" id="exampleModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">회원탈퇴</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>정말 탈퇴할꺼면 비번을 입력하세요.</p>
        <input name=pw>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="realLeave">탈퇴하기</button>
      </div>
    </div>
  </div>
</div>

<script>
	$(document).on('click','#realLeave',function(){
		var leaveForm=$('form')
		leaveForm.attr('action','leave.me')
		leaveForm.attr('method','post')
		var pwTag=$('input[name="pw"]').clone()
		leaveForm.empty();
		leaveForm.append(pwTag)

		leaveForm.submit()
	})
	
</script>