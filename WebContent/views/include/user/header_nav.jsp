<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	String contextPath=request.getContextPath();
	Member mem=(Member)session.getAttribute("mem");
	String head=request.getParameter("head");
	/* String googleMem = (String)session.getAttribute("googleMem"); */

	if(head!=null){
		session.setAttribute("head", head);
}
%>
<%
	String alert = (String) session.getAttribute("alert");
	String pwChange = (String) session.getAttribute("pwChange");
	String nickChange = (String) session.getAttribute("nickChange");
%>
<script>
	var msg = "<%=alert%>";
	if (msg != "null") {
		alert(msg);// 세션에 담긴 메세지 한번만 출력하고 삭제하기
<%	session.removeAttribute("alert");%>
	}
	
	var pwChange = "<%=pwChange%>"
	if(pwChange != "null"){
		alert(pwChange);
<%	session.removeAttribute("pwChange");%>
	}
	
	var nickChange = "<%=nickChange%>"
		if(nickChange != "null"){
			alert(nickChange);
	<%	session.removeAttribute("nickChange");%>
		}
	
	</script>
<nav class="navbar navbar-expand-lg fixed-top scrolling-navbar">
	<div class="container">
		<div class="theme-header clearfix">

			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#main-navbar" aria-controls="main-navbar"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
					<span class="lni-menu"></span>
					<span class="lni-menu"></span>
					<span class="lni-menu"></span>
				</button>
				<a href="<%=request.getContextPath() %>" class="navbar-brand"><img
					src="resources/images/logo12.png"
					style="width: 100px; height: 35px;" alt=""></a>
				<a style="color:black;">현재접속자수: <span id=userCounting>1</span>명</a>
			</div>
<script type="text/javascript">
 	var webSocket = new WebSocket('ws://<%=request.getServerName()%>:<%=request.getServerPort()%>/itjobs/userCounting');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	webSocket.onclose = function(event) {
		onClose(event)
	}
	function onMessage(event) {//다른사람 동작->나한테 발생
		callback(event.data)
	}
	function onOpen(event) {
		webSocket.send("어차피 안나올 값");
	}
	function onError(event) {
		alert(event.data);
	}
	function onClose(event) {
		webSocket.send("어차피 안나올 값");
	}
	function callback(str){
		var arr=str.split(',');
		$('#userCounting').text(arr[0]);
		$('#todayCount').text(arr[2]);
		$('#totalCount').text(arr[1]);
	}
</script>
			<div class="collapse navbar-collapse" id="main-navbar">
				<ul class="navbar-nav mr-auto w-100 justify-content-end">
					<li class="nav-item"><a class="nav-link">
						오늘 <span id="todayCount">&nbsp;</span> · 전체 <span id="totalCount">&nbsp;</span>
					</a></li>
					<%	if(mem!=null ){ %>
					<li class="nav-item"><a class="nav-link"> ${mem.nickname }님 안녕하세요.</a></li>
					<%	} %>
					<li class="aaa nav-item">
						<div></div>
						<a class="nav-link" href="<%=request.getContextPath() %>">
							Home </a></li>
					<li class="nav-item aaa dropdown">
						<div></div><a
						class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/list.bo?head=main" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 게시판 </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=main">전체</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=free">자유</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=study">스터디</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=project">프로젝트</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=qu">공지사항</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/list.bo?head=form">서식</a></li>
							
						</ul></li>
					<li class="nav-item aaa"><div></div>
						<a class="nav-link" href="<%=request.getContextPath()%>/notificationList.se">
							공고검색 </a></li>
					<li class="nav-item aaa"><div></div>
						<a class="nav-link" href="<%=request.getContextPath()%>/resumeList.se">
							인재검색 </a></li>
					<%	if(mem!=null && mem.getType().equals("1")){ %>
					<li class="nav-item dropdown aaa"><div></div>
					<a
						class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/myInfo.me" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 마이페이지 </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myInfo.me">내 정보수정
									</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myApplyList.vo">지원리스트
									</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myNotificationList.like">관심공고
									</a></li>
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/list.re">이력서관리</a></li>
							<li><a class="dropdown-item" href="mylist.qu">나의문의
									</a></li>
						</ul></li>
					<%	}else if(mem!=null && mem.getType().equals("2")){ %>
					<li class="nav-item dropdown aaa"><div></div>
					<a
						class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 마이페이지 </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myInfo.me">내 정보수정
									</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myNotification.me">공고리스트
									</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/myResumeList.like">관심인재
									</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/mylist.qu">나의문의
									</a></li>
						</ul>
					</li>
					<%}else if(mem !=null && mem.getType().equals("0")){ %>
					<li class="button-group"><a href="<%=request.getContextPath()%>/memberList.ad"
						class="button btn btn-common">관리자</a></li>
					<%	}else{ %>
					<li class="nav-item aaa"><div></div>
					<a class="nav-link" href="<%=request.getContextPath()%>/login.me">마이페이지</a></li>
					<%	} %>
					<%	if(mem!=null){ %>
					<li class="nav-item aaa"><div></div>
					<a class="nav-link" href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
					<%	}else{ %>
					<li class="nav-item aaa"><div></div>
					<a class="nav-link" href="<%=request.getContextPath()%>/login.me">로그인</a></li>
					<li class="nav-item aaa"><div></div>
					<a class="nav-link" href="<%=request.getContextPath()%>/joinlaw.jo">회원가입</a></li>
					<%	} %>
					
				</ul>
				
			</div>
		</div>
	</div>
	<div class="mobile-menu" data-logo="assets/img/logo-mobile.png"></div>
</nav>




