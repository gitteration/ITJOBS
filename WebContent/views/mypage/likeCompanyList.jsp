<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.like.model.vo.Like"%>
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
		var page_header_title='관심 기업'
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
						<h3 class="alerts-title">좋아요 한 기업</h3>
<%	ArrayList<Like> list=(ArrayList<Like>)request.getAttribute("list");
	if(list==null || list.size()==0){%>
		좋아요 한 목록이 없어요.
<%	}else{
		for(Like m:list){%>
						<a class="job-listings" href="job-details.html">
							<div class="row">
								<div class="col-lg-4 col-md-12 col-xs-12">
									<div class="job-company-logo">
										<img src="assets/img/features/img1.png" alt="">
									</div>
									<div class="job-details">
										<h3><%=m.getNickname() %></h3>
										<span class="company-neme">  </span>
									</div>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<div class="location">
										<i class="lni-map-marker"></i> <%=m.getAddress() %>
									</div>
								</div>
								<div class="col-lg-2 col-md-12 col-xs-12 text-right">
									<span class="btn-full-time">개 공고<br>모집중</span>
								</div>
								<div class="col-lg-3 col-md-12 col-xs-12 text-right">
									<span class="btn-apply">Apply Now</span>
									<span class="btn-apply" onclick="return del(<%=m.getM_no()%>);">삭제</span>
								</div>
							</div>
						</a>
<%		}
	} %>
					<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						System.out.println(pi);
						int currentPage=pi.getCurrentPage();%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myCompanyList.like?currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/myCompanyList.like?currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/myCompanyList.like?currentPage=<%=currentPage+1%> class="btn-next">Next <i
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





<%-- <h1>기업 좋아요</h1>
<table border=1>
	<thead>
		<tr>
			<th><input type=checkbox></th>
			<th>type</th>
			<th>email</th>
			<th>pw</th>
			<th>nickname</th>
			<th>status</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<%	list=(ArrayList<Member>)request.getAttribute("list");
			for(Member m:list){%>
		<tr>
			<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
			<td><%=m.getType() %></td>
			<td><%=m.getEmail() %></td>
			<td><%=m.getPw() %></td>
			<td><%=m.getNickname() %></td>
			<td><%=m.getStatus() %></td>
			<td><button onclick="del(<%=m.getM_no()%>,<%=mem.getM_no()%>)">삭제</button></td>
		</tr>
		<%	} %>
	</tbody>
</table>
<script>
	function del(co_no){
		location.href="<%=request.getContextPath()%>/delCompany.like?co_no="+co_no;
		return false;
	}
</script>

<button>삭제</button>
<table border=1>
	<tr>
		<th><input type=checkbox></th>
		<th>기업명</th>
		<th>모집중인 공고수</th>
		<th>삭제</th>
	</tr>
	<tr>
		<td><input type=checkbox></td>
		<td><a href="get.jsp?bno=1">기업1</a></td>
		<td>공고수1</td>
		<td><button>삭제</button></td>
	</tr>
</table> --%>



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