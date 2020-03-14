<%@page import="com.kh.notification.model.vo.Notification"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	Notification noti=(Notification)request.getAttribute("noti"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/naver-smarteditor2-ca95d21/demo/js/service/HuskyEZCreator.js' charset="utf-8"></script>

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
				<div class="col-md-8 col-sm-8 col-xs-12">
					<div class="job-alerts-item">
						<h3 class="alerts-title">공고 수정</h3>
						<form class="form" action="edit.no" method="post" autocomplete=off>
							<div class="form-group is-empty">
								<label class="control-label">공고 제목</label> <input
									class="form-control" type="text" name="title" value="<%=noti.getTitle()%>"> <span
									class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<div class="row">
									<div class="col-md-6">
										<label class="control-label">마감일</label>
										<input class="form-control" type="date" name="end_date" value="<%=noti.getEnd_date().split(" ")[0]%>">
										<span class="material-input"></span>
									</div>
									<div class="col-md-6">
										<label class="control-label">마감시간</label>
										<input class="form-control" type="time" name="end_time" value="<%=noti.getEnd_date().split(" ")[1]%>">
										<span class="material-input"></span>
									</div>
								</div>
							</div>
							<%	String[] arr_language=noti.getP_language().split(",");
								String[] lan_selected=new String[9];
								for(int i=0;i<arr_language.length;i++){
									System.out.println(arr_language[i]);
									switch(arr_language[i]){
									case "java": 		lan_selected[0]="checked";break;
									case "javascript": 	lan_selected[1]="checked";break;
									case "C": 			lan_selected[2]="checked";break;
									case "C++": 		lan_selected[3]="checked";break;
									case "C#": 			lan_selected[4]="checked";break;
									case "VBA": 		lan_selected[5]="checked";break;
									case "python": 		lan_selected[6]="checked";break;
									case "php": 		lan_selected[7]="checked";break;
									case "asp": 		lan_selected[8]="checked";break;
									}
								} %>
							<div class="form-group is-empty">
								<label class="control-label">직군</label>
								<input type=checkbox name="language" value="java" <%=lan_selected[0] %>>java
								<input type=checkbox name="language" value="javascript" <%=lan_selected[1] %>>javascript
								<input type=checkbox name="language" value="C" <%=lan_selected[2] %>>C
								<input type=checkbox name="language" value="C++" <%=lan_selected[3] %>>C++
								<input type=checkbox name="language" value="C#" <%=lan_selected[4] %>>C#
								<input type=checkbox name="language" value="VBA" <%=lan_selected[5] %>>VBA
								<input type=checkbox name="language" value="python" <%=lan_selected[6] %>>python
								<input type=checkbox name="language" value="php" <%=lan_selected[7] %>>php
								<input type=checkbox name="language" value="asp" <%=lan_selected[8] %>>asp
								<span class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">직군</label>
								<input class="form-control" type="text" name="jobs" value="<%=noti.getJobs()%>">
								<span class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">연봉</label> <input
									class="form-control" type="text" name="salary" value="<%=noti.getSalary()%>"pattern="[0-9]{0,9}" title="원 단위로 숫자만 입력해 주세요" maxlength="9"> <span
									class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">내용</label>
								<textarea class="form-control" rows="5" id="comment1" name="contents"><%=noti.getContents()%></textarea>
								<span class="material-input"></span>
							</div>
<script>
var oEditors = [];
	
nhn.husky.EZCreator.createInIFrame({
 	 oAppRef: oEditors,
 	 elPlaceHolder: document.getElementById('comment1'),
  	 sSkinURI: "<%=contextPath%>/resources/naver-smarteditor2-ca95d21/demo/SmartEditor2Skin.html",  
     fCreator: "createSEditor2",
     htParams:{
    	 bUseToolbar:true, // 툴바 사용여부
    	 bUseVerticalResizer:false, // 크기조절바 사용여부
    	 bUseModeChanger : true,	// 모드 탭(Editor | HTML | TEXT) 사용 여부
     }
});
</script>
							<div class="form-group is-empty">
								<label class="control-label">우대사항</label>
								<textarea class="form-control" rows="5" id="comment2" name="hope"><%=noti.getHope()%></textarea>
								<span class="material-input"></span>
							</div>
<script>
nhn.husky.EZCreator.createInIFrame({
 	 oAppRef: oEditors,
 	 elPlaceHolder: document.getElementById('comment2'),
  	 sSkinURI: "<%=contextPath%>/resources/naver-smarteditor2-ca95d21/demo/SmartEditor2Skin.html",  
     fCreator: "createSEditor2",
     htParams:{
    	 bUseToolbar:true, // 툴바 사용여부
    	 bUseVerticalResizer:false, // 크기조절바 사용여부
    	 bUseModeChanger : true,	// 모드 탭(Editor | HTML | TEXT) 사용 여부
     }
});
</script>
							<%	String open=noti.getOpen();
								String[] checked_open={"",""};
								if(open.equals("Y")){
									checked_open[0]="checked";
								}else{
									checked_open[1]="checked";
								}%>
							<div class="form-group">
								<input type="radio" name="open" value="Y" <%=checked_open[0] %>>공개
								<input type="radio" name="open" value="N" <%=checked_open[1] %>>비공개
							</div>
							<button id="submit" onclick="edit_ok()" class="btn btn-common">Save Change</button>
							<input type=hidden name="noti_no" value="<%=noti.getNoti_no()%>">
						</form>
					</div>
				</div>
				<!-- End of right -->
<script>
	function edit_ok(){
		oEditors.getById["comment1"].exec("UPDATE_CONTENTS_FIELD", []);
		oEditors.getById["comment2"].exec("UPDATE_CONTENTS_FIELD", []);
	}
</script>
				
			</div>
			<!-- End of row -->
			
		</div>
		<!-- End of container -->
	</div>
	<!-- End of content -->
	
	
	
	
	
<%-- <h1>공고 수정</h1>

<form action="edit.no" method="post" autocomplete=off>
제목:<input name="title" value="<%=noti.getTitle()%>"><br>
마감일:<input type=date name="end_date" value="<%=noti.getEnd_date().split(" ")[0]%>"><br>
모집인원:<input value="모집인원이 없다고?"><br>
직군:<input name="jobs" value="<%=noti.getJobs()%>"><br>
언어:
<input type=checkbox name="language" value="java" <%=lan_selected[0] %>>java
<input type=checkbox name="language" value="javascript" <%=lan_selected[1] %>>javascript
<input type=checkbox name="language" value="C" <%=lan_selected[2] %>>C
<input type=checkbox name="language" value="C++" <%=lan_selected[3] %>>C++
<input type=checkbox name="language" value="C#" <%=lan_selected[4] %>>C#
<input type=checkbox name="language" value="VBA" <%=lan_selected[5] %>>VBA
<input type=checkbox name="language" value="python" <%=lan_selected[6] %>>python
<input type=checkbox name="language" value="php" <%=lan_selected[7] %>>php
<input type=checkbox name="language" value="asp" <%=lan_selected[8] %>>asp
<br>
연봉:<input name="salary" value="<%=noti.getSalary()%>"><br>
내용:<textarea name="contents"><%=noti.getContents() %></textarea><br>
우대사항:<input name="hope" value="<%=noti.getHope()%>"><br>
<input type=hidden name="noti_no" value="<%=noti.getNoti_no()%>">
<button>수정</button>
</form>
<button onclick="back(<%=noti.getNoti_no()%>)">취소</button>
<script>
	function back(noti_no){
		location.href="<%=request.getContextPath()%>/get.no?noti_no="+noti_no
	}
</script> --%>




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