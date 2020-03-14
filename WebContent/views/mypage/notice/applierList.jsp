<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.volunteer.model.vo.Volunteer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp"%>
<!-- End of import from jobx -->

</head>
<body>

	<header id="home" class="hero-area">
		<%@ include file="/views/include/user/header_nav.jsp"%>
	</header>

	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp"%>
	<script>
      var page_header_title='지원자관리'
   </script>
	<!-- end of page-header -->


	<div id="content">
		<div class="container">
			<div class="row">

				<!-- left -->
				<%@ include file="/views/include/user/mypage_menu.jsp"%>
				<!-- End of left -->


				<div class="col-lg-8 col-md-12 col-xs-12">
					<div class="job-alerts-item">
						<h3 class="alerts-title">지원자</h3>
						<a class="btn btn-common btn-sm" style="width: 85px"
							onclick="history.back()">뒤로</a>
						<div class="alerts-list">
							<div class="row">
								<div class="col-md-2">
									<p>지원번호</p>
								</div>
								<div class="col-md-2">
									<p>공고번호</p>
								</div>
								<div class="col-md-2">
									<p>이력서번호</p>
								</div>
								<div class="col-md-2">
									<p>지원날짜</p>
								</div>
								<div class="col-md-2">
									<p>상태</p>
								</div>
								<div class="col-md-2">
									<p>이력서보기</p>
								</div>
							</div>
						</div>
						<%
							ArrayList<Volunteer> list = (ArrayList<Volunteer>) request.getAttribute("list");
							int noti_no=list.get(0).getNoti_no();
							for (Volunteer v : list) {
						%>
						<div class="alerts-content">
							<div class="row">

								<div class="col-md-2">
									<p><%=v.getV_no()%></p>
								</div>
								<div class="col-md-2">
									<p><%=v.getNoti_no()%></p>
								</div>

								<div class="col-md-2">
									<p><%=v.getResume_no()%></p>
								</div>

								<div class="col-md-2">
									<p><%=v.getV_date()%></p>
								</div>

								<div class="col-md-2">
									<p><%=v.getStatus()%></p>
								</div>
								<div class="col-md-2">
									<p>
										<a class="btn btn-common btn-sm" style="width: 85px" id="new"
											href="detail.re?resume_no=<%=v.getResume_no()%>&v_no=<%=v.getV_no()%>">보기</a>
									</p>
								</div>
							</div>
						</div>
						<%
							}
						%>
						
						<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
						int currentPage=pi.getCurrentPage();%>
						<ul class="pagination" style="display:block;">
							<%	if(currentPage>1){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/list.vo?noti_no=<%=noti_no %>&currentPage=<%=currentPage-1%>" class="btn-prev"><i
									class="lni-angle-left"></i> prev</a></li>
							<%	} %>
							<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
							<li><a href="<%=request.getContextPath()%>/list.vo?noti_no=<%=noti_no %>&currentPage=<%=i%>"><%=i %></a></li>
							<%	} %>
							<%	if(currentPage<pi.getMaxPage()){ %>
							<li class="active"><a href="<%=request.getContextPath()%>/list.vo?noti_no=<%=noti_no %>&currentPage=<%=currentPage+1%>" class="btn-next">Next <i
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

	<br>

	</div>




	<h1>지원자 관리</h1>

	<button onclick="history.back()">뒤로</button>
	<table border=1>
		<tr>
			<th><input type=checkbox></th>
			<th>v_no</th>
			<th>noti_no</th>
			<th>resume_no</th>
			<th>지원날짜</th>
			<th>상태</th>
			<th>이력서 보기</th>
		</tr>
		<%
			ArrayList<Volunteer> list1 = (ArrayList<Volunteer>) request.getAttribute("list");
			for (Volunteer v : list1) {
		%>
		<tr>
			<td><input type=checkbox></td>
			<td><%=v.getV_no()%></td>
			<td><%=v.getNoti_no()%></td>
			<td><%=v.getResume_no()%></td>
			<td><%=v.getV_date()%></td>
			<td><%=v.getStatus()%></td>
			<td><button onclick="showResume(<%=v.getResume_no()%>)">이력서
					보기</button></td>
		</tr>
		<%
			}
		%>
	</table>
	<script>
	function showResume(resume_no){
		location.href="detail.re?resume_no="+resume_no
	}
	
</script>


	<!-- footer -->
	<%@ include file="/views/include/user/footer.jsp"%>
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
	<%@ include file="/views/include/user/js.jsp"%>
	<!-- End of import of jobx -->

	<script>
   $('.inner-header').children('h3').text(page_header_title)
</script>
	<%@ include file="/views/include/footer.jsp"%>
</body>
</html>