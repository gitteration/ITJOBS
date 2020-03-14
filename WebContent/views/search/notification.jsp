<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> likeBoList = (ArrayList<String>)request.getAttribute("likeMem");

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

</style>

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
	
	<%	if(mem!=null){ %>
	<input type="hidden" value="<%=mem.getM_no() %>" id="memNo">
	<input type="hidden" value="<%=mem.getType()%>" id="memType">
	<%	} %>
	
	
	<!-- page-header -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="inner-header">
						<h3>Find Job</h3>
					</div>
					<div class="job-search-form">
						<form action="notificationList.se" method="get" autocomplete=off>
							<div class="row justify-content-md-center">
								<div class="col-lg-5 col-md-5 col-xs-12">
									<div class="form-group">
										<input class="form-control" type="text"
											placeholder="Job Title or Company Name" name="sText">
									</div>
								</div>
								<!-- <div class="col-lg-3 col-md-5 col-xs-12">
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
								</div> -->
								<!-- <div class="col-lg-3 col-md-5 col-xs-12">
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
								</div> -->
								<div class="col-lg-1 col-md-2 col-xs-12">
									<button type="submit" class="button">
										<i class="lni-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var page_header_title='공고 검색'
	</script>
	<!-- end of page-header -->
	
	<!-- list section -->
	<section id="job-listings" class="section">
		<div class="container">
			<div class="row">
			<%	ArrayList<Notification> list=(ArrayList<Notification>)request.getAttribute("list");
				for(Notification n:list){%>
				
				
				<div class="col-lg-6 col-md-12 col-xs-12">
					<a class="job-listings-featured">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-xs-12" style="cursor:pointer;">
								<div class="job-company-logo">
									<img src="<%=contextPath %>/resources/cofileupload/<%=n.getLogoFile() %>" style="width:70px;height:70px;" alt="">
								&nbsp;&nbsp;&nbsp;
								</div>
								<div class="job-details">
									<h3 onclick="location.href='<%=request.getContextPath()%>/get.no?noti_no=<%=n.getNoti_no()%>'"><%=n.getTitle() %></h3>
									<span class="company-neme" onclick="detailCo(<%=n.getCo_no()%>)"><%=n.getNickname()%></span>
									<div class="tags">
										<span><i class="lni-map-marker"></i> <%=n.getAddress().split(" ")[0].split("\\+")[1] %></span> <span><i
											class="lni-user"></i><%=n.getSalary() %> 만원</span>
									</div>
								</div>
							</div>			
							<div class="col-lg-6 col-md-6 col-xs-12 text-right">
								<div class="tag-type">
								<div class="tag-type">
									<span class="heart-icon" style="background:white; color:blue; text-align:center; padding-right: 132px;">
									<input type="hidden" value="<%=n.getNoti_no()%>" id="noNo5" onchange="likeSum();">
									
									
									
									</span>
								</div>
									<input type="hidden" value="<%=n.getNoti_no()%>" class="no_no">
									
									<%
										boolean flag = false;  // 좋아요 이미지가 겹치지 않게 하기 위해서
										if(mem != null){
									
										for(int i=0; i<likeBoList.size(); i++){ // 서블릿에서 좋아요한 맴버의 게시글번호를 받아
											
											if(Integer.parseInt(likeBoList.get(i)) == n.getNoti_no()){  // 그 게시글번호와 현재 for문으로 작동하는 게시글번호와 일치하면
												flag = true;	// 	좋아요한 이미지 보이게									
												}
											}
										}
									%>
									
									<%if(!flag){  %>
										<span class="heart-icon"> <img src="./resources/img/like-before.png" class="likeimg"> </span>
									<%}else{ %>
										<span class="heart-icon"> <img src="./resources/img/like-after1.png" class="likeimg"> </span>
									<%} %>
									
									<span class="full-time">~<%=n.getEnd_date().split(" ")[0] %></span>
								</div>
							</div>
						</div>
					</a>
				</div>
			<%	} %>
			<%	PageInfo pi=(PageInfo)request.getAttribute("pi");
				int currentPage=pi.getCurrentPage();
				String sText=(String)request.getAttribute("sText");%>
				<ul class="pagination" style="display:block;">
					<%	if(currentPage>1){ %>
					<li class="active"><a href="<%=request.getContextPath()%>/notificationList.se?sText=<%=sText %>&currentPage=<%=currentPage-1%>" class="btn-prev"><i
							class="lni-angle-left"></i> prev</a></li>
					<%	} %>
					<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){ %>
					<li><a href="<%=request.getContextPath()%>/notificationList.se?sText=<%=sText %>&currentPage=<%=i%>"><%=i %></a></li>
					<%	} %>
					<%	if(currentPage<pi.getMaxPage()){ %>
					<li class="active"><a href="<%=request.getContextPath()%>/notificationList.se?sText=<%=sText %>&currentPage=<%=currentPage+1%> class="btn-next">Next <i
							class="lni-angle-right"></i></a></li>
					<%	} %>
				</ul>
			</div>
		</div>

	</section>
	<!-- End of list section -->
	




<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->

<script>
	
	function likeSum(){
		
		var noNo = $('#noNo5').val();
		
		console.log(noNo);
		
	}
	
	
	
	
	
	
	
	
	function search(){
		return false;
		var sKey=$('#sKey').val();
		var sText=$('#sText').val();
		$('#resultArea').load('<%=request.getContextPath()%>/notificationList.se #result',{'sKey':sKey,'sText':sText})
	}
	
	function searchA(){
		var sTextA=$('#sTextA').val();
		$('#resultArea').load('<%=request.getContextPath()%>/notificationList.se #result',{"sText":sTextA})
	}
	
	function detailCo(co_no){
		location.href="<%=request.getContextPath()%>/detail.co?co_no="+co_no
	}

	// 좋아요 ajax
	 $(function(){
		
		
		var memNo = $("#memNo").val();
		var memType = $("#memType").val();
		
		//$(".likeimg").click(function (){
		
			$(document).on("click", ".likeimg", function(e){	
			
			if(memNo!=null && memType != 2){
			//var noNo =	$(this).parent().prev().val();
			
			
			var test = e.target;
			
			
			var noNo =	test.parentNode.previousSibling.previousSibling.value;
			console.log(noNo);
			
			var span = test.parentNode;
			
			//console.log(span);
		
	 			 $.ajax({
					url:"like.no",
					data:{noNo:noNo, memNo:memNo},
					type:"get",
					success:function(result){
						
						//var likeimg = $(this).parent().children(); 
						
						/* console.log("ajax성공");
						console.log(result); */
						
						
						
						if(result==0){
							
							
							span.innerHTML = "<img src='./resources/img/like-after1.png' class='likeimg'>"; // 보람쌤꺼
							
							//likeimg.attr('src','./resources/img/like-after1.png');	// 내꺼			
						}else{
							span.innerHTML = "<img src='./resources/img/like-before.png' class='likeimg'>"; // 보람쌤꺼
										
							//likeimg.attr('src','./resources/img/like-before.png');	// 내꺼	
						}
				
					
					
					},error:function(){
						console.log("ajax실패");
					}
			
				}); 
			}else if(memType=="2"){
			alert("기업회원끼리는 좋아요 불가능 합니다");	
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