<%@page import="com.kh.resume.model.vo.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String likeNoCheck = (String)request.getAttribute("likeNoCheck");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here1</title>
<style>

	.like{
	width:20px;
	height:20px;
	}

	.likeimg1{
	width:20px;
	height:20px;
	box-sizing:border-box;
	text-align:center;
	}
	
	.likeimg1:hover{
	cursor:pointer;
	}

</style>



<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->

</head>
<body>

	<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>
	</header>
	<%@ include file="/views/include/user/js.jsp" %>
	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp" %>
	<script>
		var page_header_title='공고 정보'
	</script>
	<!-- end of page-header -->
	<% if(mem != null){ %>
	<input type="hidden" value="<%=mem.getM_no() %>" id="memNo">
	<input type="hidden" value="<%=mem.getType() %>" id="memType">
	<%} %>

	<%	Notification noti=(Notification)request.getAttribute("noti");%>
	<input type ="hidden" value=<%=noti.getNoti_no()%> id="noNo">
	<section class="job-detail section">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-4 col-md-12 col-xs-12">
					<div class="sideber">
						<div class="widghet">
							<h3>Job Location</h3>
							<div class="maps">
								<div id="map" class="map-full"></div>
							</div>
							<h3><%=noti.getAddress().split("\\+")[1]+ " " +noti.getAddress().split("\\+")[2] %></h3>
						</div>
						<hr>
						<div class="widghet" style="height:200px;">
						
							<% if(mem != null ){ %>
								<% if(likeNoCheck.equals("1")){ %>  
								<span class="heart-icon"> <img src="./resources/img/button-after.png" class="likeimg1" style="height:200px; width:320px;"> </span>
								<% 	}else{ %>
								<span class="heart-icon"> <img src="./resources/img/button-before.png" class="likeimg1" style="height:200px; width:320px;"> </span>									
								<% 	} %>
								<%}else{ %>
								<span class="heart-icon"> <img src="./resources/img/button-before.png" class="likeimg1" style="height:200px; width:320px;"> </span>
								<%} %>	
						
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-md-12 col-xs-12">
					<div class="content-area">
						<h4><%=noti.getTitle() %></h4>
						<%=noti.getOpen().equals("Y")?"공개":"비공개" %> - <span><i class="lni-calendar"></i><%=noti.getEnroll_date() %></span>
						<hr>
						
						<h4>기업이름</h4>
						<img src="<%=contextPath %>/resources/cofileupload/<%=noti.getLogoFile() %>" style="height:70px;" alt="">
						<ul>
						<%=noti.getNickname() %>
						</ul>
						<hr>
						
						<h4>마감일</h4>
						<ul>
						<%=noti.getEnd_date() %>
						</ul>
						
						<hr>
						<h4>연봉</h4>
						<ul>
						<%=noti.getSalary() %>
						</ul>
						
						<hr>
						<h4>필요언어</h4>
						<ul>
						<%	String[] arr_lan=noti.getP_language().split(",");
							for(int i=0;i<arr_lan.length;i++){%>
							<li>- <%=arr_lan[i] %></li>
						<%	} %>
						</ul>
						
						<hr>
						<h4>우대사항</h4>
						<p><%=noti.getHope() %></p>
						
						<hr>
						<h4>직군</h4>
						<p><%=noti.getJobs() %></p>
						
						<hr>
						<h4>세부내용</h4>
						<p><%=noti.getContents() %></p>
						<hr>
						
						<%	if(mem!=null && mem.getM_no()==noti.getCo_no()){ %>
						<a href="#" onclick="edit(<%=noti.getNoti_no() %>)" class="btn btn-common">수정</a>
						<a href="#" onclick="del(<%=noti.getNoti_no() %>)" class="btn btn-common">삭제</a>
						<a href="#" onclick="location.href='<%=request.getContextPath() %>/myNotification.me'" class="btn btn-common">나의 공고목록</a>
						<a href="#" onclick="showApplier(<%=noti.getNoti_no() %>)" class="btn btn-common">지원자 확인</a>
						<%	}else if(mem!=null && mem.getType().equals("1")){
								ArrayList<Resume> rlist=(ArrayList<Resume>)request.getAttribute("rlist");
								if(rlist!=null){%>
								<form action="apply.vo" method="post">
									<input type=hidden name="noti_no" value="<%=noti.getNoti_no() %>">
									<div class="row">
									<div class="col-md-6">
										<label class="styled-select">내 이력서
											<select name="resume_no" id="resume_no" onchange="test(this)">
												<option value="0">지원할 이력서를 선택해주세요.</option>
												<% for(Resume r:rlist){%>
												<option value="<%=r.getResume_no()%>"><%=r.getTitle() %></option>
												<%	} %>
											</select>
										</label>
									</div>
									<div class="col-md-6">
										<label class="control-label">내 점수 / 지원자 평균</label>
										<input type="text" class="form-control" id="score" readonly>
									</div>
									</div>
									<a href="#" onclick="apply(<%=noti.getNoti_no() %>)" class="btn btn-common">지원하기</a>
									<div id="info"></div>
									<div id="info1"></div>
								</form>
						<%		}else{%>
								<h3>이미 지원한 공고입니다.</h3>
							<%	} %>
						<%	} %>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		var noti_no=<%=noti.getNoti_no()%>;
		var noti_lan="<%=noti.getP_language()%>";
		
		function score(resume_lan,noti_lan){
			var arr_re=resume_lan.split(",");
			var arr_noti=noti_lan.split(",");

			var score=0;
			for(i=0;i<arr_re.length;i++){
				for(j=0;j<arr_noti.length;j++){
					if(arr_re[i]==arr_noti[j]){
						score+=10;
						break;
					}
				}
			}
			return score;			
		}
		
		function test(val){
			var str="0";
			var resume_no=val.value;
			if(resume_no==0){
				$('#score').val("이력서를 선택하시면 점수가 떠요")
				return;
			}

			//내점수
			$.ajax({
				url:'get.re.ajax',
				type:'post',
				data:{
					resume_no:resume_no,
				},
				dataType:'json',
				success:function(result){
					//내점수//result=resume객체
					/* console.log("내점수성공"); */
					str=score(result.p_language,noti_lan)
				},
			})

			//총지원자 평균
			$.ajax({
				url:'getAvg.re.ajax',
				type:'post',
				data:{
					noti_no:noti_no,
				},
				dataType:'json',
				success:function(result){
					console.log("avg성공")
					var count=result.length
					if(count==0){
						str+=" / 현재 지원자가 없습니다."
					}else{
						var sum=0;
						for(k=0;k<result.length;k++){
							sum+=score(result[k].p_language,noti_lan)
						}
						str+=" / "+(sum/count)
					}
						$('#score').val(str)
					
				},
			})
		}
		
		
		
	</script>

	<section id="featured" class="section bg-gray pb-45">
		<div class="container">
			<h4 class="small-title text-left">Similar Jobs</h4>
			<div class="row">
			<%	ArrayList<Notification> list=(ArrayList<Notification>)request.getAttribute("random");
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
									<input type="hidden" value="<%=n.getNoti_no()%>" class="no_no">
