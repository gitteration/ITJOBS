<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.resume.model.vo.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> likeResList = (ArrayList<String>)request.getAttribute("likeRes");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

	.like{
	width:20px;
	height:20px;
	}

	.likeimg{
	width:20px;
	height:20px;
	box-sizing:border-box;
	text-align:center;
	}
	
	.likeimg:hover{
	cursor:pointer;
	}
	
	 .heart-icon {
    color: #fff;
    line-height: 24px;
    padding: 3px 10px;
    font-size: 14px;
    border-radius: 4px;
    text-align: center;
    display: inline-block;
    margin: 0px 10px;
    background: #00BCD4;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
    transition-property: all;
    transition-duration: 0.3s;
    transition-timing-function: ease-in-out;
    transition-delay: 0s;
}

	#blur{
		
		-webkit-filter: blur(5px); 
		-moz-filter: blur(5px); 
		-o-filter: blur(5px); 
		-ms-filter: blur(5px); 
		filter: blur(5px);

	}

</style>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<%@ include file="/views/include/user/js.jsp" %>
<!-- End of import from jobx -->

</head>
<body>
	<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>

	<%	if(mem!=null){ %>
	<input type="hidden" value="<%=mem.getM_no() %>" id="memNo">
	<input type="hidden" value="<%=mem.getType()%>" id="memType">
	<%	} %>

	</header>

	<!-- page-header -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="inner-header">
						<h3>Find Job</h3>
					</div>
					<!-- <div class="job-search-form">
						<form>
							<div class="row">
								<div class="col-lg-5 col-md-5 col-xs-12">
									<div class="form-group">
										<input class="form-control" type="text"
											placeholder="Job Title or Company Name">
									</div>
								</div>
								<div class="col-lg-3 col-md-5 col-xs-12">
									<div class="form-group">
										<div class="search-category-container">
											<label class="styled-select"> <select>
													<option value="none">Locations</option>
													<option value="none">New York</option>
													<option value="none">California</option>
													<option value="none">Washington</option>
													<option value="none">Birmingham</option>
													<option value="none">Chicago</option>
													<option value="none">Phoenix</option>
											</select>
											</label>
										</div>
										<i class="lni-map-marker"></i>
									</div>
								</div>
								<div class="col-lg-3 col-md-5 col-xs-12">
									<div class="form-group">
										<div class="search-category-container">
											<label class="styled-select"> <select>
													<option>All Categories</option>
													<option>Finance</option>
													<option>IT & Engineering</option>
													<option>Education/Training</option>
													<option>Art/Design</option>
													<option>Sale/Markting</option>
													<option>Healthcare</option>
													<option>Science</option>
													<option>Food Services</option>
											</select>
											</label>
										</div>
										<i class="lni-layers"></i>
									</div>
								</div>
								<div class="col-lg-1 col-md-2 col-xs-12">
									<button type="submit" class="button">
										<i class="lni-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div> -->
				</div>
			</div>
		</div>
	</div>
	<script>
		var page_header_title='공개 이력서 검색'
	</script>
	<!-- end of page-header -->
	
	<!-- list section -->
	<div id="content">
		<div class="container">
			<div class="row">
			<%	ArrayList<Resume> list=(ArrayList<Resume>)request.getAttribute("list");
				for(Resume n:list){%>
				<div class="col-lg-6 col-md-6 col-xs-12">
					<div class="manager-resumes-item">
						<div class="manager-content">
						<%if(mem== null || mem.getM_no() != n.getM_no() && !(mem.getType().equals("2"))){ %> 
							<a href="detail.re?resume_no=<%=n.getResume_no()%>"><img class="resume-thumb"
								src="<%= contextPath %>/resources/fileupload_resumeImg/<%= n.getPhoto()%>" id="blur"  ></a>
								<%}else{ %>
								<a href="detail.re?resume_no=<%=n.getResume_no()%>"><img class="resume-thumb"
								src="<%= contextPath %>/resources/fileupload_resumeImg/<%= n.getPhoto()%>"  ></a>
								<%} %>
							<div class="manager-info">
								<div class="manager-name">
									<h4>
										<a style="color:#00bcd4;">
											<%	if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==n.getM_no())){ %>
												<%=n.getName() %>
											<%	}else{ %>
												<%=n.getName().substring(0,1)+"**" %>
											<%	} %>
										</a>
									</h4>
									<h5>
										<%	if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==n.getM_no())){ %>
												학과: <%=n.getDepartment() %>
										<%	}else{ %>
											학과: ******
										<%	} %>
									</h5>
								</div>
								<div class="manager-meta">

									<span class="location"><i class="ti-location-pin"></i>
										<%-- <%	String[] arr_address=n.getAddress().split("\\+");
											String[] arr_address_middle=arr_address[1].split(" ");
											if(mem!=null && mem.getType().equals("2")){ %>
												<%=arr_address_middle[0]+" "+arr_address_middle[1] %>
										<%	}else{ %>
												<%=arr_address_middle[0] %>
										<%	} %> --%>
										지역: <%=n.getAddress().split("\\+")[1].split(" ")[0] %>
									</span> <span class="rate"><i
										class="ti-time"></i>
											<%	if(mem!=null && (mem.getType().equals("2") || mem.getM_no()==n.getM_no())){ %>
												희망연봉: <%=n.getHope_salary().equals("4001")?"4000이상":n.getHope_salary().equals("0")?"회사내규에따름":n.getHope_salary() %>
										<%	}else{ %>
											희망연봉: ******
										<%	} %>
										</span>
								</div>
							</div>
						</div>
						<div class="item-body">
							<div class="content">
								<p><%=n.getTitle() %></p>
							</div>
							<div class="resume-skills">
								<div class="tag-list float-left">
									<%	String[] arr=n.getP_language().split(",");
										for(int i=0;i<arr.length;i++){%>
									<span><%=arr[i] %></span>
									<%	} %>
								</div>
								<div class="resume-exp float-right">
									<!-- 좋아요 버튼 -->
									<%
										boolean flag = false;  // 좋아요 이미지가 겹치지 않게 하기 위해서
										if(mem != null){
									
										for(int i=0; i<likeResList.size(); i++){ // 서블릿에서 좋아요한 맴버의 게시글번호를 받아
											
											if(Integer.parseInt(likeResList.get(i)) == n.getResume_no()){  // 그 게시글번호와 현재 for문으로 작동하는 게시글번호와 일치하면
												flag = true;	// 	좋아요한 이미지 보이게									
												}
											}
										}
									%>
									<input type="hidden" value="<%=n.getResume_no()%>" class="res_no">
									<%if(!flag){  %>
									<span class="heart-icon"> <img src="./resources/img/like-before.png" class="likeimg" > </span>
									<%}else{ %>
									<span class="heart-icon"> <img src="./resources/img/like-after1.png" class="likeimg"> </span>
									<%} %>
									<%	if(n.getCareer().equals("N")){ %>
									<a class="btn btn-common btn-xs" style="padding: 6px 16px; font-size: 12px;">신입</a>
									<%	}else{ 
											String[] arr_year_string="1,2".split(",");//n.getCareer_year().split(",");
											int career_year=0;
											for(int i=0;i<arr_year_string.length;i++){
												career_year+=Integer.parseInt(arr_year_string[i]);
											}%>
									<a class="btn btn-common btn-xs" style="padding: 6px 16px; font-size: 12px;">경력 <%=career_year %>년</a>
									<%	} %>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%	} %>
				
				<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
					int currentPage=pi.getCurrentPage();
					//String sText=(String)request.getAttribute("sText")==null?"":(String)request.getAttribute("sText");
					%>
				<ul class="pagination" style="display:block;">
					<%	if(currentPage>1){ %>
					<li class="active"><a href="<%=request.getContextPath()%>/resumeList.se?currentPage=<%=currentPage-1%>" class="btn-prev"><i
							class="lni-angle-left"></i> prev</a></li>
					<%	} %>
					<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
					<li><a href="<%=request.getContextPath()%>/resumeList.se?currentPage=<%=i%>"><%=i %></a></li>
					<%	} %>
					<%	if(currentPage<pi.getMaxPage()){ %>
					<li class="active"><a href="<%=request.getContextPath()%>/resumeList.se?currentPage=<%=currentPage+1%> class="btn-next">Next <i
							class="lni-angle-right"></i></a></li>
					<%	} %>
				</ul>
			</div>
		</div>
	</div>
	<!-- End of list section -->
	
	
	

