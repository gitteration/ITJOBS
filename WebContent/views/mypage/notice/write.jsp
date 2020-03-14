<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h3 class="alerts-title">공고 작성</h3>
						<form class="form" action="write.no" method="post" autocomplete=off>
							<div class="form-group is-empty">
								<label class="control-label">공고 제목</label> <input
									class="form-control" type="text" name="title"> <span
									class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<div class="row">
									<div class="col-md-6">
										<label class="control-label">마감일</label>
										<input class="form-control" type="date" name="end_date">
										<span class="material-input"></span>
									</div>
									<div class="col-md-6">
										<label class="control-label">마감시간</label>
										<input class="form-control" type="time" name="end_time">
										<span class="material-input"></span>
									</div>
								</div>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">언어</label>
								<input type=checkbox name="language" value="java" >java
								<input type=checkbox name="language" value="javascript" >javascript
								<input type=checkbox name="language" value="C" >C
								<input type=checkbox name="language" value="C++" >C++
								<input type=checkbox name="language" value="C#" >C#
								<input type=checkbox name="language" value="VBA" >VBA
								<input type=checkbox name="language" value="python" >python
								<input type=checkbox name="language" value="php" >php
								<input type=checkbox name="language" value="asp" >asp
								<span class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">직군</label>
								<input class="form-control" type="text" name="jobs">
								<span class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">연봉(원)</label> <input
									class="form-control" type="text" name="salary" pattern="[0-9]{0,10}" title="원 단위로 숫자만 입력해 주세요" maxlength="9"> <span
									class="material-input"></span>
							</div>
							<div class="form-group is-empty">
								<label class="control-label">내용</label>
								<textarea class="form-control" rows="5" id="comment1" name="contents"></textarea>
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
								<textarea class="form-control" rows="5" id="comment2" name="hope"></textarea>
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
							<div class="form-group is-empty">
								<input type="radio" name="open" value="Y" checked>공개
								<input type="radio" name="open" value="N" >비공개
							</div>
							<button onclick="write_ok()" class="btn btn-common">Save Change</button>
						</form>
					</div>
				</div>
				<!-- End of right -->
<script>
	function write_ok(){
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