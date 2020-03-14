<%@page import="com.kh.notification.model.vo.Notification"%>
<%@page import="com.kh.volunteer.model.vo.Volunteer"%>
<%@page import="com.kh.resume.model.vo.Resume"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Resume re = (Resume)request.getAttribute("re");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>resumDetailView</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->
<style>
	#blur{
		
		-webkit-filter: blur(5px); 
		-moz-filter: blur(5px); 
		-o-filter: blur(5px); 
		-ms-filter: blur(5px); 
		filter: blur(5px);

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
		var page_header_title='이력서'
	</script>
	<!-- end of page-header -->
	
	<!-- content -->
	<div id="content">
	
		<!-- container -->
		<div class="container">
			
			<!-- row -->
			<%	if(mem!=null && mem.getM_no()==re.getM_no()){ %>
			<div class="row">
			<%	}else{ %>
			<div class="row justify-content-center">
			<%	} %>
				
				<!-- left -->
				<%	if(mem!=null && mem.getM_no()==re.getM_no()){ %>
				<%@ include file="/views/include/user/mypage_menu.jsp" %>
				<%	} %>
				<!-- End of left -->
				
				<!-- right  -->
				<div class="col-lg-8 col-md-12 col-xs-12">
					<div class="inner-box my-resume">
					<%	Volunteer v=(Volunteer)request.getAttribute("v");
						Notification n=(Notification)request.getAttribute("n");
						if(mem!=null && mem.getM_no()==re.getM_no()){ %>
					<button class="btn btn-common" onclick="location.href='<%=request.getContextPath()%>/update.re?resume_no=<%=re.getResume_no()%>'">수정하기</button>
					<button class="btn btn-common" onclick="location.href='<%=request.getContextPath()%>/deleteResum.re?resume_no=<%=re.getResume_no()%>'">삭제하기</button>
					<%	}else if(mem!=null && mem.getType().equals("2") && n!=null && mem.getM_no()==n.getCo_no() && v.getNoti_no()==n.getNoti_no()){
							 if(!v.getStatus().equals("pass") && !v.getStatus().equals("fail")){%>
					<button class="btn btn-common" onclick="location.href='<%=request.getContextPath()%>/pass.vo?v_no=<%=v.getV_no()%>'">서류합격</button>
					<button class="btn btn-common" onclick="location.href='<%=request.getContextPath()%>/fail.vo?v_no=<%=v.getV_no()%>'">서류탈락</button>
						<%	}else{ %>
							<h3><%=v.getStatus() %>상태의 이력서 입니다.</h3>
						<%	} %>
					<%	} %>
						<hr>
						<h3>이력서 제목</h3>
						<p><%= re.getTitle()%></p>
						<hr>
						<div class="author-resume">
							<div class="thumb">
							<%if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==re.getM_no())){ %> 
								<img src="<%= contextPath %>/resources/fileupload_resumeImg/<%= re.getPhoto()%>" >
								<%}else{ %>
								<img src="<%= contextPath %>/resources/fileupload_resumeImg/<%= re.getPhoto()%>" id="blur">
								<%} %>
							</div>
<%	if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==re.getM_no())){ %>
							<div class="author-info">
								<h3><%=re.getName() %></h3>
								<!-- <p class="sub-title">UI/UX Designer</p> -->
								<p>생년월일 : <%= re.getBirth_date()%></p>
								<p>이메일 : <%= re.getEmail() %><br></p>
								<p>
									<span class="address"><i class="lni-map-marker"></i> <%=re.getAddress().split("\\+")[1] %></span><br>
									<span><i class="lni-phone"></i> <%=re.getPhone() %></span>
								</p>
								<!-- <div class="social-link">
									<a href="#" class="Twitter"><i class="lni-twitter-filled"></i></a>
									<a href="#" class="facebook"><i class="lni-facebook-filled"></i></a>
									<a href="#" class="google"><i class="lni-google-plus"></i></a>
									<a href="#" class="linkedin"><i class="lni-linkedin-fill"></i></a>
								</div> -->
							</div>
<%	}else{ %>
							<div class="author-info">
								<h3>****</h3>
								<!-- <p class="sub-title">UI/UX Designer</p> -->
								<p>생년월일 : ****</p>
								<p>이메일 : ****<br></p>
								<p>
									<span class="address"><i class="lni-map-marker"></i> ****</span><br>
									<span><i class="lni-phone"></i> ****</span>
								</p>
								<!-- <div class="social-link">
									<a href="#" class="Twitter"><i class="lni-twitter-filled"></i></a>
									<a href="#" class="facebook"><i class="lni-facebook-filled"></i></a>
									<a href="#" class="google"><i class="lni-google-plus"></i></a>
									<a href="#" class="linkedin"><i class="lni-linkedin-fill"></i></a>
								</div> -->
							</div>
<%	} %>
						</div>
