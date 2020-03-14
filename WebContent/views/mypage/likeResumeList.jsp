<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.resume.model.vo.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		var page_header_title='내 정보 수정'
	</script>
	<!-- end of page-header -->
	
	
	<!-- content -->
	<div id="content">
	
		<!-- container -->
		<div class="container">
			
			<!-- row -->
			<div class="row">
				
				<!-- left -->
				<%@ include file="/views/include/user/mypage_menu.jsp" %>
				<!-- End of left -->
				
				<!-- right  -->
				<div class="col-lg-8 col-md-6 col-xs-12">
					<div class="job-alerts-item bookmarked">
						<h3 class="alerts-title">좋아요 한 인재</h3>
<%	ArrayList<Resume>  list=(ArrayList<Resume>)request.getAttribute("list");
	if(list==null || list.size()==0){%>
		좋아요 한 목록이 없어요.
<%	}else{
		for(Resume n:list){%>
						<a class="job-listings" href="detail.re?resume_no=<%=n.getResume_no()%>">
							<div class="row">
								<div class="col-lg-4 col-md-12 col-xs-12">
									<div class="job-company-logo">
										<img src="<%=contextPath %>/resources/fileupload_resumeImg/<%=n.getPhoto() %>" style="width:70px;height:70px;" alt="">
								&nbsp;&nbsp;&nbsp;
									</div>
									<div class="job-details">
										<h3><%=n.getTitle() %></h3>
										<span class="company-neme"> <%=n.getP_language() %> </span>
									</div>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<div class="location">
										<i class="lni-map-marker"></i> <%=n.getCareer() %>
									</div>
								</div>
								<div class="col-lg-2 col-md-12 col-xs-12 text-right">
									<span class="btn-full-time"><%=n.getDepartment() %></span>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<span class="btn-apply" onclick="return del(<%=n.getResume_no()%>);">삭제</span>
								</div>
							</div>
						</a>
<%		}
	} %>
					<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						int currentPage=pi.getCurrentPage();%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myResumeList.like?currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/myResumeList.like?currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myResumeList.like?currentPage=<%=currentPage+1%> class="btn-next">Next <i
									class="lni-angle-right"></i></a></li>
							<%	} %>
						</ul>

					</div>
				</div>
				<!-- End of right -->
				
			</div>
			<!-- End of row -->
			
		</div>
		<!-- End of container -->
	</div>
	<!-- End of content -->




<%-- <h1>인재 좋아요</h1>
<button>삭제</button>
<table border=1>
	<tr>
		<th><input type=checkbox></th>
		<th>이름</th>
		<th>언어</th>
		<th>신입/경력</th>
		<th>생년월일</th>
		<th>학력</th>
		<th>이력서 보기</th>
		<th>삭제</th>
	</tr>
	<%	list=(ArrayList<Resume>)request.getAttribute("list");
		for(Resume r:list){%>
	<tr>
		<td><input type=checkbox></td>
		<td><%=r.getName() %></td>
		<td><%=r.getP_language() %></td>
		<td><%=r.getCareer() %></td>
		<td><%=r.getBirth_date() %></td>
		<td><%=r.getSchool() %></td>
		<td><button>이력서 보기</button></td>
		<td><button onclick="del(<%=r.getResume_no()%>,<%=mem.getM_no()%>)">삭제</button></td>
	</tr>
	<%	} %>
</table> --%>
<script>
	function del(resume_no){
		location.href="<%=request.getContextPath()%>/delResume.like?resume_no="+resume_no;
		return false;
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