<%@page import="com.kh.board.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");  
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
/* #test{width:20px;} */
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->

<!-- import of jobx -->
<%@ include file="/views/include/user/js.jsp" %>
<!-- End of import of jobx -->
</head>
<body>
	
	<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>
	</header>

	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp" %>
	<script>
		var page_header_title='게시판'
	</script>
	<!-- end of page-header -->
	
	
	
	<div id="content">
	<div class="container">
	<div class="row">
	<div class="col-lg-4 col-md-12 col-xs-12">
	<div class="right-sideabr">
	<h4>게시판</h4>
	<ul class="list-item">
	<li><a href="<%=contextPath%>/list.bo?head=main">전체보기</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=free">자유</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=study">스터디</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=project">프로젝트</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=qu">공지사항</a></li>
	<li><a href="<%=contextPath%>/listForm.bo?head=form">서식</a></li>
	</ul>
	
	</div>
	</div>
	
	<% 
	switch(head) {
		case "main" : head="전체보기"; break;
		case "free" : head="자유"; break;
		case "study" : head="스터디"; break;
		case "project" : head="프로젝트"; break;
		case "qna" : head="공지사항"; break;
		case "form" : head="서식"; break;
	}
	%>
	
	<div class="col-lg-8 col-md-12 col-xs-12">
	
	
	<div class="job-alerts-item">
	<h3 class="alerts-title" style="display:inline-block"><%=head%></h3>
	

	<section class="category section bg-white">
	<div class="container">
	<div class="row">
	
	<% for(int i=0; i<list.size(); i++) { %>
	<div class="col-lg-3 col-md-6 col-xs-12 f-category">
	<a href="<%= contextPath %>/detail.bo?head=form&bId=<%= list.get(i).getB_no() %>">
	<div class="icon bg-color-1">
	<img onclick="imgBtn();" src="<%=contextPath%>/resources/fileupload_board/<%= list.get(i).getEditFile() %>"  width="70px" height="50px"></i>
	</div>
	<h3> <%= list.get(i).getTitle() %></h3>
	<p>조회수 : <%= list.get(i).getCount() %><br>
		다운로드수 : <%=list.get(i).getDown_count() %></p>
	</a>
	</div>
	<!-- <div style='width:70px;'></div> -->
	<% } %>

	

	</div>
	</div>
	</section>

	</div>
	</div>
	
	</div>
	</div>
	</div>

	
	
	
	
<%-- 	<script>
		$(function(){
			$("img").mouseenter(function(){
				$(this).css({"cursor":"pointer"})
			}).click(function(){
				var bId = $("#bId").val();
				
				location.href="<%= contextPath %>/detail.bo?head=form&bId=" + bId;
			
			});
		});
	
	</script> --%>
	
	
	
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


	<script>
	$('.inner-header').children('h3').text(page_header_title)
	</script>
</body>
</html>