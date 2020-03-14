<%@page import="com.kh.resume.model.vo.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% 
	/*  Resume re = (Resume)request.getAttribute("re"); */
	//String contextPath = request.getContextPath();
	//Member m = (Member)session.getAttribute("loginUser"); 
	/* PageInfo pi = (PageInfo)request.getAttribute("pi"); */
	
	ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");
	/* 
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
	
	
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 리스트</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->

	



<style>

/* 	table{
		border:1px solid black;
		text-align:center;
	}
	.tableArea{
		width:650px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	tabel td:hover{
		background-color:lightgray;
	}
	 */
	#new{
		margin-left:65%;
	}
</style>
</head>
<body>

<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>
	</header>

	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp" %>
	<script>
		var page_header_title='나의 이력서'
	</script>
	<!-- end of page-header -->
	
<div id="content">
<div class="container">
<div class="row">

<%-- <div id="newButton">
<a href="<%=contextPath%>/add.re" class="btn btn-common btn-xs" id="new">+ 새 이력서 작성하기</a>
</div> --%>

				<!-- left -->
				<%@ include file="/views/include/user/mypage_menu.jsp" %>
				<!-- End of left -->
				
				<!-- right  -->

<div class="col-lg-8 col-md-12 col-xs-12">
<div class="job-alerts-item candidates">
<h3 class="alerts-title">나의 이력서</h3>
<a class="btn btn-common btn-sm" id="new" href="<%=contextPath%>/add.re">새 이력서 추가하기</a>
<% if(list==null || list.isEmpty()){ %>

<label>조회된 리스트가 없습니다</label>
				
<% }else if(list!=null){ %>
			<% for(Resume re : list){ %>
<div class="manager-resumes-item">
<div class="manager-content">
<a href="resume.html"><img class="resume-thumb" src="assets/img/jobs/avatar-1.jpg" alt=""></a>
<div class="manager-info">
<div class="manager-name">
<h4><a href="<%=contextPath%>/detail.re?resume_no=<%= re.getResume_no()%>"><%= re.getTitle() %></a></h4>
<h5><%=re.getCover_letter() %></h5>
</div>
<div class="manager-meta">
<span class="location"><i class="lni-map-marker"></i>
<%if(re.getOpen().equals("Y")){ %>
현재 공개중인 이력서 입니다.
<%}else{%>
비공개중인 이력서입니다.
<%} %>
</span>
<span class="rate"><i class="lni-alarm-clock"></i>
<% if(re.getCareer_year()==null){ %>
신입
<%}else{ %>
경력<%=re.getCareer_year() %>년차
<%} %>
</span>
</div>
</div>
</div>
<div class="update-date">
<p class="status">
<strong><%=re.getUpdate_date() %></strong>에 수정된 이력서입니다.
</p>

</div>
</div>
<%} %>
<%} %>

					<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						int currentPage=pi.getCurrentPage();%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/list.re?currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/list.re?currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/list.re?currentPage=<%=currentPage+1%> class="btn-next">Next <i
									class="lni-angle-right"></i></a></li>
							<%	} %>
						</ul>

</div>
</div>
</div>

</div>
</div>
</div>

</div>
</div>
				<!-- End of right -->

			</div>
			<!-- End of row -->
			
		</div>
		<!-- End of container -->
	</div>
	<!-- End of content -->
	

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