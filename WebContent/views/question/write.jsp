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

<!-- import of jobx -->
<%@ include file="/views/include/user/js.jsp" %>
<!-- End of import of jobx -->
</head>
<body>

   <header id="home" class="hero-area">
   <%@ include file="/views/include/user/header_nav.jsp" %>
   </header>

   <!-- page-header -->
   <%@ include file="/views/include/user/page_header.jsp" %>
   <script>
      var page_header_title='문의하기'
   </script>
   <!-- end of page-header -->

			


	<div id="content">
	<div class="container">
	<div class="row">
			<!-- left -->
            <%@ include file="/views/include/user/mypage_menu.jsp" %>
            <!-- End of left -->
            
	
	<div class="col-lg-8 col-md-12 col-xs-12">
	
	<div class="post-job box">
	<h3 class="job-title">문의하기</h3>
	<form action="<%=contextPath%>/insert.qu" method="post" autocomplete=off id="form">
	<input type="hidden" value="<%= mem.getM_no() %>" name="m_no">
	<div class="form-group">
	
	<div class="search-category-container">
	<!-- <label class="styled-select">
	<select class="dropdown-product selectpicker" name="writehead" id="writehead">
		<option value="no">-------</option>
		<option value="자유">자유</option>
		<option value="스터디">스터디</option>
		<option value="프로젝트">프로젝트</option>
		<option value="공지">공지</option>
		<option value="서식">서식</option>
	</select>
	</label> -->
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label">제목</label>
	<!-- <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요."> -->
	<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요">
	</div>
	<section id="editor">
	<div class="form-group">
	<label for="comment">내용</label>
	<textarea class="form-control" rows="15" id="comment" name="contents"></textarea>
	</div>
	</section>
	<div onclick="window.history.back()" class="btn btn-common">취소</div>
	<div onclick="writeAdd();" class="btn btn-common">등록</div>
	</form>
	</div>	


	</div>
	</div>
	</div>
	
	
	<script>
		function writeAdd(){
	
			var content = $("#comment");
			var title = $("#title");
			if(title.val().trim().length == 0){
				alert("제목을 입력해주세요.");
				title.focus();
				return false;
			} 
			if(content.val().trim().length == 0){
				alert("내용을 입력해주세요.") 
				content.focus();
				return false; 
				
			}else{
				$("#form").submit();
			}
		};

		
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
	
	
	
	<script>
	$('.inner-header').children('h3').text(page_header_title)
	</script>


 <h1>문의하기</h1>
<form action="<%=request.getContextPath()%>/insert.qu" method="post" autocomplete=off>
내용:<input name=contents><br>
<button>등록</button>
</form>
<button onclick="history.back()">취소</button>
<%@ include file="/views/include/footer.jsp" %>

</body>
</html>