<%	if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==re.getM_no())){ %>
						<div class="work-experence item">
							<h3>언어</h3>
							<%	String[] languages=re.getP_language().split(",");
								
								for(int i=0;i<languages.length;i++){%>
							<h4>-<%= languages[i]%></h4>
							<%	} %>
						</div>
						<div class="school_final item">
							<h3>최종학력</h3>
								<%	String[] schools=re.getSchool().split(",");
									String[] departments=re.getDepartment().split(",");
									String[] school_period=re.getSchool_period().split("~");
									String[] st_school_period=school_period[0].split(",");
									String[] ed_school_period=school_period[1].split(",");
									
									for(int i=0;i<schools.length;i++){%>
								<h4><%= schools[i]%></h4>
								<p><%= departments[i]%></p>
								<span class="date"><%= st_school_period[i]%>~<%= ed_school_period[i]%></span> <br>
								<%	} %>
						</div>
						<div class="about-me item">
							<h3>경력</h3>
							<%= re.getCareer()%><br>
							<%	if(re.getCareer().equals("Y")){
									String[] work_place=re.getWork_place().split(",");
									String[] work_date=re.getWork_date().split("~");
									String[] st_work_date=work_date[0].split(",");
									String[] ed_work_date=work_date[1].split(",");
									String[] work=re.getWork().split(",");
									String[] career_year=re.getCareer_year().split(",");
									
									for(int i=0;i<work_place.length;i++){%>
							<h4>일한곳: <%=work_place[i]%></h4>
							<p>한일: <%=work[i]%></p>
							<span class="date">일한 날짜: <%=st_work_date[i]%>~<%=ed_work_date[i]%></span> <br>
							<p>경력: <%=career_year[i] %></p>
							<%		}
								}%>
						</div>
						<div class="work-experence item">
							<h3>자격증</h3>
							<%	if(re.getCertification()!=null && re.getCer_date()!=null){
									String[] certifications=re.getCertification().split(",");
									String[] cer_dates=re.getCer_date().split(",");
								
									for(int i=0;i<certifications.length;i++){%>
							<h4><%= certifications[i]%></h4>
							<span class="date"><%= cer_dates[i]%></span> <br>
							<%		}
								}else{%>
								N<br>
							<%	} %>
						</div>
						<div class="education item">
							<h3>자소서</h3>
							<p><%= re.getCover_letter()%></p>
						</div>
						<div class="other item">
							<h3>공개비공개</h3>
							<p><%= re.getOpen()%></p>
							<h3>희망연봉</h3>
							<p><%=re.getHope_salary().equals("4001")?"4000이상":re.getHope_salary().equals("0")?"회사내규에따름":re.getHope_salary() %></p>
						</div>
<%	}else{ %>
						<div class="other item">
							<h3>기업로그인 하면 전체 조회 가능합니다.</h3>
						</div>
<%	} %>
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
<%-- <h2 align="center">이력서 작성</h2>

	<img src="resources/fileupload_resumeImg/<%=re.getPhoto()%>"><br>
	제목 : <%= re.getTitle()%><br>
	이름 : <%= re.getName()%><br>
	생년월일 : <%= re.getBirth_date()%><br>
	폰 : <%= re.getPhone()%><br>
	주소 : <%= re.getAddress() %><br>
	이메일 : <%= re.getEmail() %><br> --%>

	<%-- 	<%	String[] schools=re.getSchool().split(",");
		String[] departments=re.getDepartment().split(",");
		String[] school_period=re.getSchool_period().split("~");
		String[] st_school_period=school_period[0].split(",");
		String[] ed_school_period=school_period[1].split(",");
		
		for(int i=0;i<schools.length;i++){%>
	학교 : <%= schools[i]%><br>
	학과 : <%= departments[i]%><br>
	기간 : <%= st_school_period[i]%>~<%= ed_school_period[i]%><br>
	<br>
	<%	} %> --%>

	<%-- 경력 : <%= re.getCareer()%><br>
	<%	if(re.getCareer().equals("Y")){
			String[] work_place=re.getWork_place().split(",");
			String[] work_date=re.getWork_date().split("~");
			String[] st_work_date=work_date[0].split(",");
			String[] ed_work_date=work_date[1].split(",");
			String[] work=re.getWork().split(",");
			
			for(int i=0;i<work_place.length;i++){%>
	일한장소 : <%=work_place[i]%><br>
	한 일 : <%=work[i]%><br>
	일한날짜 : <%=st_work_date[i]%>~<%=ed_work_date[i]%><br><br>
	<%		}
		}%> --%>

	<%-- <%	String[] certifications=re.getCertification().split(",");
		String[] cer_dates=re.getCer_date().split(",");
		
		for(int i=0;i<certifications.length;i++){%>
	자격증 : <%= certifications[i]%><br>
	자격날짜 : <%= cer_dates[i]%><br>
	<%	} %> --%>

	<%-- 희망연봉 : <%= re.getHope_salary()%><br>
	공개 : <%= re.getOpen()%><br>
	언어 : <%= re.getP_language()%><br> --%>
<%-- 	자소서 : <%= re.getCover_letter()%><br>

<button onclick="location.href='<%=request.getContextPath()%>/update.re?resume_no=<%=re.getResume_no()%>'">수정하기</button>
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