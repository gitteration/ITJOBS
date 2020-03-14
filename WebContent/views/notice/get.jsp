<%@page import="com.kh.resume.model.vo.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->

</head>
<body>

	<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>
	</header>

	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp" %>
	<script>
		var page_header_title='기업정보'
	</script>
	<!-- end of page-header -->
	
	
${noti }<br>
<%	Notification noti=(Notification)request.getAttribute("noti");%>

기업
<button onclick="edit(<%=noti.getNoti_no() %>)">수정</button>
<button onclick="del(<%=noti.getNoti_no() %>)">삭제</button>
<button onclick="open_(<%=noti.getNoti_no() %>)">공개</button>
<button onclick="openCancle(<%=noti.getNoti_no() %>)">비공개</button>
<button onclick="location.href='<%=request.getContextPath()%>/myNotification.me'">나의 공고목록으로</button>
<button onclick="showApplier(<%=noti.getNoti_no() %>)">지원자 확인</button>
<br>
일반
지원서: 
	<%	ArrayList<Resume> rlist=(ArrayList<Resume>)request.getAttribute("rlist"); %>
<form action="apply.vo" method="post">
	<input type=hidden name="noti_no" value="<%=noti.getNoti_no() %>">
	<select name="resume_no">
		<% for(Resume r:rlist){%>
		<option value="<%=r.getResume_no()%>"><%=r.getTitle() %></option>
		<%	} %>
	</select>
	<button onclick="apply(<%=noti.getNoti_no() %>)">지원하기</button>
</form>
<script>
	function edit(noti_no){
		location.href="edit.no?noti_no="+noti_no;
	}
	function del(noti_no){
		location.href="del.no?noti_no="+noti_no;
	}
	function open_(noti_no){
		location.href="open.no?noti_no="+noti_no;
	}
	function openCancle(noti_no){
		location.href="openCancle.no?noti_no="+noti_no;
	}
	function showApplier(noti_no){
		location.href="list.vo?noti_no="+noti_no;
	}
	function apply(noti_no){
		
	}
</script>

	<!-- footer -->
		<%@ include file="/views/include/user/footer.jsp" %>
	<!-- End of footer -->
	
	<!-- back to top button -->
		<a href="#" class="back-to-top"> <i class="lni-arrow-up"></i></a>
	<!-- End of back to top button -->
	
	<!-- 뭔지 모르겠어 -->
	<div id="preloader">
		<div class="loader" id="loader-1"></div>
	</div>
	<!-- 뭔지 모르겠어 -->


	<!-- import of jobx -->
	<%@ include file="/views/include/user/js.jsp" %>
	<!-- End of import of jobx -->

<script>
	$('.inner-header').children('h3').text(page_header_title)
</script>
</body>
</html>