<script>
	function search(){
		var sKey=$('#sKey').val();
		var sText=$('#sText').val();
		$('#resultArea').load('<%=request.getContextPath()%>/resumeList.se #result',{'sKey':sKey,'sText':sText})
	}
	function searchA(){
		var sTextA=$('#sTextA').val();
		$('#resultArea').load('<%=request.getContextPath()%>/resumeList.se #result',{"sText":sTextA})
	}

	// 좋아요 ajax
		$(function(){
		
			var memNo = $("#memNo").val();
			var memType = $("#memType").val();
			$(".likeimg").click(function(){
						
	
			if(memNo!=null && memType != 1){ // 회원이 존재하면
				
				var resNo =	$(this).parent().prev().val()
				
				var likeimg = $(this).parent().children() 
				
			
				
		 			 $.ajax({
						url:"like.res",
						data:{resNo:resNo, memNo:memNo},
						type:"get",
						success:function(result){
						
							
							if(result==0){
							likeimg.attr('src','./resources/img/like-after1.png');							
							}else{
							likeimg.attr('src','./resources/img/like-before.png');		
							}
						
						},error:function(){
							
							console.log("ajax실패");
						}
				
					}); 
				}else if(memType=="1"){ // 일반회원끼리 좋아요 방지
				alert("일반회원끼리는 좋아요 불가능 합니다.");
				}else{
				alert("로그인을 진행해 주세요");
				}	
		})
	})
				
	
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