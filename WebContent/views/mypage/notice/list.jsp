<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
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
		var page_header_title='공고 관리'
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
						<h3 class="alerts-title">공고 관리</h3>
						<a class="btn btn-common" onclick="location.href='<%=request.getContextPath()%>/write.no'">공고 만들기</a>
<%	ArrayList<Notification> list=(ArrayList<Notification>)request.getAttribute("list");
	for(Notification n:list){%>
						<a class="job-listings" href="<%=request.getContextPath()%>/get.no?noti_no=<%=n.getNoti_no()%>">
							<div class="row">
								<div class="col-lg-6 col-md-12 col-xs-12">
									<div class="job-company-logo">
										<img src="<%=contextPath %>/resources/cofileupload/<%=n.getLogoFile() %>" style="width:70px;height:70px;" alt="">
								&nbsp;&nbsp;&nbsp;
									</div>
									<div class="job-details">
										<h3><%=n.getTitle() %></h3>
										<span class="company-neme"> <%=n.getNickname() %> </span>
									</div>
								</div>
								<%-- <div class="col-lg-1 col-md-12 col-xs-12 text-right">
									<div class="location">
										<i class="lni-map-marker"></i> <%=n.getAddress() %>
									</div>
								</div> --%>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<span class="btn-full-time"><%=n.getSalary() %>만원</span>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<span class="btn-apply"><%=n.getOpen().equals("Y")?"공개":"비공개" %></span>
								</div>
							</div>
						</a>
<%	} %>
					<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						int currentPage=pi.getCurrentPage();%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myNotification.me?currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/myNotification.me?currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myNotification.me?currentPage=<%=currentPage+1%> class="btn-next">Next <i
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



<%-- <%@ include file="/views/include/header.jsp" %> --%>
<%-- <h1>공고 관리</h1>
<button onclick="location.href='<%=request.getContextPath()%>/write.no'">공고 만들기</button>
<select>
	<option>제목</option>
	<option>작성자</option>
	<option>내용</option>
</select>
<input>
<button>검색</button><button>삭제</button>
<table border=1>
	<tr>
		<th><input type=checkbox></th>
		<th>제목</th>
		<th>등록일</th>
		<th>수정일</th>
		<th>상태</th>
		<th>공개</th>
		<th>지원자 확인</th>
	</tr>
	<%	list=(ArrayList<Notification>)request.getAttribute("list");
		for(Notification n:list){%>
	<tr>
		<td><input type=checkbox></td>
		<td><a href="get.no?noti_no=<%=n.getNoti_no()%>"><%=n.getTitle() %></a></td>
		<td><%=n.getEnroll_date() %></td>
		<td><%=n.getEnd_date() %></td>
		<td><%=n.getStatus() %></td>
		<td><%=n.getOpen() %></td>
		<td><button onclick="location.href='<%=request.getContextPath()%>/list.vo?noti_no=<%=n.getNoti_no()%>'">지원자 확인</button></td>
	</tr>
	<%	} %>
</table>
 --%>


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