<%-- 									<%
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
									<%} %> --%>
									
									<span class="full-time">~<%=n.getEnd_date().split(" ")[0] %></span>
								</div>
							</div>
						</div>
					</a>
				</div>
				<%	} %>
			</div>
		</div>
	</section>


<script>
	function edit(noti_no){
		location.href="edit.no?noti_no="+noti_no;
	}
	function del(noti_no){
		location.href="del.no?noti_no="+noti_no;
	}
	function open_(noti_no){
		location.href="open.no?noti_no="+noti_no;
	}
	function openCancle(noti_no){
		location.href="openCancle.no?noti_no="+noti_no;
	}
	function showApplier(noti_no){
		location.href="list.vo?noti_no="+noti_no;
	}
	function apply(noti_no){
		location.href="apply.vo?noti_no="+noti_no+"&resume_no="+$('#resume_no').val()
	}

	$(function(){
		
		var memNo = $("#memNo").val();
		var noNo = $("#noNo").val();	
		var memType = $("#memType").val();
		
		
		$(".likeimg1").click(function(){
			
			if(memNo!=null && memType != 2){ // 회원이 존재하면
			
	 			 $.ajax({
					url:"like.no",
					data:{noNo:noNo, memNo:memNo},
					type:"get",
					success:function(result){
					
						
						if(result==0){
						$(".likeimg1").attr('src','./resources/img/button-after.png');							
						}else{
						$(".likeimg1").attr('src','./resources/img/button-before.png');		
						}
				
					
					
					},error:function(){
						
						console.log("ajax실패");
					}
			
					}); 
				}else if(memType=="2"){ // 일반회원끼리 좋아요 방지
				alert("기업회원끼리는 좋아요 불가능 합니다.");
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
<!-- 지도api -->


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3f8e5a5f11c657a1034900d7a303bc56&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
	<%	String address=noti.getAddress();
		String[] addresss=address.split("\\+");%>
geocoder.addressSearch('<%=addresss[1]+" "+addresss[2]%>', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 h이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
<!-- end of 지도api -->
</body>
</html>