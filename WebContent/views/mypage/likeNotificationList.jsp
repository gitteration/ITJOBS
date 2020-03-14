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
						<h3 class="alerts-title">좋아요 한 공고</h3>
<%	ArrayList<Notification> list=(ArrayList<Notification>)request.getAttribute("list");
	if(list==null || list.size()==0){%>
		좋아요 한 목록이 없어요.
<%	}else{
	for(Notification n:list){%>
						<a class="job-listings" href="get.no?noti_no=<%=n.getNoti_no()%>">
							<div class="row">
								<div class="col-lg-4 col-md-12 col-xs-12">
									<div class="job-company-logo">
										<img src="<%=contextPath %>/resources/cofileupload/<%=n.getLogoFile() %>" style="width:70px;height:70px;" alt="">
								&nbsp;&nbsp;&nbsp;
									</div>
									<div class="job-details">
										<h3><%=n.getTitle() %></h3>
										<span class="company-neme"> <%=n.getNickname() %> </span>
									</div>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<div class="location">
										<i class="lni-map-marker"></i> <%=n.getAddress().split("\\+")[1] %>
									</div>
								</div>
								<div class="col-lg-2 col-md-12 col-xs-12 text-right">
									<span class="btn-full-time">Full Time</span>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<span class="btn-apply" onclick="return del(<%=n.getNoti_no()%>);">삭제</span>
								</div>
							</div>
						</a>
<%		}
	} %>
					<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						System.out.println(pi);
						int currentPage=pi.getCurrentPage();
						String sText=(String)request.getAttribute("sText");%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myNotificationList.like?sText=<%=sText %>&currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/myNotificationList.like?sText=<%=sText %>&currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myNotificationList.like?sText=<%=sText %>&currentPage=<%=currentPage+1%> class="btn-next">Next <i
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